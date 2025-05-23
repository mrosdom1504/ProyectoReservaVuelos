package Agencia.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Representa un vuelo en el sistema de la agencia.
 * Contiene información sobre la compañía, fecha, precio y plazas disponibles.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vuelo {

    /**
     * Identificador único del vuelo.
     */
    @Id
    private int id;

    /**
     * Nombre de la compañía aérea que opera el vuelo.
     */
    private String compania;

    /**
     * Fecha del vuelo.
     * Representa la fecha y hora en que el vuelo está programado.
     */
    private Date fecha;

    /**
     * Precio del vuelo.
     * Indica el costo del vuelo en la moneda correspondiente.
     */
    private double precio;

    /**
     * Número de plazas disponibles para el vuelo.
     * Representa la cantidad de asientos que aún no han sido reservados.
     */
    private int plazasDisponibles;
}