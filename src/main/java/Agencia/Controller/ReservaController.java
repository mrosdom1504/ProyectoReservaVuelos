package Agencia.Controller;

import Agencia.Model.Reserva;
import Agencia.Service.ReservaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar las reservas.
 * Proporciona endpoints relacionados con la creación, consulta, modificación y eliminación de reservas.
 */
@RestController
@RequestMapping("/reservas")
public class ReservaController {
    private final ReservaService reservaService;

    /**
     * Constructor para inyectar el servicio de reservas.
     *
     * @param reservaService Servicio para gestionar las reservas.
     */
    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    /**
     * Endpoint para crear una nueva reserva.
     *
     * @param reserva Objeto de tipo Reserva que contiene los datos de la reserva.
     * @return La reserva creada.
     */
    @PostMapping
    public Reserva crearReserva(@RequestBody Reserva reserva) {
        return reservaService.saveReserva(reserva);
    }

    /**
     * Endpoint para obtener una lista de todas las reservas.
     *
     * @return Lista de todas las reservas existentes.
     */
    @GetMapping
    public List<Reserva> listarReservas() {
        return reservaService.getAllReservas();
    }

    /**
     * Endpoint para eliminar una reserva existente.
     *
     * @param id Identificador único de la reserva a eliminar.
     */
    @DeleteMapping("/{id}")
    public void eliminarReserva(@PathVariable int id) {
        reservaService.eliminarReserva(id);
    }

    /**
     * Endpoint para modificar una reserva existente.
     *
     * @param id      Identificador único de la reserva a modificar.
     * @param reserva Objeto de tipo Reserva con los nuevos datos de la reserva.
     * @return La reserva modificada.
     */
    @PutMapping("/{id}")
    public Reserva modificarReserva(@PathVariable int id, @RequestBody Reserva reserva) {
        return reservaService.modificarReserva(id, reserva);
    }
}