package Agencia.Service;

import Agencia.Model.Vuelo;
import Agencia.Repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Servicio para gestionar los vuelos en el sistema de la agencia.
 * Proporciona métodos para obtener información sobre los vuelos disponibles,
 * crear nuevos vuelos, eliminar vuelos y modificar datos de vuelos existentes.
 */
@Service
public class VueloService {
    private final VueloRepository vueloRepository;

    /**
     * Constructor para inyectar el repositorio de vuelos.
     *
     * @param vueloRepository Repositorio para gestionar los datos de los vuelos.
     */
    @Autowired
    public VueloService(VueloRepository vueloRepository) {
        this.vueloRepository = vueloRepository;
    }

    /**
     * Obtiene una lista de todos los vuelos disponibles.
     * Un vuelo se considera disponible si tiene al menos una plaza libre.
     *
     * @return Lista de vuelos con plazas disponibles.
     */
    public List<Vuelo> getAllVuelosAvaliable() {
        List<Vuelo> vuelos = new ArrayList<>();
        for (Vuelo vuelo : vueloRepository.findAll()) {
            if (vuelo.getPlazasDisponibles() >= 1) {
                vuelos.add(vuelo);
            }
        }
        return vuelos;
    }

    /**
     * Crea un nuevo vuelo en el sistema.
     *
     * @param vuelo Objeto de tipo Vuelo que contiene los datos del vuelo a crear.
     * @return El vuelo creado.
     */
    public Vuelo createVuelo(Vuelo vuelo) {
        return vueloRepository.save(vuelo);
    }

    /**
     * Elimina un vuelo existente en el sistema.
     *
     * @param id Identificador único del vuelo a eliminar.
     * @throws IllegalArgumentException Si el vuelo con el ID especificado no existe.
     */
    public void eliminarReserva(int id) {
        if (!vueloRepository.existsById(id)) {
            throw new IllegalArgumentException("El vuelo con ID " + id + " no existe.");
        }
        vueloRepository.deleteById(id);
    }

    /**
     * Modifica los datos de un vuelo existente.
     *
     * @param id    Identificador único del vuelo a modificar.
     * @param vuelo Objeto de tipo Vuelo con los nuevos datos del vuelo.
     * @return El vuelo modificado.
     * @throws IllegalArgumentException Si el vuelo con el ID especificado no existe.
     */
    public Vuelo modificarVuelo(int id, Vuelo vuelo) {
        Vuelo vueloExistente = vueloRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("El vuelo con ID " + id + " no existe."));
        vueloExistente.setCompania(vuelo.getCompania());
        vueloExistente.setFecha(vuelo.getFecha());
        vueloExistente.setPrecio(vuelo.getPrecio());
        vueloExistente.setPlazasDisponibles(vuelo.getPlazasDisponibles());
        return vueloRepository.save(vueloExistente);
    }
}