package com.mx.mex.RepositoryImplement;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import com.mx.mex.Repository.CatEstadosDAO;
import com.mx.mex.entities.CatEstados;
import com.mx.mex.entities.UsuariosAdmin;


@Repository
public class CatEstadosDAOImpl extends GenericDAO<CatEstados, Long> implements CatEstadosDAO{

	
	
	/**
	 * GET ALL ESTADOS CATALOGO
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<CatEstados> obtieneAllEstados() {
		
		final Session session = sessionFactory.getCurrentSession();
	      final Criteria criteria = session.createCriteria(CatEstados.class);
		
		return (List<CatEstados>) criteria.list();
	}
	
	
	
	
	
}
