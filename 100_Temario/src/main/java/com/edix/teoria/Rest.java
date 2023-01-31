package com.edix.teoria;

public class Rest {

	/*
	 * UF6. MICROSERVICIOS RESTFULL CON SPRING BOOT
	 * --------------------------------------------
	 * 
	 * METODOS HTTP
	 * ------------
	 * 
	 * HTTP define un conjunto de métrodos de petición para undicar la acción que se desea realizar para un recurso determinado. 
	 * Aunque estos también pueden ser sustantivos, estos métodos de solicitud a veces son llamados verbos HTTP. 
	 * 
	 * 1. GET 
	 * Solicita un representacion de un recurso específico. Las peticiones que usan el métodos GET solo deben recuperar datos. 
	 * 
	 * 2. POST
	 * Se utiliza para enviar una entidad a un recurso específico, causando a menudo un cambio en el estado o efectos secundarios en el
	 * servidor. 
	 * 
	 * 3. PUT
	 * Reemplaza todas las representaciones actuales del recurso de destino con la carga útil de la petición. 
	 * 
	 * 4. DELETE
	 * Borra un recurso en específico. 
	 * 
	 * 5. PATCH 
	 * Se usa para aplicar modificaciones parciales a un recurso. 
	 * 
	 * 6. HEAD 
	 * Pide una respuesta idéntica a la de una petición GET, pero sin el cuerpo de la respuesta. 
	 * 
	 * En un aplicañon web, usamos fundamentalmente dos: 
	 *  
	 *    *GET: que son las peticiones que recibimos desde la URL del navegador, para arrancar la aplicación. Y desde los href de las etiquetas <a>, asociadas a
	 *    distintos botonoes de acción del navegador. 
	 *    
	 *    *POST: para los formularios.
	 *  
	 * En servicios web, usaremos fundamentalmente: 
	 * 	
	 * 	  *GET: para las consuiltas de datos. 
	 * 	  *POSt en estas peticiones los clientes nos pasan estructuras de datos, en diferentes formatos, fundamentalmente en JSON. 
	 * 	  *PUT: los clientes a través del cuerpo de HTTP, nos pasarán datos en fomrato JSON para que los modifiquemos en nuestra BBDD. 
	 * 	  *DELETE: los clientes normalmente a tráves de la URL nos pasarán el código del producto o la familia que quieren que demos de baja.   
	 *
	 * CASOS DE USO DE MI APLICACION DE SERVICIOS WEB
	 * ----------------------------------------------
	 * 
	 *   * @GetMapping: trata todas las peticiones de tipo HTTP GET. 
	 *   * @PostMapping: todas las que solicitan dar de alta un objeto. 
	 *   * @PutMapping: para modificar un objeto en la base de datos. 
	 *   * @DeleteMapping: para eliminar un objeto en la base de datos.
	 * 
	 * 
	 * UF6.2 SERVICIOS REST
	 * 
	 * Fundamentos sobre REST
	 * ----------------------
	 * Los servicios de tipo REST constituyen una nueva generación de servicios web que exponen a t´ráves de internet una serie de recursos Java a los que se puede 
	 * acceder con peticiones HTTP sencillas (tipo GET, PUT,POST, DELETE, etc.) in recurrir a complejor entándares, como SOAP o WSDL, tecnologias anterios a REST, que eran mas complejas.
	 * 
	 * Los servicios REST se basan en ofrecer recursos a otras aplicaciones. Estos recursos, habitualmente cadenas de caracteres u objetos de tipo JavaBean, son expuestos
	 * por lo métodos del servicio web a tráves de diferentes formatos.
	 * 
	 * Los servicios REST también pueden proporcionar operaciones para la realización de tareas de acción, como crear nuevos recursos, modificar o elimnar recursos existentes. 
	 * La información necesaria para la realización de la operación puede ser enviada en distintos formátos a través de la HTTP. 
	 * 
	 * EL API JAX-RS. Tecnología base JEE 
	 * ----------------------------------
	 * Para simplificar la creación de servicios web REST, es la especficación JAva se cuenta conel API JAX-RS. Gracias a este API, podemos implementar la capa del adaptador web como 
	 * calse JavaBean (también llamada POJO) en la que se dfinen, en lenguaje Java, los métodos expuestos por el servicio. 
	 * 
	 * Desde estos métodos, derivaremos las llamadas a los componentes de la lógica de negocio y, utilizando una serie de anotaciones JAX-RS, le indicamos al motor de servicios REST la infomración necesaria 
	 * para poder realizar la interacción con el exterior. 
	 * 
	 * Anotaciones más importantes:
	 * 
	 * @Path: se emplea a nivel de clase para asignar la URL del servicio. También puede emplearse a novel de los métodos de la clase para asignar subdirecciones o parámetros a dichos métodos. 
	 * 
	 * @GET, @POST, @DELETE, @PUT: asocian a los métodos del servicio un determinado método HTTP. Cuando llege una petición del tipo GET, POST, PUT p DELETE, se ejecutará el método 
	 * que tenga asociado la anotación correspondiente. 
	 * 
	 * @PathParam: asocia un parámetro recibido en la petición con el correspondiente parámetro del mñetodos del servicio que le va a procesar. 
	 * 
	 * @Produces: se emplea a nivel de método para inicar al motor JAX-RS el formato de respuesta. Se debe indicar el tipo de 'mime' correspondiente al formato del dato que se va a devolver, utilizando una de las 
	 * constantes definidas en la enumeración javax.ws.rs.core.MediaType. 
	 * 
	 * @Consumes: es similar a la anterior, pero se emplea para indicar el formato del dato que va a ser enviado en el cuerpo de la petición, si es que se va a enviar algo. Normalmente, se emplea en métodos que van 
	 * a enviar algo. Normalmente, se emplea en métodos que van a responder a peticiones PUT y POST, que son las que suelene enviar datos en el cuerpo. 
	 * 
	 * Pero en nuestro caso estamos usando Spring Boot, que usa sus propias anotaciones, de las que conocemos @GerMapping y @PostMapping, que como ves se parecen bastante a las deJAX- Rs. 
	 * 
	 * 
	 * UF6.3 MICROSERVICIOS REST CON SPRING BOOT
	 * -----------------------------------------
	 * Diferencia entre servicio REST y microservicio REST:
	 * 
	 * Un microservicio es una unidad de software que implementa una funcionalizada concreta y se ejecuta de forma autónoma e independiente. Incluye todo lo necesario para su ejecucion, 
	 * sin depender de ningún software adicional. Es decir, se despliega de forma autonomática e independiente. 
	 * 
	 * Los servicios REST tradicionales se montan sobre un controlador we, les hace falta su motor de servicios (Jax_rs) y una vez terminando se genera una aplicación de tipo war y se despliegan en un 
	 * servidor de aplicaciones de las ampliaciones. 
	 * 
	 * Para montar un microservicio: 
	 * 
	 * 		Se implementan los métodos que generan las respuestas. 
	 * 
	 * 		Se genera un fichero '.jar', con su método estático 'main()'. 
	 * 
	 * 		El servidor de aplicaciones está embutido en el proyecto, de forma que, esta aplicacion se pueda ejecutar po sí sola (standalone), sin depender de nadie. 
	 * 
	 * 
	 * CONFIGURACION 
	 * -------------
	 * Un microservicio REST no deja de ser una aplición que recibe peticiones HTTP a través de la web, de cualquier cliente, siempre y ciando este cliente pueda realziar peticiones HTTP. 
	 * 
	 * Como aplicación Spring Boot tiene incorporado Tomcat, que es el servidor de aplicaciones web, hay que configurar el puerto por donde va a escuchar estas peticiones. Esto lo hacemos en el fichero 'application.properties'
	 * 
	 * Creación del controlador REST: @RestController
	 * 		
	 * 		* Una clase controladora se Spring Boot se convierte en una aplicación de servicios web, anotando la clase como @RestController.
	 * 
	 * 		* Como es una petición de lectura el método que va a manejar la petcición se anota @getMapping("/saludo") especificando la ruta de la URL asociada al método. 
	 * 
	 * 		* Y el servicio estaría completado. 
	 * 
	 * 
	 * UF6.4 DESARROLLO DESPLIEGUE Y EJECUCIÓN CON POSTMAN
	 * ---------------------------------------------------
	 * lo primero es crear el proyecto se servicios REST para los casos de uso. 
	 * 
	 * Creamos el proyecto nuevo con los starter de: 
	 * 
	 *		* Spring mvc y spring Developpers Tools. 
	 *		* Spring Data JPA y Driver MySQL. 
	 *		* Aplicación Java 11, Maven y Package jar. 
	 *
	 *	Definir los JavaBean anotados JPA.
	 *	Crear los repositories.
	 *	Crear los interfaces de negocio.
	 *	Clases que implementan los interfaces.
	 *	
	 *
	 *	DEFINIR LOS @RESTCONTROLLER
	 *	---------------------------
	 * La anotación @CrossOrigins(origins="*"), es para permiitir accesos desde aplicaciones cliente web, es decir, desde JavaScript con peticiones HTTP Ajax.
	 * 
	 */
}
