package senac.trabalho.biblioteca.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import senac.trabalho.biblioteca.api.exception.RecursoNaoEncontrado;
import senac.trabalho.biblioteca.api.model.Pais;
import senac.trabalho.biblioteca.api.repository.PaisRepository;

import java.util.List;

@Service
public class PaisService {

    @Autowired
    private PaisRepository paisRepository;

    public List<Pais> listarTodos() {
        return paisRepository.findAll();
    }

    public Pais buscarPorCodigo(Integer codigo) {
        return paisRepository.findById(codigo)
                .orElseThrow(() -> new RecursoNaoEncontrado("Pais não encontrado!"));
    }

    public Pais salvar(Pais pais) {
        return paisRepository.save(pais);
    }

    public Pais atualizar(Integer codigo, Pais paisDetalhes) {
        Pais pais = buscarPorCodigo(codigo);
        pais.setDescricao(paisDetalhes.getDescricao());
        return paisRepository.save(pais);
    }

    public void deletar(Integer codigo) {
        Pais pais = buscarPorCodigo(codigo);
        paisRepository.delete(pais);
    }
}