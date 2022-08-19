package br.com.Pagamento.services;

import br.com.Pagamento.entity.Pagamento;
import org.springframework.stereotype.Service;

@Service
public class PagamentoServices {


    public Pagamento getPagamento(long PessoaId, int meses){
        return new Pagamento("Hitallo", 800.0, meses);
    }
}
