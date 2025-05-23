package Agencia.Controller;

import Agencia.Model.Vuelo;
import Agencia.Service.VueloService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar los vuelos.
 * Proporciona endpoints relacionados con la creación, consulta, modificación y eliminación de vuelos.
 */
@RestController
@RequestMapping("/vuelos")
public class VueloController {
    private final VueloService vueloService;

    /**
     * Constructor para inyectar el servicio de vuelos.
     *
     * @param vueloService Servicio para gestionar los vuelos.
     */
    public VueloController(VueloService vueloService) {
        this.vueloService = vueloService;
    }

    /**
     * Endpoint para obtener una lista de vuelos disponibles.
     *
     * @return Lista de vuelos con plazas disponibles.
     */
    @GetMapping
    public List<Vuelo> listarVuelos() {
        return vueloService.getAllVuelosAvaliable();
    }

    /**
     * Endpoint para crear un nuevo vuelo.
     *
     * @param vuelo Objeto de tipo Vuelo que contiene los datos del vuelo a crear.
     * @return El vuelo creado.
     */
    @PostMapping
    public Vuelo crearVuelo(@RequestBody Vuelo vuelo) {
        return vueloService.createVuelo(vuelo);
    }

    /**
     * Endpoint para eliminar una reserva asociada a un vuelo.
     *
     * @param id Identificador único del vuelo cuya reserva se desea eliminar.
     */
    @DeleteMapping("/{id}")
    public void eliminarReserva(@PathVariable int id) {
        vueloService.eliminarReserva(id);
    }

    /**
     * Endpoint para modificar los datos de un vuelo existente.
     *
     * @param id    Identificador único del vuelo a modificar.
     * @param vuelo Objeto de tipo Vuelo con los nuevos datos del vuelo.
     * @return El vuelo modificado.
     */
    @PutMapping("/{id}")
    public Vuelo actualizarVuelo(@PathVariable int id, @RequestBody Vuelo vuelo) {
        return vueloService.modificarVuelo(id, vuelo);
    }
}