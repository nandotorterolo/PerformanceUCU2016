# Grabación

Los que van a automatizar usando una herramienta para sistemas web desde una computadora:
Acceder a http://opencart.abstracta.us/
Buscar un producto llamado "Macbook".
Presionar "Add to cart" sobre el primer elemento que muestra el resultado de búsqueda.
Sobre el botón negro de la derecha arriba, presionar "View cart".

El Resultado de la grabado se puede ver en  [PerformanceUCU2016/src/test/scala/testing/Grabacion.scala]
 
 
# Comparar con sesión en Fiddler
 
 Graba los mismos pasos con Fiddler (o Charles) y observa las similitudes y diferencias. 
 
 ¿Qué información extra tienes en el sniffer http?
 
 _Usando charles vemos todo el trafico de ida y vuelta, el recorder de Gatling tambien actua como proxy http._
 
 ¿Por qué crees que puede ser útil contar con la sesión http grabada con esta otra herramienta?
 
 _Para obtener inforcación adicional (cookies, headers ...) que el recorder no graba._
 
 
# Prueba reproducir el script con la herramienta, pero ejecuta solo 1 usuario, sin concurrencia.
 
 ¿Qué observas? ¿Ejecutó correctamente o se observa algún problema?
 
 HINT: en algunas herramientas es necesario agregar algo para que gestione las Cookies, en otras ya está resuelto. 
 
 En algunos casos un script puede fallar porque se están usando variables de sesión o algunos otros aspectos que será necesario parametrizar, eso lo veremos más adelante. 
 
 ¿Cuál fue el tiempo de respuesta?
 
     ================================================================================
     ---- Global Information --------------------------------------------------------
     > request count                                         87 (OK=87     KO=0     )
     > min response time                                    216 (OK=216    KO=-     )
     > max response time                                   1736 (OK=1736   KO=-     )
     > mean response time                                   454 (OK=454    KO=-     )
     > std deviation                                        238 (OK=238    KO=-     )
     > response time 50th percentile                        367 (OK=367    KO=-     )
     > response time 75th percentile                        562 (OK=562    KO=-     )
     > mean requests/sec                                  2.348 (OK=2.348  KO=-     )
     ---- Response Time Distribution ------------------------------------------------
     > t < 800 ms                                            80 ( 92%)
     > 800 ms < t < 1200 ms                                   6 (  7%)
     > t > 1200 ms                                            1 (  1%)
     > failed                                                 0 (  0%)
     ================================================================================
     
     Reports generated in 0s.
     Please open the following file: /home/fernando/Projects/PerformanceUCU2016/target/gatling/grabacion-1465484784433/index.html
     [info] Simulation Grabacion successful.
     
     
# Validaciones o Assertions
 
 Es fundamental que en cada paso del script se verifique que se está obteniendo la página deseada. Se suele verificar que aparezca algo que identifique la página, como el título, algún texto, algún botón, etc. 
 
 En cada herramienta habrá que ver cómo se llaman las validaciones (en JMeter por ejemplo son  assertions). 
 
 Agregar al menos una validación por paso. 
 
 Volver a ejecutar y ver si estas validaciones están funcionando: o sea, hay que probar que valida correctamente, y que si el texto no está la validación falla (para hacer esto por ejemplo, modifiquen el script de forma tal que sepan que va a fallar, alterando la URL del pedido por ejemplo).
 
    En Gatling los assertions tienen otro significado, estos refieren a verificar estadisticas globales, numero de request que fallaron, etc.
    En este enlace se puede ver la documentación.
    Lo que esta tarea se refiere, en gatling se denominan, HTTP Checks