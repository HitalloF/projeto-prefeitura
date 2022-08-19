package br.com.Pagamento;

import br.com.Pagamento.entity.Pagamento;
import br.com.Pagamento.services.PagamentoServices;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/pagamentos")
public class PagamentoController {


    @Autowired
    private PagamentoServices services;


    @GetMapping(value= "/{PessoaId}/meses/{meses}")
    public ResponseEntity<Pagamento> GetPagamento(@PathVariable Long PessoaId,@PathVariable Integer meses){
        Pagamento pagamento =  services.getPagamento(PessoaId, meses);
        return ResponseEntity.ok(pagamento);
    }
}
