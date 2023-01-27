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
	 */
}
