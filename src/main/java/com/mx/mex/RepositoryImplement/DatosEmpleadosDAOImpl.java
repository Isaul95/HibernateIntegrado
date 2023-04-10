package com.mx.mex.RepositoryImplement;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mx.mex.Dto.DatosEmpleadosDTO;
import com.mx.mex.Repository.DatosEmpleadosDAO;

import com.mx.mex.entities.DatosEmpleados;


@SuppressWarnings("unchecked")
@Repository
public class DatosEmpleadosDAOImpl extends GenericDAO<DatosEmpleados, Long> 
implements DatosEmpleadosDAO{

	
	@Transactional
	@Override
	public DatosEmpleados buscarDatosRfc(String rfc) {
		
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(DatosEmpleados.class);
		criteria.add(Restrictions.eq("rfc", rfc));
		
		return (DatosEmpleados) criteria.uniqueResult();
	}

	
	@Transactional
	@Override
	public List<DatosEmpleados> obtenerRegistros() {
		

		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(DatosEmpleados.class);
		//Query query = (Query) session.createQuery("SELECT * FROM DATOS_EMPLEADOS WHERE SEXO = M");
		criteria.add(Restrictions.eq("sexo","M"));	
		return (List<DatosEmpleados>) criteria.list();
		
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<DatosEmpleados> obtenerRegistrosMujeres() {
		

		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(DatosEmpleados.class);
		//Query query = (Query) session.createQuery("SELECT * FROM DATOS_EMPLEADOS WHERE SEXO = M");
		criteria.add(Restrictions.eq("sexo","F"));	
		return (List<DatosEmpleados>) criteria.list();
		
	}

}
