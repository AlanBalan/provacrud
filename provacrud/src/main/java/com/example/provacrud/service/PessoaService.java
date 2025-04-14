package com.example.provacrud.service;

import com.example.provacrud.model.PessoaModel;
import com.example.provacrud.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<PessoaModel> getAll() {
        return pessoaRepository.findAll();
    }

    public Optional<PessoaModel> getById(Long id) {
        return pessoaRepository.findById(id);
    }

    public PessoaModel create(PessoaModel pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Optional<PessoaModel> update(Long id, PessoaModel pessoaDetalhe) {
        Optional<PessoaModel> pessoa = pessoaRepository.findById(id);
        if (pessoa.isPresent()) {
            PessoaModel existePessoa = pessoa.get();
            existePessoa.setNome(pessoaDetalhe.getNome());
            return Optional.of(pessoaRepository.save(existePessoa));
        }
        return Optional.empty();
    }

    public boolean delete(Long id) {
        if (pessoaRepository.existsById(id)) {
            pessoaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
