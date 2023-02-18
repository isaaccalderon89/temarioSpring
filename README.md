![Spring](https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/Spring_Framework_Logo_2018.svg/1280px-Spring_Framework_Logo_2018.svg.png)
***
# Desarrollo Web Entorno Servidor

Lo que vamos a hacer ahora es generar una breve documentación que nos aporte una idea muy básica sobre como se forma un proyecto web.
Un proyecto web se divide en tres capas fundamentales, **la capa controladora (servlets), la capa donde van los datos (modelo), la capa donde van las vistas (JSPs).**

Primero definimos las carpetas donde van a ir cada capa. La capa donde van los datos la dividimos en dos carpetas. En una van los beans y en otra los metodos que vamos a utilizar. Las vistas van en otra carpeta que depende de 'WebApp'.

1. Lo primero que generamos son los Beans: 

        * Empezamos siempre por la case que va a ser heredada. 
        * Tiene que implementar Serializable. 
        
[vídeo temario PART1 ](https://youtu.be/ZT9l1GPDnfY)        
2. Hacemos la capa de acceso a datos:

    * Lo primero que creamos es un interface. El interface es independiente de donde estén los datos, lo que realmente hacemos es marcar que información queremos, ponemos los métodos que vamos a usar. 
    * Después creamos la clase que implementa el interface. Aquí es donde desarrollamos los métodos. 
    
[vídeo temario PART2 ](https://youtu.be/7QSPuUssmBA)

3. Hacemos la capa controladora: 

    * Creamos un "servlet" para cada capa de negocio. 

[vídeo temario PART3 ](https://youtu.be/IX8m13RAZGI)

4. Hacemos la capa de vistas: 

        * Debemos cercionarnos que el 'archivo.jsp' se crea dentro del directorio raíz.

[vídeo temario PART4 ](https://youtu.be/w7sQaMy7364)
[vídeo temario PART5 ](https://youtu.be/DRjEg34u-mE)
[vídeo temario PART6 ](https://youtu.be/ZT3hnGqsnqY)
[vídeo temario PART7 ](https://youtu.be/VafYQ_pKVc8)
## Spring Boot

Informamos a Spring (con ficheros de configuración XML, anotaciones especiales de Spring en Java o ficheros de propiedades) sobre donde se ecnuentra la clase y que atributos tiene. 
La inversión de control y gestión de dependencias es la capacidas de definir una variable y usar sus métodos, sin importar clases ni crear objetos, y usar los métodos de esta clase. 

* **@Autowired**. Le damos el nombre del Bean. 
* **@Component**. Cualquier clase que quiera incorporar al contenerdor de Spring debe llevar esta etiqueta.
* **@Controller**. En la capa del controlador anotaremos con esta etiqueta para desarrollar una aplicación web típica. Se crea una clase normal de Java, anotada con *@Controller*, y se define un método por cada petición. que atiende a una sola URL.
* **@RequestMapping**. Anotación que hace que no tengamos que estar repitiendo URLs. Se escribe detrás de del *@controller*.
* **@PostMapping**. Esta anotación se utiliza para asignar solicitudes HTTP POST a métodos de controlador específicos.
* **@InitBinder**.Esta anotación es una anotación de nivel de método que desempeña el papel de identificar los métodos que inicializan WebDataBinder, un DataBinder que vincula el parámetro de solicitud a los objetos JavaBean. Para personalizar el enlace de datos de parámetros de solicitud, puede usar métodos anotados **@InitBinder** dentro del controlador. Los métodos anotados con **@InitBinder** incluyen todos los tipos de argumentos que admiten los métodos de controlador.
Se llamarán los métodos anotados de **@InitBinder** para cada solicitud HTTP si no especifica el elemento de valor de esta anotación. El elemento de valor puede ser un nombre de formulario único o múltiple o parámetros de solicitud a los que se aplica el método de enlace de inicio.

        Ejemplo: 
        @InitBinder
            public void initBinder(WebDataBinder webdataBinder){
                SimpleDateFormat sdf = new SimpleDateformat("yyyy-MM-dd");
                webdatabinder.reisterCustomEditor(Date.class, new CustomDateEditor(sdf, false)
            }
     * El nombre del método es inventado. 
     *  Recibe un objeto de la clase **WebDataBinder**, que es el encargado de hacer la transformación.
     *  Hemos elegido la clase **SimpledateFormat**, registraremos la conversión pasándole la clase y el formato de conversión. 
     *  Spring registra este vínculo y, en cualquier método de este controlador que necesite una conversión de fecha, esta se hará de forma automática. 
Pasamos a la capa de datos.
* **@Repository**.Definimos la funcionalidad de la interfaz y creamos una clase que implemente la interfaz.
* **@Service**. El *servicio* representa el subconjunto de métodos del repositorios, métodos necesarios en mi aplicación para trabajar con la identidad. 


El protocolo HTTP tiene para las aplicaciones web dos métodos de transmisión de datos: GET y POST. 

        * Get: Todas las URLs que van en el atributo href de HTML. 
        * Post: solo se usa en formularios, para que sea más segura. 

Cada  método debe seranotado con **@GetMapping**, si la petición es GET; o con **@PostMapping**, si la peticón es por POST. Por parámetro pasamos la URL  

**Por convenio y buenas prácticas, todas las peticiones que vengan del exterior las tratareamos a través del controlador por peticiones GET.**
* **@RestController**. Si queremos hacer una Api Rest, para transmitir texto , JSON, XML, etc. 


[Incorporación de Spring Boot a Eclipse PART8 ](https://youtu.be/vAhA7sIPJGU)
[Primer HolaMundo con Spring Boot PART9 ](https://youtu.be/ZoKKuo2THow)

Lo único que necesitarás para abrir un documento Markdown es un editor de texto plano.

El lenguaje Markdown fue creado por [John Gruber](https://daringfireball.net).

### ¿Cuántas clases con @Controller son necesarias?

Todo depende del número de tareas a desarrollar. Una buena práctica sería.

* Para mostrar la página de inicio de la aplicación y en relación con las tareas de iniciar sesión, cerrar sesión, crearemos **HomeController**. 
* Por cada **JavaBean**, es decir, crearemos una clase que llamaremos **Gestion(Nombre de JavaBean)**. 

        * Ejemplo: GestionProductos. 


[vídeo temario PART10 ](https://youtu.be/YkGzDQKi38o)
[vídeo temario PART11 ](https://youtu.be/Rb_M9JAW5BU)
[vídeo temario PART12](https://youtu.be/N8_B2MWV-x8)


### Tipos de rutas URL

Existen dos tipos de rutas URL independientemente de la técnología y del lenguaje de programación que utilicemos. 

1. **URL estáticas**. La URL dice que hay que hacer por sí sola. 
2. **URL dinámicas**. Estas rutas tienen una parte estática y no cambia en los **href**, y otra parte, asociada a los valores que se considera dinámica. 
Vamos a ver como recogemos esto en el *@GetMapping*:
    * El parámetro se recoge con **@PathVariable**.
    * Entre paréntesis se recoge el nombre que pusimos entre llaves en el *GetMapping*. 
    * Le dices que te convierta el String de la ruta a la variable que tú le digas y le das el nombre que tú quieras.

                 Ejemplo:
                @GetMapping(“/listarPorFamiliaColor/{id}/{color}”)
                 public String listarPorFamiliaColor(@PathVariable(“id”) int idFamilia, @PathVariable(“color”) String color) {
                System.out.println(“la familia recogida es el “ + idFamilia);
                System.out.println(“el color recogido es el “ + color);
                
                 return “listarProductos”;
                 
            }

* **@RequestParam**. Con esta etiqueta esta sería otra forma de recoger parámetros. 
    * En la URL del *@GetMapping* solo se pone la parte estática de la ruta. 
    * Los parámetros se recogen por *RequestParam*, **el nombre debe ser el mismo** del parámetro que viaja. 
    * Spring te convierte los valores String al tipo que le indiques.
        
## Spring JPA
El **acceso a las bases de datos** en aplicaciones web se realiza siempre desde el **modelo MVC**.
**Spring Data JPA** tiene como objetio mejorar significativamente la implementación de capas de acceso a datos al reducri el esfuerzo a la cantidad de líneas de código que realmente necesita.

**Entidades**. Una clase que contiene los atributos correspondientes a las columnas de las tablas de la base de datos. Cada objeto de una clase corresponde a una fila de la tabla. 

* **@Entity**. Con esta anotación expresamos que esta clase corresponde a una tabla.
* **@Table**. Esta anotación es porque la tabla se llama distinto de la clase, se le indica la que tabla con la que se relaciona. @Table(name = "nombre_tabla").
* **@Column**. Cada atrinuto del javaBean a cada columna de la base de datos. @Column(name = "nombre_columna").
* **@Id**. El atributo del JavaBean que corresponde a la *Primary Key* de la tabla.
* **@OneToOne, @ManyToOne y @ManyToMany**. Las relaciones entre tablas/clases
* **@Temporal**(TemporalType.DATE), para columnas de tipo Date, el TemporalType contiene unas enumeraciones para cada tipo de columna de fecha de la base de datos. 

### Sincronización motor de persistencia con base de datos
* **Persist**. Cuando se ejecuta el persist, si hace un "find" previo, como el objeto está sincronizado con la fila, al invocar a persist, este se transforma en un update a la tabla. Pero si invoco directamente a persist, sin lectura previa, se convierte en tiempo de ejecución en un "insert into familias", para dar de alta la fila. 
* **Merge**. Hace un select. Si la fila existe, se ejecuta un update para modificar la fila. Si la fila no existe, se ejecuta un insert para dar de alta la fila. 
* **Remove**. Este método invoca a la sentencia de SQL, delete, pero la fila se borra si el objeto correspondiente a la fila está sincronizado. 

### Repositorios Spring data JPA
* **CrudRepository**. Proporciona funciones para la mayoría de operaciones CRUD [ver métodos](https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html)
* **PagingAndSortingRepository**. Proporciona métodos para hacer painación y ordenar registros. [ver métodos](https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/PagingAndSortingRepository.html)
* **JpaRepository**. Proporciona métodos relacionados con JPA, para trabajar con registros en lotes. [ver métodos](https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html)

## Spring Boot Microservicios REST
HTTP define un conjunto de métodos de petición para indicar la acción que se desea realizar para un recurso determinado. 
En servicios web usaremos: 
* **Get**: para consultas de datos. 
* **Post**: en estas peticiones los clientes nos pasan estructuras de datos en diferentes formatos, pero fundamentalmente **JSON**.
* **Put**: los clientes a través del cuerpo HTTP, nos pasarán datos en formato **JSON** para que lo modifiquemos en nuestra base de datos. 
* **Delete**: los clientes normalmente a través de la URL nos pasarán el código del producto o la familia que quieren que demos de baja.

### Anotaciones
* **@GetMapping**: trata todas las peticiones de tipo HTTP GET. 
* **@PostMapping**: todas las que solicitan dar de alta un objeto. 
* **@PutMapping**: para modificar un objeto en la base de datos. 
* **@DeleteMapping**: para eliminar un objeto de la base de datos.

En tiempo de ejecución y en segundo plano, Spring Boot, transformará estos objetos (JavaBeans):
* El cliente nos manda datos con formato **JSON** en el cuerpo del mensaje HTTP, y yo recibo el objeto correspondiente en Java. 
* Yo devuelvo uno o más objetos javabean, y Spring Boot, lo transforma en uno o un array de objetos **JSON**, que es lo que recibe el cliente que me ha llamado. 
* En operaciones de actualización responsdo con un String informando si el alta, baja o modificación ha salido bien o mal. 
###
* **@Path**. Se emplea a nivel de clase para asignar la **URL del servicio**.También puede emplearse a nivel de los métodos de la clase para asignar subdirecciones o parámentros a dichos métodos. 
* **@GET, @POST, @DELETE, @PUT: asocian a lso métodos del servicio un determinado método HTTP**
* **@PathParam**: asocia un parámetro recibido en la petición con el correspondiente parámetro del método del servicio que la va a procesar.
* **@Produces**: se emplea a nivel de método para indicar al motor el **formato de respuesta**. 
* **@Consumes**: es similar a la anterior, pero se emplea para inidicar el **formato del dato que va a ser enviado en el cuerpo de la petición. Normalmente, se emplea en métodos que van a responder a peticiones PUT y POST, que son las que suelen enviar datos en el cuerpo.
* **@ResController**.Una clase controladora de Spring Boot se convierte en una aplicación de servicios web, simplemente anotando la clase como **@RestController**
* **@CrossOrigins(origins= "*"), es para permitir accesos desde aplicaciones cliente web, es decir, desde JavaScript con peticiones HTTP **Ajax**.

**RECUERDA: que un servicio REST, devuelve datos, información, que el proceso que nos llame necesita para su funcionamieto**. 
Una aplicación web nos devuelve un jsp que queremos mandar al navegador. 

### Configuración del microservicio REST

Creamos el proyecto nuevo con los starter de: 

        * Spring mvc y Spring Developer Tools 
        * Spring Data JPA y Driver MySQL
        * Aplicación Java 11, Maven y Package jar. 

1. Definimos los JavaBean anotados con JPA
2. Creamos los repositories
3. Creamos las interfaces de negocio
4. Clases que implementan las interfaces
5. Definir los @RestController
6. Ejecución con Postman

## Spring Boot Security 

A nivel de desarrollo de aplicaciones web, vamos a centrarnos en dos aspectos concretos, que son la autenticación y autorización de usuarios, aspectos que están estandarizados por la especificación Java EE. 

El proceso de autorización es realizado también por el servicio de seguridad de servidor, basándose en las políticas de seguridad definidas dentro de la aplicación. Estas políticas se definen de manera declarativa en el archivo de configuración 'web.xml'. 

Configuramos el proyecto añadiendo en los Strarter las opciones: 

        * Spring mvs y Dev Tools
        * Spring Security

Tenemos que visualizar el fichero **pom.xml** y confirmar que se han añadidos las dependencias de Spring Security. 

Por defecto nuestro proyecto aplicará de forma automática la siguiente configuración: 
* Se crea un usario en memoria (**username=user**)con acceso a todas las URLs. 
* La contraseña, encriptada, se genera automáticamente al arrancar Tomcat y se despliega en los log de arranque en la consola. 
* Será requerida autenticación para todas las URL. 

Para asignar un usario y una password por defecto lo hacemos a tráves del fichero de **'application.popoerties'**

Se puede trabajar de dos maneras: 

1. Tablas security:

    * Crear dos tablas en motor de BBDD que tengamos. 
    * Incorporar el driver de MySQL y el starter de Spring Data JPA. 
    * Crear las clases anotadas @Entity con anotaciones JPA.
    * Configurar la base de datos en el fichero **'application.popoerties'**
    * Crear la clase que hereda de **WebSecurityConfigurerAdapter**. 

2. Tablas propias. En el **datasource** hayq ue añadir dos métodos: 
    * **usersByUserNameQuery**, que es una consulta SQL de las columnas que hay en la tabla, donde le informo de cuál hacer de *username*, *password* y *eneable*. 
    * **authoritiesByUsernameQuery**, que es una consulta de SQL en donde le digo que voy a usar como *username* y nombre de perfil de la tabla de perfiles.
    

### Anotaciones

* **@Configuration**. Indica que la clase sobre la que se encuentra aplicada debe ser usada como parte de la configuración de Spring. 
* **@EneableWebSecurity**. Es una anotación importante en aplicaciones web de Spring Boot que permite habilitar la seguridad web utilizando las carácteristicas predefinidas de Spring Security, y personalizar la configuración de seguridad según las necesisades de tu aplicación. 
* **{noop}** Informamos a Spring Security que la password no va encriptada. 

[vídeo temario PART13](https://youtu.be/fNlQgJ6MWjs)
[vídeo temario PART14](https://youtu.be/MtTc0SvG35Y)




### Clase WebSecurityAdapter
Es una clase importante de Spring Security que te permite personalizar la configuración de seguridad de una palicación web. Al extender esta clase y sobreescribir sus métodos, puedes definir reglas de seguridad específicas para las solicitudes HTTP entrantes, configurar el objeto AuthenticationManager y establecer otros aspectos de la seguridad de la aplicación. 

[vídeo temario PART15](https://youtu.be/zDgCBr9l0oA)

### Clase BCryptPasswordEncoder
Es una herramienta importante para asegurar que las contraseñas de los usuario se almacenen de forma segura y se puedan verificar de forma efectiva en aplicaciones de Spring Security. Implementa la interfaz **PasswordEncoder** y utiliza el método **BCrypt** para cifrar las contraseñas. 



[Pincha para llevarte una sorpresa](https://www.google.com/url?sa=i&url=https%3A%2F%2Fes.linkedin.com%2Fin%2Ftom%25C3%25A1s-escudero-delgado-2032872b&psig=AOvVaw0TNL8_UopbIgyJo-vlDJ_f&ust=1676397801028000&source=images&cd=vfe&ved=0CBAQjRxqFwoTCLCK1c6Kk_0CFQAAAAAdAAAAABAI)