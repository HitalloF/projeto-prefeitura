package br.com.pagamento.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name= "prefeitura",url = "localhost:8001", path = "/pessoa")
public interface PrefeituraFeignClient {
    @GetMapping(value = "{id}")
    ResponseEntity<br.com.Pagamento.entity.Pessoa> findById(@PathVariable("id") Long id);

}
