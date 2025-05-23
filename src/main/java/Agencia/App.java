package Agencia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Clase principal de la aplicación de la agencia.
 * Esta clase arranca la aplicación utilizando Spring Boot y ejecuta un archivo SQL
 * para inicializar la base de datos.
 */
@SpringBootApplication
public class App {

    /**
     * Método principal que arranca la aplicación Spring Boot.
     * También ejecuta el archivo SQL para inicializar la base de datos.
     *
     * @param args Argumentos de línea de comandos.
     */
    public static void main(String[] args) {
        SpringApplication.run(App.class, args); // Arranca la aplicación

        // Ejecutar el archivo SQL
        ejecutarSQL();
    }

    /**
     * Método para ejecutar un archivo SQL que inicializa la base de datos.
     * Lee el archivo línea por línea y ejecuta cada sentencia SQL completa.
     */
    private static void ejecutarSQL() {
        String url = "jdbc:mysql://localhost:3306/agencia"; // URL de la base de datos
        String usuario = "root"; // Usuario de la base de datos
        String contrasena = "root"; // Contraseña de la base de datos

        try (Connection conexion = DriverManager.getConnection(url, usuario, contrasena);
             Statement statement = conexion.createStatement();
             BufferedReader br = new BufferedReader(new FileReader("src/main/java/Agencia/agencia.sql"))) {

            String linea;
            StringBuilder query = new StringBuilder();

            // Leer el archivo línea por línea
            while ((linea = br.readLine()) != null) {
                query.append(linea).append("\n");
                // Ejecutar la sentencia SQL cuando termina con un punto y coma
                if (linea.trim().endsWith(";")) {
                    statement.execute(query.toString());
                    query.setLength(0); // Limpiar el StringBuilder para la siguiente sentencia
                }
            }

            System.out.println("Archivo SQL ejecutado correctamente.");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo SQL: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error al ejecutar el archivo SQL: " + e.getMessage());
        }
    }
}