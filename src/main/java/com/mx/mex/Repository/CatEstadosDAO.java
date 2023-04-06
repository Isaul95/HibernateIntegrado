package com.mx.mex.Repository;

import java.util.List;

import com.mx.mex.entities.CatEstados;

public interface CatEstadosDAO extends DAO<CatEstados, Long>{

	List<CatEstados> obtieneAllEstados();
	


}//Fin class
