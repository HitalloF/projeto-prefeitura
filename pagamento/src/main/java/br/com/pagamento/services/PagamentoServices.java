package br.com.Pagamento.services;

import br.com.Pagamento.entity.Pagamento;
import br.com.Pagamento.entity.Pessoa;
import br.com.pagamento.feignClients.PrefeituraFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PagamentoServices {

    @Autowired
    private PrefeituraFeignClient prefeituraFeignClient;

    public Pagamento getPagamento(long PessoaId, int meses){


        Pessoa pessoa = prefeituraFeignClient.findById(PessoaId).getBody();
        return new Pagamento(pessoa.getName(), pessoa.getSalario(), meses);
    }
}
