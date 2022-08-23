package br.com.Pagamento;

import br.com.Pagamento.entity.Pagamento;
import br.com.Pagamento.services.PagamentoServices;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/pagamentos")
public class PagamentoController {


    private static Logger logger = LoggerFactory.getLogger(PagamentoController.class);

    @Autowired
    private Environment env;

    @Autowired
    private PagamentoServices services;


    @HystrixCommand(fallbackMethod = "GetPagamentoAlternative")
    @GetMapping(value= "/{PessoaId}/meses/{meses}")
    public ResponseEntity<Pagamento> GetPagamento(@PathVariable Long PessoaId,@PathVariable Integer meses){

        logger.info("PORT = " + env.getProperty("localhost.server.port"));

        Pagamento pagamento =  services.getPagamento(PessoaId, meses);
        return ResponseEntity.ok(pagamento);
    }

    public ResponseEntity<Pagamento> GetPagamentoAlternative(Long PessoaId, Integer meses){
        Pagamento pagamento =  new Pagamento("Brann",1100.00,meses);
        return ResponseEntity.ok(pagamento);
    }
}
