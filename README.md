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
