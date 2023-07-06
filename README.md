# ChallengeSondeos

Pasos para iniciar el proyecto

 Ir al repositorio https://github.com/francosalvo/ChallengeSondeos/tree/master y clonarlo.
 En mi caso estoy usando STS4.
 Una vez clonado, es necesario crear un schema "libros", se debe adaptar el apication.propertis a como tengas configurado tu motor de base de datos, en mi caso utilizo MySQLWorkbrench.
Asi lo tengo configurado yo mi apication.propertis.

#:::::::: NOMBRE DEL MICROSERVICIO :::::::::
spring.application.name=libros

#:::::::: PUERTO :::::::::::::::::::::::::::
server.port=8080

#:::::::: DATASOURCE MYSQL :::::::::::::::::
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/libros?useSSL=false
spring.datasource.username=root
spring.datasource.password=41424345ea.
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

Una vez realizado esto se puede compilar sin problemas.


1- Para guardar un libro mediante metodo POST, el endpoint es libros/save , en el cual se le debe enviar un Json como el siguiente:

Ej:
{
"titulo": "El Señor de los Anillos",
"autor": "J.R.R. Tolkien",
"precio": "3500",
"fecha_lanz": "1954-01-19"
}


2- Para mostrar todos los libros que se encuentran guardados mediante el metodo GET, el endpoint es libros/all. En cambio, si se quiere solo traer un libro, de un ID determinado el endpoint es libros/byId/{id}.

3- Si se quiere actualizar un libro mediante el metodo PUT, el endpoint es libros/update/{id}, en el cual se le debe enviar un Json como voy a dar de ejemplo.
Ej:
{
"titulo": "UPDATE LIBRO",
"autor": "UPDATE LIBRO",
"precio": "3500",
"fecha_lanz": "1954-01-19"
}


4- Para eliminar un libro mediante el metodo DELETE, el endpoint es libros/delete/{id} , donde ID es el libro que se desea borrar.


