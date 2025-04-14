package com.example.provacrud.controller;

import com.example.provacrud.model.PessoaModel;
import com.example.provacrud.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public List<PessoaModel> getAll() {
        return pessoaService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaModel> getById(@PathVariable Long id) {
        return pessoaService.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public PessoaModel create(@RequestBody PessoaModel pessoa) {
        return pessoaService.create(pessoa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaModel> update(@PathVariable Long id, @RequestBody PessoaModel pessoaDetalhe) {
        return pessoaService.update(id, pessoaDetalhe)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (pessoaService.delete(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
