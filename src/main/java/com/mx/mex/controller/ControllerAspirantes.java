package com.mx.mex.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mx.mex.Dto.Aspirantes;
import com.mx.mex.Services.IAspirantes;

@Controller
@RequestMapping(value="Aspirantes")
public class ControllerAspirantes {
	
	@Autowired 
	private IAspirantes aspirantes;
	
	
	
	// UN METODO SE COMPONE POR
	// TIPO DE IDENTIFICADOR (PUBLIC, PRIVATE O PROTECTED)
	//
	
	//JSON LA REPRESENTACION DE UNA CLASE Y SUS VARIABLES
	/*{	
		alumno: "Alumno",
		edad: 12,
		nombre: "Jorge"		
	}*/
	
	
	
	@ResponseBody //NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
	@RequestMapping(value="/getAspirantes", method = RequestMethod.GET, produces = "application/json")
	ResponseEntity <  List<Aspirantes> > getAspirantes(){
		final HttpHeaders httpHeaders = new HttpHeaders();
		List<Aspirantes> lista = aspirantes.getAspirantes();
		
//		for(Aspirantes run : lista) {
//			System.out.println("Nombre: "+run.getIdAlumno());
//	    	System.out.println("Edad: "+run.getNombreAlumno());
//	    	System.out.println("Direccion: "+run.getEdad());
//	    	System.out.println("Nombre: "+run.getFechaInscripcion());
//	    	System.out.println("Edad: "+run.getCurso());
//	    	System.out.println("Direccion: "+run.getMaestro());
//		}
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		return new ResponseEntity <List<Aspirantes>> (lista, httpHeaders, HttpStatus.OK);	
    } //202 = OK 
	// 200 = OK
	// 403 = NO PERMITIDO 
	// 404 = LA PAGINA O RUTA NO SE ENCUENTRA
	// 500 = ES UN EXCEPCionN INTERNA
	// 503 = NO TE ENCUENTRAS AUTORIZADA
	// 
	
	
	
	@ResponseBody
	@RequestMapping(value="/insertAspirantes", method = RequestMethod.POST, produces = "application/json") //= select * from Aspirantes
	ResponseEntity <String> insertAspirantes(@RequestBody Aspirantes p){
		final HttpHeaders httpHeaders = new HttpHeaders();
		
		
		System.out.println("Nombre: "+p.getIdAlumno());
    	System.out.println("Edad: "+p.getNombreAlumno());
    	System.out.println("Direccion: "+p.getEdad());
    	System.out.println("Nombre: "+p.getFechaInscripcion());
    	System.out.println("Edad: "+p.getCurso());
    	System.out.println("Direccion: "+p.getMaestro());
    	
		String respuesta = aspirantes.insertAspirantes(p);
		
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity <String> (respuesta, httpHeaders, HttpStatus.OK);		
    }
	
	@ResponseBody // NOS PERMITE MANDAR LA RESPUESTA COMO VALORES
	@RequestMapping(value="/updateAspirantes", method = RequestMethod.POST, produces = "application/json") //= select * from Aspirantes
	ResponseEntity <String> updateAspirantes(@RequestBody Aspirantes p){
		final HttpHeaders httpHeaders = new HttpHeaders();

		System.out.println("Nombre: "+p.getIdAlumno());
    	System.out.println("Edad: "+p.getNombreAlumno());
    	System.out.println("Direccion: "+p.getEdad());
    	System.out.println("Nombre: "+p.getFechaInscripcion());
    	System.out.println("Edad: "+p.getCurso());
    	System.out.println("Direccion: "+p.getMaestro());
    	
		String respuesta = aspirantes.updateAspirantes(p);
		
		httpHeaders.setContentType(MediaType.APPLICATION_JSON); //NOS PERMITE RECIBIR UNICAMENTE DATOS EN FORMATO JSON
		return new ResponseEntity <String> (respuesta, httpHeaders, HttpStatus.OK);		
    }
	
	
	
	@ResponseBody // NOS PERMITE MANDAR LA RESPUESTA COMO VALORES
	@RequestMapping(value="/deleteAspirantes", method = RequestMethod.POST, produces = "application/json") //= select * from Aspirantes
	ResponseEntity <String> deleteAspirantes(@RequestBody Aspirantes p){
		final HttpHeaders httpHeaders = new HttpHeaders();

		System.out.println("Nombre: "+p.getIdAlumno());
    	System.out.println("Edad: "+p.getNombreAlumno());
    	System.out.println("Direccion: "+p.getEdad());
    	System.out.println("Nombre: "+p.getFechaInscripcion());
    	System.out.println("Edad: "+p.getCurso());
    	System.out.println("Direccion: "+p.getMaestro());
    	
		String respuesta = aspirantes.deleteAspirantes(p);
		
		httpHeaders.setContentType(MediaType.APPLICATION_JSON); //NOS PERMITE RECIBIR UNICAMENTE DATOS EN FORMATO JSON
		return new ResponseEntity <String> (respuesta, httpHeaders, HttpStatus.OK);		
    }
		
//		List<Aspirantes> listaAspirantes = new ArrayList<>();
//		Aspirantes objeto = new Aspirantes(); // puede contener un registro
//		objeto.setCurso("1");
//	    objeto.setEdad(12);
//	    objeto.setFechaInscripcion(new Date());
//	    objeto.setIdAlumno(new BigDecimal(1));
//	    objeto.setMasestro("Jacinto");
//	    objeto.setNombreAlumno("Taboada");
//	    
//	 
//	  
//	    listaAspirantes.add(objeto); //PUEDES ASIGNAR UN OBJETO  , alexis
//		   
//	    objeto.setCurso("0001");
//		objeto.setEdad(12);
//		objeto.setFechaInscripcion(new Date());
//		objeto.setIdAlumno(new BigDecimal(1));
//		objeto.setMasestro("Jacinto");
//		objeto.setNombreAlumno("Taboada");
//		   
//		listaAspirantes.add(objeto); //PUEDES ASIGNAR UN OBJETO ,, arturo 
//		
//		// de los 1000 registros, solamente vas a ver el ultimo en el objeto
		
	
	
	
	
	
	
}
