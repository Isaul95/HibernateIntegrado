package com.mx.mex.Services;

import java.util.List;

import com.mx.mex.Dto.DatosEmpleadosDTO;
import com.mx.mex.entities.DatosEmpleados;

public interface DatosEmpleadosService {

	String getDatosEmpleados(DatosEmpleadosDTO rfc);

	String elimarEmpleados(DatosEmpleadosDTO id);

	String updateDatosEmpleados(DatosEmpleadosDTO datos);

	List<DatosEmpleados> consultarEmpleadosHombres();

	List<DatosEmpleados> consultarEmpleadosMujeres();

	String buscarEmpleado(DatosEmpleadosDTO buscarEmpleado);

}
