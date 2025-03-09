package br.com.erudio.request;

import br.com.erudio.model.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

//operações para cadastrar um pessoa

@Service
public class PersonServices {
    private final AtomicLong counter = new AtomicLong();

    private Logger logger  = Logger.getLogger(PersonServices.class.getName());


    public Person findById(String id){
        logger.info("finding one person");
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Eldo");
        person.setLastName("Lima");
        person.setAddress("Rua do Java");
        person.setGender("Male");
        return person;
    }

}
