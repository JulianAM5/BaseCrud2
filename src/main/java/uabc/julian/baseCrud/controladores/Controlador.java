package uabc.julian.baseCrud.controladores;

import java.util.List;

import uabc.julian.baseCrud.data.Direccion;
import uabc.julian.baseCrud.data.Persona;
import uabc.julian.baseCrud.data.Telefono;

/**
 * Controlador
 */
public class Controlador implements Escritor, Lector {

	@Override
	public List<Persona> leerPersonas() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'leerPersonas'");
	}

	@Override
	public List<Direccion> leerDirecciones() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'leerDirecciones'");
	}

	@Override
	public List<Telefono> leerTelefonos() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'leerTelefonos'");
	}

	@Override
	public Persona leerPersona(int id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'leerPersona'");
	}

	@Override
	public Direccion leerDireccion(int id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'leerDireccion'");
	}

	@Override
	public Telefono leerTelefono(int id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'leerTelefono'");
	}

	@Override
	public boolean agregarPersona(Persona persona) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'agregarPersona'");
	}

	@Override
	public boolean agregarDireccion(Direccion direccion) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'agregarDireccion'");
	}

	@Override
	public boolean agregarTelefono(Telefono telefono) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'agregarTelefono'");
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
	public boolean asignarDireccionAPersona(int personaId, int direccionId) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'asignarDireccionAPersona'");
	}

	@Override
	public boolean desasignarDireccionAPersona(int personaId, int direccionId) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'desasignarDireccionAPersona'");
	}

	@Override
	public boolean asignarTelefonoAPersona(int personaId, int telefonoId) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'asignarTelefonoAPersona'");
	}

	@Override
	public boolean desasignarTelefonoAPersona(int personaId, int telefonoId) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'desasignarTelefonoAPersona'");
	}
}
