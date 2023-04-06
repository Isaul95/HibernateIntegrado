package com.mx.mex.ServicesImplement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mx.mex.Dto.UsuariosAdminDTO;
import com.mx.mex.Repository.UsuariosAdminDAO;
import com.mx.mex.Services.UsuariosAdminService;
import com.mx.mex.entities.UsuariosAdmin;


@Service
public class UsuariosAdminImpl implements UsuariosAdminService{
	
//	Inyección de dependencias - LLAMAR/CONECTAR CON LAS CLASES DE DAO (interface)
	@Autowired
	private UsuariosAdminDAO usuariosAdminDAO;

	
	@Override
	public List<UsuariosAdminDTO> getAllUsuariosAdmin() {
				
		return usuariosAdminDAO.obtenerAllUserAdmin();
	}

	
	/**
	 * Guardar new usuario por hibernate
	 */
	@Override
	public String insertUserAdmin(UsuariosAdminDTO p) {
		UsuariosAdmin usuariosAdmin = new UsuariosAdmin();
		
		usuariosAdmin.setIdUser(p.getIdUser());
		usuariosAdmin.setNombreCompleto(p.getNombreCompleto());
		usuariosAdmin.setEdad(p.getEdad());
		usuariosAdmin.setDireccion(p.getDireccion());
		usuariosAdmin.setEstado(p.getEstadoInt());
		usuariosAdmin.setRol(p.getRolInt());
		
//	usuariosAdminDAO.create(usuariosAdmin); // Guardando info con hibernate desde aqui en Negocio
		
		Integer respuesta = usuariosAdminDAO.insertarUsuario(usuariosAdmin);
		String respuestaInsert;
		
		if(respuesta==0) 
			respuestaInsert="¡No se insertó correctamente!";
		else 
			respuestaInsert="¡Se insertó correctamente!";
				
		return respuestaInsert;
	}

	

	@Override
	public List<UsuariosAdmin> getAllUsuariosAdmin_Hibernate() {
		
		List<UsuariosAdmin> usuariosAdmin = usuariosAdminDAO.obtenerAllUserAdmin_Hibernate();
		
		System.out.println(" Consult inf for hibernate ----->"+usuariosAdmin.size());
		
		return usuariosAdmin;
	}


	@Override
	public String eliminarUserAdmin(UsuariosAdminDTO p) {
		
		Integer respuesta = usuariosAdminDAO.eliminaUsuario(p.getIdUser());
		String respuestaDelete;
		
		if(respuesta==0) 
			respuestaDelete="¡Error al eliminar!";
		else 
			respuestaDelete="¡Elimino correctamente!";
				
		return respuestaDelete;
	}


	
	
	@Override
	public String updateUserAdmin(UsuariosAdmin p) {
		
//		UsuariosAdmin usuariosAdmin = new UsuariosAdmin();
//		
//		usuariosAdmin.setIdUser(p.getIdUser());
//		usuariosAdmin.setNombreCompleto(p.getNombreCompleto());
//		usuariosAdmin.setEdad(p.getEdad());
//		usuariosAdmin.setDireccion(p.getDireccion());
//		usuariosAdmin.setEstado(p.getEstadoInt());
//		usuariosAdmin.setRol(p.getRolInt());
		
		Integer respuesta = usuariosAdminDAO.actualizarUsuario(p);
		String respuestaUpdate;
		
		if(respuesta==0) 
			respuestaUpdate="¡Error al Actualizar info...!";
		else 
			respuestaUpdate="¡Actualizo correctamente!";
				
		return respuestaUpdate;
	}
	
	
	

} // Fin de la class
