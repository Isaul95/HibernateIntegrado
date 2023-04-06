package com.mx.mex.Repository;

import java.util.List;
import com.mx.mex.Dto.UsuariosAdminDTO;
import com.mx.mex.entities.UsuariosAdmin;


public interface UsuariosAdminDAO{// extends DAO<UsuariosAdmin, Long>

	List<UsuariosAdminDTO> obtenerAllUserAdmin();
	
	
	
//	-------------------------- consultas por hibernate  ---------------------------

	Integer insertarUsuario(UsuariosAdmin usuariosAdmin);

	List<UsuariosAdmin> obtenerAllUserAdmin_Hibernate();

	Integer eliminaUsuario(Long idUser);

	Integer actualizarUsuario(UsuariosAdmin usuariosAdmin);
	
	


}// Fin class
