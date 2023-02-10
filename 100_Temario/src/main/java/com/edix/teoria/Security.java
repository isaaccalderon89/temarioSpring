package com.edix.teoria;

public class Security {
	
	/*
	 * 5.1 PRINCIPIOS DE SEGURIDAD EN APLICACIONES
	 * -------------------------------------------
	 * 
	 * -Aplicaciones seguras-
	 * 
	 * Conceptos Generales: 
	 * Cuando hablamos de seguridad en aplicaciones web, nos estamos refiriendo a factores como: 
	 * 
	 * 	- Que la aplicación solo pueda ser utilizada por usuarios autorizados.
	 * 	- Que los datos que manejan la aplicación no puedan ser vistos o alterados por terceros. 
	 *  - Que las operaciones realizadas por la aplicación se ejecuten en un entorno seguro y libre de errores. 
	 *  - Que esté preparada para repeler posibles ataques externos. 
	 *  
	 *   La seguridad de una aplicación no solo afeta a su creación, también al entorno de ejecución y al elemento 
	 *   físico en el que se utiliza el (hardware del equipo, red, etc). 
	 *   
	 *   
	 *   Características de la seguridad:
	 *   
	 *   1. Disponibilidad. Capacidad de la aplicación consistente en que los usuarios autorizados tengan accesos a
	 *   los recursos en el momento en que lo soliciten. 
	 *   
	 *   2. Autenticidad. Característica que consiste en identificar a un usaurio, verificando que es quien dice ser.
	 *   
	 *   3. Integridad. Propiedad consistente en garantizar que los recursos de la aplicación n puedan ser alteraods por
	 *   usuarios no autorizados. 
	 *   
	 *   4. Confidencialidad. Mediante esta caracteristica de la seguridad se garantiza que la información solamente es accesible 
	 *   a los usuarios autorizados, no estando disponible para aquellos que no tienen los privilegios adecuados. 
	 *   
	 *   5. Trazabilidad. Las actuaciones de un usuario dentro de la aplicación solamente pueden imputarse a dicho usuario. 
	 *  
	 *   
	 *   -SEGURIDAD DECLARATIVA Y PROGRAMÁTICA- 
	 *   Dos vías: 
	 *   
	 *   * Seguridad declarativa: Consiste en aplicar las políticas de seguridad de manera declarativa, sin utilizar 
	 *   código , es decir, a través, del archivo de configuración de la aplicación o anotaciones. 
	 *   
	 *   * Seguridad programática: La gestión de la seguridad se realiza desde código. Se debe evitar programar aspectos
	 *   de seguridad desde código, ya que cualquier cambio en las políticas de seguridad requeriría modificar de nuevo 
	 *   la aplicaición.
	 *   
	 *    -AUTENTICACIÓN Y AUTORIZACIÓN DE USUARIOS- 
	 *    Son dos tareas que pueden ser realizadas por cualquier servidor Java EE. 
	 *    
	 *    Dos conceptos clave en el desarrollo de aplicaciones seguras son la autenticación y autorización de usuario que acceden
	 *    a los componentes de la aplicación. 
	 *    
	 *    
	 *    Autenticación: La autenticación es el proceso mediante el cual se identifica al usuario de una aplicación web, comprobando 
	 *    que efectivamente es quien dice ser. 
	 *    
	 *    A traves del archivo de configuración 'web.xml' se le indica al servidor de aplicaciones el mecanismo que debe utilizar para solicitar 
	 *    al usuario de la aplicación los credenciales. Una vez enviados, el servicio de seguridad del servidor se encargará de comprobar en repositorio
	 *    de usuarios si la combinación de usuario y contraseña recibida coincide con algunas de las combinaciones registradas en dicho repositorio. 
	 *    
	 *    Autorización: Una vez que el usuario ha sido identificando durante el proceso de autenticación, se comprueba que dicho usuario tiene privilegios
	 *    para utilizar el recurso de una aplicación al que intenta acceder. Este preoceso es conocido como autorización. 
	 *    
	 *    El proceso de autprización es realizado también por el servicio de seguridad del servidor, basándose en las políticas de seguridad definidas dentro de la 
	 *    aplicación . Estas políticas se definen de manera declarativa en el archivo de configuración 'web.xml'.
	 *    
	 *    
	 *    UF5.2 CONFIGURACIÓN BÁSICA CON SPRING SECURITY
	 *    ----------------------------------------------
	 *    Debemos seleccionar la opción de Spring Security. 
	 *    Le añadimos los starter de:
	 *    
	 *    	* Spring mvs y DevTools. 
	 *    	* Spring Security. 
	 *    
	 *    En el fichero 'pom.xml'
	 *    <dependency>
	 *			<groupId>org.springframework.boot</groupId>
	 *			<artifactId>spring-boot-starter-security</artifactId>
	 *	  </dependency>
     *     <dependency>
	 *			<groupId>org.springframework.security</groupId>
	 *   		<artifactId>spring-security-test</artifactId>
	 *			<scope>test</scope>
	 *	  </dependency>
	 *	  
	 *	  -CONFIGURACION BÁSICA CON SPRING SECURITY- 
	 *   Por defecto, con solo agregar el starter de Spring Security a nuestro proyecto se aplicará de forma automática la siguiente configuración.
	 *   
	 *   * Se crea un usuario en memoria (username=user) con acceso a todas las URLs.
	 *   * La contraseña, encriptada, se genera automáticamente al arrancar el tomcat y se despliega en los log 
	 *   de arranque en la consola.
	 *   * Será requerida autentucación para todas las URL. Por tanto, vamos a ir al navegador y vamos a invocar a la URL ('/')
	 *   
	 *   -CERRAR SESIÓN- 
	 *   La configuración por defecto de Spring Security también incluye la funcionalidad para cerrar la sesión de una aplicaciónweb. 
	 *   
	 *   
	 *   -UF 5.3 TABLAS USUARIOS Y ROLES EN MI MODELO. CONFIGURACIÓN DE DATASOURCE EN MI PROYECTO-
	 *   
	 *   -Usuario y contraseña personalizados- 
	 *   Cada vez que rearrancamos el proyecto, la password cambia. 
	 *   Para ello, podemos asignar un usaurio y una password por defecto a través del fichero de 'application.porpoerties'
	 *    
	 *    -Usuarios y perfiles: configurar las tablas de SQL- 
	 *    Con Spring Security podemos trabajar con usuarios y perfiles (roles) de dos formas: 
	 *      * Usando las tablas que reconoce spring por defecto. 
	 *      * Usando nuestras propias tablas. 
	 *      
	 *      TABLAS SECURITY
	 *      Si vamos a trabajar con las tablas que viene por defecto deberemos:
	 *      
	 *      1. Crear estas dos tablas en el motro de bases de datos que tengamos (en nuestro caso MySQL). 
	 *      2. Incorporar el driver de MySQL y el starter de Spring Data JPA. 
	 *      3. Crear las clases anotadas con @Entity con anotaciones JPA. 
	 *      4. Configurar la base de datos en el fichero 'application.propierties' de recursos.
	 *      5. Crear una clase que hereda de webSecurityConfigurerAdapter, con la configuración que vemos a continuación.
	 *      
	 *      @Configuration
			@EnableWebSecurity
			public class DatSecurity  extends WebSecurityConfigurerAdapter{

			@Autowired
    		private DataSource dataSource;
    		
			@Override
			protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       							auth.jdbcAuthentication().dataSource(dataSource);
			}
	 *      
	 *       De este código destacamos:
	 *       
	 *         * Esta clase puede estar dentro del paquete principal, pero tambén podemos poner un paquete independiente para estas 
	 *         clases de configuración. 
	 *         
	 *         * Está anotada con @Configuration y @EneableWebSecurity 
	 *         
	 *         *El nombre de la clase es inventado. 
	 *         
	 *         *Hereda (extends) de la clase WebSecurityConfigurarAdapter para la configuración de seguridad en la web. 
	 *         
	 *         *La calse necesita un datasource, clase necesaria para implementar una fuente de datos externa, generalmente, una base de datos.
	 *         
	 *         *Necesita un método redefinido denominado configure y cuya estructura de método es como la que tieness en el código. 
	 *         
	 *         *A través de la variable auth y el siguiente código
	 *         auth.jdcAuthentication().dataSource(dataSource); le indicamos que busque de forma automática, las tablas 'USERS' y 'AUTHORITIES', en la base de datos
	 *         que le hemos indicado en el fichero 'applications.propierties'. 
	 *         
	 *         TABLAS DE SECURITY PROPIAS
	 *         Hacer la misma clase que el apartado anterior con el método configure, pero ahora al data source hay que añadir dos métodos: 
	 *         
	 *         * usersByUsarnameQuery, que es una consulta SQL de las columnas que hay en la tabla, donde le informo de cuál hace de usarname, password y eneable. 
	 *         
	 *         * authoritiesByUsernameQuery, que es una consulta de SQL en donde le digo qué voy a usar como username y nombre del perfil de las tabla de perfiles.
	 *         
	 *         UF 5.4 PERMISOS Y AUTORIZACIONES DE URL.
	 *         ----------------------------------------
	 *         
	 *         -Autenticación de URL-
	 *         
	 *         Mediante la configuración HttpSecurity y su métodos tenemos la capacidad de configurar que URLs están permitidas sin autorización y qué URLs no lo están. 
	 *         
	 *         En la mismca clase donde hemos configurado el datasource con las tablas de usuarios y perfiles visto en la lección anterior, debemos sobrecargar el método 
	 *         configure, admitiendo como parámetro un objeto de la clase HttpSecurity
	 *         
	 *         Esta clase tiene los siguientes métodos: 
	 *         
	 *          	* autorizeRequest(): con este método se inicia la lista de recursos y URLs autorizadas.
	 *          	* antMatchers(): especificación del recurso o URL entre comillas separados por comas, que queremos autorizar. 
	 *          	* permiteAll(): indica que todos lo recursos URLs especificados por antMatchers están permitidas sin autorización y, por tanto, no solicitan la llamada 
	 *          					a la URL/login que muestra en el navegador el formulario de login. 
	 *          
	 *          Por tanto, en primera instancia especificamos que directrios del proyecto de la parte static: JavaScript, CSS, Bootstrap, imágenes o cualquier directorio que tengamos
	 *          ahí (si los hubiera), le autorizamos sin autenticación. 
	 *          
	 *          Y, a continuación, sí permitimos navegar a usuarios que no se han registrado previamente, como invitados, para que vean como es nuestra aplicación. 
	 *          
	 *          Todos los métodos descritos devuelven un objeto de la clase HttpSecurity, por eso van todos encadenados. 
	 *          
	 *          El resto de URLs sin especificar, saltará el formluario de login. 
	 *          
	 *          -Autenticación de perficles-
	 *          
	 *          Los métodos de HttpSecurity encargados son: 
	 *          
	 *          * antMatchers(): especificación del recurso o URL entre comillas y separados por comas, que tenemos que autorizar. 
	 *          
	 *          * hasAnyAuthority(): con este método se indica la lista del perfil, o perfiles, autorizados de las URLs especificadas en antMachers. 
	 *          
	 *          * permiteAll(): indica que todos los recursos y URLs especificados por antMachers están permitidas sin autorización y, por tanto, no solicitan la llamada 
	 *          				a la URL/login que muestra en el navegador el formulario del login. 
	 *          
	 *          
	 *          FORMULARIO LOGIN Y RESTO DE URLS
	 *          --------------------------------
	 *           Al final de este método de configuración debemos poner que cualquier recurso o URL no especificada tiene que estar autenticada, esto se hace con los métodos: 
	 *           
	 *           	* anyRequest(): cualquier otra petición no especificada hasta ahora. 
	 *              * aunthenticated(): queda autenticada y, por tanto, saldrá el formulario de login solicitando usuario y password. 
	 *              
	 *           
	 *          OBTENER USUARIO Y PERFIL EN MI PROYECTO
	 *          ----------------------------------------
	 *          Si en cualquier comento del controlador quiero obtener el usuario o el perfil introducido en el formulario del login, debo inyectar un objeto de la clase 'Authentication'.
	 *          
	 *          Esta clase nos proporciona dos métodos: 
	 *          
	 *          		* .getName(): que devuelve el nombre del usuario que se ha autenticado. 
	 *          
	 *          		* .getAuthorities(): que nos devuelve una lista de la clase 'GrantedAuthority' para ver el perfil o perfiles de ese usuario. 
	 *          
	 *          
	 *          UF 5.5 PERSONALIZAR VISTAS. TAGLIB SECURITY 
	 *          -------------------------------------------
	 *          Spring Security nos ofrece, para la creación y personalización de nuestras páginas JSP, una librería de etiquetas personalizadas. 
	 *          
	 *          PAra ello tenemos que incluir en el fichero de Maven pom.xml, la dependencia: 
	 *          
	 *          <!-- https://mvnrepository.com/artifact/org.springframework.security/spring-security-taglibs -->
					<dependency>
		    			<groupId>org.springframework.security</groupId>
		    			<artifactId>spring-security-taglibs</artifactId>
		    			<version>5.4.5</version>
					</dependency>
					
					y la siguiente línea en cada fichero jsp que queremos personalizar. 
	 *          
	 *          		<%@ taglib prefix="sec"uri="http://www.springframework.org/security/tags" %>
	 * 
	 * 			La idea es que la misma página la pueda configurar dependiendo de si estás autorizado o no, y que salgan botones del menú de navegación o 
	 * 			botones de acción en función del perfil de cada usuario.
	 *  		
	 *  
	 *  		ESTAS O NO AUTENTICADO
	 *  		----------------------
	 *  		La etiqueta corresponde a un método que pregunta si estás o no autenticado, para sacar todo lo que se encuentre entre la etiquea y el final de la etiqueta. 	
	 *          
	 *          
	 *          UF 5.6 SESIONES DE USUARIO. ENCRIPTACIÓN DE DATOS. 
	 *          --------------------------------------------------
	 *          
	 *          -Agragar datos a la sesión de usuario- 
	 *          
	 *          En el fastbook 04 vimos como en controladore podíamos obtener los datos del usuario y los perfiles a trvés de los métodos de la clase Authentication. 
	 *          
	 *          Aunque Security almacena este dato, en muchas ocasiones nos interesa almacenar en la sesión todos los atributos del Usuario, para poder obtenerlo en cualquier momento. 
	 *          
	 *          Para ello, tenemos que inyectar un objeto de la clase HtpSession en el método que tengamos para arrancar la página del Home. 
	 *          
	 *          Antes de almacenar el Uusario en el atrbiuto de la sesión, hacemos dos cosas:
	 *          
	 *          1. Preguntar si el atributo ha sido almacenado antes. 
	 *          2. Eliminamos del usuario la password para que no ande viajando el objeto Usario con ella, así, aumentar la seguridad. 
	 *          
	 *          ENCRIPTAR CONTRASEÑAS
	 *          ---------------------
	 *          Spring Security proporciona la clase BCryptPasswordEncoder, que implementa l ainterfaz PasswordEncoder se Spring y utiliza el método hash fuerte de BCrypt para cifrar las contraseñas. 
	 *          
	 *          Para ello, debemos configurar, en el paquete de configuración (en el mismo fichero donde configuramos el DataSource y los permisos), un @Bean que nos permita inyectar en el controlador un objeto
	 *          de la BCyptPasswordEncoder:  
	 *          
	 *          La contraseña encriptada, en tiempo de registrar al usuario, se alamacena también encriptada en la base de datos. 
	 *          
	 *          En fase de pruebas debes recordad la contraseña que tienes alamacenada en la base de datos
	 *          
	 *          
	 *         
	 */

}
