package com.mx.mex.Services;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.mex.Dto.DatosEmpleadosDTO;
import com.mx.mex.Repository.DatosEmpleadosDAO;
import com.mx.mex.entities.CatEstados;
import com.mx.mex.entities.DatosEmpleados;


@Service
public class DatosEmpleadosServiceImpl implements DatosEmpleadosService {
	@Autowired
	private DatosEmpleadosDAO datosEmpleadosDAO;

	Integer ValidarRfc(String rfc){
		String validaRfc = null;
		Integer respuesta = 0;
		
		DatosEmpleados dato = datosEmpleadosDAO.buscarDatosRfc(rfc);
		
		validaRfc= dato.getRfc();
		Pattern patN = Pattern.compile("^[A-Z]{4}[0-9]{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])[A-Z0-9]{2}[0-9A]$");
		Matcher matN = patN.matcher(validaRfc);
		
		if(matN.find()) {
			respuesta= 1;
			System.out.println("El rfc es valido");
			}else {
				respuesta=0;
			}
		
		return respuesta;
		
	}
	
	@SuppressWarnings("unused")
	@Override
	public String getDatosEmpleados(DatosEmpleadosDTO rfc) {
		String validaRfc = "";
		String respuesta=null;
		if (rfc.getRfc() == null || rfc.getRfc().isEmpty()){
			respuesta="El RFC es un dato requerido, favor de insertarlo";
			
		}else {
			
			Integer valida = ValidarRfc(rfc.getRfc());
			if(valida == 1) {
			
			DatosEmpleados dato = datosEmpleadosDAO.buscarDatosRfc(rfc.getRfc());
			/*validaRfc= dato.getRfc();
			Pattern patN = Pattern.compile("^[A-Z]{4}[0-9]{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])[A-Z0-9]{2}[0-9A]$");
			
			Matcher matN = patN.matcher(validaRfc);*/
			
			//if(matN.find()) {
				//System.out.println("El rfc es valido");
				if(dato == null) {
					DatosEmpleados entity = new DatosEmpleados();
					entity.setIdDatosEmpleados(rfc.getIdDatosEmpleados());
					entity.setNombreCompleto(rfc.getNombreCompleto());
					entity.setRfc(rfc.getRfc());
					entity.setEdad(rfc.getEdad());
					entity.setDireccion(rfc.getDireccion());
					entity.setTelefono(rfc.getTelefono());
					entity.setSexo(rfc.getSexo());
					entity.setActivo(rfc.getActivo());
					datosEmpleadosDAO.create(entity);
					respuesta = "El dato se guardo correctamente";
			}else {
				respuesta="El registro ya existe en la base de datos";
			}
		//}else {
			//respuesta="El RFC no es valido";
		//}
			}else {
				respuesta="El RFC no es valido";
			}
		}
	return respuesta;
			
	}

	@Override
	public String elimarEmpleados(DatosEmpleadosDTO id) {
		
		String respuesta=null;
		if (id.getIdDatosEmpleados() !=0 ||id.getIdDatosEmpleados() != null ){
			DatosEmpleados existeUsuario = datosEmpleadosDAO.read(id.getIdDatosEmpleados());
			
			if(existeUsuario != null) {
				
				if(existeUsuario.getActivo() == 0) {
					datosEmpleadosDAO.delete(id.getIdDatosEmpleados());
					respuesta="Empleado eliminado correctamente";
					
				}else {
					respuesta="Imposible eliminar Empleado, Sigue Laborando (Activo)...!";
				}
			}else {
				respuesta="No existe el usuario";
			}
			
		}else {
			respuesta="Ingresa un id para buscar en la base de datos";
		}
		return respuesta;
	}

	@Override
	public String updateDatosEmpleados(DatosEmpleadosDTO datos) {
			String respuesta=null;
			if(datos.getIdDatosEmpleados()!=0 ||datos.getIdDatosEmpleados() != null ){
				DatosEmpleados existeUsuario = datosEmpleadosDAO.read(datos.getIdDatosEmpleados());
				
				if(existeUsuario != null) {
				
				if(existeUsuario.getActivo() == 1) {
					
					DatosEmpleados update = new DatosEmpleados();
					update.setIdDatosEmpleados(datos.getIdDatosEmpleados());
					
					update.setNombreCompleto(datos.getNombreCompleto());
					update.setRfc(datos.getRfc());
					update.setEdad(datos.getEdad());
					update.setDireccion(datos.getDireccion());
					update.setTelefono(datos.getTelefono());
					update.setSexo(datos.getSexo());
					update.setActivo(datos.getActivo());
					
					datosEmpleadosDAO.update(update);
					
					
					respuesta="El usuario se actualizo correctamente";
				}else {
					respuesta="El empleado esta dado de baja, No puede actualizar su informacion.!";
				}
			}else {
				respuesta="No existe el usuario, ingresa un id valido";
			}
			
		}else {
			
			respuesta="Ingresa un id para buscar en la base de datos";
		}
			return respuesta;
	}

	
	@Override
	public List<DatosEmpleados> consultarEmpleadosHombres() {
		
		List<DatosEmpleados> estados = datosEmpleadosDAO.obtenerRegistros();		
		
		return estados;
	}
	
	
	
	@Override
	public List<DatosEmpleados> consultarEmpleadosMujeres() {
		List<DatosEmpleados> estados = datosEmpleadosDAO.obtenerRegistrosMujeres();
		return estados;
	}
	

	@Override
	public String buscarEmpleado(DatosEmpleadosDTO buscarEmpleado) {
		
		String respuesta=null;
		DatosEmpleados dato = datosEmpleadosDAO.buscarDatosRfc(buscarEmpleado.getRfc());
		if(dato== null){
			respuesta = "El empleado no existe";
		}else {
			respuesta = "El empleado es: "+ dato.getNombreCompleto()+ " y su rfc es: "+dato.getRfc();
		}
		
		return respuesta;
	}
	
	@Override
	public List<DatosEmpleados> consultaDatosEmpleados() {
		
		 List<DatosEmpleados> listDatos = datosEmpleadosDAO.obtenerDatos();
		 
		 return listDatos;
		 
	}
}
