package senac.trabalho.biblioteca.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import senac.trabalho.biblioteca.api.model.Pais;
import senac.trabalho.biblioteca.api.service.PaisService;

import java.util.List;

@RestController
@RequestMapping("/api/paises")
public class PaisesController {

    @Autowired
    private PaisService paisService;

    // --- READ ALL ---
    @GetMapping
    public ResponseEntity<List<Pais>> listarPaises() {
        List<Pais> paises = paisService.listarTodos();
        return ResponseEntity.ok(paises);
    }

    // --- READ ONE ---
    @GetMapping("/{codigo}")
    public ResponseEntity<Pais> buscarPaisPorId(@PathVariable Integer codigo) {
        Pais pais = paisService.buscarPorCodigo(codigo);
        return ResponseEntity.ok(pais);
    }

    // --- CREATE ---
    @PostMapping
    public ResponseEntity<Pais> addPais(@RequestBody Pais pais) {
        Pais novoPais = paisService.salvar(pais);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPais);
    }

    // --- UPDATE ---
    @PutMapping("/{codigo}")
    public ResponseEntity<Pais> atualizarPais(@PathVariable Integer codigo, @RequestBody Pais paisDetalhes) {
        Pais paisAtualizado = paisService.atualizar(codigo, paisDetalhes);
        return ResponseEntity.ok(paisAtualizado);
    }

    // --- DELETE ---
    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> deletarPais(@PathVariable Integer codigo) {
        paisService.deletar(codigo);
        return ResponseEntity.noContent().build();
    }
}