package br.com.erudio.services;

import br.com.erudio.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    public List<Person> findAll(){
        logger.info("Find all people");
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }
    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("First name "+i);
        person.setLastName("last name "+i);
        person.setAddress("Addres " +i);
        person.setGender("Male");
        return person;
    }

    public Person create(Person person) {
        logger.info("Creating one person");
        return person;
    }

    public Person Update(Person person){
        logger.info("Update one person");
        return person;
    }
    public void delete(String id){
        logger.info("Deleting one person");
    }


}
