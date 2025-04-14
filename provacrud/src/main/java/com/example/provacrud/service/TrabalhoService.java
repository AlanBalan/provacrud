package com.example.provacrud.service;

import com.example.provacrud.model.TrabalhoModel;
import com.example.provacrud.repository.PessoaRepository;
import com.example.provacrud.repository.TrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrabalhoService {

    @Autowired
    private TrabalhoRepository trabalhoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<TrabalhoModel> getAll() {
        return trabalhoRepository.findAll();
    }

    public Optional<TrabalhoModel> getById(Long id) {
        return trabalhoRepository.findById(id);
    }

    public Optional<TrabalhoModel> create(TrabalhoModel trabalho) {
        if (trabalho.getPessoa() != null && pessoaRepository.existsById(trabalho.getPessoa().getId())) {
            return Optional.of(trabalhoRepository.save(trabalho));
        }
        return Optional.empty();
    }

    public Optional<TrabalhoModel> update(Long id, TrabalhoModel trabalhoDetalhe) {
        Optional<TrabalhoModel> trabalho = trabalhoRepository.findById(id);
        if (trabalho.isPresent()) {
            TrabalhoModel existeTrabalho = trabalho.get();
            existeTrabalho.setTitulo(trabalhoDetalhe.getTitulo());
            if (trabalhoDetalhe.getPessoa() != null && pessoaRepository.existsById(trabalhoDetalhe.getPessoa().getId())) {
                existeTrabalho.setPessoa(trabalhoDetalhe.getPessoa());
            }
            return Optional.of(trabalhoRepository.save(existeTrabalho));
        }
        return Optional.empty();
    }

    public boolean delete(Long id) {
        if (trabalhoRepository.existsById(id)) {
            trabalhoRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
