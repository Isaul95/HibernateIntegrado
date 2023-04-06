package com.mx.mex.controller;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mx.mex.Dto.AlumnosNoviembre;
import com.mx.mex.Dto.Aspirantes;
import com.mx.mex.Dto.UsuariosAdminDTO;
import com.mx.mex.Services.UsuariosAdminService;
import com.mx.mex.entities.UsuariosAdmin;


@Controller //Esta class es un controlador
@RequestMapping(value = "UsuariosAdmin") // Nombre de este controller
public class UsuariosAdminController {
	
	
// Inyección de dependencias - LLAMAR/CONECTAR CON LAS CLASES DE SERVICIO (interface)
	@Autowired
	private UsuariosAdminService usuariosAdminService;
	
	
	/**
	 * Get all user admin... JDBCTEMPLATE
	 * @return
	 */
	@ResponseBody 
	@RequestMapping (value= "/getUsuarioAdmin", method = RequestMethod.GET, produces = "application/json") 
	ResponseEntity < List<UsuariosAdminDTO>> getUsuariosAdmin(){
		final HttpHeaders httpHeaders = new HttpHeaders();
		List<UsuariosAdminDTO> lista = usuariosAdminService.getAllUsuariosAdmin();
		
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		return new ResponseEntity <List<UsuariosAdminDTO>> (lista, httpHeaders, HttpStatus.OK);	
    } 
	
	
	
	
	
	
	
	
	
//	**************************    consultas por HIBERNATE      ************************
	
	/**
	 * Get all user admin... JDBCTEMPLATE
	 * @return
	 */
	@ResponseBody 
	@RequestMapping (value= "/getUsuarioAdminHibernate", method = RequestMethod.GET, produces = "application/json") 
	ResponseEntity < List<UsuariosAdmin>> getUsuariosAdmin_Hibernate(){
		final HttpHeaders httpHeaders = new HttpHeaders();
		List<UsuariosAdmin> lista = usuariosAdminService.getAllUsuariosAdmin_Hibernate();
		
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		return new ResponseEntity <List<UsuariosAdmin>> (lista, httpHeaders, HttpStatus.OK);	
    } 
	
	
	/**
	 * Add user admin por HIBERNATE
	 * @param p
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/insertUsuariosAdmin", method = RequestMethod.POST, produces = "application/json")
	ResponseEntity <String> insertAspirantes(@RequestBody UsuariosAdminDTO p){
		final HttpHeaders httpHeaders = new HttpHeaders();
		
		System.out.println(" Controller... ----- ");
		
		String respuesta = usuariosAdminService.insertUserAdmin(p);
		
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity <String> (respuesta, httpHeaders, HttpStatus.OK);		
    }
	
	
	
	/**
	 * delete user admin por HIBERNATE
	 * @param p
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/eliminarUsuarioAdmin", method = RequestMethod.POST, produces = "application/json")
	ResponseEntity <String> eliminarUserAdmin(@RequestBody UsuariosAdminDTO p){
		final HttpHeaders httpHeaders = new HttpHeaders();
		
		System.out.println(" Controller... -----> "+p.getIdUser());
		
		String respuesta = usuariosAdminService.eliminarUserAdmin(p);
		
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity <String> (respuesta, httpHeaders, HttpStatus.OK);		
    }
	
	
	
	
	
	/**
	 * Update user admin por - HIBERNATE
	 * @param p
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/actualizarUsuariosAdmin", method = RequestMethod.POST, produces = "application/json")
	ResponseEntity <String> actualizarAspirantes(@RequestBody UsuariosAdmin p){
		final HttpHeaders httpHeaders = new HttpHeaders();
		
		System.out.println(" Controller... ----- ");
		
		String respuesta = usuariosAdminService.updateUserAdmin(p);
		
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity <String> (respuesta, httpHeaders, HttpStatus.OK);		
    }
	

} // Fin de la clase de controlador
