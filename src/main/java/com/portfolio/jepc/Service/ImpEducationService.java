package com.portfolio.jepc.Service;

import com.portfolio.jepc.Entity.Education;
import com.portfolio.jepc.Repository.IEducationRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpEducationService {
    @Autowired
    IEducationRepository iEducation;
    
    public List<Education> list(){
        return iEducation.findAll();
    }
    
    public Optional<Education> getOne(int id){
        return iEducation.findById(id);
    }
    
    public Optional<Education> getByEdName(String edName){
        return iEducation.findByEdName(edName);
    }
    
    public void save(Education education){
        iEducation.save(education);
    }
    
    public void delete(int id){
        iEducation.deleteById(id);
    }
    
    public boolean existsById(int id){
        return iEducation.existsById(id);
    }
    
    public boolean existsByEdName(String edName){
        return iEducation.existsByEdName(edName);
    }
    
}
