package com.portfolio.jepc.Controller;

import com.portfolio.jepc.DTO.PersonDTO;
import com.portfolio.jepc.Entity.Person;
import com.portfolio.jepc.Security.Controller.Message;
import com.portfolio.jepc.Service.ImpPersonService;
import java.util.List;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("/persons")
@CrossOrigin(origins = "http://localhost:4200/")
public class PersonController {

    @Autowired
    ImpPersonService impPersonService;

    @GetMapping("/list")
    public ResponseEntity<List<Person>> getPerson() {
        List<Person> list = impPersonService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/get/profile")
    public Optional<Person> findPerson() {
        return impPersonService.getOne((int) 1);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Person> getById(@PathVariable("id") int id) {
        if (!impPersonService.existsById(id)) {
            return new ResponseEntity(new Message("No existe el ID"), HttpStatus.BAD_REQUEST);
        }

        Person person = impPersonService.getOne(id).get();
        return new ResponseEntity(person, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public String savePerson(@RequestBody Person person) {
        impPersonService.save(person);
        return "La persona fue creada";
    }

    @DeleteMapping("/delete/{id}")
    public String deletePerson(@PathVariable int id) {
        impPersonService.delete(id);
        return "La persona fue eliminada";
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePerson(@PathVariable("id") int id, @RequestBody PersonDTO personDTO) {
        if (!impPersonService.existsById(id)) {
            return new ResponseEntity(new Message("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        if (impPersonService.existsByName(personDTO.getAbout()) && impPersonService.getByName(personDTO.getName()).get().getId() != id) {
            return new ResponseEntity(new Message("Esa persona ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(personDTO.getName())) {
            return new ResponseEntity(new Message("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(personDTO.getAbout())) {
            return new ResponseEntity(new Message("La descripción de la persona es obligatoria"), HttpStatus.BAD_REQUEST);
        }

        Person person = impPersonService.getOne(id).get();
        person.setName(personDTO.getName());
        person.setLastname(personDTO.getLastname());
        person.setAbout(personDTO.getAbout());
        person.setProfileImgUrl(personDTO.getProfileImgUrl());

        impPersonService.save(person);
        return new ResponseEntity(new Message("Persona actualizada"), HttpStatus.OK);

    }

    
}
