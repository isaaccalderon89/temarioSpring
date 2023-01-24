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
	 * 
	 * GENERACION DE PÁGINAS WEB CON CÓDIGO EMBEBIDO: JSP
	 * --------------------------------------------------
	 * La respueste de una petición a un servlet temina con la genracion de una ágina HTML. 
	 * 
	 * Aquí el servlet tiene dos estrategias:
	 *  
	 * 		1- Una primitica que consiste en generar la respuesta directamente en el método service, a través del objeto response, que nos proporciona 
	 * 			un objeto de la clase PrintWriter.
	 * 
	 * 		2- Generar un ficehero con apariencia de fichero HTML, pero incrustando algunas líneas de configuración (denominadas directivas) y código Java
	 * 			embebido (llamado Scriptless).
	 * 
	 * EL OBJETO HTTPSERVLETRESPONSE
	 * -----------------------------
	 * Una de las principales tareas que debe realizar un servlet es la generación de respuestas. Este objeto nos ofrecerá los medios para realizar esta tarea
	 * Además, dispone de una serie de métodos para la construcción y manipulación de la respuesta. 
	 * 
	 * 		1. void setContentType(String tipo)
	 * 			Con este método indicamos el tipo de respuesta que vamos a generar. Esta información se incluirá como parte de la cabecera de la respuesta HTTP 
	 *  		que se va a enviar al cliente.
	 *  
	 *  	2. PrintWriter getWriter()
	 *  		Mediante este método obtenemos el objeto PrintWriter asociado al canal de respuesta, por lo que la genración de una respuesta desde un servlet se
	 *  		convierte al final en una operación de entrada y salida normal en Java. 
	 *  		En el caso de un servlet, el objeto PrintWriter, obtenido a partir del método getWriter() de HttpeServletResponse, apunta al canal de salida que conitene
	 *  		el cuerpo de la respuesta que se enviará al cliente. 
	 *  
	 *  Actividad. Generación de página con mensaje 102_saludo_aumento
	 *  
	 *  FUNDAMENTOS DE JSP
	 *  ------------------
	 *  Una Java Server Page, o página JSP, es un archivo de texto con extensión .jsp en el que se combinan bloque de texto HTML con código Java. 
	 *  Es un componete que forma parte de una aplicación web Java EE y, al igual que los servlets, se ejecuta ante la llegada de peticiones desde el navegador cliente, 
	 *  generando como resultado una página HTML que es enviada en la respuesta HTTP. 
	 *  Las páginas JSP no son clases Java, sino archivos de texto con extensión .jsp en los que se combinan bloques de texto HTML con bloques de código Java, que se ejecuta en el
	 *  servidor cuando la página es solicitada. 
	 *  Los bloques de código Java, también conocidos como scriptlets, se definen dentro de los símbolos <% y %> y pueden aparecer en cualquier paete de la página. 
	 *  Si viéramos el código fuente recibido por el navegador, no aparecería por ningún sitio el código Java, sino que solo veríamos el HTML resultando de la combinación. 
	 *  
	 *  CREACIÓN DE UNA PÁGINA JSP
	 *  --------------------------
	 *  Una página JSP forma parte de una aplicación web Java EE. 
	 *  
	 *  	1. Las páginas JSP, al igual que los servlets, se incluyen dentro de un proyecto web dinámico. 
	 *  		hay un ejemplo de tablas de multiplicar dento de 102_saludo_aumento
	 *  
	 *  Recordad: toda página JSP es transfornada en un servlet por el servidor de aplicaciones la primera vez que es solicitada.
	 *  
	 *  la primera vez que la página JSP es solicitada por un navegador cliente se transforma n un servlet. Este servlet se compila, 
	 *  se insta y, a aprtir de ahí, el comportamiento sería el mismo que el de cualquier otro servlet.
	 *  
	 *  Las restantes peticiones que se pudieran hacer sobre la página serían derivadas por el servidor de aplicaciones directamente al servlet. 
	 *  Solo se generaría de nuevo el servlet, si el servidor detecta que se ha realizado alún cambio en el contenido de la página.
	 *  
	 *  COMPONENTES DE UNA PÁGINA JSP
	 *  -----------------------------
	 *  A la hora de construir una página JSP, podemos incluir en ella los siguientes elementos: 
	 *  
	 *  1. Boques de texto HTML
	 *  2. Código embebido
	 *  	Es el código Java que se ejecuta en el servidor cuando la págia es solicitada. Este código tiene como misión generar de forma dinámica
	 *  	parte de la página y, como hemos visto, se separa del texto HTML delimitándolo entre los símbolos <% y%>.
	 *  3. Ojetos implícitos
	 *  	Objetos creados implícitamente por el servidor de aplicaciones y que están disponibles dentro del código embebido de la página. 
	 *  	A traves de estos objetos podemos acceder a parámetros, atrubutos...
	 *  4. Directivas
	 *  	Órdenes al servidor de aplicaciones, que serán procesadas durante la fase de transformación de la página a servlet. Las directivas se definen
	 *  	entre los símbolos <%@ y %>.
	 *  5. Acciones
	 *  	Una accioón es una llamada a un método de una clase Java definido en algún archivo de librería de acciones. Su particularidad es que esta llamada
	 *  se realiza utilizando notación de etiquetas en lugar de código Java. 
	 *  
	 *  TIPOS DE ESTRUCTURAS DE CÓDIGO EMBEBIDO
	 *  ---------------------------------------
	 *  El código embebido se encarga de la generación dinánmica de parte de la página de respuesta.
	 *  
	 *  Existen dos opciones de código que podemos incluir: 
	 *  
	 *  1. Scriptles 
	 *  	Se trata de los bloques de código definidos entre los bloques <% y%>. Este código sigue exactamente las mismas reglas sintácticas que el código Java que 
	 *  	se define dentro de un método de una clase.
	 *  
	 *  2. Expresiones JSP
	 *  	Cuando queremos generar, mediante código Java, un dato que debe ser incluido dentro de la página de respuesta, utilizaremos un bloque de código embebido especial 
	 *  	conocido como expresión JSP.
	 *  
	 *  	La instrucción Java que genera este resultado no debe finalizar en ; (punto y coma). 
	 *  
	 *  https://youtu.be/w7sQaMy7364 
	 *  
	 *  2.4 CAPTURAS DE DATOS DE USUARIO
	 *  --------------------------------
	 *  Gran parte de las tareas de un servlet dependen de los parámetros enviados desde la capa cliente. Estos parámetros pueden enciarse de dos modos: 
	 *  
	 *  	* A través de un formulacio de una página web. 
	 *  	* Insertados en la URL.
	 *  
	 *  Tanto el formulario como los controles se construyen a través de una serie de etiquetas que vamos a estudiar.
	 *  
	 *  ETIQUETA FORM
	 *  Vamos a analizar dos atributos importantes que se deberán utilizar en la definición de la etiqueta <form>:
	 *  	
	 *  	1. action: Indica la dirección del componente (en nuestro caso, un servlet), que será soliciatada cuando se lance la petición desde el formulario 
	 *  	
	 *  	2. method: Establece el método HTTP utilizando en la peticicón. Las peticiones HTTP pueden utilizar varios métodos, aunque en el caso de un formulario
	 *  				nos limitaremos a los métodos GET y POST. La elección de uno y otor influirá en la manera en que los parámetros son enviados en la trama
	 *  				HTTP. En el caso de POST, los parámetros viajan en el cuerpo de la petición mientras que en GET se insertan al final de la URL.
	 *  
	 *  Los parámetros viajan en forma de parejas nombre=valor, separando cada pareja de la siguiente con un &. En el caso de las peticiones GET,estos parámetros se colocan
	 *  al final de la URL y a continuación del símbolo de interrogación.
	 *  
	 *  CONTROLES HTML
	 *  --------------
	 *  Son los componentes gráficos que se emplean para la captura de los datos de usuario y encío de los mismo al servlet. Por cada control, se enviará un parámetro al servlet
	 *  con el dato recogido. Todas las etiquetas que se emplean para la generación de estos controles disponen de un atributo name, con el que se indica el nombre del parámetro. 
	 *  
	 *  A continuación, te mostramos algunos de los controles más utilizados:: 
	 *  
	 *  1. Campo de texto
	 *  Se emplea para solicitar la introducción de un dato al usuario en una única línea. Se utiliza la equiteque <input>, indicando el valor 'text' en su atributo type. 
	 *  		
	 *  		Ej: <input type="text" name="dato"/>
	 *  2. Campo de contraseña
	 *  Son campos dondelos caracteres introducidos no se visualizan en la página. Se genera también con la etiqueta input, indicando el valor 'pasword' en el atributo type. 
	 *  
	 *  3. Caja de texto multilínea
	 *  Se emplea para que el usuario pueda introducir un texto de varias líneas. Se genera con la etiqueta <textarea></textarea>.
	 *  
	 *  4. Caja numérica
	 *  Su aspecto es el mismo que el de una caja de texto estándar, pero solo permite la introducción de números. Se genera con la etiqueta <input>, indicando en su atributo type
	 *  el valor 'number'. 
	 *  
	 *  5. Botones de radio
	 *  Se emplean para las selección de opciones excluyentes entre sí. Cada botón de radio se genera con la etiqueta <input>, indicando en su atributo tyoe el valor 'radio'. 
	 *  Para conseguie que todos los botones del grupo sean excluyentes entre sí, es necesario que todos ellos cuenten con el mismo valor del atributo 'name'. 
	 *  
	 *  6. Casillas de verificación 
	 *  Se emplean para permitir al usuario la elección de opciones en una página. las opciones no son excluyentes entre sí y se permite la selección de multiples opciones. 
	 *  Se generan con la etiqueta <input>, indicando el valor checkbox en el atributo type. 
	 *  
	 *  7. Listas de selección
	 *  Este control presenta una lista de opciones al usuario, entre las que podrá elegir una o varias. Se genera mediante la etiqueta <select></select>, y cada opción a presentar 
	 *  se indica a través de la etiqueta <option></option>. El atributo 'value' de cada <option> contiene el valor del parámetro que será enviado al servlet. 
	 *  
	 *  8. Botón de envío 
	 *  Para que se puedan enviar los parámetros recogidos es necesario crear el botón tipo submit. 
	 *  Se trata de un botón dep ulsación que, cuando se pulsa, lanza la petición de slervlet, cuya direccion se indica en el atributo 'action' del formulario. Dependiendo del valor del atributo 'method'
	 *  los parámetos con los valores de los diferentes controles se empaquetan en el cuerpo de la petición o en la URL. 
	 *  
	 *  RECOGIDA DE PARÁMETROS EN UN SERVLET
	 *  ------------------------------------
	 *  Los datos recogidos por un formulario son enviados como parámetros de la petición a un servlet, Veamos cómo el servlet puede acceder a dichos parámetros. 
	 *  
	 *  EL OBJETO HTTPSERVLETREQUEST
	 *  ----------------------------
	 *  El acceso a los parámetro recibidos en la petición se realiza en un servlet desde el interior del método service(). PAra ello, utilizaremos el objeto HttpServletRequest que el contenedor web nos proporciona
	 *  en la llamada a este método.
	 *  
	 *  La interfaz HttpServletRequest nos proporciona los siguientes métodos para acceder a los parámetros de la petición: 
	 *  	
	 *  	* String getParameter (String nombre)
	 *  
	 *  Independientemente de que el parámetro haya sido enviado por GET o POST, este método recupera el valor del mismo a partir de su nombre. 
	 *  Si no se encuentra ningún parámetro con ese nombre, devolverá null. 
	 *  Ej: string p=request.getParameter("pais"); para recoger el parametro de un pais
	 *  
	 *  El parámetro siempre es recogido como un string. 
	 *  
	 *  	*String[] getParameterValues (string nombre)
	 *  
	 *  Utilizamos este método para parámetros que puedan tener varios valores, como los enviados desde una lista de selección múltiple o un grupo de checkbox.
	 *  Ej: string[] opciones=reuest.getParameterValues("opcion"); para recoger los valores del grupo checkbox
	 *  
	 *  	*Map<String,String[]> getParameterMap()
	 *  
	 *  Este método devuelve una colección de tipo Map con todos los parámetros. Cada entrada incluye el nombre del parámetro y un array con los valores del mismo. 
	 *  Si el parámetro tiene un único valor, el array será de un solo elemento. 
	 *  
	 *  OTROS DATOS ENVIADOS EN UNA PETICIÓN
	 *  ------------------------------------
	 *  Además de lo visto anteriormente, es posible enviar parámetros al servlet sin que tengan que ser introducidos o seleccionados por un usuario meniante formulario
	 *  
	 *  PARÁMETROS EN LA URL 
	 *  --------------------
	 *  Una forma de enviar datos desde una página al servlet, sin introducirlos explícitamente por un usuario, es insertando estos datos en la URL. 
	 *  
	 *  Los datos se incluirán como parámetro en las URL:
	 *  
	 *  	* Los enlaces, es decir, en el atributo 'href'. 
	 *  	* En las de los action de los propios formularios.
	 *  
	 *  La manera en la que se recogerían estos parámetros desde el servlet sería la misma que en el caso de los parámetros enviados desde un formulario, con el método getParameter()
	 *  de HttpServletRequest:
	 *  
	 *  IMPORTANTE:el método getParameter() de request devuelve siempre String. Integer.parseInt(), Double.parseDouble().
	 *  
	 *  En el caso de las fechas, estas también viajan al servlet como String con formato 'yyyy-mm-dd' hay que aplicar alguno de los mecanismos de conversión a la clase de fecha 
	 *  
	 *  
	 *  ENCABEZADOS DE LA PETICIÓN
	 *  --------------------------
	 *  Además de los parámetros recogidos desde la página web, en cada peticicón al navegador envía al servidor una serie de datos dentro de la cabecera HTTP, datos que contienen 
	 *  infomración diversa sobre el cliente, como el tipo de navegador utilizado, el tipo de datos que acepta:
	 *  
	 *  1. String getHeader (String nombre) A partir del nombre del encabezado oobtenemos su valor. 
	 *  
	 *  2. Enumeration<String>getHeaderNames()
	 *  
	 *  TRANSFERENCIA DE PETICIONES
	 *  ---------------------------
	 *  No siempre tiene que ser el mismo servlet el que genere la respuesta para el cliente. Puede que decida transferir la petición a otro componente (ya sea un servlet, JSP o HTML) que se
	 *  encargue del procesamiento final de la petición. 
	 *  
	 *  
	 *  	* El objeto RequestDispatcher: Para transferir una petición a otro componente, necesitamos hacer uso del objeto RequestDispatcher. El proceso sería el siguiente: 
	 *  		
	 *  		1. Obtener el objeto RequestDispatcher asociado al componente destino de la petición.
	 *  		2. Llamar al método que realiza la transferencia. 
	 *  
	 *  OBTENER EL OBJETO RequestDispatcher
	 *  RequestDispatcher es una interfaz que proporciona una serie de métodos para realizar la trasnferencia de una petición desde un servlet a otro componente. 
	 *  Este método recibe como parámetro la URL relativa del servlet u otro componente al que queremos transferir la petición. 
	 *  EJ: RequestDispatcher rd= request.getRequestDispatcher ("Servlet2");
	 *  
	 *  TRANSFERIR LA PETICIÓN
	 *  ----------------------
	 * Una vez que tenemos el RequestDispatcher apuntado al servlet destino, podríamos llamar a cualquier de los siguientes métodos para realizar la transferencia de la petición: 
	 * 
	 *   	* forward(ServletRequest request, ServletResponse response)
	 *   Transfiere totalmente el control al componente destino, que sería el encargado de generar la respuesta final para el cliente. 
	 *   
	 *   	* include(Servletrequest request, ServletResponse response)
	 *   Transfiere temporalmente el control al componente destino, de modo que cuando finalice sus ejecución, el control de la petición volverá al servlet principal, el que será el encargado final de generar
	 *   la respuesta. 
	 *   
	 *   REDIRECCIONAMIENTO
	 *   ------------------
	 *   El servlet no tiene porque generar dinámicamente una página de respuesta al usuario, sino que la respuesta consistirá en informar al navegador de que tiene que visitar otra URL.
	 *   
	 *   El método sendRedirect de HttpServletResponse
	 *   Para redireccionar al usuario a otra URL utilizaremos el método sendRedirect() de HttpServletResponse:
	 *   
	 *   	void sendRedirect(String url)
	 *   
	 *   La diferencia entre transferencia yy redireccionamiento. En el redireccionamiento se vuelve a frozar una segunda peticicón desde el cleitne hacia el recurso de destino, 
	 *   mientras que en la transferencia de petición todo tiene lugar dentro del servidor, en la misma tarea. 
	 *   
	 *   https://youtu.be/DRjEg34u-mE
	 *   
	 *   UF2.5 ALMACENAMIENTO DE DATOS EN EL SERVIDOR: ATRIBUTOS Y ÁMBITOS.
	 *   
	 *   CAPTURA DE DATOS DE USUARIO
	 *   ---------------------------
	 *   PAra conseguir que los datos manejados por un servlet estén disponibles más allá de la ejecución de este servlet, la especificación Java EE pone a disposición del programadore
	 *   una serie de técnicas conocidas como TÉCNICAS PARA EL MANTENIMIENTO DE ESTADO, con la que podemos conseguir nuestros objetivos.
	 *   
	 *   Las diferentes técnicas son:
	 *   
	 *   * Atributos de petición. 
	 *   * Atributos de seción.
	 *   * Atributos de Aplicaicón.
	 *   * Cookies. 
	 *   
	 *    Cada una de estas técnicas es apropiada en un determinado contexto. Un uso inadecuado de las mismas puede acarrear problemas de rendimiento en nuestra aplicación.
	 *    
	 *    LAS TRES PRIMERAS TÉCNICAS UTILIZAN LA MEMORIA DEL SERVIDOR DE APLICACIONES, MIENTRAS QUE LAS COOKIES UTILIZAN EL DISCO DURO DEL CLIENTE.
	 *    
	 *    ATRIBUTOS DE PETICIÓN
	 *    ---------------------
	 *    Pueden compartir datos entre dos o más servlets, o entre servlets y JSP, que se ejecutan destro de una misma peticicón. 
	 *    Los atributos de petición se almacenan en el objeto HttpServletRequest, que es compartido por todos los componentes de la petición. 
	 *    
	 *     Métodos para almacenar atributos de petición 
	 *     --------------------------------------------
	 *     * void setAttibute (string nombre, object data). 
	 *     * Object getAttribute (string nombre)
	 *     
	 *     ATRIBUTOS DE SESIÓN
	 *     --------------------
	 *     Un atributo de sesión permite compartir datos entre todos los componentes de la aplicación mientras dure la sesión de usuario. 
	 *     Los atributos de sesión se almacenan en la memoria del servidor de aplicaciones, dentro del objeto HttpSession. Cada usuario de la 
	 *     aplicación tendrá su propia copia de HttpSession.
	 *     
	 *     OBTENCIÓN DE UN OBJETO HTTPSESSION
	 *     ----------------------------------
	 *     Para obtener un objeto HttpSession desde el interior del método service() se utilizará el método getSession() del objeto HttpServletRequest
	 *     
	 *     			EJ: HttpSession sesion=request.getSession();
	 *     
	 *     
	 *     Métodos para acceder a tributos de sesion
	 *     -----------------------------------------
	 *     La interfz HttpSession cuenta con los métodos setAttribute() y getAttribute() para guardar y recupeprar los atributos de sesión.
	 *     Desde el momento que el objeto HttpSession se crea, este permanece en la memoria del servidor de aplicaciones hasta que la sesioón caduca, 
	 *     a este se lde denomina Timeout.
	 *     El Timeout depende de cada servidor de aplicaciones, aunque siempe se puede configurar para una aplicación concreta. 
	 *     
	 *     QUEDA PENDIENTE HACER LOS EJEMPLEOS SOBRE LOS ATRIBUTOS DE SESSION
	 *
	 *	ATRIBUTOS DE APLICACION
	 *	-----------------------
	 *	Los atributos de aplicacion nos permiten compartir datos entre todos los usuarios de la aplicación. Están accesibles desde cualquier componente de la misma. 
	 *	El objeto donde se almacenan los atributos de aplicación es el ServletContext, que implementa la interfaz de mismo nombre. 
	 *
	 *	ejemplo: El tipico 'me gusta' que incluyen muchas aplicaciones web. 
	 *
	 *	Métodos para la manipulación de los atributos de aplicación 
	 *	-----------------------------------------------------------
	 *	Para almacenar y recuperar atributos de aplicación recurriremos a los métodos setAttribute / getAttribute. Su funcionamiento es exactamente el mismo que los ya vistos en HttpServletRequest y HttpSession
	 *
	 *	Obtención del objeto ServletContext
	 *	-----------------------------------
	 *	Una vez más, el objeto HttpServletRequest dispone de un método, en este caso getServletContext(), que nos devuelve una referencia al objeto ServletContext:
	 *
	 *	ServletContext sc = request.getServletContest();
	 *
	 *	Dado que es un objeto compartido por todos los usuarios, el ServletContext se crea cuando el primer usuario de la apliación lo solicita mediante llamada a getServletContext(). No se destruye hasta que la aplicación 
	 *	se detiene por algún motivo. 
	 * Puede se interesante que la priemra petición que haga el usao del ServletContext  realice una inicialización de los atributos. 
	 *  		
	 * 
	 * https://youtu.be/ZT3hnGqsnqY
	 * 
	 * 2.6. JSP: SUSTITUIR CÓDIGO EMBEBIDO POR ETIUQUETAS PERSONALIZADAS (JSTL/EL)
	 * ---------------------------------------------------------------------------
	 * La combinación del lenguaje de expresiones permite realizar tareas de LÓGICA DE PROGRAMACIÓN en una página JSP sin uilizar código Java.
	 * 
	 * Este lenguaje de expresiones (expression language) se emplea para definir expresiones dentro de una página JSP, es decir, operaciones que devuelven un resultado en la página de respuesta. 
	 * 
	 * El lenguaje de expresiones (EL) representa una alternativa de usao de código Java a la hora de generar resultados dento de una página JSP. 
	 * Es reconocido automáticamente por todos los servidores de aplicaciones. 
	 * 
	 * La sintaxis es : ${expresion}
	 * 
	 * También podemos utilizar objetos referenciados mediante la acción del useBean. 
	 * 
	 * Ej: ${obj.nombre}
	 * 
	 * OBJETOS EL 
	 * ----------
	 * Disponemos de una serie de objetos implícitos con los que acceder a toda la infomración de contexto de aplicación. 
	 * 
	 * La sintaxis de uso de estos objetos sería: ${objeto.propiedad}, que devolvería a la página el valor conetnido en la propiedad indicada del objeto. 
	 * En ningún caso podemos utilizar un objeto EL para modificar ninguno de los datos alamcenados en los objetos. 
	 * 
	 * Juegos de objetos EL
	 * --------------------
	 * 
	 * 1. El objeto param. Mediante este objeto accedemos a la parámetros creados en la propia página. Por ejemplo, si quisiéramos imprimir en la página 
	 * el valor del parámetro 'usuario' recibido en la request, sería:  ${param.usuario}
	 * 
	 *  **En el  caso de no existir ese parametro, la expresion EL no devuelve null, sino una cadena vacía. 
	 *  
	 * 2. El objeto requestScope. Proporciona acceso a los atributos de petición expuestos a tráves de propiedades del objeto en tiempo de ejecución. Por ejemplo, si queremos mostrar
	 * el valor de un atributo de petición llamado 'codigo', escribiremos:  ${requestScope.codigo}
	 * 
	 * Esta expresión realizar implícitamente una llamada al método getTitulo() del objeto JavaBean. 
	 * En el caso de las colecciones del tipo 'Map' , tamvién podemos acceder a los valores de los objetos almacenados utilizando el nombre de clase en luegar de la posición. 
	 * 
	 * 3. Los objetos sessionScope y applicationScope. Estos objetos permiten acceder a los atributos de sesción y aplicación respectivamente y, al igual que requestScope, exponen 
	 * en tiempo de ejecución los valores de los atributos a tráves de las propiedades del objeto. Además, la manera de utilizar los tres objetos es la misma. 
	 * 
	 * 4. El objeto header. Es el que proporciona acceso a los encabezados recibidos en la petición. Al igual que param, expone una serie de propiedades cuyos nombres
	 * son los nombres de los encabezados recibidos. Por ejemplo, para mostrar el valor del encabezado user-agent utilizaremos la expresión: 
	 * EJ  ${header.user-agent}
	 * 
	 * OPERADORES EL
	 * -------------
	 * Las expresiones EL pueden incluir operaciones con datos haciendo uso de los operadores EL. 
	 * 
	 * Estos operadores son un subconjunto del juego de operadores del lenguaje Java. 
	 * 
	 * 1. Operadores aritméticos
	 * 
	 *  Son +,-,*,/ y %
	 *  
	 *  EJEMPLO: 
	 *  			${param.numero*sessionScope.facto}
	 *  
	 *  No tenemos que realizar ningún tipo de conversión a número para poder realizar operaciones artiméticas con los datos El, ya que este lenguaje se encarga de realizar estas 
	 *  conversiones implícitamente. 
	 *  
	 *  2. Operadores relacionales
	 *  Se pueden emplear abreviaturas o combinaciones de letras. 
	 *  
	 *  son >(gt),<(lt),>=(ge),<=(le),!=(ne)
	 *  
	 *  Por ejemplo, la siguiente expresión nos mosotrará true si la porpiedad 'edad' del atributo de sesión persona es mayor o igual a 18:
	 *  		${sessionScope.persona.edad ge 18}
	 *  
	 *  Si el atributo no existe, no se producirá ninguna excepción y se devolverá directamente false. 
	 *  
	 *  3. Lógicos 
	 *  Realizan operaciones de tipo lógico en una expresión . 
	 *  
	 *  son &&(and), ||(or), !(not)
	 *  
	 *  4. Operador condicional. 
	 *  Es equivalente al operador ternario de Java. 
	 *  En el siguiente ejemplo, semuestra 'conseguido', si el valor del parámetro 'nota' es superior a 5, y 'no conseguido' en el caso contrario: 
	 *  
	 *  		${param.nota>5?"conseguido":"no conseguido"}
	 *  
	 *  5. Operador vacío
	 *  Se trata del operador 'empty' y es de gran utilidad en muchas aplicaciones. DEvuelve true, si el dato sobre el que se aplica es nulo. 
	 *  en el caso de ytratarse de un dato de tipo colección o array, devolverá true si la colección/array existe pero tiene tamaño 0.
	 *  
	 *  
	 *  UTILIZACIÓN DE TAGLLIB: ETIQUETAS PERSONALIZADAS
	 *  ------------------------------------------------
	 *  Una acción es una tarea lógica que puede realizarse dentro de una página JSP, sin emplear código Java para ello, simplemente 
	 *  utilizando etiquetas XML. 
	 *  Una acción es una llaamda a un método definido dentro de una clase Java. 
	 *  
	 *  la sintáxis es la siguiente. 
	 *  <prefijo: nombre_accion atributo1="valor" atributo2="valor"/>
	 *  
	 *  LA LIBRERÍA DE ACCIONES DE JSTL
	 *  -------------------------------
	 *  
	 *  JSTL es la libreía de acciones estándares de JSP. 
	 *  
	 *  JSTL son las siglas de Java Standar Tag Library (librería de acciones estándares de Java). 
	 *  
	 *  Grupos de acciones JSTL
	 *  -----------------------
	 *  JSTL proporciona muchas acciones para realizar diferentes tipos de tareas en una página JSP. 
	 *  Estas acciones se ecnuentran clasificadas en los siguientes grupos: 
	 *  	
	 *  	* Core: Se trata del grupo mas importante, ya que en él se encuentran todas aquellas que realizan las tareas de lógica de programación habituales. 
	 *  
	 *  	* Formato: contiene acciones para el formateo de datos en una página, como números, texto y fechas. Este grupo se emplea mucho para la internacionalización 
	 *  				de sitiios web.
	 *  
	 *  	* SQL: Incluye acciones para enviar instrucciones SQL a una base de datos. Este tipo de tareas no se realizan habitualmente en una página JSP, por lo que
	 *  				no son muy utilizadas.
	 *  
	 *   	* XML: Con este grupo de acciones podemos manipular documentos XL es una página JSP. 
	 *   
	 *   	* Function: Incluye un gran número de funciones para la realización de operaciones con cadenas de caracteres. 
	 *   
	 *   
	 *   ESTUDIO DE LAS PRINCIPALES ACCIONES JSTL
	 *   ----------------------------------------
	 *   
	 *   Acción set: creación de variables
	 *   
	 *   la acción ser se emplea para crear variables y asignarles un determinado valor. El valor de esta varibale puede utilizarse después en otra parte de la página,
	 *   dentro de una expresion EL. La acción set, además, dispone de los siguiente atributos: 
	 *   
	 *    	* var: Identidicados de la variable que se quiere crear. 
	 *    	* value: Valor asignado de la variable. 
	 *    
	 *    				<c:set var="num" value="5"/> creación de la varibale 5
	 *   
	 *  
	 *  
	 *  
	 */

}
