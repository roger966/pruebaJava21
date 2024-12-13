# pruebaJava21

después de que todo funciona:
primero se crea el .jar
entonces lanzas el clean, después el install y se debe crear el .jar.
Después si
se crea el Dockerfile, los pasos para creación, después desde la carpeta raíz desde afuerita se crea el docker-compose para crear imagen como contenedor.

cuando ya esta todo voy a la ruta de la carpeta viendo el docker-compose y... tiro: 
docker-compose build #se crea la imagen, 
después lanzo
docker-compose up se crea contenedor y lo despliega :)




recordar esto:
para los cambios así de ultimo momento se debe lanzar esto:
#### para empaquetar todo con lo dl ultimo time: 
./mvnw clean package -DskipTests; y después de esto si
docker-compose build
# docker images
docker-compose up
### se puede usar docker secret para no exponer las variables de entorno.