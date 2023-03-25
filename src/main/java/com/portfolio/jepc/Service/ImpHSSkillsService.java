package com.portfolio.jepc.Service;

import com.portfolio.jepc.Entity.HSSkills;
import com.portfolio.jepc.Repository.IHSSkillsRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpHSSkillsService {

    @Autowired
    IHSSkillsRepository iHSSkills;

    public List<HSSkills> list() {
        return iHSSkills.findAll();
    }

    public Optional<HSSkills> getOne(int id) {
        return iHSSkills.findById(id);
    }

    public Optional<HSSkills> getByHsName(String hsName) {
        return iHSSkills.findByHsName(hsName);
    }

    public void save(HSSkills hsSkills) {
        iHSSkills.save(hsSkills);
    }

    public void delete(int id) {
        iHSSkills.deleteById(id);
    }

    public boolean existsById(int id) {
        return iHSSkills.existsById(id);
    }

    public boolean existsByHsName(String hsName) {
        return iHSSkills.existsByHsName(hsName);
    }

}
