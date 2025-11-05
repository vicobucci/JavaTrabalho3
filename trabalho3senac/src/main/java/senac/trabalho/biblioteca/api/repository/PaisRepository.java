package senac.trabalho.biblioteca.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import senac.trabalho.biblioteca.api.model.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Integer> {
}
