# Cookies

Verifiquen cómo hacerlo con su herramienta, y revisen que su script lo esté haciendo bien.

    El soporte esta habilitado por defecto y es transparente, al igual que como lo hace un browser.
    De la documentacion [http://gatling.io/docs/2.2.1/http/http_helpers.html?highlight=cookies]
    Cookie support is enabled by default and then Gatling handles Cookies transparently, just like a browser would.    

# Parametrización

Lo que vamos a hacer ahora es que tome el nombre del producto buscado desde una lista que se la vamos a proporcionar en un archivo de texto. Es así que en cada ejecución buscará un producto diferente. 

Para esto debemos buscar dónde está el string "Macbook" en nuestro script y tomar ese valor de una variable que se alimenta de un archivo. En cada herramienta esto puede variar bastante.


En gatling para esta funcionalidad estan los Feeders:
Hay distintos tipos, csv, json, ssv, jsonFile, jsonUrl, jdbc y rdis.
También se puede definir la estragia de búsqueda, queue, shuffle, random, circular.
En el archivo [testing.GrabacionConParameters] esta implementado tomar datos de un archivo Json y inyectarlo al scenario.
Si queremos ver el resultado, o sea que valor se esta inyectando, vas a la configuracion de logging, [lockback.xml] y lo editamos para que grabe las request que se estan hacciendo.
Este es el resultado de un request, tomando de un jsonFile, con estrategia queue (default).

    =========================
    HTTP request:
    GET http://opencart.abstracta.us:80/image/cache/catalog/demo/macbook_pro_1-228x228.jpg
    headers=
    Accept: */*
    Accept-Encoding: gzip, deflate
    Accept-Language: en-US,en;q=0.5
    User-Agent: Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:45.0) Gecko/20100101 Firefox/45.0
    Referer: http://opencart.abstracta.us/index.php?route=product/search&search=Macbook
    Cookie: PHPSESSID=54cs0u0j2t6gpmlgq27aj4hbm2; language=en; currency=USD
    Connection: keep-alive
    Host: opencart.abstracta.us:80
    =========================


# Correlación de variables

La tarea es correlacionar las variables que haga falta para que el script quede funcionando acorde.

Gatrling tiene muchas formas de extraer informacion de la response, string, regex, xpath, jsonPath entre otras
En este caso se hizo un check con una expresion regular, todos los script que tuvieran la forma de la linea de abajo, y se guardo como "idProduct"

    check(regex("""cart.add\('([0-9]*)',""").saveAs("idProduct"))

Luego se utilizara enviara en el formulario esta variable. 

    .formParam("product_id", "${idProduct}")

Nota: tener cuidado en scala el concepto de string interpolation. No poner la s. 

    println(s"${variable}"

http://gatling.io/docs/1.5.6/user_documentation/tutorial/advanced_usage.html

# Control de flujo

En todas las herramientas hay al menos estructuras de control de flujo básicas, como loops, if-then-else, etc. 

La tarea consiste en verificar si la respuesta de la búsqueda es vacía, si es así cortar el script ahí, y si no es vacía entonces continúa. En el archivo de datos entonces se deberá agregar algún producto que no exista en el catálogo de productos de OpenCart para que de esa forma dé vacío.
Supongamos que buscamos un producto, que no esta, por ejemplo "pelota"


    .check(regex("""cart.add\('([0-9]*)',""").exists.saveAs("idProduct"))

    ---- Errors --------------------------------------------------------------------
    > regex(cart.add\('([0-9]*)',).find(0).exists, found nothing          1 (50.00%)
    > No attribute named 'idProduct' is defined                           1 (50.00%)
    ================================================================================        
    

_Notas_ 

Tarea para ejectutar simples escenarios

    gatling:testOnly testing.GrabacionConParameters

**Resource inferring**, Gatling can fetch resources in parallel in order to emulate the behaviour of a real web browser.
At the protocol level, you can use inferHtmlResources methods, so Gatling will automatically parse HTML to find embedded resources and load them asynchronously.