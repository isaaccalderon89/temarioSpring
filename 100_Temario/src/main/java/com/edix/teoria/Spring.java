package com.edix.teoria;

public class Spring {

	/*
	 * UF 3.1 CARACTERISTICAS DE SPRING Y SPRING BOOT PARA APLICACIONES WEB
	 * 
	 * Creado en el 2003 por Rod Johnson.
	 * 
	 * SPRING CORE CONTAINER PARA JAVABEANS
	 * ------------------------------------
	 * El Core es un gran contenedor de objetos; por tanto, no solo contiene los obejtos de las Calsses configuradas, sino
	 * que gestiona el ciclo de vida de cada objeto que crea. 
	 * 
	 * Este contendor se basa en dos principios firmemente relacionados: 
	 * 
	 * 	* La inversión de control (IOC). 
	 * 	* La instanciación e inyección de dependencias (objetos).
	 * 
	 * La inversión de control y gestión de dependedencias es la capacidad de definir una variable y usar sus métodos, sin importar clases
	 * ni crear objetos, y usar los métodos de esta clase. 
	 * 
	 * Spring Boot
	 * -----------
	 * Es un subproyecto de Spring FrameWork que busca facilitar la creación de proyectos web, eliminando la necesidad de crear largos archivos
	 * de configuración XML.
	 * 
	 * 		* Spring boot provee configuraciones por defecto para la mayoría de las tecnologías usadas. 
	 * 		* Spring boot nos ayuda a administrar todas las dependencias. 
	 * 		* Spring boot provee un modelo de programación parecido a las aplicaciones Java tradicionales que inician con el método main. 
	 * 
	 * Una aplicación desarrollada con Spring Boot Web se desarrolla en tres pasos: 
	 * 
	 * 1.Incluir todas las dependencias.
	 * 2.Crear la aplicación.
	 * 3.Desplegar el proyecto
	 * 
	 * La ventaja que nos proporciona Spring boot es la simplificación al máximo nivel de los pasos 1 y 3.
	 * 
	 * INCLUIR DEPENDENCIAS NECESARIAS
	 * -------------------------------
	 * Con el fin de que no te tengas que saber todos y cada uno de los componentes necesarios, ha creado las dependencias de tipo Starter. 
	 * Es decir, yo le digo la tecnología que quiero y me incorpora una dependencia en el POM de Maven.
	 * 
	 * DESPEGAR EL PROYECTO 
	 * --------------------
	 * Normlamente una vez creada la palicación JEE, debemos generar un archivo con extensión .war, que se debe introducir en un servidor de aplicaciones
	 * JEE (como Tomcat)para poder ejecutar la aplicación.
	 * Una aplicación Spring Boot, puede hacerse de la misma forma. 
	 * PEro Spring Boot lleva incorporado un servidor web Apache Tomcat embebido, por lo que podemos generar una aplicación Stand-alone, es decir, 
	 * una aplicación independiente.
	 * 
	 * 		*Incorporación de clases a Spring Boot. 
	 * Cualquier clase que quiera incorporar al contenedor Spring debe llevar, explícita o implícitamente, la anotación @Component. 
	 * Muchas de las anotaciones propias de Spring Boot, que iremos viendo oa lo largo de las unidades formativas de este curso, 
	 * llevan implícita @Component y, por tanto quedan bajo el paraguas del contenedor Spring. 
	 * 
	 * 		*Incorporación de Sprng Boot a Eclipse. 
	 * En este video te muestra como configurar eclipse para Spring Boot
	 * https://youtu.be/vAhA7sIPJGU
	 * 
	 * UF3.2 CONFIGURADOR DE PROYECTOS WEB: SPRING STARTER
	 * ---------------------------------------------------
	 * Spring Boot Starter POMs es una unidad existente dentro de Spring boot que facilita la creación y configuración de una aplicación Java
	 * 
	 * Cuando creamos un proyecto y montamos el fichero de configuración de Maven, debemos añadir las librerías de Spring y de terceros que necesita 
	 * para funcionar.
	 * 
	 * CREAR EL PROYECTO CON ECLIPSE 
	 * -----------------------------
	 * *Name: ponemos el nombre al proyecto. 
	 * 
	 * *Type: escogemos Maven , aunque también tienes la opción de usar Gradle.
	 * 
	 * *Packaging: la opción por defecto es realizar un proyecto con extensión . jar, como si fuera un proyecto normal de java.
	 *  
	 * *Java version:
	 *  
	 * *Languaje: por defecto nos muestra java, pero también lo podríamos desarrollar en kotlin o Groovy.
	 *  
	 * *Artifact: se pone los mismo que en Name, es decir, el nombre del proyecto.
	 *  
	 * *Group_id:por convención, es el nombre de la empresa o tu identificador. Estos nombres son libres, pero ten en cuenta 
	 * 	que cada punto te genera una carpeta en tuu sistema operativo.
	 * 
	 * * Package: se suele poner el nombre del Group_id
	 * 
	 * Para un primer proyecto no es necesario dos dependencias: 
	 * 
	 * 1. Spring web MVC: que nos aporta todas las clases necesarias para desarrollar aplicaciones web con servlets y todos los objetos 
	 * 		impícitos(request, response, sessión...), y también para generar servicios web. 
	 * 
	 * 2. Spring devs tools: que nos proporciona un conjunto de herramientasm entre las que destaca una mejora sustancial para compilar, montar 
	 * 		y ejecutar nuestras aplicaciones a través del Tomcat embebido.
	 * 
	 * 
	 * UF.3.3 CRACIÓN Y EJECUCIÓN DE MI PRIMER PROYECTO WEB 
	 * ----------------------------------------------------
	 * 1. Src/main/Java: aquí configuramos por paquetes todas nuestras capas de Java: controlador, modelo,servicio, repositorios...
	 * 
	 * 2. Src/main/resources: aquí va todo lo que es estático en nuestro proyecto: 
	 * 
	 * 		* Imágenes, vídeos, ficheros CSS, ficheros JavaScript, etc. 
	 * 
	 * 		* Fichero denominado Aplication.propierties en el que, de una manera muy sencilla, podemos configurar un montón de cosas, 
	 * 		  cosas que antes se hacían con XML y que eran muy complicadas: puerto de escucha del Tomcat, configuración de las bases de datos...
	 * 
	 * 		* Una carpeta templates para los ficheros HTML, en caso que usemos algún fichero estático. 
	 * 
	 * 3. Scr/test/Java: para realizar test de prueba a tráves de Sprint Test, aunque no lo vayamos a tratar en este tema. 
	 * 
	 * 
	 * MI PRIMER CONTROLADOR
	 * ---------------------
	 * Como hemos visto, Spring web MVC sigue el patrón modelo vista controlador, y tiene un Servlet FrontController que recibe toddas las peticiones y las
	 * encauza al métoco que contenga esa petición. 
	 * 
	 * Pero este proceso se desarrolla en segundo plano, por tanto, nosotros como desarrolladores de aplicaciones de Spring no lo vemos. 
	 * 
	 * Nuestra responsabilidad se queda en crear una clase normal de Java anotada con: 
	 * 
	 * 		* @Controller, si quiero desarrollar una aplicación web típica. 
	 * 	
	 * 		* @RestController, si quiero hacer una Api Rest, para transmitir texto, JSON, XML. 
	 * 
	 * Si anotamos el método con @GetMapping("/saludo"), entre parénteis indicamos la URL que va a tratar esta petición. 
	 * 
	 * Vamos a analizar algunos comentarios cuando se arranca la aplicación con Spring. 
	 * 
	 * 		* Tomcat initialized with port(s): 8083(http): es el puerto configurado. 
	 * 		* Strarting Servlet engine: [Apache Tomcat/9.0.50]: es la versión del Tomcat embebido en nuestra aplicación. 
	 * 		* Initializing Spring embedded WebApplicationContext: es decir, se ha arrancado el Spring. 
	 * 		* Started Application in 1.79 seconds (JVM running for 2.73): la aplicación está correctamente desplegada.
	 * 
	 * 
	 * En este momento tomcat está esperando peticiones. 
	 * 
	 * Nos vamos al navegador que tengamos y tecleamos: Localhost:8083/saludo
	 * 
	 * El FrontController ha buscado un método con la URL "/saludo", que devuleve un mensaje de bienvenida, y lo lanza al navegador que mandó la petición. 
	 * 
	 * A partir de ahora iremos creando nuestras aplicaciones web, generando clases normaliza de Java, anotadas con @Controller, que manejen datos, páginas web con 
	 * JSTL/EL y todos los recursos necesarios. 
	 * 
	 * Proyecto: hola Mundo, ejecución de mi primer programa Spring Boot https://youtu.be/ZoKKuo2THow
	 * 
	 * 
	 * UF3.4 SPRING WEB MVC: CAPAS DE CONTROL, VISTAS Y DATOS. 
	 * -------------------------------------------------------
	 * La capa de control en Spring sustituye a los servlet de JEE, haciendo la programación de estos mucho más eficaz y mucho más sencilla.
	 * 
	 * La capa de la vista la vamos a desarrollar con ficheros JSP, mediante JSTL/EL. Solo será necesario ver como se configura, para poder usarlos, y cómo se llama
	 * 
	 * La capa de datos, como no sabemos acceder a las bases de datos relacionales (se tratarán en la unidad formativa 6), simularemos una capa de datos en memoria, pero usando
	 * las notaciones de Spring Boot, para que nos vayan resultando familiares.
	 * 
	 *  CAPA  DE CONTROL: NOTACIÓN @CONTROLER
	 *  -------------------------------------
	 *  Para porcesar de forma única cada petición de un navegador en el servidor, se crea una clase nomral de Java, anotada con @Controller, y se define un método por cada petición 
	 *  que atienda a una sola URL. 
	 *  
	 *  @Controller lleva implícito @Component y, por tanto, queda bajo el paraguas del contenedor de Spring. 
	 * 
	 * El protocolo HTTP tiene para las plaicaciones web dos métodos de transmisión de datos: GET y POST
	 * 
	 * 		* GET: Se transmiten por GET todas las URL que van en el atributo href de HTML, y las tecleadas 
	 * 			   por un usuario en la caja de texto en el navegador. 
	 * 
	 * 		* POST: Solo se usa en formularios, para impedir que los parámetro se vean por la URL del navegador 
	 * 				y la transmisión sea más segura. 
	 * 
	 * Por convenio y buenas prácticas, todas las peticiones que vengan del exterior las trateremos a tráver del controlador por peticiones GET. 
	 * Los tratamientos de los formularios los veremos más adelante. 
	 * 
	 * Cada método debe ser anotado con @GetMapping, si la petición es GET; o con @PostMapping si la petición es por POST. 
	 * Esta anotación necesita como parámetro la URL Path que de diseñó para la tarea que se le encomienda. 
	 * 
	 * La URL PATH solo se puede repetir para el tratamiento de un formulario: 
	 * 
	 * 		* El método asociaddo a @GetMapping se encargará de mostrar el formulario en el navegador. 
	 * 		* El método asociado a @PostMapping se encargará de procesar los datos que llegan del formulario. 
	 * 
	 * Para no repetir en la clase correspondiente el principio de la URL, Spring nos proporciona la anotación @RequestMapping, que se escribe 
	 * detrás de @Controler y donde se informa del comienzo de la URL de todos los métodos descritos en esa clase. 
	 * 
	 * CAPA VISTA:FICHERO JSP/JSTL/EL
	 * ------------------------------
	 * La capa vista dentro de Spring, hay que configurarla porque Spring no sabe de su existencia. Los pasos son los siguientes: 
	 * 
	 * 		1. Crear en nuestro proyecto Maven la carpeta webapp , dependiente de la carpeta main. Y dentro de webapp, creamos la carpeta: WEB-INF
	 *         que a su vez incluirá la carpeta vistas. En esta última carpeta crearemos los ficheros JSP. 
	 *        
	 *      2. Abrir el fichero applicacion.propierties y añadirle las dos siguientes líneas:
	 *      spring.mvc.view.prefix=/WEB-INF/vistas/ informamos del directorio de las vistas. 
	 *		spring.mvc.view.suffix=.jsp	informamos de la extensión de los ficheros .jsp
	 *
	 *		3. Agregar al fichero pom.xml dos dependencias: 
	 *				* Las del JSTL. 
	 *				* Una especial para Tomcat 
	 *
	 * CAPA DE DATOS : MODELO 
	 * ----------------------
	 * Para cada entidad de negocio necesitamos tres capas, cada una en un paquete distinto. Los nombre de los paquetes pueden ser otros, pero lo adecuado sería: 
	 * 
	 * 1. El JavaBean de la entidad en el paquete modelo.beans
	 * 
	 * 2. Un repositorio de datos en un paquete denominado modelo.repository, y usamos la forma de trabajar de Spring: definir la funcionalidad en una interfaz y crear
	 * una clase que implemente esta interfaz anotado con @Repository, que lleva implícito la anotación @Component. 
	 * 
	 * 		A) Una interfaz para esta entidad que dice todo lo que podemos hacer con esta entidad: 
	 * 
	 * 				*Métodos CRUD: insert, update, delete, buscar uno por atributo identidad. 
	 * 
	 * 				*Buscar todos (y búsquedas por todo lo imaginable).
	 * 
	 * 3. El servicio que representa el subconjunto de métodos del repositorio, métodos necesarios en mi aplicación para trabajar con la entidad (JavaBean) correspondiente, 
	 * en el modelo.services, y con la misma filosofía de Spring que el repositorio: 
	 * 
	 * 		A) Una interfaz con los métodos que necesito en esta aplicación. 
	 * 
	 * 		B) Una clase que implementa esta interfaz, anotado con @Service, que lleva implícito la anotación @Component y, por tanto, queda bajo el paraguas del contenedor de Spring. 
	 * 			Además, usa los métodos del repositorio , inyectando una variable con @Autowired del tipo interfaz del repositorio. 
	 * 
	 * 4. Y, por último, usar los métodos del servicio en nuestro controlador. 
	 * 
	 * 
	 * USAR EL SERVICIO EN EL CONTROLADOR
	 * ----------------------------------
	 * Vamos a suponer que nos llega una petición web con la URL: /familias/todas. Creamos un método con el @GetMapping correspondiente ("/todas"). 
	 * 
	 * Definimos una varibale de IFamiliaService y, con  @Autowired Spring, nos hace el NES de FamiliaService. 
	 * 
	 * ver vídeo UF3.4  https://youtu.be/YkGzDQKi38o  1º
	 * ver vídeo UF3.4  https://youtu.be/Rb_M9JAW5BU  2º
	 *  
	 *  
	 * UF3.5 GESTION DE URL: ANOTACIONES, OBJETOS Y ATRIBUTOS
	 * ------------------------------------------------------
	 * Básicamente existen tres tipo de rutas URL para la gestión de tareas en el servidor, independeientemente de la tecnología y el lenguaje de programación que usemos: 
	 * URL estática y URL dinámica (de tipo RequestParam o de PathVariable). 
	 * 
	 * 1.URL sin parámetro, llamadas URL estáticas, es decir, la  URL dice lo que hay que hacer por sí sola. Ejemplos: 
	 * 			
	 * 			A) /productos/todos: Quiero todos los produtos. 
	 * 
	 * 			B) /prodcutos/novedades: Quiero todos los prodcutos nuevos.
	 * 
	 * 			C) /productos/alta: Dar de alta un producto. 
	 * 
	 * 2. URL con parámetros, también llamadas URLs dinámicas. Es decir, necesito datos, saber el código de un producto para eliminar, cancelarm para editar. Necesito 
	 * un código de familia para sacar los productos de una familia. En este caso, hay dos posibilidades o estilos de URL: 
	 * 
	 * 		1.El uso de parámetros, es decir, parejas de datos de tipo Map<String, String>: 
	 * 
	 * 				String para el nombre del parámetro. 
	 * 
	 * 				String para el valor. 
	 * 
	 * 		2.A este tipo de parámetro String lo llama RequestParam, y nos sirven como ejemplos descriptivos: 
	 * 
	 * 				/productos?opcion=editar&producto=2
	 * 
	 * 				/productos?opcion=porfamilia&idFamilia=3
	 * 
	 * 		3.El uso de datos formando parte de la path de la URL. A estos Spring los denominda PathVariable. Y por comparación del modelo anterior, estos ejemplos: 
	 * 				
	 * 				/productos/editar/2
	 * 				
	 * 				/prodcutos/porfamilia/3
	 * 
	 * 
	 * 	URLs dinámicas @PathVariable
	 * -----------------------------
	 * En Spring MVC estas URLs dinámicas se las conoce como URL Templates, ya que funcionan como plantillas para obtener las diferentes rutas, y que serán tratadas 
	 * por los métodos de los controladores. 
	 * Un parte es estática y no cambia en los href; otra parte, la asociada a los valores, se considera dinámiza porque toma el valor correspondiente a la variable escrita en el 
	 * JSTL: 
	 * 
	 * Cuando el usuario pulsa el botón o enlace asociado al href, el path toma como último parámetro el valor asociado a ese código a tráves de la expresión de lenguaje
	 * ${prod.idProducto}
	 * 
	 * Debes tener en cuenta que los datos siempre viajan como String, independientemente del tipo de dato. 
	 * 
	 * En el caso de que la URL viniese con más de un dato, en los parámetros del método se recogerían tantos @PathVaribale como variables hubiese y con el tipo de dato correspondiente.
	 * 
	 *  URls dinámicas @RequestParam
	 *  ----------------------------
	 *  Otra manera de pasar los datos dinámicos por la URL consiste en el uso de parámetros que contienen dos partes, ambas de tipo String: la clave y el valor.
	 *  
	 *   @RequestParam es del mismo tipo que el objeto request de la clase HttpRequest de JEE, el que tenía el método getParameter("name") para obtener el valor de este parámetro y, luego, tenías que hacer
	 *   tú los parses para convertir el String al dato necesario.
	 *   
	 *   ATRIBUTOS DE PETICIÓN (REQUEST) 
	 *   -------------------------------
	 *   PAra que las vistas (los ficheros JSP) puedan mostrar dinámicamente la información proviniente del negocio (de los métodos del conrolador), necesitan crear atributos. 
	 *   En JEE estos atributos se generaban con el método setAttributte de request. 
	 *   
	 *   En el caso de Spring MVC se realizan usando una varibale de la clase Model, que la usamos como parámetro de los métodos de control cuando nos haga falta. 
	 *   
	 *   ATRIBUTOS DE SESIÓN
	 *   -------------------
	 *   La manera mas simple de tratar con sesiones es introducir una varibale de HttpSession en el método donde queremos mantener la sesión del usuario. 
	 *   
	 *   Cuando se cierre la sesión usamos los mismos métodos para eliminar la sesión: 
	 *   
	 *   		* removeAttibute() para borrar todos los atributos de la sesión. 
	 *   
	 *   		* invalidate() para cancelar la sesión.
	 *   
	 *   ver vídeos https://youtu.be/N8_B2MWV-x8
	 *   
	 *   
	 *   UF3.6 GESTION DE FORMULARIOS: DATA BINDING Y REDIRECCIONAMIENTO
	 *   ---------------------------------------------------------------
	 *   Solo dos consideraciones: 
	 *   
	 *   		* Ambos métodos, @getMapping y @PostMapping, llevan la misma URL. Pero los métodos en un controlador deben llevar nombres distintos por eso mismo, porque son distintos. 
	 *   
	 *   		* El FrontController, DispatcherServlet, de Spring distingue la misma URL, porque una viene por petición GET y la segunda vienen por POST.
	 *   
	 *    
	 *    @RequestParam en Formularios
	 *    ----------------------------
	 *    Como sabemos, en un formulario, los valores asociados, se recogían a tráves del atributo name con su nombre de parámetro correspondiente. 
	 *    
	 *    los atributos id y class son para las hojas de estilo CSS.
	 *    
	 *    "Como buena práctica, el literal asociado al atributo name de los componentes de un formulario debería ser el mismo que el atributo de instancia de la clase de negocio al que corresponden los datos del formulario."
	 *    
	 *    Si tomamos cada nombre de parámetro de forma independiente, el tratamiento en el método del controlador será el mismo que el aplicado en las URLs de estilo RequestParam, es decir, se recoge en el método que trata el formulario, cada
	 *    parámetro en un @RequestParam y se crea la variable necesaria para obtener la información.
	 *    
	 *    Data Binding
	 *    ------------
	 *    nos centramos ne los praámetros usuario y pasword con traibutos de la clase Clietne. Pues bien, si en el método @PostMapping, en lugar de recoger parámetro a parámetro, porngo una variable que referencia a la clase cliente que contiene alguno 
	 *    de los atributos con el mismo nombre que los name: 
	 *    
	 *    Spring MVC en tiempo de transmisión de los datos busca esa clase cliente, crea un objeto de esta y asocia a cada atributo de la clase el valor de los name correspondientes. 
	 *    
	 *    
	 *    REDIRECCIONAMIENTO 
	 *    ------------------
	 *    Para redireccionar a toro método con una URL diferente, Spring me proporciona dos maneras: forward y redirect. 
	 *    
	 *    1. Forward 
	 *    		return "forward:/url";
	 *    
	 *    Este forward es una reminiscencia del método forwrad de RequestDispacher de servlet:
	 *    
	 *    Enlaza dos servlet en la misma tarea y, al pasarle el request y responde, el siguiente servlet tiene acceso a todos los atributos que se han generado durante la petición.
	 *    
	 *    Pero este forward en Spring necesita que las dos peticiones enlazadas sean de tipo @GetMapping y esta petición, que procesa un formulario, es de tipo @PostMapping, y da error. 
	 *    
	 *    2. Redirect
	 *    		return "redirect:/url";
	 *    
	 *    A diferencia de forward, arranca una tarea nueva, una petición nueva, hilo nuevo- 
	 *    Caundo se hace una petición nueva, todos los atributos de Model se pierden y el formulario, que quiere mostrar el mensaje de "alta", enerando en el método post, no lo encuentra, por tanto, no aparecería nada. 
	 *    
	 *    Sprign ha ideado  un mecanismo: los atributos FlashAttribute. Estos atributos los guarda en la sesión, pero nada más utilizarlos (al referenciarlos la primera vez) los elimina en segundo plano sin que te enteres. 
	 *    
	 *    
	 *   
	 */
}
