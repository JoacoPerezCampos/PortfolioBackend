package com.portfolio.jepc.Service;

import com.portfolio.jepc.Entity.Proyect;
import com.portfolio.jepc.Repository.IProyectRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpProyectService {
    @Autowired
    IProyectRepository iProyect;
    
    public List<Proyect> list(){
        return iProyect.findAll();
    }
    
    public Optional<Proyect> getOne(int id){
        return iProyect.findById(id);
    }
    
    public Optional<Proyect> getBypName(String pName){
        return iProyect.findBypName(pName);
    }
    
    public void save(Proyect proyect){
        iProyect.save(proyect);
    }
    
    public void delete(int id){
        iProyect.deleteById(id);
    }
    
    public boolean existsById(int id){
        return iProyect.existsById(id);
    }
    
    public boolean existsBypName(String pName){
        return iProyect.existsBypName(pName);
    }
    
}
