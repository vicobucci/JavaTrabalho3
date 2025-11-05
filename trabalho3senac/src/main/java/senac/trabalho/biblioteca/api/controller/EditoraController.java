package senac.trabalho.biblioteca.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import senac.trabalho.biblioteca.api.model.Editora;
import senac.trabalho.biblioteca.api.service.EditoraService;

import java.util.List;

@RestController
@RequestMapping("/api/editoras")
public class EditoraController {
    @Autowired
    private EditoraService editoraService;

    // --- READ ALL ---
    @GetMapping
    public ResponseEntity<List<Editora>> listarEditoras() {
        List<Editora> editoras = editoraService.listarTodas();
        return ResponseEntity.ok(editoras);
    }

    // --- READ ONE ---
    @GetMapping("/{codigo}")
    public ResponseEntity<Editora> buscarEditoraPorCodigo(@PathVariable Integer codigo) {
        Editora editora = editoraService.buscarPorCodigo(codigo); // Aqui pode lançar exceção personalizada se não encontrar
        return ResponseEntity.ok(editora);
    }

    // --- CREATE ---
    @PostMapping
    public ResponseEntity<Editora> addEditora(@RequestBody Editora editora) {
        Editora novaEditora = editoraService.salvar(editora);
        return new ResponseEntity<>(novaEditora, HttpStatus.CREATED);
    }

    // --- UPDATE ---
    @PutMapping("/{codigo}")
    public ResponseEntity<Editora> atualizarEditora(@PathVariable Integer codigo, @RequestBody Editora editoraDetalhes) {
        Editora editoraAtt = editoraService.atualizar(codigo, editoraDetalhes); // Aqui pode lançar exceção personalizada
        return ResponseEntity.ok(editoraAtt);
    }

    // --- DELETE ---
    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> deletarEditora(@PathVariable Integer codigo) {
        editoraService.deletar(codigo); // Aqui pode lançar exceção personalizada
        return ResponseEntity.noContent().build();
    }
}