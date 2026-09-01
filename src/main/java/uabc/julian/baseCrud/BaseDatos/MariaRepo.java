package uabc.julian.baseCrud.BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import uabc.julian.baseCrud.data.Direccion;
import uabc.julian.baseCrud.data.Persona;
import uabc.julian.baseCrud.data.Telefono;

/**
 * MariaRepo
 */
public class MariaRepo implements Repositorio {

    private static final String URL = "jdbc:mariadb://localhost:3306/agenda_2";
    private String USUARIO;
    private String CONTRASEÑA;
    private Statement stmt;
    private Connection connection;

    public MariaRepo(String usuario, String contraseña) {
        
    }

	@Override
	public ArrayList<Persona> consultarTodasPersonas() {
		throw new UnsupportedOperationException("Unimplemented method 'consultarPersona'");
	}

    @Override
    public Persona consultarPersona(int id) {
        try {
            String sqlInstruccion = "SELECT nombre FROM Personas where id = ?";
            PreparedStatement ps = connection.prepareStatement(sqlInstruccion);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {   
                String nombre = rs.getString("nombre");
                rs.close();
                ps.close();
                return new Persona(id, nombre, null, null);
            } else {
                rs.close();
                ps.close();
                return null;
            }
        } catch (SQLException se) {
            se.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<Direccion> consultarTodasDirecciones() { 
        try {
            ArrayList<Direccion> direcciones = new ArrayList<>();
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Direcciones");

            while (rs.next()) {
                int id = rs.getInt("id");
                String direccionTex = rs.getString("direccion");

                Direccion direccion = new Direccion(id, direccionTex);

                direcciones.add(direccion);
            }

            rs.close();
            return direcciones;
        } catch (SQLException se) {
            se.printStackTrace();
            return null;
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
	}

	@Override
	public Direccion consultarDireccion(int id) {
        try {
            String sqlInstruccion = "SELECT direccion FROM Direcciones where id = ?";
            PreparedStatement ps = connection.prepareStatement(sqlInstruccion);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String direccion = rs.getString("direccion");
                rs.close();
                ps.close();
                return new Direccion(id, direccion);
            } else {
                rs.close();
                ps.close();
                return null;
            }
        } catch (SQLException se) {
            se.printStackTrace();
            return null;
        }
	}

	@Override
	public Telefono consultarTelefono(int id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'consultarTelefono'");
	}

    @Override
    public ArrayList<Telefono> consultarTelefonosDePersona(int personaId) {
        try {
            ArrayList<Telefono> telefonos = new ArrayList<>();

            String sqlInstruccion = "SELECT telefono FROM Telefonos where personaId = ?";
            PreparedStatement ps = connection.prepareStatement(sqlInstruccion);

            ps.setInt(1, personaId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                telefonos.add(new Telefono(rs.getInt("id"), personaId, rs.getString("telefono")));
            }

            rs.close();
            ps.close();
            return telefonos;
        } catch(SQLException se) {
            se.printStackTrace();
            return null;
        }
    }

	@Override
    public ArrayList<Direccion> consultarDireccionesDePersona(int personaId) {
        try {
            ArrayList<Direccion> direcciones = new ArrayList<>();

            String sqlInstruccion = "SELECT direccionId FROM Personas_Direcciones WHERE personaId = ?";
            PreparedStatement ps = connection.prepareStatement(sqlInstruccion);

            ps.setInt(1, personaId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Direccion direccion = consultarDireccion(rs.getInt("direccionId"));

                if (direccion != null) { direcciones.add(direccion); }
            }

            rs.close();
            ps.close();
            return direcciones;
        } catch(SQLException se) {
            se.printStackTrace();
            return null;
        }
	}

	@Override
    public ArrayList<Persona> consultarPersonasEnDireccion(int direccionId) {
        try {
            ArrayList<Persona> personas = new ArrayList<>();

            String sqlInstruccion = "SELECT personaId FROM Personas_Direcciones WHERE direccionId = ?";
            PreparedStatement ps = connection.prepareStatement(sqlInstruccion);

            ps.setInt(1, direccionId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Persona persona = consultarPersona(rs.getInt("personaId"));

                if (persona != null) { personas.add(persona); }
            }

            rs.close();
            ps.close();
            return personas;
        } catch (SQLException se) {
            se.printStackTrace();
            return null;
        }
	}

	@Override
	public boolean agregarPersona(Persona persona) { 
        try {
            String sqlInstruccion = "INSERT INTO Personas (nombre) VALUES (?)";
            PreparedStatement ps = connection.prepareStatement(sqlInstruccion);

            ps.setString(1, persona.getNombre());

            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        }
	}

	@Override
    public boolean agregarTelefono(Telefono telefono) {
        try {
            String sqlInstruccion = "INSERT INTO Telefonos (personaId, telefono) VALUES (?, ?)";
            PreparedStatement ps = connection.prepareStatement(sqlInstruccion);

            ps.setInt(1, telefono.getPersonaId());
            ps.setString(2, telefono.getNumeroTelefonico());

            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        }
    }

	@Override
    public boolean agregarDireccion(Direccion direccion) {
        try {
            String sqlInstruccion = "INSERT INTO Direcciones (direccion) VALUES (?)";
            PreparedStatement ps = connection.prepareStatement(sqlInstruccion);

            ps.setString(1, direccion.getDireccion());

            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        }
    }

	@Override
	public boolean modificarPersona(Persona persona) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'modificarPersona'");
	}

	@Override
	public boolean modificarDireccion(Direccion direccion) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'modificarDireccion'");
	}

	@Override
	public boolean modificarTelefono(Telefono telefono) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'modificarTelefono'");
	}

	@Override
	public boolean asignarDireccionAPersona(int personaId, int direccionId) {
        try {
            String sqlInstruccion = "INSERT INTO Personas_Direcciones (personaId, direccionId) VALUES (?, ?)";
            PreparedStatement ps = connection.prepareStatement(sqlInstruccion);

            ps.setInt(1, personaId);
            ps.setInt(2, direccionId);

            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        }
    }

	@Override
	public boolean asignarTelefonoAPersona(int personaId, int telefonoId) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'asignarTelefonoAPersona'");
	}

	@Override
    public boolean desasignarDireccionDePersona(int personaId, int direccionId) {
        try {
            String sqlInstruccion = "DELETE FROM Personas_Direcciones WHERE personaId = ?, direccionId = ?";
            PreparedStatement ps = connection.prepareStatement(sqlInstruccion);

            ps.setInt(1, personaId);
            ps.setInt(2, direccionId);
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        }
    }

	@Override
	public boolean desasignarTelefonoDePersona(int personaId, int direccionId) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'desasignarTelefonoDePersona'");
	}

	@Override
	public boolean eliminarPersona(int id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'eliminarPersona'");
	}

	@Override
	public boolean eliminarDireccion(int id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'eliminarDireccion'");
	}

	@Override
	public boolean eliminarTelefono(int id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'eliminarTelefono'");
	}

	@Override
    public boolean iniciarConexion() {
        try {
            // 1. Registrar el driver JDBC
            Class.forName("org.mariadb.jdbc.Driver");

            // 2. Establecer la conexión
            System.out.println("Conectando a la base de datos...");
            connection = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
            return true;
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
	}

	@Override
	public boolean cerrarConexion() {
        try {
            if (connection != null) { connection.close(); }
            return true;
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        }
	}
}
