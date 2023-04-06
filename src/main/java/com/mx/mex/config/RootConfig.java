package com.mx.mex.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages= {"com.mx.mex"},// Paquete principal en donde spring buscara nuestras clases con anotaciones
excludeFilters= {
		@ComponentScan.Filter(type= FilterType.ANNOTATION,
				value=EnableWebMvc.class)
		})// Filtro para spring tome aquellas clases que lleven anotaciones o la anotacion @EnableWebMvc
public class RootConfig {

}
