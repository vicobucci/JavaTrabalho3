package senac.trabalho.biblioteca.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import senac.trabalho.biblioteca.api.model.Lingua;
import senac.trabalho.biblioteca.api.service.LinguaService;

import java.util.List;

@RestController
@RequestMapping("/api/linguas")
public class LinguaController {

    @Autowired
    private LinguaService linguaService;

    @GetMapping
    public ResponseEntity<List<Lingua>> listarTodas() {
        List<Lingua> linguas = linguaService.listarTodas();
        return ResponseEntity.ok(linguas);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Lingua> buscarPorCodigo(@PathVariable Integer codigo){
        Lingua lingua = linguaService.buscarPorCodigo(codigo); // Pode lançar exceção personalizada se não encontrar
        return ResponseEntity.ok(lingua);
    }

    @PostMapping
    public ResponseEntity<Lingua> addLingua(@RequestBody Lingua lingua){
        Lingua addLingua = linguaService.salvar(lingua);
        return ResponseEntity.status(HttpStatus.CREATED).body(addLingua);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Lingua> editLingua(@PathVariable Integer codigo, @RequestBody Lingua lingua){
        Lingua attLingua = linguaService.atualizar(codigo, lingua); // Pode lançar exceção personalizada
        return ResponseEntity.ok(attLingua);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> deleteLingua(@PathVariable Integer codigo){
        linguaService.delete(codigo); // Pode lançar exceção personalizada se não existir
        return ResponseEntity.noContent().build();
    }
}