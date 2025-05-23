package Agencia.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa una reserva en el sistema de la agencia.
 * Contiene información sobre el usuario, su DNI, y las entidades asociadas como el vuelo y el hotel.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reserva {

    /**
     * Identificador único de la reserva.
     */
    @Id
    private int id;

    /**
     * Nombre del usuario que realiza la reserva.
     */
    private String usuario;

    /**
     * Documento Nacional de Identidad (DNI) del usuario.
     */
    private String dni;

    /**
     * Vuelo asociado a la reserva.
     * Relación de muchos a uno con la entidad Vuelo.
     * La columna en la base de datos se denomina "vuelo_asociado" y no puede ser nula.
     */
    @ManyToOne
    @JoinColumn(name = "vuelo_asociado", nullable = false)
    private Vuelo vueloAsociado;

    /**
     * Hotel asociado a la reserva.
     * Relación de muchos a uno con la entidad Hotel.
     * La columna en la base de datos se denomina "hotel_asociado" y no puede ser nula.
     */
    @ManyToOne
    @JoinColumn(name = "hotel_asociado", nullable = false)
    private Hotel hotelAsociado;
}