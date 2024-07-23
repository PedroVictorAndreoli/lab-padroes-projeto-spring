package one.digitalinnovation.gof.controller;

import one.digitalinnovation.gof.model.Fornecedor;
import one.digitalinnovation.gof.service.PessoaService;
import one.digitalinnovation.gof.service.impl.FornecedorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("fornecedores")
public class FornedorRestController {
    @Autowired
    private FornecedorServiceImpl pessoaService;

    @GetMapping
    public ResponseEntity<Iterable<Fornecedor>> buscarTodos() {
        return ResponseEntity.ok(pessoaService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pessoaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Fornecedor> inserir(@RequestBody Fornecedor fornecedor) {
        pessoaService.inserir(fornecedor);
        return ResponseEntity.ok(fornecedor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> atualizar(@PathVariable Long id, @RequestBody Fornecedor fornecedor) {
        pessoaService.atualizar(id, fornecedor);
        return ResponseEntity.ok(fornecedor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        pessoaService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
