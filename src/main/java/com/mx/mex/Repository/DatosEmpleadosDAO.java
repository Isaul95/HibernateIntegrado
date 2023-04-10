package com.mx.mex.Repository;

import java.util.List;

import com.mx.mex.Dto.DatosEmpleadosDTO;
import com.mx.mex.entities.DatosEmpleados;

public interface DatosEmpleadosDAO extends DAO<DatosEmpleados, Long>{

	
	DatosEmpleados buscarDatosRfc(String rfc);

	List<DatosEmpleados> obtenerRegistros();
	
	List<DatosEmpleados> obtenerRegistrosMujeres();

}
