package com.portfolio.jepc.Service;

import com.portfolio.jepc.Entity.Experience;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.jepc.Repository.IExperienceRepository;

@Service
@Transactional
public class ImpExperienceService {
    @Autowired
    IExperienceRepository iExperience;
    
    public List<Experience> list(){
        return iExperience.findAll();
    }
    
    public Optional<Experience> getOne(int id){
        return iExperience.findById(id);
    }
    
    public Optional<Experience> getByExpName(String expName){
        return iExperience.findByExpName(expName);
    }
    
    public void save(Experience experience){
        iExperience.save(experience);
    }
    
    public void delete(int id){
        iExperience.deleteById(id);
    }
    
    public boolean existsById(int id){
        return iExperience.existsById(id);
    }
    
    public boolean existsByExpName(String expName){
        return iExperience.existsByExpName(expName);
    }
}   

