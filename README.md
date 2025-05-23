# Agencia de Reservas

Este proyecto es una aplicación de gestión de reservas para una agencia de viajes. Permite gestionar hoteles, vuelos y reservas mediante una API REST desarrollada con **Spring Boot**. La base de datos utilizada es **MySQL**, y se integra con **Hibernate** para el manejo de las entidades.

## Funcionalidades

### Gestión de Hoteles
- Listar hoteles disponibles.
- Crear un nuevo hotel.
- Modificar los datos de un hotel existente.
- Eliminar un hotel.

### Gestión de Vuelos
- Listar vuelos con plazas disponibles.
- Crear un nuevo vuelo.
- Modificar los datos de un vuelo existente.
- Eliminar un vuelo.

### Gestión de Reservas
- Crear una nueva reserva asociando un hotel y un vuelo.
- Listar todas las reservas existentes.
- Modificar los datos de una reserva.
- Eliminar una reserva.

## Estructura del Proyecto

- **`Model`**: Contiene las clases que representan las entidades del sistema (`Hotel`, `Vuelo`, `Reserva`).
- **`Repository`**: Interfaces que extienden `JpaRepository` para realizar operaciones CRUD en la base de datos.
- **`Service`**: Contiene la lógica de negocio para gestionar hoteles, vuelos y reservas.
- **`Controller`**: Proporciona los endpoints REST para interactuar con el sistema.
- **`App`**: Clase principal que inicializa la aplicación y ejecuta un archivo SQL para configurar la base de datos.

## Configuración

### Base de Datos
El archivo SQL `agencia.sql` inicializa la base de datos con las tablas necesarias (`hotel`, `vuelo`, `reserva`). Asegúrate de que la base de datos MySQL esté configurada correctamente.

### Archivo `application.properties`
Configura la conexión a la base de datos en el archivo `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/agencia
spring.datasource.username=root
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```
## Endpoints
### Hoteles
- GET /hoteles: Lista los hoteles disponibles.
- POST /hoteles: Crea un nuevo hotel.
- PUT /hoteles/{id}: Modifica un hotel existente.
- DELETE /hoteles/{id}: Elimina un hotel.
### Vuelos
- GET /vuelos: Lista los vuelos con plazas disponibles.
- POST /vuelos: Crea un nuevo vuelo.
- PUT /vuelos/{id}: Modifica un vuelo existente.
- DELETE /vuelos/{id}: Elimina un vuelo.
### Reservas
- GET /reservas: Lista todas las reservas.
- POST /reservas: Crea una nueva reserva.
- PUT /reservas/{id}: Modifica una reserva existente.
- DELETE /reservas/{id}: Elimina una reserva.
### Ejecución
1. Clona el repositorio y abre el proyecto en tu IDE.
2. Asegúrate de que el archivo agencia.sql esté en la ruta src/main/java/Agencia/.
3. Configura la base de datos en application.properties.
4. Ejecuta la clase App para iniciar la aplicación.
5. Usa herramientas como Postman o cURL para interactuar con los endpoints.
### Notas
El archivo SQL crea las tablas necesarias si no existen.
Hibernate sincroniza automáticamente las entidades con la base de datos.
Asegúrate de que los IDs de hoteles y vuelos existan antes de crear una reserva.
### Tecnologías Utilizadas
Java 17
Spring Boot
Hibernate
MySQL
Maven
