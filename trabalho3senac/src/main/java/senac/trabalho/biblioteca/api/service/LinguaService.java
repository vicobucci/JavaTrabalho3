package senac.trabalho.biblioteca.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import senac.trabalho.biblioteca.api.exception.RecursoNaoEncontrado;
import senac.trabalho.biblioteca.api.model.Lingua;
import senac.trabalho.biblioteca.api.repository.LinguaRepository;

import java.util.List;

@Service
public class LinguaService {

    @Autowired
    private LinguaRepository linguaRepository;

    public List<Lingua> listarTodas() {
        return linguaRepository.findAll();
    }

    public Lingua buscarPorCodigo(Integer codigo) {
        return linguaRepository.findById(codigo)
                .orElseThrow(() -> new RecursoNaoEncontrado("Lingua não encontrada!"));
    }

    public Lingua salvar(Lingua lingua) {
        return linguaRepository.save(lingua);
    }

    public Lingua atualizar(Integer codigo, Lingua linguaDetalhes) {
        Lingua lingua = buscarPorCodigo(codigo);
        lingua.setDescricao(linguaDetalhes.getDescricao());
        return linguaRepository.save(lingua);
    }

    public void delete(Integer codigo) {
        Lingua lingua = buscarPorCodigo(codigo);
        linguaRepository.delete(lingua);
    }
}