package com.portfolio.jepc.Service;

import com.portfolio.jepc.Entity.Person;
import com.portfolio.jepc.Interface.IPersonService;
import com.portfolio.jepc.Repository.IPersonRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpPersonService implements IPersonService{

    @Autowired
    IPersonRepository ipersonRepository;

    @Override
    public List<Person> getPerson() {
        List<Person> person = ipersonRepository.findAll();
        return person;
    }
    
    public Optional<Person> getOne(int id){
         return ipersonRepository.findById(id);
     }

    @Override
    public void savePerson(Person person) {
        ipersonRepository.save(person);
    }

    @Override
    public void deletePerson(int id) {
        ipersonRepository.deleteById(id);
    }

    @Override
    public Person findPerson(int id) {
        Person person = ipersonRepository.findById(id).orElse(null);
        return person;
    }

    @Override
    public boolean existsById(int id) {
        return true;
    }
}


