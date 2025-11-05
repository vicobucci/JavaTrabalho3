package senac.trabalho.biblioteca.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import senac.trabalho.biblioteca.api.exception.RecursoNaoEncontrado;
import senac.trabalho.biblioteca.api.model.Autor;
import senac.trabalho.biblioteca.api.repository.AutorRepository;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public List<Autor> listarTodos() {
        return autorRepository.findAll();
    }

    public Autor buscarPorCodigo(Integer codigo) {
        return autorRepository.findById(codigo)
                .orElseThrow(() -> new RecursoNaoEncontrado("Autor não encontrado!"));
    }

    public Autor salvar(Autor autor){
        return autorRepository.save(autor);
    }

    public Autor atualizar(Integer codigo, Autor autorDetalhes) {
        Autor autor = buscarPorCodigo(codigo);
        autor.setNome(autorDetalhes.getNome());
        autor.setPais(autorDetalhes.getPais());
        autor.setSexo(autorDetalhes.getSexo());
        autor.setDataNascimento(autorDetalhes.getDataNascimento());
        autor.setNotaBiografica(autorDetalhes.getNotaBiografica());
        return autorRepository.save(autor);
    }

    public void delete(Integer codigo) {
        Autor autor = buscarPorCodigo(codigo);
        autorRepository.delete(autor);
    }
}