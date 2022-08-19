package br.com.Pagamento.services;

import br.com.Pagamento.entity.Pagamento;
import br.com.Pagamento.entity.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PagamentoServices {

    @Value("${prefeitura.host}")
    private String prefeituraHost;

    @Autowired
    private RestTemplate restTemplate;

    public Pagamento getPagamento(long PessoaId, int meses){
        Map<String, String> uriVariables =  new HashMap<>();
        uriVariables.put("id",""+PessoaId );


        Pessoa pessoa= restTemplate.getForObject(prefeituraHost+"/pessoa/{id}", Pessoa.class, uriVariables);
        return new Pagamento(pessoa.getName(), pessoa.getSalario(), meses);
    }
}
