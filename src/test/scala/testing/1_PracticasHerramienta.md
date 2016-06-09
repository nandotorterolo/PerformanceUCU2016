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
 
 
# Validaciones o Assertions
 
 Es fundamental que en cada paso del script se verifique que se está obteniendo la página deseada. Se suele verificar que aparezca algo que identifique la página, como el título, algún texto, algún botón, etc. 
 
 En cada herramienta habrá que ver cómo se llaman las validaciones (en JMeter por ejemplo son  assertions). 
 
 Agregar al menos una validación por paso. 
 
 Volver a ejecutar y ver si estas validaciones están funcionando: o sea, hay que probar que valida correctamente, y que si el texto no está la validación falla (para hacer esto por ejemplo, modifiquen el script de forma tal que sepan que va a fallar, alterando la URL del pedido por ejemplo).
 
