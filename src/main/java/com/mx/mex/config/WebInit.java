package com.mx.mex.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//El núcleo de la aplicación
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		// Se llama la clase donde se mapea el paquete principal
		return new Class <?> [] {RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?> [] {WebConfig.class};//Se llama la clase donde se mapean vistas y recursos
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"}; // El contexto de la aplicacion
/*
 localhost:8080/Curso
 * 1.- localhost = 
 * 2.- 8080 = puerto
 * 3.- /Curso = es el contexto/nombre del aplicativo 
 * 
 * Abrir cuenta de GitHub = Repositorio compartir Código
*/
	}

}
