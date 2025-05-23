package Agencia.Controller;

import Agencia.Model.Hotel;
import Agencia.Service.HotelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar los hoteles.
 * Proporciona endpoints relacionados con los hoteles disponibles.
 */
@RestController
@RequestMapping("/hoteles")
public class HotelController {
    private final HotelService hotelService;

    /**
     * Constructor para inyectar el servicio de hoteles.
     *
     * @param hotelService Servicio para gestionar los hoteles.
     */
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    /**
     * Endpoint para obtener una lista de hoteles disponibles.
     *
     * @return Lista de hoteles con disponibilidad.
     */
    @GetMapping
    public List<Hotel> listarHotels() {
        return hotelService.getAllHotelAvaliable();
    }

    /**
     * Endpoint para crear un nuevo hotel.
     *
     * @param hotel Objeto `Hotel` que contiene los datos del hotel a crear.
     * @return El hotel creado.
     */
    @PostMapping
    public Hotel crearHotel(@RequestBody Hotel hotel) {
        return hotelService.createHotel(hotel);
    }

    /**
     * Endpoint para eliminar una reserva asociada a un hotel.
     *
     * @param id Identificador único del hotel cuya reserva se desea eliminar.
     */
    @DeleteMapping("/{id}")
    public void eliminarReserva(@PathVariable int id) {
        hotelService.eliminarReserva(id);
    }

    /**
     * Endpoint para modificar los datos de un hotel existente.
     *
     * @param id    Identificador único del hotel a modificar.
     * @param hotel Objeto `Hotel` con los nuevos datos del hotel.
     * @return El hotel modificado.
     */
    @PutMapping("/{id}")
    public Hotel modificarHotel(@PathVariable int id, @RequestBody Hotel hotel) {
        return hotelService.modificarHotel(id, hotel);
    }
}