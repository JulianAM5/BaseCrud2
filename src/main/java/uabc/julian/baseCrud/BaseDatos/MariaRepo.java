package uabc.julian.baseCrud.BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
    private Connection connection;

    public MariaRepo(String usuario, String contraseña) {
        
    }

	@Override
	public ArrayList<Persona> consultarTodasPersonas() {
		throw new UnsupportedOperationException("Unimplemented method 'consultarPersona'");
	}

	@Override
	public Persona consultarPersona(int id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'consultarPersona'");
	}

	@Override
	public ArrayList<Direccion> consultarTodasDirecciones() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'consultarTodasDirecciones'");
	}

	@Override
	public Direccion consultarDireccion(int id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'consultarDireccion'");
	}

	@Override
	public ArrayList<Telefono> consultarTodosTelefonos() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'consultarTodosTelefonos'");
	}

	@Override
	public Telefono consultarTelefono(int id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'consultarTelefono'");
	}

	@Override
	public ArrayList<Telefono> consultarTelefonosDePersona(int personaId) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'consultarTelefonosDePersona'");
	}

	@Override
	public ArrayList<Direccion> consultarDireccionesDePersona(int personaId) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'consultarDireccionesDePersona'");
	}

	@Override
	public ArrayList<Persona> consultarPersonaEnDireccion(int direccionId) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'consultarPersonaEnDireccion'");
	}

	@Override
	public boolean agregarPersona(Persona persona) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'agregarPersona'");
	}

	@Override
	public boolean agregarTelefono(Telefono telefono) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'agregarTelefono'");
	}

	@Override
	public boolean agregarDireccion(Direccion direccion) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'agregarDireccion'");
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
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'asignarDireccionAPersona'");
	}

	@Override
	public boolean asignarTelefonoAPersona(int personaId, int telefonoId) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'asignarTelefonoAPersona'");
	}

	@Override
	public boolean desasignarDireccionDePersona(int personaId, int direccionId) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'desasignarDireccionDePersona'");
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
