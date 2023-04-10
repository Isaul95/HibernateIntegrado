package com.mx.mex.controller;

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

import com.mx.mex.Dto.DatosEmpleadosDTO;
import com.mx.mex.Services.DatosEmpleadosService;
import com.mx.mex.entities.DatosEmpleados;

@Controller
@RequestMapping(value="DatosEmpleados")
public class DatosEmpleadosController {
	
	@Autowired
	private DatosEmpleadosService datosEmpleadosService;
	
	//-----------Agregar Empleado-------------
	@ResponseBody 
	@RequestMapping(value="/getDatosEmpleados", method = RequestMethod.POST, produces = "application/json") 
	ResponseEntity < String> getDatosEmpleados(@RequestBody DatosEmpleadosDTO rfc){
		final HttpHeaders httpHeaders = new HttpHeaders();
		String respuesta = datosEmpleadosService.getDatosEmpleados(rfc);
		
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		return new ResponseEntity <String> (respuesta, httpHeaders, HttpStatus.OK);	
    }
	
	
	
	//-----------Eliminar Empleado-------------
		@ResponseBody 
		@RequestMapping(value="/eliminarEmpleados", method = RequestMethod.POST, produces = "application/json") 
		ResponseEntity < String> getEmpleados(@RequestBody DatosEmpleadosDTO id){
			final HttpHeaders httpHeaders = new HttpHeaders();
			String respuesta = datosEmpleadosService.elimarEmpleados(id);
			
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			
			return new ResponseEntity <String> (respuesta, httpHeaders, HttpStatus.OK);	
	    }
	
		
		///--------Actualizar empleado ---------
	
		@ResponseBody 
		@RequestMapping(value="/updateDatosEmpleados", method = RequestMethod.POST, produces = "application/json") 
		ResponseEntity < String> updateDatosEmpleados(@RequestBody DatosEmpleadosDTO datoEmpleado){
			final HttpHeaders httpHeaders = new HttpHeaders();
			String respuesta = datosEmpleadosService.updateDatosEmpleados(datoEmpleado);
			
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			
			return new ResponseEntity <String> (respuesta, httpHeaders, HttpStatus.OK);	
	    }
		
		//--------Consultar Empleados Hombres ---------
		
			@ResponseBody 
			@RequestMapping(value="/consultarEmpleadosHombres", method = RequestMethod.GET, produces = "application/json") 
			public ResponseEntity<List<DatosEmpleados>> consultarEmpleadosHombres(){
				final HttpHeaders httpHeaders = new HttpHeaders();
				List<DatosEmpleados> estados = datosEmpleadosService.consultarEmpleadosHombres();
				
				httpHeaders.setContentType(MediaType.APPLICATION_JSON);
				return new ResponseEntity <List<DatosEmpleados>> (estados, httpHeaders, HttpStatus.OK);
		    }
		
			
			
			//--------Consultar Empleados Mujeres ---------
			
			@ResponseBody 
			@RequestMapping(value="/consultarEmpleadosMujeres", method = RequestMethod.GET, produces = "application/json") 
			public ResponseEntity<List<DatosEmpleados>> consultarEmpleadosMujeres(){
				final HttpHeaders httpHeaders = new HttpHeaders();
				List<DatosEmpleados> estados = datosEmpleadosService.consultarEmpleadosMujeres();
				
				httpHeaders.setContentType(MediaType.APPLICATION_JSON);
				return new ResponseEntity <List<DatosEmpleados>> (estados, httpHeaders, HttpStatus.OK);
		    }
		
		
		//--------- Buscar por RFC-----
		
			@ResponseBody 
			@RequestMapping(value="/buscarEmpleado", method = RequestMethod.POST, produces = "application/json") 
			ResponseEntity <String> buscarEmpleado(@RequestBody DatosEmpleadosDTO buscarEmpleado){
				final HttpHeaders httpHeaders = new HttpHeaders();
				String respuesta = datosEmpleadosService.buscarEmpleado(buscarEmpleado);
				
				httpHeaders.setContentType(MediaType.APPLICATION_JSON);
				
				return new ResponseEntity <String> (respuesta, httpHeaders, HttpStatus.OK);	
		    }
			
			
		
}
