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
	 */

}
