package com.simple.resources;

import com.simple.dto.ResponseDTO;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by jonathan on 1/15/17.
 */

@RestController
@RequestMapping("/v1")
@Scope("request")
public class Routes {


    //exemplo com POST
    @RequestMapping(value = "/informacao", method = RequestMethod.POST)
    public ResponseDTO alfa() {

        ResponseDTO objetoDeResposta = new ResponseDTO();
        objetoDeResposta.setId("1");
        objetoDeResposta.setName("alfa-post");


        return objetoDeResposta;

    }

    //exemplo com GET
    @RequestMapping(value = "/informacao", method = RequestMethod.GET)
    public ResponseDTO beta() {

        ResponseDTO objetoDeResposta = new ResponseDTO();
        objetoDeResposta.setId("2");
        objetoDeResposta.setName("beta-get");

        return objetoDeResposta;
    }


    //exemplo recuperando valor
    @RequestMapping(value = "/informacao/{id:.+}/{name:.+}", method = RequestMethod.GET)
    public ResponseDTO omega(@PathVariable String id,
                             @PathVariable String name) {

        ResponseDTO objetoDeResposta = new ResponseDTO();
        objetoDeResposta.setId(id);
        objetoDeResposta.setName(name);


        return objetoDeResposta;
    }

    /*

    #REQUISIÇOES:

     exemplo 1 (get/post) : localhost:9000/v1/informacao/
     exemplo 2 (recuperando valor): localhost:9000/v1/informacao/1/nome


     #DICA
      Use o postman : https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop


     #OBSERVAÇÕS

     Claro que os get e set devem ser abstraidos em uma outra camada (BUSS)....
     Há outras maneiras de se chegar no mesmo fluxo de trabalho...
     Mas, no meu ver...essa é uma opção bem minimalista, e o melhor, funciona. hahah
     E como você deve ter percebido...
     Aqui: [ method = RequestMethod.GET], definimos a verbosidade HTTP.


    */



}
