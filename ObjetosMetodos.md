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
