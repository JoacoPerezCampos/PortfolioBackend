package com.portfolio.jepc.Controller;

import com.portfolio.jepc.DTO.ExperienceDTO;
import com.portfolio.jepc.Entity.Experience;
import com.portfolio.jepc.Security.Controller.Message;
import com.portfolio.jepc.Service.ImpExperienceService;
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
@RequestMapping("/exp")
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienceController {

    @Autowired
    ImpExperienceService impExperienceService;

    @GetMapping("/list")
    public ResponseEntity<List<Experience>> list() {
        List<Experience> list = impExperienceService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")

    public ResponseEntity<Experience> getById(@PathVariable("id") int id) {

        if (!impExperienceService.existsById(id)) {
            return new ResponseEntity(new Message("no existe"), HttpStatus.NOT_FOUND);
        }

        Experience experience = impExperienceService.getOne(id).get();

        return new ResponseEntity(experience, HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ExperienceDTO experienceDTO) {
        if (StringUtils.isBlank(experienceDTO.getExpName())) {
            return new ResponseEntity(new Message("El nombre de la experiencia es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (impExperienceService.existsByExpName(experienceDTO.getExpName())) {
            return new ResponseEntity(new Message("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }

        Experience experience = new Experience(experienceDTO.getExpName(), experienceDTO.getExpDescription(), experienceDTO.getExpImgUrl());
        impExperienceService.save(experience);

        return new ResponseEntity(new Message("Experiencia agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ExperienceDTO experienceDTO) {
        if (!impExperienceService.existsById(id)) {
            return new ResponseEntity(new Message("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        if (impExperienceService.existsByExpName(experienceDTO.getExpDescription()) && impExperienceService.getByExpName(experienceDTO.getExpName()).get().getId() != id) {
            return new ResponseEntity(new Message("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(experienceDTO.getExpName())) {
            return new ResponseEntity(new Message("El nombre de la experiencia es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(experienceDTO.getExpDescription())) {
            return new ResponseEntity(new Message("La descripción de la experiencia es obligatoria"), HttpStatus.BAD_REQUEST);
        }

        Experience experience = impExperienceService.getOne(id).get();
        experience.setExpName(experienceDTO.getExpName());
        experience.setExpDescription(experienceDTO.getExpDescription());
        experience.setExpImgUrl(experienceDTO.getExpImgUrl());

        impExperienceService.save(experience);
        return new ResponseEntity(new Message("Experiencia actualizada"), HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!impExperienceService.existsById(id)) {
            return new ResponseEntity(new Message("El id no existe"), HttpStatus.BAD_REQUEST);
        }

        impExperienceService.delete(id);

        return new ResponseEntity(new Message("La experiencia ha sido borrada"), HttpStatus.OK);
    }
}
