![portada](https://images.unsplash.com/photo-1489875347897-49f64b51c1f8?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80)
# El objeto HttpServletRequest

Un objeto **HttpServletRequest** proporciona acceso a los datos de cabecerar HTTP, también permite obtener los argumentos que el cliente envía como parte de la petición. 
La interfaz _HttpServletRequest_ porporciona los siguientes **métodos para acceder a los parámetros de la petición:**

* **String getParameter (Strin nombre)**
Este método **recupera el valor del mismo a partir de su nombre**. Si no se encuentra ningún parámetro con este nombre, devolverá null. Independientemente de que el parámetro haya sido enviado por GET o POST. 

* **Strinng[] getParameterValues(String nombre)**. Utilizamos este método para **parámetro que puedan tener varios valores**, como los enviados desde una lista de selección múltiple o un grupo de checkbox. 

* **Map<String,String> getParameterMap()** Este método devuelve una colección de [tipo Map](https://jarroba.com/map-en-java-con-ejemplos/)   con todos los parámetros. **Cada entrada incluye el nombre del parámetro y un array con los valores del mismo**. 

* **Atributos de petición**. Permiten compartir datos entre dos o más servlets, o entre servlets y JSP, que se ejecutan dentro de la misma petición. Los atributos de petición se almacenan en el objeto **HttpServletRequest** que es compartido por todos los componentes de la petición. 

            * void setAttribute (String nombre, Object data)
            * Object getAttribute (String nombre)
            
* **Atributos de sesión**. Un atributo de sesión permite compartir datos entre todos los componentes de la aplicaciónmientras dure la sesión del usuario. Los atributos de sesión se almacenan en la memoria del servidor de aplicaciones, denro del objeto **HttpSession**. Cada usuario de la aplicación tendrá su porpia copia de HttpSession. 

        * getSession()
        * setAttribute()
        *getAttribute()
        *invalidate()
        
* **Atributos de aplicación**. Nos permiten compartir datos entre los usuarios de la aplicación. Estos atributos están accesibles desde cualquier componente de la misma. Para **almacenar y recuperar atributos de aplicación** recurriremos a los métodos **setAttribute/getAtributte**. Su funcionamiento es exactamente el mismo que los ya vistos en HttpServletRequest y HttpSession.
    
        * getServletContext(), que nos devuelve una referencia al objeto ServletContex. 

# El objeto RequestDispatcher
Para transferir una petición a otro componente, necesitamos hacer uso del objeto __RequestDispacher__. 
_RequestDispacher_ es una interfaz que proporciona una serie de métodos para realizar la transferencia de una petición desde un servlet a otro componente. 

* **forward(ServletRequest request, ServletReponse response)**. Transfiere temporalmente el control al componente destino, que sería la respuesta final para el cliente. 

* **include(ServletRequest request, ServletResponse response)**. Transfiere temporalmente el control al componente destino de modo que, cuando este finalice su ejecución, el control de la petición volverá al servlet principal, el que será el encargado final de generar la respuesta.

## HttpServletResponse

* **sendRedirect**.  Cuyo formato es:

            * void sendredirect(String url)
            
Le pasaremos por parámetro la URL completa a donde queremos enviar el usuario.

### Diferencia entre transferencia y redireccionamiento
En el **redireccionamiento se vuelve a forzar una segunda petición** desde el cliente hacia el recurso de destino, mientras que en la **transferencia de petición todo tiene lugar dentro del servidor, en la misma tarea**

# Atributos de petición (request)
En JEE estos atributos se generaban con el método **setAttributte de request**. En el caso de Spring MVC se realizan usando una variable de la *clase Model*, que la usamos como parámetro de los métodos de control cuandos nos haga falta.

        @GetMapping(“/”)
        public String saludoPersonalizado(Model model){
                model.addAttribute(“mensaje”, “Soy el profe”);
                return  “saludo”;
        }

# Atributos de sesión 
La manera más simple de tratar con sesiones es introducir una variable de HttpSession en el método donde queremos mantener la sesión del usuario.

        @GetMapping(“/ruta”)
        public String iniciarSesion(Model model, Cliente cliente, HttpSession  misesion){
                if  (cdao.existeUsuario(cliente) == null)
                model.addAtributte(“mensaje”, “usuario o password incorrectos”);
                else
                    misesion.setAttribute(“cliente”, cliente);
            return “vistajsp”;
          }

Cuando se cierre la sesión usamos los mismos métodos para eliminar sesión: 
* removeAttribute() para borrar todos los atributo de la sesión. 
* invalidate() para cancelar la sesión. 


# Redireccionamiento
En lugar de Model, inyectamos por parámetro un objeto de la clase **RedirectAttributes**, que tiene el método **addFlashAttribute**.

        Ejemplo: 
        @PostMapping("/alta")
        public String porcesarAlta(RedirectAttributes attr, Producto producto){
            int codigo = pdao.insertarProdcuto(producto);
            if (codigo ==1)
                attr.addFlashAttribute("mensajeAlta", "Producto insertado");
            else
                attr.addFlashAttribute("mensajeAlta", Producto no insertado)
                
                return "redirect:/index";
        }

### Clase WebSecurityAdapter
Es una clase importante de Spring Security que te permite personalizar la configuración de seguridad de una palicación web. Al extender esta clase y sobreescribir sus métodos, puedes definir reglas de seguridad específicas para las solicitudes HTTP entrantes, configurar el objeto AuthenticationManager y establecer otros aspectos de la seguridad de la aplicación. 

            @Configutarion
            @EnableWebSecurity
            public class DatSecurity extends WebSecurityConfigureAdapter{
                 @Autowired
                 Private DataSource dataSource;
                 @Override
                 protected void configure (AuthentcationManagerBuilder auth) throws Exceptions{
                     auth.jdbcAuthentication().dataSource(dataSource);
                 }
            }
            

*  Esta clase puede estar dentro de un paquete principal, pero también podemos poner un paquete independiente para estas clases de configuración. 
*  Está anotada con **@Configuration** y **@EneableWebSecurity**. 
*  El nombre de la clase es inventado. 
*  Hereda (extends) de la clase **WebSecurityConfigureAdapter** para la configuración de seguridad en la web. 
*  La clase necesita un **dataSource**, clase necesaria para implementar una fuente de datos externa, generalmente, una base de datos.
*  Necesita un método redefinido denominado **configure** y cuya estructura de método es como la que tienes en el código. 
*  A través de la variable **auth** y el siguiente código *auth.jdbcAuthentication().dataSource(dataSource)*; le indicamos busque, de forma automática, las tablas 'USERS' y 'AUTHORITIES', en la base de datos que le hemos indicando en el fichero 'applicacitions.propierties'. 

#### Objeto Authentication
Proporciona una fomra de encapsular y manipular la información de autenticación del usuario en toda la aplicación. Esto permite la creación de reglas de seguridad personalizadas y la asignación de permisos para diferentes roles de usuario. 
Métodos destacados: 
* **getAuthorities()**: Devuelve una colección de objetos que representan los permisos otorgados del usuario. 
* **getCredentials()**: Devuelve las credenciales de autenticación del usuario, como la contraseña, etc.
* **getDetails()**:Devuelve cualquier información adicional sobre la autenticación del usuario.
* **getPrincipal()**: Devuelve el objeto principal que representa la identidad del usuario.
* **getAuthenticated()**: Devuelve 'true' si el usuario está autenticado correctamente, de los contrario devuelve false.

### Clase HttpSecurity
Permite a los desarrolladores configurar la autenticación de sus aplicaciones, así como definir reglas de acceso para la URL o métodos HTTP específicos.Permite especificar que puntos finales requieren autenticación, que métodos de autenticación se deben utilizar y que nivel de autorización se requiere para acceder a recursos específicos . 
Contiene los siguientes métodos: 
* **autorizeRequest()**: con este método se inicia la lista de recursos y URLs autorizadas.
* **antMatchers()**: especificación del recurso o URL entre comillas y separados por comas que queremos autorizar. 
* **permiteAll()**: indica que todos los recursos y URLs especificados por antMachers están permitidas sin autorización y, por tanto, no solicitan la llamada de la URL/Login que muestra en el navegador el formulario de login. 

Autenicación de perfiles:
* **antMatchers()**: especificación del recurso o URL entre comillas y separados por comas que queremos autorizar. 
* **hasAnyAuthority()**: con este método se indica la lista del perfil, o perfiles autorizados a las URLs especificadas en antMatchers.  
* **permiteAll()**: indica que todos los recursos y URLs especificados por antMachers están permitidas sin autorización y, por tanto, no solicitan la llamada de la URL/Login que muestra en el navegador el formulario de login. 

Formulario login y resto de URLs:
* **anyRequest()**: Cualquier otra petición no especificada hasta ahora. 
* **aunthenticated()**: queda autenticada y, por tanto, saldrá el formulario de login, solicitando usuario y password. 

Obtener ususario y perfil en mi proyecto:
* **getName()**: devuelve el nombre del usuario que se ha autenticado.
* **getAuthorities()**: que nos devuelve una lista de la clase **'GrantedAuthority'** para ver el perfil o perfiles de ese usuario. 

### Clase BCryptPasswordEncoder
Es una herramienta importante para asegurar que las contraseñas de los usuario se almacenen de forma segura y se puedan verificar de forma efectiva en aplicaciones de Spring Security.
