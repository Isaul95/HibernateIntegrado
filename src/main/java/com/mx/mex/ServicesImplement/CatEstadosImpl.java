package com.mx.mex.ServicesImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.mex.Dto.CatEstadosDTO;
import com.mx.mex.Dto.MensajeDTO;
import com.mx.mex.Repository.CatEstadosDAO;
import com.mx.mex.Services.CatEstadosService;
import com.mx.mex.entities.CatEstados;


@Service
public class CatEstadosImpl implements CatEstadosService {
	
	@Autowired
	private CatEstadosDAO catEstadosDAO;

	
	
//	@Override
//	public List<CatEstadosDTO> getAllEstados_Hibernate() {
//		Long idEstado = 2L; 
//		CatEstados estados = catEstadosDAO.read(idEstado);
//		System.out.println("Propiedad #01 NOMBRE-->" +estados.getNombre() +"* ABREV-->"+ estados.getAbreviatura());
//		return null;
//	}



	@Override
	public String getAllEstados_Hibernate(CatEstadosDTO identificadorEstado) {
		String resp = null;
		
//		Long idEstado = new Long(identificadorEstado);
//		SELECT * FROM WHERE ID_ESTADO = X;
		CatEstados estados = catEstadosDAO.read(identificadorEstado.getIdEstado());	
		System.out.println("Propiedad #01 NOMBRE-->" +estados.getNombre() +"* ABREV-->"+ estados.getAbreviatura());
		
		if(estados != null && (estados.getNombre() != null || !estados.getNombre().isEmpty())) {
			resp = "Si existe el registro para el Identificardo del estado->:"+identificadorEstado.getIdEstado();
			
		}else if(estados != null && estados.getAbreviatura().isEmpty() ) {
			resp = "El registro existe, Perooo...!! Su abreviatura esta vacia.!";
			
		}else {
			resp = "El registro NO existe";
		}
			
		
		
		return resp;
	}



	
	/**
	 * Obtener todos los estados....
	 */
	@Override
	public List<CatEstados> obtenerAllEstados_Hibernate() {
		
		List<CatEstados> estados = catEstadosDAO.obtieneAllEstados();		
		
		return estados;
	}




	/**
	 * Agregar new estado...
	 */
	@Override
	public String insertEstado_Hibernate(CatEstadosDTO estado) {
		
		CatEstados catEstados = new CatEstados();
		catEstados.setIdEstado(estado.getIdEstado());
		catEstados.setNombre(estado.getNombre());
		catEstados.setAbreviatura(estado.getAbreviatura());
		
		Long addEstado = catEstadosDAO.create(catEstados);
		
		System.out.println("VALOR-------> "+ addEstado);
		
		if(addEstado != 0) {
			return "Inserto de forma correcta....!";
		}else {
			return "No se pudo insertar....!";
		}
			
	}




	/**
	 * Eliminar estado por id
	 */
	@Override
	public String eliminarEstadoId(CatEstadosDTO p) {
		
		 catEstadosDAO.delete(p.getIdEstado());
		
		return "Si elimino";
	}
	
	
// ----------  ELIMINAR CON RETORNO DE MensajeDTO  -----------------------
	@Override
	public MensajeDTO eliminarEstadoPorIdent(CatEstadosDTO p) {
		MensajeDTO mensajeDTO = new MensajeDTO();
	
		try {
			
			if (p.getIdEstado() != null && p.getIdEstado() != 0) { // 1.- Verificar si el ide que se manda no sea null o cero (Incorrecto)

				CatEstados existeEstado = catEstadosDAO.read(p.getIdEstado()); // 2.- Verifica/consultar si existe el estado con ese id

				if (existeEstado != null) { // 2.- Evaluar Si existe el estado conusltado por el ide
					catEstadosDAO.delete(p.getIdEstado());
					mensajeDTO.setMensaje("El estado ha sido Elimminado correctamente...!!!");
					
				} else{
					mensajeDTO.setMensaje("El estado no Existe para el identificador.!");
				}
			} else{
				mensajeDTO.setMensaje("Los datos enviados para la consulta son Erroneos.!");
			}
			
		} catch (Exception e) {
			mensajeDTO.setMensaje("Ocurrio un error al intentar eliminar la informacion");
		}
		return mensajeDTO;
	}
	
	
	
	



	/**
	 * Actualizar estados info
	 */

	@Override
	public String actualizarEstado_Hibernate(CatEstadosDTO estado) {
		
		CatEstados catEstados = new CatEstados();
		catEstados.setIdEstado(estado.getIdEstado());
		catEstados.setNombre(estado.getNombre());
		catEstados.setAbreviatura(estado.getAbreviatura());
		
		catEstadosDAO.update(catEstados);
		
		
		return "Actualiza";
	}




	
	

}
