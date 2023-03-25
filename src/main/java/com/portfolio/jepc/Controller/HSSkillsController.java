package com.portfolio.jepc.Controller;

import com.portfolio.jepc.DTO.HSSkillsDTO;
import com.portfolio.jepc.Entity.HSSkills;
import com.portfolio.jepc.Security.Controller.Message;
import com.portfolio.jepc.Service.ImpHSSkillsService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/skills/")
public class HSSkillsController {

    @Autowired
    ImpHSSkillsService impHSSkills;

    @GetMapping("/list")
    public ResponseEntity<List<HSSkills>> list() {
        List<HSSkills> list = impHSSkills.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")

    public ResponseEntity<HSSkills> getById(@PathVariable("id") int id) {

        if (!impHSSkills.existsById(id)) {
            return new ResponseEntity(new Message("no existe"), HttpStatus.NOT_FOUND);
        }

        HSSkills hsSkills = impHSSkills.getOne(id).get();

        return new ResponseEntity(hsSkills, HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody HSSkillsDTO hsSkillsDTO) {
        if (StringUtils.isBlank(hsSkillsDTO.getHsName())) {
            return new ResponseEntity(new Message("El nombre de la habilidad es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (impHSSkills.existsByHsName(hsSkillsDTO.getHsName())) {
            return new ResponseEntity(new Message("Esa habilidad ya existe"), HttpStatus.BAD_REQUEST);
        }

        HSSkills hsSkills = new HSSkills(hsSkillsDTO.getHsName(), hsSkillsDTO.getPercent());
        impHSSkills.save(hsSkills);

        return new ResponseEntity(new Message("Habilidad agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody HSSkillsDTO hsSkillsDTO) {
        if (!impHSSkills.existsById(id)) {
            return new ResponseEntity(new Message("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        if (impHSSkills.existsByHsName(hsSkillsDTO.getHsName()) && impHSSkills.getByHsName(hsSkillsDTO.getHsName()).get().getId() != id) {
            return new ResponseEntity(new Message("Esa habilidad ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(hsSkillsDTO.getHsName())) {
            return new ResponseEntity(new Message("El nombre de la habilidad es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        HSSkills hsSkills = impHSSkills.getOne(id).get();
        hsSkills.setHsName(hsSkillsDTO.getHsName());
        hsSkills.setPercent(hsSkillsDTO.getPercent());

        impHSSkills.save(hsSkills);
        return new ResponseEntity(new Message("Habilidad actualizada"), HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!impHSSkills.existsById(id)) {
            return new ResponseEntity(new Message("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        impHSSkills.delete(id);
        return new ResponseEntity(new Message("La habilidad ha sido borrada"), HttpStatus.OK);
    }

}
