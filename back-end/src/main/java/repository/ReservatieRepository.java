package repository;

import entity.Reservatie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservatieRepository extends JpaRepository<Reservatie, Long> {
}
