package senac.trabalho.biblioteca.api.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import senac.trabalho.biblioteca.api.exception.RecursoNaoEncontrado;
import senac.trabalho.biblioteca.api.model.Autor;
import senac.trabalho.biblioteca.api.repository.AutorRepository;

import java.util.List;

@Service
@Transactional
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public List<Autor> listarTodos() {
        return autorRepository.findAll();
    }

    public Autor buscarPorCodigo(Long codigo) {
        return autorRepository.findById(Math.toIntExact(codigo))
                .orElseThrow(() -> new RecursoNaoEncontrado("Autor não encontrado!"));
    }

    public Autor salvar(Autor autor){
        return autorRepository.save(autor);
    }

    public Autor atualizar(Long codigo, Autor autorDetalhes) {
        Autor autor = buscarPorCodigo(codigo);
        autor.setNome(autorDetalhes.getNome());
        autor.setPais(autorDetalhes.getPais());
        autor.setSexo(autorDetalhes.getSexo());
        autor.setDataNascimento(autorDetalhes.getDataNascimento());
        autor.setNotaBiografica(autorDetalhes.getNotaBiografica());
        return autorRepository.save(autor);
    }

    public void delete(Long codigo) {
        Autor autor = buscarPorCodigo(codigo);
        autorRepository.delete(autor);
    }

}