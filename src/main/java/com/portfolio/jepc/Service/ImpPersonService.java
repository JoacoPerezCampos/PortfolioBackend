package com.portfolio.jepc.Service;

import com.portfolio.jepc.Entity.Person;
import com.portfolio.jepc.Repository.IPersonRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpPersonService {

    @Autowired
    IPersonRepository ipersonRepository;

    public List<Person> list(){
        return ipersonRepository.findAll();
    }
    
    public Optional<Person> getOne(int id){
        return ipersonRepository.findById(id);
    }
    
    public Optional<Person> getByName(String name){
        return ipersonRepository.findByName(name);
    }
    
    public void save(Person person){
        ipersonRepository.save(person);
    }
    
    public void delete(int id){
        ipersonRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return ipersonRepository.existsById(id);
    }
    
    public boolean existsByName(String name){
        return ipersonRepository.existsByName(name);
    }

}


