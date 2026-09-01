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
        USUARIO = usuario;
        CONTRASEÑA = contraseña;
    }

	@Override
    public ArrayList<Persona> consultarTodasPersonas() {
        try {
            ArrayList<Persona> personas = new ArrayList<>();
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id FROM Personas");

            while (rs.next()) {
                int id = rs.getInt("id");

                personas.add(consultarPersona(id));
            }

            rs.close();
            return personas;
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
                return new Persona(id, nombre, consultarDireccionesDePersona(id), consultarTelefonosDePersona(id));
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
        try {
            String sqlInstruccion = "SELECT * FROM Telefonos where id = ?";
            PreparedStatement ps = connection.prepareStatement(sqlInstruccion);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int personaId = rs.getInt("personaId");
                String numeroTelefonico = rs.getString("telefono");
                rs.close();
                ps.close();
                return new Telefono(id, personaId, numeroTelefonico);
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
    public ArrayList<Telefono> consultarTelefonosDePersona(int personaId) {
        try {
            ArrayList<Telefono> telefonos = new ArrayList<>();

            String sqlInstruccion = "SELECT id, telefono FROM Telefonos where personaId = ?";
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
            PreparedStatement ps = connection.prepareStatement(sqlInstruccion, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, persona.getNombre());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                persona.setId(rs.getInt(1));
            }

            ps.close();
            
            for (Direccion direccion : persona.getDirecciones()) {
                if (consultarDireccion(direccion.getId()) != null) {
                    asignarDireccionAPersona(persona.getId(), direccion.getId());
                } else {
                    int direccionId = agregarDireccion(direccion);
                    asignarDireccionAPersona(persona.getId(), direccionId);
                }
            }
            
            for (Telefono telefono : persona.getTelefonos()) {
                telefono.setPersonaId(persona.getId());
                agregarTelefono(telefono);
            }

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
    public int agregarDireccion(Direccion direccion) {
        try {
            String sqlInstruccion = "INSERT INTO Direcciones (direccion) VALUES (?)";
            PreparedStatement ps = connection.prepareStatement(sqlInstruccion, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, direccion.getDireccion());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            int id = -1;
            if (rs.next()) {
                id = rs.getInt(1);
            }

            ps.close();
            return id;
        } catch (SQLException se) {
            se.printStackTrace();
            return -1;
        }
    }

	@Override
    public boolean modificarPersona(Persona persona) {
        try {
            String sqlInstruccion = "UPDATE Personas SET nombre = ? WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sqlInstruccion);

            ps.setString(1, persona.getNombre());
            ps.setInt(2, persona.getId());

            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        }
	}

	@Override
    public boolean modificarDireccion(Direccion direccion) {
        try {
            String sqlInstruccion = "UPDATE Direcciones SET direccion = ? WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sqlInstruccion);

            ps.setString(1, direccion.getDireccion());
            ps.setInt(2, direccion.getId());

            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        }
    }

	@Override
    public boolean modificarTelefono(Telefono telefono) {
        try {
            String sqlInstruccion = "UPDATE Telefonos SET telefono = ? WHERE personaId = ?";
            PreparedStatement ps = connection.prepareStatement(sqlInstruccion);

            ps.setString(1, telefono.getNumeroTelefonico());
            ps.setInt(2, telefono.getPersonaId());

            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        }       
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
    public boolean eliminarPersona(int id) {
        try {
            String sqlInstruccion = "DELETE FROM Personas WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sqlInstruccion);

            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        }
    }

	@Override
    public boolean eliminarDireccion(int id) {
        try {
            String sqlInstruccion = "DELETE FROM Direcciones WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sqlInstruccion);

            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        }
    }

	@Override
    public boolean eliminarTelefono(int id) {
        try {
            String sqlInstruccion = "DELETE FROM Telefonos WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sqlInstruccion);

            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        }
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

	@Override
	public void setCredenciales(String usuario, String contraseña) {
        this.USUARIO = usuario;
        this.CONTRASEÑA = contraseña;
	}
}
