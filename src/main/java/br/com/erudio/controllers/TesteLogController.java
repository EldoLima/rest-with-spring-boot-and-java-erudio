package br.com.erudio.controllers;

import br.com.erudio.services.PersonServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TesteLogController {

    private Logger logger = LoggerFactory.getLogger(TesteLogController.class.getName());


    @GetMapping("/test")
    public String testeLog(){
        logger.info("This is an INFO log");
        logger.debug("This is an DEBUg log");
        logger.warn("This is an WARN log");
        logger.error("This is an ERROR log");
        return "Logs generated successully";
    }

}
