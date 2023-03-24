
package com.portfolio.jepc.Controller;

import com.portfolio.jepc.DTO.EducationDTO;
import com.portfolio.jepc.Entity.Education;
import com.portfolio.jepc.Security.Controller.Message;
import com.portfolio.jepc.Service.ImpEducationService;
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
@RequestMapping ("/ed")
@CrossOrigin (origins = "http://localhost:4200")
public class EducationController {
    
    @Autowired
    ImpEducationService impEducation;
    
    @GetMapping("/list")
    public ResponseEntity<List<Education>> list() {
        List<Education> list = impEducation.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")

    public ResponseEntity<Education> getById(@PathVariable("id") int id) {

        if (!impEducation.existsById(id)) {
            return new ResponseEntity(new Message("no existe"), HttpStatus.NOT_FOUND);
        }

        Education education = impEducation.getOne(id).get();

        return new ResponseEntity(education, HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody EducationDTO educationDTO) {
        if (StringUtils.isBlank(educationDTO.getEdName())) {
            return new ResponseEntity(new Message("El nombre de la educacion es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (impEducation.existsByEdName(educationDTO.getEdName())) {
            return new ResponseEntity(new Message("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }

        Education education = new Education(educationDTO.getEdName(), educationDTO.getEdDescription(), educationDTO.getEdImgUrl());
        impEducation.save(education);

        return new ResponseEntity(new Message("Educación agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody EducationDTO educationDTO) {
        if (!impEducation.existsById(id)) {
            return new ResponseEntity(new Message("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        if (impEducation.existsByEdName(educationDTO.getEdDescription()) && impEducation.getByEdName(educationDTO.getEdName()).get().getId() != id) {
            return new ResponseEntity(new Message("Esa educación ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(educationDTO.getEdName())) {
            return new ResponseEntity(new Message("El nombre de la educacion es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(educationDTO.getEdDescription())) {
            return new ResponseEntity(new Message("La descripción de la educación es obligatoria"), HttpStatus.BAD_REQUEST);
        }

        Education education = impEducation.getOne(id).get();
        education.setEdName(educationDTO.getEdName());
        education.setEdDescription(educationDTO.getEdDescription());
        education.setEdImgUrl(educationDTO.getEdImgUrl());

        impEducation.save(education);
        return new ResponseEntity(new Message("Experiencia actualizada"), HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!impEducation.existsById(id)) {
            return new ResponseEntity(new Message("El id no existe"), HttpStatus.BAD_REQUEST);
        }

        impEducation.delete(id);

        return new ResponseEntity(new Message("La educación ha sido borrada"), HttpStatus.OK);
    }
    
}
