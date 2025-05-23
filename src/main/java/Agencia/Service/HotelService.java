package Agencia.Service;

import Agencia.Model.Hotel;
import Agencia.Repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Servicio para gestionar los hoteles en el sistema de la agencia.
 * Proporciona métodos para obtener información sobre los hoteles disponibles,
 * crear nuevos hoteles, eliminar reservas y modificar datos de hoteles existentes.
 */
@Service
public class HotelService {
    private final HotelRepository hotelRepository;

    /**
     * Constructor para inyectar el repositorio de hoteles.
     *
     * @param hotelRepository Repositorio para gestionar los datos de los hoteles.
     */
    @Autowired
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    /**
     * Obtiene una lista de todos los hoteles disponibles para reservas.
     *
     * @return Lista de hoteles con disponibilidad.
     */
    public List<Hotel> getAllHotelAvaliable() {
        List<Hotel> hoteles = new ArrayList<>();
        for (Hotel hotel : hotelRepository.findAll()) {
            if (hotel.isDisponibilidad()) {
                hoteles.add(hotel);
            }
        }
        return hoteles;
    }

    /**
     * Crea un nuevo hotel en el sistema.
     *
     * @param hotel Objeto de tipo Hotel que contiene los datos del hotel a crear.
     * @return El hotel creado.
     */
    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    /**
     * Elimina una reserva asociada a un hotel.
     *
     * @param id Identificador único del hotel cuya reserva se desea eliminar.
     * @throws IllegalArgumentException Si el hotel con el ID especificado no existe.
     */
    public void eliminarReserva(int id) {
        if (!hotelRepository.existsById(id)) {
            throw new IllegalArgumentException("El hotel con ID " + id + " no existe.");
        }
        hotelRepository.deleteById(id);
    }

    /**
     * Modifica los datos de un hotel existente.
     *
     * @param id    Identificador único del hotel a modificar.
     * @param hotel Objeto de tipo Hotel con los nuevos datos del hotel.
     * @return El hotel modificado.
     * @throws IllegalArgumentException Si el hotel con el ID especificado no existe.
     */
    public Hotel modificarHotel(@PathVariable int id, @RequestBody Hotel hotel) {
        Hotel hotelExistente = hotelRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("El hotel con ID " + id + " no existe."));
        hotelExistente.setNombre(hotel.getNombre());
        hotelExistente.setCategoria(hotel.getCategoria());
        hotelExistente.setPrecio(hotel.getPrecio());
        hotelExistente.setDisponibilidad(hotel.isDisponibilidad());
        return hotelRepository.save(hotelExistente);
    }
}