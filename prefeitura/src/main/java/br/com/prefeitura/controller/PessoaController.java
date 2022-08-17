package br.com.prefeitura.controller;

import br.com.prefeitura.entity.Pessoa;
import br.com.prefeitura.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;


    @GetMapping
    public List<Pessoa> listPessoas(){
        return this.pessoaService.listPessoas();
    }
    @PostMapping(value = "/save")
    public Pessoa savePessoa(@RequestBody Pessoa pessoa){
        System.out.printf("salvou");
        return this.pessoaService.savePessoa(pessoa);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Pessoa> getById(@PathVariable("id") Long id){
        return this.pessoaService.getById(id);
    }

    @DeleteMapping(value ="{id}")
    public ResponseEntity<Pessoa> deleteById(@PathVariable("id") Long id){
        return this.pessoaService.deleteById(id);
    }

    @PutMapping(value = "/change/{id}")
    public ResponseEntity<Pessoa> changePessoa(@PathVariable("id") Long id,@RequestBody Pessoa pessoa){
        return this.pessoaService.changePessoa(pessoa, id);
    }

}
