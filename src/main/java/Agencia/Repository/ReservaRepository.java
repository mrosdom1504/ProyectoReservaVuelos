package Agencia.Repository;

import Agencia.Model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para la entidad Reserva.
 * Proporciona métodos para realizar operaciones CRUD en la base de datos.
 */
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
}