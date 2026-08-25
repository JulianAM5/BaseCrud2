package uabc.julian.baseCrud;

import java.lang.reflect.Array;
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

    public EnlaceDB() {

    }

    public ArrayList<Persona> RecuperarPersonas() {
        try {
            ArrayList<Persona> personas = new ArrayList<>();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Personas");

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");

                Persona persona = new Persona(id, nombre);

                personas.add(persona);
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

    public ArrayList<Direccion> RecuperarDirecciones() {
        try {
            ArrayList<Direccion> direcciones = new ArrayList<>();
            stmt = conn.createStatement();
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

    public Persona RecuperarPersona(int id) {
        try {
            String sqlInstruccion = "SELECT nombre FROM Personas where id = ?";
            PreparedStatement ps = conn.prepareStatement(sqlInstruccion);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {   
                String nombre = rs.getString("nombre");
                rs.close();
                ps.close();
                return new Persona(id, nombre);
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

    public Direccion RecuperarDireccion(int id) {
        try {
            String sqlInstruccion = "SELECT direccion FROM Direcciones where id = ?";
            PreparedStatement ps = conn.prepareStatement(sqlInstruccion);
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

    public ArrayList<Telefono> RecuperarTelefonosDePersona(int personaId) {
        try {
            ArrayList<Telefono> telefonos = new ArrayList<>();

            String sqlInstruccion = "SELECT telefono FROM Telefonos where personaId = ?";
            PreparedStatement ps = conn.prepareStatement(sqlInstruccion);

            ps.setInt(1, personaId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                telefonos.add(new Telefono(personaId, rs.getString("telefono")));
            }

            rs.close();
            ps.close();
            return telefonos;
        } catch(SQLException se) {
            se.printStackTrace();
            return null;
        }
    }

    public ArrayList<Direccion> RecuperarDireccionesDePersona(int personaId) {
        try {
            ArrayList<Direccion> direcciones = new ArrayList<>();

            String sqlInstruccion = "SELECT direccionId FROM Personas_Direcciones WHERE personaId = ?";
            PreparedStatement ps = conn.prepareStatement(sqlInstruccion);

            ps.setInt(1, personaId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Direccion direccion = RecuperarDireccion(rs.getInt("direccionId"));
                
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

    public ArrayList<Persona> RecuperarPersonasAsociadasADireccion(int direccionId) {
        try {
            ArrayList<Persona> personas = new ArrayList<>();
            
            String sqlInstruccion = "SELECT personaId FROM Personas_Direcciones WHERE direccion = ?";
            PreparedStatement ps = conn.prepareStatement(sqlInstruccion);

            ps.setInt(1, direccionId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Persona persona = RecuperarPersona(rs.getInt("personaId"));

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
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
