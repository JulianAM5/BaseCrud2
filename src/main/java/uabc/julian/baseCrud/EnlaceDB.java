package uabc.julian.baseCrud;

import java.sql.*;
import java.util.ArrayList;

import uabc.julian.baseCrud.data.Direccion;
import uabc.julian.baseCrud.data.Persona;
import uabc.julian.baseCrud.data.Telefono;

/**
 * EnlaceDB
 */
public class EnlaceDB {

    // Datos de conexión a la base de datos
    private static final String URL = "jdbc:mariadb://localhost:3306/agenda";
    private static final String USER = "usuario1";
    private static final String PASSWORD = "superpassword";

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    public EnlaceDB() {

    }

    public ArrayList<Persona> RecuperarPersonas() {
        try {
            ArrayList<Persona> personas = new ArrayList<>();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM Personas");

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");

                Persona persona = new Persona(id, nombre);

                personas.add(persona);
            }

            return personas;
        } catch (SQLException se) {
            se.printStackTrace();
            return null;
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public Persona RecuperarPersona(int id) {
        try {
            String sqlInstruccion = "SELECT nombre FROM Personas where id = ?";
            PreparedStatement ps = conn.prepareStatement(sqlInstruccion);
            ps.setInt(1, id);
            
            rs = ps.executeQuery();

            String nombre = rs.getString("nombre");

            ps.close();
            return new Persona(id, nombre);
        } catch (SQLException se) {
            se.printStackTrace();
            return null;
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public Direccion RecuperarDireccion(int id) {
        try {
            String sqlInstruccion = "SELECT direccion FROM Direcciones where id = ?";
            PreparedStatement ps = conn.prepareStatement(sqlInstruccion);
            ps.setInt(1, id);

            rs = ps.executeQuery();

            String direccion = rs.getString("direccion");

            ps.close();
            return new Direccion(id, direccion);
        } catch (SQLException se) {
            se.printStackTrace();
            return null;
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

    }

    public ArrayList<Telefono> RecuperarTelefonosDePersona(int personaId) {
        try {
            ArrayList<Telefono> telefonos = new ArrayList<>();

            String sqlInstruccion = "SELECT telefono FROM Telefonos where personaId = ?";
            PreparedStatement ps = conn.prepareStatement(sqlInstruccion);

            ps.setInt(1, personaId);
            rs = ps.executeQuery();

            while (rs.next()) {
                telefonos.add(new Telefono(personaId, rs.getString("telefono")));
            }

            ps.close();
            return telefonos;
        } catch(SQLException se) {
            se.printStackTrace();
            return null;
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public ArrayList<Direccion> RecuperarDireccionesDePersona(int personaId) {
        try {
            ArrayList<Direccion> direcciones = new ArrayList<>();

            String sqlInstruccion = "SELECT direccionId FROM Personas_Direcciones where personaId = ?";
            PreparedStatement ps = conn.prepareStatement(sqlInstruccion);

            ps.setInt(1, personaId);
            rs = ps.executeQuery();

            while (rs.next()) {
                
            }

            return direcciones;
        } catch(SQLException se) {
            se.printStackTrace();
            return null;
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public void ConectarAServidor() {
        try {
            // 1. Registrar el driver JDBC
            Class.forName("org.mariadb.jdbc.Driver");

            // 2. Establecer la conexión
            System.out.println("Conectando a la base de datos...");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    public void CerrarConexion() {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
