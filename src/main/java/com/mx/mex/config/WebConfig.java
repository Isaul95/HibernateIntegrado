package com.mx.mex.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/** ANOTACIONES:
 * A nivel de spring framework es una herramienta que le pertenece a spring, lo vamos a utilizar en esta clase.
 */

@Configuration // Esta es una clase de config para el manejo de Beans
@EnableWebMvc // Esta anotacion se refiere a que vamos a habilitar la arq. Web MVC
@ComponentScan("com.mx.mex") // Sirve para indicar a spring sobre ese ruta
public class WebConfig extends WebMvcConfigurerAdapter{
	
	/* Que es un bean?
	 * 1.- Es una pieza de software que representa un OBJETO dentro de Spring
	 * 2.- Tienen un ciclo de vida, son manejados por el contenedor de spring y son reusables.	 
	 */
	
//	Mapear = buscar entre todo el proyecto la ubicacion de las vistas
	@Bean
	public InternalResourceViewResolver resolver() {
		   InternalResourceViewResolver resol = new InternalResourceViewResolver();
		   resol.setPrefix("/WEB-INF/views/"); // Mapear la carpeta de las vistas = .jsp -> vistas html
		   resol.setSuffix(".jsp"); // Especificar la extension de las vistas
		return resol;
	}
	
	
//	Mapear = buscar la ubicacion de los recursos 
//	(css, js, logos imagenes, iconos, jquery, bootstrap)
	public void addResourcerHandlers(ResourceHandlerRegistry registry) {
		registry
		.addResourceHandler("/resources/**")
		.addResourceLocations("classpath:/resources/");			
	}


}
