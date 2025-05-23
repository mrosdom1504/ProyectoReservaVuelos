package Agencia.Repository;

import Agencia.Model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para la entidad Hotel.
 * Proporciona métodos para realizar operaciones CRUD en la base de datos.
 */
public interface HotelRepository extends JpaRepository<Hotel, Integer> {
}