package com.mx.mex.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mx.mex.Dto.CatEstadosDTO;
import com.mx.mex.Dto.MensajeDTO;
import com.mx.mex.Dto.UsuariosAdminDTO;
import com.mx.mex.Services.CatEstadosService;
import com.mx.mex.entities.CatEstados;
import com.mx.mex.entities.UsuariosAdmin;


@Controller //Esta class es un controlador
@RequestMapping(value = "CatalogoEstados") // Nombre de este controller
public class CatEstadosController {
	
	@Autowired
	private CatEstadosService catEstadosService;
	
	
	
	/**
	 *  Consulta  estados por IDestado
	 * @param idEstado
	 * @return
	 */	
	@RequestMapping(value="/getCatEstados_Hibernate", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String getUsuariosAdmin_Hibernate(@RequestBody CatEstadosDTO idEstado){
		final HttpHeaders httpHeaders = new HttpHeaders();
		String respuesta = catEstadosService.getAllEstados_Hibernate(idEstado);
		
//		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
//		return new ResponseEntity <List<CatEstadosDTO>> (lista, httpHeaders, HttpStatus.OK);
		return respuesta;
    } 
	
	
	
	
	
	/**
	 *  Consulta  All estados...
	 * @param idEstado
	 * @return
	 */	
	@RequestMapping(value="/getAllCatEstados_Hibernate", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<List<CatEstados>> getAllEstados_Hibernate(){
		final HttpHeaders httpHeaders = new HttpHeaders();
		List<CatEstados> estados = catEstadosService.obtenerAllEstados_Hibernate();
		
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity <List<CatEstados>> (estados, httpHeaders, HttpStatus.OK);
		
    } 
	
	
	
	
	
	/**
	 *  Insertar nuevo estado...
	 * @param idEstado
	 * @return
	 */	
	@RequestMapping(value="/insertEstado_Hibernate", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String agregarNewEstado_Hibernate(@RequestBody CatEstadosDTO estado){
		final HttpHeaders httpHeaders = new HttpHeaders();
		String respuesta = catEstadosService.insertEstado_Hibernate(estado);
		
//		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
//		return new ResponseEntity <List<CatEstadosDTO>> (lista, httpHeaders, HttpStatus.OK);
		return respuesta;
    } 
	
	
	
	
	/**
	 * delete user admin por HIBERNATE
	 * @param p
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/eliminarEstadoId", method = RequestMethod.POST, produces = "application/json")
	ResponseEntity <String> eliminarEstadoPorId(@RequestBody CatEstadosDTO p){
		final HttpHeaders httpHeaders = new HttpHeaders();
		
		String respuesta = catEstadosService.eliminarEstadoId(p);
		
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity <String> (respuesta, httpHeaders, HttpStatus.OK);		
    }
	
	
	/**
	 * Service eliminar con mensaje string
	 * @param p
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/eliminarEstadoPorId", method = RequestMethod.POST, produces = "application/json")
	public MensajeDTO eliminarEstadoPorIde(@RequestBody CatEstadosDTO p){
		final HttpHeaders httpHeaders = new HttpHeaders();
		
//		String respuesta = catEstadosService.eliminarEstadoId(p);
		return catEstadosService.eliminarEstadoPorIdent(p);
		
//		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
//		return new ResponseEntity <String> (respuesta, httpHeaders, HttpStatus.OK);		
    }
	
	
	
	
	
	

	/**
	 *  Insertar nuevo estado...
	 * @param idEstado
	 * @return
	 */	
	@RequestMapping(value="/updateEstado_Hibernate", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String agctualizarEstado_Hibernate(@RequestBody CatEstadosDTO datoEstado){
		final HttpHeaders httpHeaders = new HttpHeaders();
		String respuesta = catEstadosService.actualizarEstado_Hibernate(datoEstado);
		
//		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
//		return new ResponseEntity <List<CatEstadosDTO>> (lista, httpHeaders, HttpStatus.OK);
		return respuesta;
    } 
	
	
	

}
