package br.com.prefeitura.service;

import br.com.prefeitura.entity.Pessoa;
import br.com.prefeitura.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;


    public List<Pessoa> listPessoas(){
        return this.pessoaRepository.findAll();
    }

    public Pessoa savePessoa(Pessoa pessoa){
        return this.pessoaRepository.save(pessoa);
    }

    public ResponseEntity<Pessoa> getById(Long id){
        Optional<Pessoa> Pessoa = this.pessoaRepository.findById(id);
        if(Pessoa.isPresent()) {
            return new ResponseEntity<Pessoa>(Pessoa.get(), HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    public ResponseEntity<Pessoa> deleteById(Long id){
        Optional<Pessoa> pessoa = this.pessoaRepository.findById(id);
        if(pessoa.isPresent()){
            this.pessoaRepository.delete(pessoa.get());
            return new ResponseEntity<Pessoa>(HttpStatus.OK);
            }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    public ResponseEntity<Pessoa> changePessoa(Pessoa newPessoa, Long id){
        Optional<Pessoa> oldPessoa = this.pessoaRepository.findById(id);
        if(oldPessoa.isPresent()){

            Pessoa pessoa = oldPessoa.get();
            pessoa.setName(newPessoa.getName());
            pessoa.setCargo(newPessoa.getCargo());
            pessoa.setSalario(newPessoa.getSalario());
            this.pessoaRepository.save(pessoa);
            return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    }




