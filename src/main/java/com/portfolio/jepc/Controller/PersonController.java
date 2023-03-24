package com.portfolio.jepc.Controller;

import com.portfolio.jepc.Entity.Person;
import com.portfolio.jepc.Security.Controller.Message;
import com.portfolio.jepc.Service.ImpPersonService;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
@CrossOrigin (origins = "http://localhost:4200/")
public class PersonController{

    @Autowired
    ImpPersonService impPersonService;

    @GetMapping("/get")
    public List<Person> getPerson() {
        return impPersonService.getPerson();
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Person> getById(@PathVariable("id")int id){
        if(!impPersonService.existsById(id)){
            return new ResponseEntity(new Message("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Person person = impPersonService.getOne(id).get();
        return new ResponseEntity(person, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public String savePerson(@RequestBody Person person) {
        impPersonService.savePerson(person);
        return "La persona fue creada";
    }

    @DeleteMapping("/delete/{id}")
    public String deletePerson(@PathVariable int id) {
        impPersonService.deletePerson(id);
        return "La persona fue eliminada";
    }

    @PutMapping("/edit/{id}")
    public Person editPerson(@PathVariable int id,
            @RequestParam("name") String newName,
            @RequestParam("lastname") String newLastname,
            @RequestParam("profileImgUrl") String newProfileImgUrl,
            @RequestParam("about") String newAbout)
            {
        Person person = impPersonService.findPerson(id);
        person.setName(newName);
        person.setLastname(newLastname);
        person.setProfileImgUrl(newProfileImgUrl);
        person.setAbout(newAbout);

        impPersonService.savePerson(person);
        return person;

    }
    @GetMapping("/get/profile")
    public Person findPerson(){
        return impPersonService.findPerson((int)1);
    }
}
