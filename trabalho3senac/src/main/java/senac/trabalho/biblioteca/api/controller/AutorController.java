package senac.trabalho.biblioteca.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import senac.trabalho.biblioteca.api.model.Autor;
import senac.trabalho.biblioteca.api.service.AutorService;

import java.util.List;

@RestController
@RequestMapping("/api/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;


    @GetMapping
    public ResponseEntity<List<Autor>> listarAutores() {
        List<Autor> autores = autorService.listarTodos();
        return ResponseEntity.ok(autores);
    }


    @GetMapping("/{codigo}")
    public ResponseEntity<Autor> buscarAutorPorCodigo(@PathVariable Integer codigo) {
        Autor autor = autorService.buscarPorCodigo(Long.valueOf(codigo));
        return ResponseEntity.ok(autor);
    }


    @PostMapping
    public ResponseEntity<Autor> addAutor(@RequestBody Autor autor) {
        Autor novoAutor = autorService.salvar(autor);
        return new ResponseEntity<>(novoAutor, HttpStatus.CREATED);
    }


    @PutMapping("/{codigo}")
    public ResponseEntity<Autor> atualizarAutor(@PathVariable Integer codigo, @RequestBody Autor autorDetalhes) {
        Autor autorAtt = autorService.atualizar(Long.valueOf(codigo), autorDetalhes);
        return ResponseEntity.ok(autorAtt);
    }


    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> deletarAutor(@PathVariable Integer codigo) {
        autorService.delete(Long.valueOf(codigo));
        return ResponseEntity.noContent().build();
    }
}