package Agencia.Service;

import Agencia.Model.Hotel;
import Agencia.Model.Reserva;
import Agencia.Model.Vuelo;
import Agencia.Repository.HotelRepository;
import Agencia.Repository.ReservaRepository;
import Agencia.Repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Servicio para gestionar las reservas en la agencia.
 * Proporciona métodos para guardar reservas, obtener todas las reservas existentes,
 * eliminar reservas y modificar reservas.
 */
@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final HotelRepository hotelRepository;
    private final VueloRepository vueloRepository;

    /**
     * Constructor para inyectar las dependencias necesarias.
     *
     * @param reservaRepository Repositorio para gestionar las reservas.
     * @param hotelRepository Repositorio para gestionar los hoteles.
     * @param vueloRepository Repositorio para gestionar los vuelos.
     */
    @Autowired
    public ReservaService(ReservaRepository reservaRepository, HotelRepository hotelRepository, VueloRepository vueloRepository) {
        this.reservaRepository = reservaRepository;
        this.hotelRepository = hotelRepository;
        this.vueloRepository = vueloRepository;
    }

    /**
     * Guarda una nueva reserva en la base de datos.
     * Valida y asocia un hotel y un vuelo a la reserva antes de guardarla.
     *
     * @param reserva Objeto de tipo Reserva que se desea guardar.
     * @return La reserva guardada.
     * @throws IllegalArgumentException Si el hotel o el vuelo no existen, o si no hay plazas disponibles en el vuelo.
     */
    @Transactional
    public Reserva saveReserva(Reserva reserva) {
        // Validar y asociar el hotel
        Hotel hotel = hotelRepository.findById(reserva.getHotelAsociado().getId())
                .orElseThrow(() -> new IllegalArgumentException("El hotel con ID " + reserva.getHotelAsociado().getId() + " no existe."));
        reserva.setHotelAsociado(hotel);

        // Validar y asociar el vuelo
        Vuelo vuelo = vueloRepository.findById(reserva.getVueloAsociado().getId())
                .orElseThrow(() -> new IllegalArgumentException("El vuelo con ID " + reserva.getVueloAsociado().getId() + " no existe."));
        if (vuelo.getPlazasDisponibles() < 1) {
            throw new IllegalArgumentException("No hay plazas disponibles en el vuelo con ID " + vuelo.getId());
        }
        vuelo.setPlazasDisponibles(vuelo.getPlazasDisponibles() - 1);
        reserva.setVueloAsociado(vuelo);

        // Guardar la reserva
        return reservaRepository.save(reserva);
    }

    /**
     * Obtiene todas las reservas almacenadas en la base de datos.
     *
     * @return Lista de todas las reservas.
     */
    public List<Reserva> getAllReservas() {
        return reservaRepository.findAll();
    }

    /**
     * Elimina una reserva existente en la base de datos.
     *
     * @param id Identificador único de la reserva a eliminar.
     * @throws IllegalArgumentException Si la reserva con el ID especificado no existe.
     */
    public void eliminarReserva(int id) {
        if (!reservaRepository.existsById(id)) {
            throw new IllegalArgumentException("La reserva con ID " + id + " no existe.");
        }
        reservaRepository.deleteById(id);
    }

    /**
     * Modifica los datos de una reserva existente.
     *
     * @param id Identificador único de la reserva a modificar.
     * @param reserva Objeto de tipo Reserva con los nuevos datos de la reserva.
     * @return La reserva modificada.
     * @throws IllegalArgumentException Si la reserva con el ID especificado no existe.
     */
    public Reserva modificarReserva(@PathVariable int id, @RequestBody Reserva reserva) {
        Reserva reservaExistente = reservaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("La reserva con ID " + id + " no existe."));
        reservaExistente.setUsuario(reserva.getUsuario());
        reservaExistente.setDni(reserva.getDni());
        reservaExistente.setHotelAsociado(reserva.getHotelAsociado());
        reservaExistente.setVueloAsociado(reserva.getVueloAsociado());
        return reservaRepository.save(reservaExistente);
    }
}