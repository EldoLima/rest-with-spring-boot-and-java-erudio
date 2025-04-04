package br.com.erudio.services;

import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.model.Person;
import br.com.erudio.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//operações para cadastrar um pessoa

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger  = LoggerFactory.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;




    public Person findById(Long id){
        logger.info("finding one person");
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
    }
    public List<Person> findAll(){
        logger.info("Find all people");
        return repository.findAll();
    }
    public Person create(Person person) {
        logger.info("Creating one person");
        return repository.save(person);
    }
    public Person Update(Person person){
        logger.info("Update one person");
        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return repository.save(person);
    }
    public void delete(Long id){
        logger.info("Deleting one person");
        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        repository.delete(entity);
    }


}
