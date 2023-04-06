package com.mx.mex.RepositoryImplement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mx.mex.Dto.UsuariosAdminDTO;
import com.mx.mex.Repository.UsuariosAdminDAO;
import com.mx.mex.entities.UsuariosAdmin;


@Repository
public class UsuariosAdminDAOImpl implements UsuariosAdminDAO{
	
	@Autowired
	private SessionFactory sessionFactory; // Este es un objeto de hibernate para poder hacer el insertar en DB
	
	
	public UsuariosAdminDAOImpl() {
	}

	public UsuariosAdminDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	
	
	@Autowired
	private  DataSource dataSource;  //NUESTRA CONEXION A BASE DE DATOS
	private  JdbcTemplate jdbcTemplate = new JdbcTemplate(); //PARA EJECUTAR LAS CONSULTAS
	

	// Este es el metodo para obtener todos los usuarios admin por medio de JdbcTemplaTE
	@SuppressWarnings("unchecked") // Esta anotacion es para -> @Suprimir advertencias (lineas amarillas - PUEDEN COMENTAR ESTA LINEA PARA QUE VEAN A QUE ME REFIERO)
	@Override
	public List<UsuariosAdminDTO> obtenerAllUserAdmin() {
		jdbcTemplate.setDataSource(getDataSource()); //ASIGNAMOS LA CONEXIÓN AL OBJETO JDBCTEMPLATE
		
		StringBuilder sb = new StringBuilder("SELECT ID_USER, NOMBRE_COMPLETO, EDAD, DIRECCION FROM CURSOADMIN.USUARIOS_ADMIN");
		
		 return (List<UsuariosAdminDTO>) jdbcTemplate.query(sb.toString(), new Object[] {}, new RowMapper() {
	         @Override
	         public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	 UsuariosAdminDTO datos = new UsuariosAdminDTO();
			   
//	           datos.setIdUser(rs.getBigDecimal("ID_USER"));
	           datos.setIdUser(rs.getLong("ID_USER"));
			   datos.setNombreCompleto(rs.getString("NOMBRE_COMPLETO"));
			   datos.setEdad(rs.getString("EDAD"));
			   datos.setDireccion(rs.getString("DIRECCION"));
			  
			   return datos;
		   }
	   });
	}
	
	
	
	/**f
	 * Consultar select con hhibernate
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<UsuariosAdmin> obtenerAllUserAdmin_Hibernate() {

		System.out.println(" Consult inf for hibernate DAOO----- ");
		
		final Session session = sessionFactory.getCurrentSession();
	      final Criteria criteria = session.createCriteria(UsuariosAdmin.class);
//	      criteria.add(Restrictions.eq("catComponente.cveComponente", ComponenteEnum.ACCESO_REGISTRO_INFORME_SABATICO_CATEDRATICO.getCveComponente()));
//	      criteria.addOrder(Order.asc("id.idPeriodo"));
	      
	      return (List<UsuariosAdmin>) criteria.list();
	}
	
	
	
	
/**
 * Insert con hhibernate
 */
	@Override
	@Transactional
	public Integer insertarUsuario(UsuariosAdmin usuariosAdmin) {
		System.out.println(" DaoImpl ----- ");
		sessionFactory.getCurrentSession().save(usuariosAdmin);
		
		return 1;
	}
	
	
	
	
	/**
	 * Eliminar con hhibernate
	 */
	@Override
	@Transactional
	public Integer eliminaUsuario(Long idUser) { // AQUI HAY UN ERROR VERIFICA POR QUE ES POR LA ENTITY HAY QUE DECLARARLO
		System.out.println(" DAO EN ELIMINAR USER CON HIBERNATE ---> "+idUser);
		
		UsuariosAdmin idUserAdmin = new UsuariosAdmin();
		idUserAdmin.setIdUser(idUser);
		
		sessionFactory.getCurrentSession().delete(idUserAdmin);
		
		return 1;		
	}
	
	
	
	/**
	 * Actualizar info... con hhibernate
	 */
	@Transactional
	@Override
	public Integer actualizarUsuario(UsuariosAdmin p) {
		
		sessionFactory.getCurrentSession().update(p);
//		sessionFactory.getCurrentSession().saveOrUpdate(p);
		
		return 1;
	}
	
	
	
	
	
	
	
//	Estos son los get/set de datasource y JdbcTemplate
	public DataSource getDataSource() {return dataSource;}
	public void setDataSource(DataSource dataSource) {this.dataSource = dataSource;}
	public JdbcTemplate getJdbcTemplate() {return jdbcTemplate;}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}


}// Fin class
