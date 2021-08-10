## En este readme se especifica el proceso de desarrollo que fuimos llevando para construir la app.

El primer paso de todos fue descargar una aplicacion starter de la pagina initialize de spring boot, a forma de tener un punto de partida, con las dependencias ya agregadas (solo necesitamos la de spring data y elasticsearch). Procedimos a levantar el proyecto para ver que minimamente corriera.

Acto seguido, habia que crear los containers necesarios en Docker (o en su defecto, instalar elastic search localmente) para que la aplicacion pudiera luego conectarse. Para esto, creamos un docker compose que unicamente contiene un nodo de elastic y uno de kibana, de forma de tener una interfaz con la cual hacer pruebas.

Esta etapa fue muy de aprendizaje sobre elastic, sus filosofias, su forma de modelar los datos y mas importante, su forma de indizarlos y obtenerlos. Esto se hace mediante requests HTTP convencionales, con body JSON que define que tipo de query se quiere hacer.

Una vez levantado el ambiente de elastic en docker, la app es muy facil de configurar mediante un archivo `application.properties` para que sepa a que URL y puerto conectarse, entre otras cosas. En este punto, teniamos una conexion exitosa entre la base de datos y la aplicacion (sin ningun codigo escrito aun).

Luego, probamos escribir un par de entidades muy simples, con sus respectivos controllers / services / repositories para probar hacer un CRUD de las mismas, y ver las diferencias entre elastic y las DB relacionales que veniamos manejando.
