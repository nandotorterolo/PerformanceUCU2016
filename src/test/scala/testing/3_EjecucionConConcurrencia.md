# Ejecución de baselines

La primera ejecución que debemos hacer se llama "baseline" y nos va a servir para comparar. 

La idea es ejecutar 30 iteraciones con un solo usuario concurrente (o sea, sin concurrencia). Esto se supone que es el mejor tiempo posible que podemos llegar a obtener. 

Ejecutar muchas iteraciones nos da un valor más "estadístico".

Entonces, se desea registrar la siguiente información de esta ejecución:

Tiempo de respuesta promedio del script.
Tiempo de respuesta promedio de cada uno de los pasos. 
Es importante armar una tabla y una gráfica con estos resultados para poder visualizarlos fácilmente.

Toda observación que hagan sobre los tiempos obtenidos será valorada. Sería bueno complementar esta información con los tiempos mínimos, máximos y percentil 95.


    val scn = scenario("Grabacion")
        .repeat(30) {
            ...
        }
        
    
    Simulation finished
    Parsing log file(s)...
    Parsing log file(s) done
    Generating reports...
    
    ================================================================================
    ---- Global Information --------------------------------------------------------
    > request count                                       2355 (OK=2355   KO=0     )
    > min response time                                    227 (OK=227    KO=-     )
    > max response time                                   2755 (OK=2755   KO=-     )
    > mean response time                                   390 (OK=390    KO=-     )
    > std deviation                                        213 (OK=213    KO=-     )
    > response time 50th percentile                        273 (OK=273    KO=-     )
    > response time 75th percentile                        540 (OK=540    KO=-     )
    > mean requests/sec                                  2.409 (OK=2.409  KO=-     )
    ---- Response Time Distribution ------------------------------------------------
    > t < 800 ms                                          2298 ( 98%)
    > 800 ms < t < 1200 ms                                  38 (  2%)
    > t > 1200 ms                                           19 (  1%)
    > failed                                                 0 (  0%)
    ================================================================================
    
    

# Ejecución de escenario de carga

A continuación ejecutaremos el siguiente escenario de carga:

50 usuarios virtuales
cada uno iterando 30 veces
Esto implica que se ejecutarán un total de 1500 veces el mismo caso de prueba. 

Es importante configurar un ramp-up de 5 minutos (o sea, que los usuarios no comiencen todos a la vez, sino que la cantidad de usuarios simultáneos vaya creciendo progresivamente de 0 a 50 en 5 minutos). ¿Por qué es importante esta consideración?

Mostrar análisis de tiempos de respuesta desde todas las perspectivas posibles, algunas ideas:

tiempos de respuesta a lo largo de la prueba (total y por cada uno de los pasos y por cada uno de los pedidos)
tiempos de respuesta de acuerdo a la concurrencia
tiempos de respuesta de acuerdo a los hits/segundo
¿Se obtuvieron errores en la ejecución? ¿De qué tipo? ¿Por qué?

¿Estás seguro que se utilizaron distintos datos? ¿Cómo lo verificaste?

Luego de la ejecución, ¿a qué conclusiones llegas? ¿pondrías el sistema en producción?

Cierra el informe con un párrafo que describa las pruebas y los resultados, y que exprese la confianza que ganaste (o no) en el sistema en base a los resultados obtenidos. De igual forma esto debería hacer que plantees algunas líneas de trabajo futuro, incluye las mismas en las conclusiones
