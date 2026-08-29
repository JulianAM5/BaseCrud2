package uabc.julian.baseCrud.BaseDatos;

import java.util.List;

import uabc.julian.baseCrud.data.Direccion;
import uabc.julian.baseCrud.data.Persona;
import uabc.julian.baseCrud.data.Telefono;

/**
 * MariaRepo
 */
public class MariaRepo implements Repositorio {

	@Override
	public List<Persona> consultarTodasPersonas() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'consultarTodasPersonas'");
	}

	@Override
	public Persona consultarPersona(int id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'consultarPersona'");
	}

	@Override
	public List<Direccion> consultarTodasDirecciones() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'consultarTodasDirecciones'");
	}

	@Override
	public Direccion consultarDireccion(int id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'consultarDireccion'");
	}

	@Override
	public List<Telefono> consultarTodosTelefonos() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'consultarTodosTelefonos'");
	}

	@Override
	public Telefono consultarTelefono(int id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'consultarTelefono'");
	}

	@Override
	public List<Telefono> consultarTelefonosDePersona(int personaId) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'consultarTelefonosDePersona'");
	}

	@Override
	public List<Direccion> consultarDireccionesDePersona(int personaId) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'consultarDireccionesDePersona'");
	}

	@Override
	public List<Persona> consultarPersonaEnDireccion(int direccionId) {
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
}
