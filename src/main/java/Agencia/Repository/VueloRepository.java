package Agencia.Repository;

import Agencia.Model.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para la entidad Vuelo.
 * Proporciona métodos para realizar operaciones CRUD en la base de datos.
 */
public interface VueloRepository extends JpaRepository<Vuelo, Integer> {
}