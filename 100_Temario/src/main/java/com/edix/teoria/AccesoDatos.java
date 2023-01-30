package com.edix.teoria;

public class AccesoDatos {
	/*
	 * UF 4.1 TABLAS NECESARIAS PARA NUESTRO PROYECTO
	 * ----------------------------------------------
	 * 
	 * ACCESO A DATOS EN APLICACIONES WEB
	 * ----------------------------------
	 * El acceso a base de datos en aplicaciones web se realiza sempre desde el modelo MVC. 
	 * 
	 * La aplicación utiliza los objetos JDBC para enviar instrucciones SQL a la base de datos y manipular los resultados, 
	 * dejando el diver los detaller de conexión y comunicación. De este modo, el mismo código podría ser utilizado con cualquier 
	 * de base de datos. Simplemente cargando el driver correspondiente. 
	 * 
	 * LA LOGICA DE NEGOCIO
	 * --------------------
	 * Para aplicar la lógica de negocio de la aplicación, crearemos tres clase que describiremos a continuación: 
	 * 
	 * 1. La interfaz
	 * 
	 * 2. La clase que implementa la interfaz: GestionUsuariosImplMysql8
	 * 
	 * 		Lo primero es definir las variables necesarias. 
	 * 
	 * 		Y luego en el constructor establecer la conexión:
	 * 
	 * Para ello, hay que pasarle la URL proporcionada por el fabricante con el nombre de la base de datos, el usuario y la pasword.
	 * 
	 * 
	 * 
	 * UF 4.2 CAPA DE PERSISTENCIA: EL ACCESO A LOS DATOS EN UNA APLICACIÓN
	 * --------------------------------------------------------------------
	 * 
	 * Se creó un mecanismo a través de anotacniones de java para hacer corresponder: 
	 * 
	 *  * La clase se anota como @Entity.
	 *  * El JavaBean a la tabla de la base de datos: @Table (name="nombre_tabla").
	 *  * Cada Atributo del JavaBean que corresponde a la Primary Key de la tabla: @Id. 
	 *  * Las relaciones entre tablas/clases: @OneToOne, @ManyToOne y @ManyToMany
	 *  * Y otras anotaciones que veremos mas adelante.
	 *  
	 *   SINCRONIZACION DE CONSULTAS A CLASE ASOCIADAS
	 *   ---------------------------------------------
	 *   
	 *   CONSULTAS NO CRUD: JPQL
	 *   Una propiedad consiste en nmombrar el atributo de la clase como si fuera público ara, en tiempo de ejecución, transformarle en su
	 *   conrrespondiente método getter. 
	 *  
	 *  COMPONENTES DE UN FRAMEWORK DE PERSISTENCIA
	 *  -------------------------------------------
	 *  Podemos decir que todo framework de persistencia debe proporcionar tres elementos, o componentes, para la creación y manipulación de la 
	 *  capa de persistencia: 
	 *  
	 *  1. Motor de persistencia
	 *  El motor de persistencia es la parte mas importante del framework, pues es el encargado de trasladar a la base de datos todas las operacioes 
	 *  que se realzan sobre la capa de persistencia. 
	 *  
	 *  Motores de persistencia son: Hibernate, Ibatism EclipseLink, topLink...
	 *  
	 *  2. Mecanismo de configuración
	 *  Para poder realizar su labor, el motor de persistencia requiere cierta información de configuración: 
	 *  
	 *  		* Como los datos de conexión a la base de datos (en XML). 
	 *  		* Mapeo de entidades  tablas, etc. (@Anotaciones Java).
	 *  
	 *  3. EntityManagerFactory
	 *  Es la encargada de establcer la conexión a la base de datos especificada en los parámetros.
	 *  
	 *  4. Persistence
	 *  A través de la clase Persistence podemos crear objetos 'EntityManager'.
	 *  
	 *  5.EntityManager
	 *  Es el componente más importante del API JPA. La interfaz 'Entitymanager' contiene los métodos para la realización 
	 *  de las operaciones CRUD, así como para la creación de objeto de consulta. 
	 *  
	 *  6. Query y typedQuery 
	 *  A traves de las implementaciones de estas interfaces podremos enviar consultas a la capa de persistencia mediante JPQL. 
	 *  
	 *  PASOS PARA INCORPORAR JPA A UN PROYECTO
	 *  ---------------------------------------
	 *  1. PArtimos de una aplicacion java basica de consola. 
	 *  
	 *  2. Asociamos el proyecto la faceta JPA
	 *  
	 *  3. Se genera la unidad de persistencia, que es un fichero XML
	 *  
	 *  4.Mapeamos con anotaciones Javam los JavaBena, asociando cada clase a una tabla y cada atributo a cada columna de esa tabla, 
	 *  y asociando el atributo de la clase a la columna que forma la primary key de la tabla.
	 *  
	 *  5.Convertimos el proyecto a Maven y añadimos las dependencias del driver del gestor de base de datos relacional que usemos, y la dependencia 
	 *  del motor de persistencia , en nuestro EclipseLink.
	 *  
	 *  6.Creamos la interfaz con la funcionalidad: alta, baja, modificación, cosultas varias,etc.
	 *  
	 *  7.Creamos la clase qe implementa la interfaz usando las clases y métodos proporcionados por el motor JPA
	 *  
	 *  8. Hacemos una clase de test y probamos cada función de la interfaz. 
	 *  
	 *  
	 *  
	 *  UF4.3 SPRING DATA JPA.CREACION DEL PROYECTO
	 *  -------------------------------------------
	 *  Spring Data JPA tiene como objetivo mejorar significativamente la implementación de capas de accesos a datos al reducir el esfuerzo a la cantidad 
	 *  de líneas de código que relamente se necesita. 
	 *  
	 *  CARACTERISTICAS:
	 *  
	 *  	* Usa Hibernate como motor de persistencia y aprovecha y mejora todos los métodos para las operaciones CRUD de JPA.
	 *  	* Para aquellas consultas que no estén predefinidas en Spring DataJPA, proporciona una manera simple de métodos JPQL. 
	 *  
	 * 	CREACION DE LOS JAVABEAN: ENTIDADES ANOTADAS ORM
	 * 
	 *      * @Entity, con esta anotación expresamos que esta clase corresponde a una tabla. 
	 *      * @Table(name="productos"), esta anotación es porque la tabla se llama distito de la clase. 
	 *      * @Id, con el que es obligatorio que todo el JavaBena de persistencia tenga un atributo (y solo uno) con esta anotación y que normalmente corresponde a la 
	 *      	columna que es primary key en la tabla de referencia. 
	 *      *@Temporal (TemporalType.DATE), para columnas de tipo Date, el TemporalType contiene unas enumeraciones para cada tipo de columna de fecha de la base de datos.
	 *      *@ManyToOne @JoinColumn(nmae="ID_FAMILIA") con esta anotacion decimos que tiepo de asociacion tenemos, porque columna de la tabla se hace la union 
	 *      (FK respecto a PK) y la creación del atributo familia de la clase 'Familia'. 
	 *      
	 *  UF4.4 REPOSITORIOS Y MÉTODOS JPA
	 *  --------------------------------
	 *  
	 *  REPOSITORIOS SPRING DATA JPA 
	 *  
	 *  Spring proporiciona su propio mecanismo basado en Hibernate: Data JPA. 
	 *  
	 *  Spring Data JPA , a través de la implementación JPA de Hibernate, porporciona tres clases con métodos para cada una 
	 *  de la mayoría de las operaciones CRUD, en el siguiente orden de jerarquía: 
	 *  
	 *  		* CrudReository: Proporciona funciones para la mayoría de operaciones CRUD. 
	 *  
	 *  		* PagingAndSortingRepository: proporciona métodos para hacer paginación y ordenar registros. 
	 *  
	 *   		* JpaRepository: proorciona métodos relacionados con JPA, para trabajar con registros en lotes.
	 *    
	 *   La manera de crear el repositorio para usar estos métodos ya configurados es tan simple como:
	 *   
	 *    1. Crear una interfaz para cada entidad JPA que hereda alguna de las clases mencionadas, solo las que vayamos a usar en nuestro proyecto. 
	 *    
	 *    2. Como están basados en genéricos, les tenemos que dar la clase anotada JPA correspondeinte a la tabla de base de datos- 
	 *    
	 *    3. La clase que representa el tipo de dato del atributo anotado con @Id (si el tipo de dato es tipo básico de Java, int o long, habrá que especificar su clase 
	 *    envolvente, Integer, o Long respectivamente):
	 *    
	 *    Métodos de Interfaz CrudRepository <T,ID>
	 *    -----------------------------------------
	 *    Este es la interfaz para operaciones CRUD genéricas en un repositorio para un tipo específico proporcionado con el tipo de dato que corresponde 
	 *    a la clave primaria de la tabla (y anotado en el JavaBean con @Id):
	 *    
	 *    Tipo devuelto       Método y descripción
	 *    -------------		  --------------------
	 *    long 					count() Devuleve el número de entidades existentes
	 *    void 					delete(T entity) Elimina la entidad proporcionada 
	 *    void 					deleteAll() Eliminas todas las entidades gestionadas por el Repositorio. 
	 *    void					deleteAll(Terable<?extendes T>entities) Elimina las entidades proporcionadas por la lista
	 *    void 					deleteAllById(Iterable<?extends ID >ids) elimina todas la entidades que corresponden a la lista de ID´s proporcionada. 
	 *    void 					deleteById(ID id) Elimina la entidad a partir del Id proporcionado. 
	 *    boolean 				existById(ID id) Devuleve si extiste una entidad con el ID dado. 
	 *    Iterable<T>           findAll() Devuelve todas las instancias de tipo. 
	 *    Iterable<T>           findAllById(Iterable<ID>ids) Devuelve todas las instncias del tipo T con los ID dados. 
	 *    Optional<T>			findById(ID id) Recupera una entidad por su id. 
	 *    <S extends T> 		save(S entity) Guarda una entidad determinada.
	 *    <S extends T> Iterable <s> SaveAll(Iterable <S> entities) Guarda todas las entidades dadas. 
	 *    
	 *    Todos estoas métoos nos proporcionan operaciones de lectura de un objeto o todos y operaciones de alta, eliminación y modificación. 
	 *    
	 *    El método sva() es el mismo para alta y modificación. La diferencia es que jpa/hibernate hace una select previa forma que: 
	 *    
	 *    	* Si la select no recupera fila, hace un insert. 
	 *    	* Si devuelve fila, hace un update y modifica. 
	 *    
	 *    Métodos de Interfaz PagingAndSortingRepository<T,ID>
	 *    ----------------------------------------------------
	 *    
	 *    
	 *    Tipo devuelto       Método y descripción
	 *    -------------		  --------------------
	 *    Page<T> 			  findAll(Pageable pageable)Devuelve una Page de las entidades que cumplen con las restricciones de paginacion proporcionada en el Pageable objeto.
	 *    Iterable<T> 		  findAll(Sort sort)Devuelve todas las entidades ordenadas por las opciones dadas
	 *   
	 *     
	 *   Métodos de JpaRepository
	 *   ------------------------
	 *   
	 *    Tipo devuelto       Método y descripción                                                                                                                                        
	 *    -------------		  -------------------- 
	 *    void 				  deleteAllByIdInBatch(Iterable<ID>ids) Elimina las entidades identificadas por los ID dados mediante una consulta. 
	 *    void 				  deleteAllInBatch()Elimina todas las entidades en una llamada por lotes. 
	 *    void 				  deleteAllInBatch(Iterable<T> entities)Elimina las entidades dadas en un lote, lo que significa que creára una única consulta. 
	 *    List<T>			  findAll()
	 *    <S extends T> List<S>  findAll(Example<S> example) 
	 *    <S extends T> List<S>  findAll(Example<S> example,Sort sort) 
	 *    List<T> 			  findAll(Sort sort)
	 *    List<T>             findAllById(Iterable<ID>ids)
	 *    void				  flush() Vacía todos los cambios pendientes en la base de datos. 
	 *    T					  getById(ID id) Devuelve una referencia a la entidad con el identificador dado. 
	 *    <S extends T> List<S>  saveAllAndFlush(Iterable<S> entities) Guarda todas las entidades y elimina los cambios al instante. 
	 *    <S extends T> S		 saveAndFlush(S entity) Guarda una entidad y elimina los cambios al instante. 
	 *    
	 *    Si nuestra interfaz hereda JpaRepository tendremos a nuestro alcance todos los métodos expuestos.
	 *    
	 *    CÓMO INTEGRAR OTROS MÉTODOS PARA CONSULTAS
	 *    ------------------------------------------
	 *    Spring nos facilita mucho la vida a la hora de introducir métodos para consultas más complejas. 
	 *    
	 *    Y nos proporciona dos formas:  
	 *    
	 *    		* Métodos con JPQL
	 *          * Métodos derivados. 
	 *          
	 *          
	 *    EL LENGUAJE DE CONSULTA JPQL
	 *    ----------------------------
	 *    Para poder realizar operaciones sobre la capa de persitencia, distinta a las operaciones básicas CRUD proporcionadas por los métodos 
	 *    de los repositorios, es necesario emplear un lenguaje de contrultas sobre la capa de persistencia, conocido como JPQL.
	 *    
	 *      
	 *     FUNDAMENTOS:
	 *     Java Persistence Query Languaje (JPQL) es una adaptacion del lenguaje SQL creada para trabajar con entidades. A través de este lenguaje podemos realizar
	 *     operaciones más complejas sobre la capa de persistencia, como recuperer conjuntos de entidades o modificar/eliminar entidades por algún criterior específico. 
	 *     
	 *     Al ser una adaptación de SQL, su sintaxis es muy parecidad a la de este lenguaje, aunque adaptada para tratar con entidades en lugar de filas y columnas.
	 *     
	 *     JPQL soporta los mismo operadores que SQL para la creación de condiciones dentro de la claúsula where. 
	 *     
	 *     
	 *     UF4.5 DIAGRAMAS DE CLASES. REPASO UML
	 *     -------------------------------------
	 *     El número de instancias de una clase se relacionan con una o varias instancias de otra clase. 
	 *     
	 *     Para indicar la multiplicidad de una relación tenemos que indicar un mínimo y un máximo. 
	 *     
	 *     Las multiplicidades que podemos representar son: 
	 *     
	 *     		1 Uno y solo uno 
	 *      	0..1 Cero o uno 
	 *      	* Cero o varios
	 *      	1..* Al menos uno
	 *      
	 *      Relación de grado Uno a Muchos unidireccional
	 *      ---------------------------------------------
	 *      
	 *      Ejemplo:
	 *      		productos 1---------------* familias 
	 *      
	 *      Migrmoas un objeto de la clase familia como atributo de instancia en la clase producto. 
	 *      (@ManyToOne: muchos productos de una familia) 
	 *      
	 *      
	 *      Relación de Grado Uno a muchos bidireccional
	 *      --------------------------------------------
	 *      
	 *      Ejemplo: 
	 *      		Productos *---------------1 familias
	 *      
	 *      Además de migrar la Familia a prodcuto, ponemos una Lista de Prodcuto en la clase Familia. 
	 *      
	 *      
	 *      Relación de Grado Muchos a Muchos unidireccional
	 *      ------------------------------------------------
	 *      
	 *      Ejemplo: 
	 *      		usuarios*----------------*perfiles 
	 *      
	 *      Esta es la solución menos costosa. Migramos la lista de perdiles como atributo de la clase usuario.  
	 *    
	 *        
	 *       Relación de Grado Muchos a Muchos unidireccional 
	 *       ------------------------------------------------  
	 *       La pregunta es :¿Tiene sentido crear una lista de todos los usuarios de un perfil? 
	 *       
	 *       
	 *                                                                                                                                      
	 */
}
