package senac.trabalho.biblioteca.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import senac.trabalho.biblioteca.api.exception.RecursoNaoEncontrado;
import senac.trabalho.biblioteca.api.model.Editora;
import senac.trabalho.biblioteca.api.repository.EditoraRepository;

import java.util.List;

@Service
public class EditoraService {

    @Autowired
    private EditoraRepository editoraRepository;

    public List<Editora> listarTodas() {
        return editoraRepository.findAll();
    }

    public Editora buscarPorCodigo(Integer codigo) {
        return editoraRepository.findById(codigo)
                .orElseThrow(() -> new RecursoNaoEncontrado("Editora não encontrada!"));
    }

    public Editora salvar(Editora editora) {
        return editoraRepository.save(editora);
    }

    public Editora atualizar(Integer codigo, Editora editoraDetalhes) {
        Editora editora = buscarPorCodigo(codigo); // Lança exceção se não encontrar
        editora.setNome(editoraDetalhes.getNome());
        editora.setEdicoes(editoraDetalhes.getEdicoes());
        editora.setEndereco(editoraDetalhes.getEndereco());
        editora.setTelefone(editoraDetalhes.getTelefone());
        return editoraRepository.save(editora);
    }

    public void deletar(Integer codigo) {
        Editora editora = buscarPorCodigo(codigo); // Lança exceção se não encontrar
        editoraRepository.delete(editora);
    }
}