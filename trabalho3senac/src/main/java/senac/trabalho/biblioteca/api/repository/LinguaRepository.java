package senac.trabalho.biblioteca.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import senac.trabalho.biblioteca.api.model.Lingua;
import org.springframework.stereotype.Repository;

@Repository
public interface LinguaRepository extends JpaRepository<Lingua, Integer> {
}
