package com.mx.mex.Services;

import java.util.List;

import com.mx.mex.Dto.UsuariosAdminDTO;
import com.mx.mex.entities.UsuariosAdmin;

public interface UsuariosAdminService {

	List<UsuariosAdminDTO> getAllUsuariosAdmin();
	
	
	
	
//	------------------ CONSULTAS POR HIEBERNATE  --------------------

	String insertUserAdmin(UsuariosAdminDTO p);

	List<UsuariosAdmin> getAllUsuariosAdmin_Hibernate();

	String eliminarUserAdmin(UsuariosAdminDTO p);

	String updateUserAdmin(UsuariosAdmin p);
	
	

}// Fin de la class
