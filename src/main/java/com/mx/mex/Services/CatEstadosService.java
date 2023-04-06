package com.mx.mex.Services;

import java.util.List;
import com.mx.mex.Dto.CatEstadosDTO;
import com.mx.mex.Dto.MensajeDTO;
import com.mx.mex.entities.CatEstados;

public interface CatEstadosService {

	String getAllEstados_Hibernate(CatEstadosDTO idEstado);
	
	List<CatEstados> obtenerAllEstados_Hibernate();

	String insertEstado_Hibernate(CatEstadosDTO estado);

	String eliminarEstadoId(CatEstadosDTO p);

	String actualizarEstado_Hibernate(CatEstadosDTO estado);

	MensajeDTO eliminarEstadoPorIdent(CatEstadosDTO p);

}
