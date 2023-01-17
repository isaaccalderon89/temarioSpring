package com.edix.teoria;

public class Creacion {
	
	/*
	 * CONCEPTOS BÁSICOS
	 * -----------------
	 * 
	 * Front-end: Todo lo que se ejecuta en el navegador de cada usuario de cualquier parte de
	 * 		del mundo. Está formado por una mezcla de HTML + CSS (además de aalgunos de sus FRAMEWORKS
	 * 		y Javascript (además de sus FRAMEWORKS también).
	 * 
	 * Toda la información que el usuario solicita a una aplicación web no puede estar guardada en su 
	 * ordenador, sino que tiene que estar centralizada en un servidor, en un repositorio único y central. 
	 * 
	 * Cada vez que un usuario pulsa un botón de un formulario, se genera una petición a una aplicación web, 
	 * petición que es procesada para mandar al cliente la infomración necesaria.
	 * 
	 * Back-end: En una aplicación web, todo lo que se ejecuta en el servidor de aplicaciones web, en un odenado
	 * 		o varios formando un clúster y está formado por un lenguaje de programacion o algunos de sus FRAMEWORKS. 
	 * 
	 * En este curso, hemos elegido JEE(Java Enterprise Edition) como tecnología base y sus framework más importante: 
	 * Spring Boot para desarrollo web, contra bases de datos relacionales (MySQL, Oracle).
	 * 
	 * Full Stack: Aplicaciones web conducidas por el servidor a tráves de uno de los lenguajes, como JEE/Spring, y que
	 * 		se apoyan en JavaScript (con sus framework) más HTML se las conoce como aplicaciones full stack.
	 * 
	 * Mean Stack: Las aplicaciones que usan como lenguaje principal JavaScript, con el servidor de aplicaciones
	 * Node.js y acceso a bases de datos No-SQL, como MongoDB, son conocidas como aplicaciones mean stack.
	 * 
	 * 
	 * DESCRIPCIÓN DEL PROYECTO
	 * ------------------------
	 * Una empresa mayorista de ropa de estilo formal necesita crear una aplicación web para la gestión de los 
	 * articulos que vende. 
	 * 
	 * Tenemos que asginar una URL distinta a cada caso de uso para que el controlador (servlet) pueda distinguir
	 * unas peticiones de otras. 
	 * 
	 * CASOS DE USO 			URL ASIGNADA (PARA SPRING)				URLALTERNATIVA (PARA JEE)
	 * 
	 * Productos				/productos
	 * 
	 * Listar novedades			/productos/novedades					/productos?opcion=novedades
	 * Nuevo producto			/productos/alta							/productos?opcion=alta
	 * Modificar producto		/productos/modificar/id					/productos?opcion=modificar&id=valor
	 * Ver detalles de producto	/productos/detalle/id					/productos?opcion=detalle&id=valor
	 * 
	 * Familias 				/familia
	 * 
	 * Listar familias			/familia/todas							/familia?opcion=todas
	 * Nueva familia			/familia/alta							/familia?opcion=alta
	 * Listar productos familia	/familia/prodcutos/idFamilia			/familia?opcion=productos&id=valor
	 * 
	 * 
	 * VIDEOS DE YOUTUBE
	 * -----------------
	 * 1. https://youtu.be/ZT9l1GPDnfY
	 * 2. https://youtu.be/7QSPuUssmBA
	 * 
	 * 
	 * 2.2 FUNCIONAMIENTO DE UN SERVLET
	 * --------------------------------
	 * Un servlet es un objeto de la clase JEE, HttpServlet; se crea y ejecuta en el servivor de aplicaciones y su misión
	 * es atender a las peticiones que llegan desde la capa cliente, así como generar las correspondientes respuestas para
	 * los mismos.
	 * 
	 * El servlet se ejecuta sobre el contenedor web.
	 * 		http://dominio:puerto/utilidades/buscador.
	 * 
	 * Descripción del proceso: 
	 * 1.Se lanza una petición HTTP con la dirección completa del servlet. La petición es captada por el servidor web
	 * 		y es derivada al servidor de aplicaciones. Este servidor utiliza la última parte de la URL para determinar cuál 
	 * 		es el servlet que hay que ejecutar y la aplicación a la que pertenece.
	 * 
	 * 2.El servlet se ejecuta y realiza las tareas encomendadas. El servlet interactua con la capa de negocio para el procesamiento 
	 * 		de los datos. Una vez procesada la petición, se confecciona la respuesta al cliente.
	 * 
	 * 3.La respuesta construida por el servlet es enviada al servidor web.
	 * 
	 * CICLO DE VIDA DE UN SERVLET
	 * ---------------------------
	 * El servlet pasa por una serie de estados que determinan lo que se conoce como ciclo de vida del servlet.
	 * 
	 * La labor del programador es sobreescribir (@Override) los métodos que necesite para procesar cada petición. 
	 * 
	 * ESTADOS DE UN SERVLET
	 * ---------------------
	 * 1. Clase servlet. Es el estado incial del servlet. Un servlet se implementa como una clase Java, que es compilada y empaquetada
	 * 	dentro de la aplicación. Inicialmente, no exite ningún objeto de dicha clase, por lo que podríamos decir que en realidad el servlet 
	 * 	aún no existe en este estado. 
	 * 2. Inicialización. Cuando llega la primera petición del servlet. Se produce la inicialización del servlet, seguidamente se le pasa al estado de servicio
	 * 3. Servicio. Cuando ejecuta el código de la tarea que debe realizar. Si llegan peticiones de forma simultánea, cada petición provocará la ejecución de su 	
	 * 	la ejecucion de su tarea, pero todas estas ejecuciones se procesarán, como hemos indicando, de forma concurrente. 
	 * 4. Destrucción. Si el servidor de aplicaciones decide destruir el servlet, este pasaría al estado de destrucción.
	 * 
	 * MÉTODOS DEL CICLO DE VIDA
	 * -------------------------
	 * Durante los cambios de estado, el servidor de aplicaciones llama a una serie de métodos internos del servlet, conocidos como MÉTODOS DEL CICLO DE VIDA.
	 * Los métodos del ciclo de vida más importantes son:
	 * 		*Init:Es invocado durante la incialización del servlet que, ocurre cuando el servlet es solicitado por primera vez. 
	 * 			Este método, incluiremos aquellas instrucciones que deseemos ejecutar una sola vez durante la vida del servlet.
	 * 		*Service:Es el método mas importante del servlet, ya que el seridor de aplicaciones llama a este método cada vz que el servlet es solicitado. 
	 * 			Es invocado con cada petición entrante del servlet. En este métodom escribiremos las instrucciones de las tareas a realizar por el servlet.
	 * 		*Destroy:El es método llamado por el servidor justo antes de destruir el servlet. 
	 * 
	 * CREACIÓN DE UN SERVLET
	 * ----------------------
	 * 	
	 * La clase HttpServlet:
	 * Proporciona la base para la construccion de servlets en una aplicación, de modo que, si queremos crear nuestro propio servlet tendremos que heredar dicha clase. 
	 * En esta clase se encuentran los métodos del ciclo de vida del cervlet bien definidos directamente dentro de ella o bien heredados de alguna clase superior.
	 * Esta clase no es abstracta, por tanto redefinimos los métodos que nos sean necesario para nuestro propósitos.
	 * 
	 * 1. La anotación @Webservlet
	 * Informamos al servidor de aplicaciones de que esta clase es un servlet.Entre paréntesis se indica la URL asociada al servlet. 
	 * 
	 * 2. El métodoo service.
	 * Observemos los parámetros que recibe:
	 * 		*HttpServletrequest. Proporciona una serie de métodos para poder acceder a la información sobre las petición como son: 
	 * 							los parámetos enviados por el cliente, atributos de petición, etc.
	 * 
	 * 		*HttpServletResponse. A través de sus métodos podemos generar la respuesta que queremos enviarle al cliente.
	 * 
	 * Video https://youtu.be/IX8m13RAZGI
	 */

}
