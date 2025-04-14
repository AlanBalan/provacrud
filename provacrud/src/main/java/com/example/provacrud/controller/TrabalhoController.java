package com.example.provacrud.controller;

import com.example.provacrud.model.TrabalhoModel;
import com.example.provacrud.service.TrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trabalhos")
public class TrabalhoController {

    @Autowired
    private TrabalhoService trabalhoService;

    @GetMapping
    public List<TrabalhoModel> getAll() {
        return trabalhoService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrabalhoModel> getById(@PathVariable Long id) {
        return trabalhoService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TrabalhoModel> create(@RequestBody TrabalhoModel trabalho) {
        return trabalhoService.create(trabalho)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrabalhoModel> update(@PathVariable Long id, @RequestBody TrabalhoModel trabalhoDetalhe) {
        return trabalhoService.update(id, trabalhoDetalhe)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (trabalhoService.delete(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}