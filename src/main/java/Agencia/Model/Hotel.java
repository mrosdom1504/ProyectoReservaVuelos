package Agencia.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa un hotel en el sistema de la agencia.
 * Contiene información sobre el hotel, como su ID, nombre, categoría, precio y disponibilidad.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {

    /**
     * Identificador único del hotel.
     */
    @Id
    private int id;

    /**
     * Nombre del hotel.
     */
    private String nombre;

    /**
     * Categoría del hotel (por ejemplo, estrellas o clasificación).
     */
    private String categoria;

    /**
     * Precio por noche del hotel.
     */
    private double precio;

    /**
     * Indica si el hotel está disponible para reservas.
     * `true` si está disponible, `false` en caso contrario.
     */
    private boolean disponibilidad;
}