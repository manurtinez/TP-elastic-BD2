## En este readme se especifica el proceso de desarrollo que fuimos llevando para construir la app y las dificultades encontradas.

El primer paso de todos fue descargar una aplicacion starter de la pagina initialize de spring boot, a forma de tener un punto de partida, con las dependencias ya agregadas (solo necesitamos la de spring data y elasticsearch). Procedimos a levantar el proyecto para ver que minimamente corriera.

Acto seguido, habia que crear los containers necesarios en Docker (o en su defecto, instalar elastic search localmente) para que la aplicacion pudiera luego conectarse. Para esto, creamos un docker compose que unicamente contiene un nodo de elastic y uno de kibana, de forma de tener una interfaz con la cual hacer pruebas.

Esta etapa fue muy de aprendizaje sobre elastic, sus filosofias, su forma de modelar los datos y mas importante, su forma de indizarlos y obtenerlos. Esto se hace mediante requests HTTP convencionales, con body JSON que define que tipo de query se quiere hacer.

Una vez levantado el ambiente de elastic en docker, la app es muy facil de configurar mediante un archivo `application.properties` para que sepa a que URL y puerto conectarse, entre otras cosas. En este punto, teniamos una conexion exitosa entre la base de datos y la aplicacion (sin ningun codigo escrito aun).

Luego, probamos escribir un par de entidades muy simples, con sus respectivos controllers / services / repositories para probar hacer un CRUD de las mismas, y ver las diferencias entre elastic y las DB relacionales que veniamos manejando.

Durante la 'migracion' de modelos a nuestro nuevo esquema, una de las dificultades con la que nos encontramos fué relacionado a la manipulación de datos tipo Date; Sobre la cual es necesario especificar un formato particular, cuestión que nos costó descifrar dado que si la BBDD queda con datos 'basura' de algun run, al querer configurar lo mencionado, saltan errores de tipos y resultan ser los datos que mencionamos ya se encontraban almacenados, aunque se detectaban al probar los controllers únicamente y esto hacía mas difícil hallar el error.

Otra de las dificultades fué la representación de las relaciones entre modelos. En el proyecto original las relaciones se declaraban mas bien bidireccionalmente, pero en este caso, para ElasticSearch los declararemos desde un único lado (caso contrario podría generar un bucle infinito, terminando en error). 
Respecto a lo mencionado, en el proyecto anterior, además representabamos estas relaciones normalmente con HashSets, mientras que ahora debemos declararles como ArrayLists.
