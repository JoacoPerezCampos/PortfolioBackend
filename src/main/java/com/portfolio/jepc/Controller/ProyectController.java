package com.portfolio.jepc.Controller;

import com.portfolio.jepc.DTO.ProyectDTO;
import com.portfolio.jepc.Entity.Proyect;
import com.portfolio.jepc.Security.Controller.Message;
import com.portfolio.jepc.Service.ImpProyectService;
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
@RequestMapping("/proyect")
@CrossOrigin(origins = "http://localhost:4200")
public class ProyectController {

    @Autowired
    ImpProyectService impProyect;

    @GetMapping("/list")
    public ResponseEntity<List<Proyect>> list() {
        List<Proyect> list = impProyect.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")

    public ResponseEntity<Proyect> getById(@PathVariable("id") int id) {

        if (!impProyect.existsById(id)) {
            return new ResponseEntity(new Message("no existe"), HttpStatus.NOT_FOUND);
        }

        Proyect proyect = impProyect.getOne(id).get();

        return new ResponseEntity(proyect, HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProyectDTO proyectDTO) {
        if (StringUtils.isBlank(proyectDTO.getpName())) {
            return new ResponseEntity(new Message("El nombre de la educacion es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (impProyect.existsBypName(proyectDTO.getpName())) {
            return new ResponseEntity(new Message("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }

        Proyect proyect = new Proyect(proyectDTO.getpName(), proyectDTO.getpDescription(), proyectDTO.getpImg1Url(), proyectDTO.getpImg2Url(), proyectDTO.getpImg3Url(), proyectDTO.getpImg4Url());
        impProyect.save(proyect);

        return new ResponseEntity(new Message("Educación agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ProyectDTO proyectDTO) {
        if (!impProyect.existsById(id)) {
            return new ResponseEntity(new Message("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        if (impProyect.existsBypName(proyectDTO.getpDescription()) && impProyect.getBypName(proyectDTO.getpName()).get().getId() != id) {
            return new ResponseEntity(new Message("Esa proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(proyectDTO.getpName())) {
            return new ResponseEntity(new Message("El nombre del proyecto es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(proyectDTO.getpDescription())) {
            return new ResponseEntity(new Message("La descripción del proyecto es obligatoria"), HttpStatus.BAD_REQUEST);
        }

        Proyect proyect = impProyect.getOne(id).get();
        proyect.setpName(proyectDTO.getpName());
        proyect.setpDescription(proyectDTO.getpDescription());
        proyect.setpImg1Url(proyectDTO.getpImg1Url());
        proyect.setpImg1Url(proyectDTO.getpImg2Url());
        proyect.setpImg1Url(proyectDTO.getpImg3Url());
        proyect.setpImg1Url(proyectDTO.getpImg4Url());

        impProyect.save(proyect);
        return new ResponseEntity(new Message("Proyecto actualizado"), HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!impProyect.existsById(id)) {
            return new ResponseEntity(new Message("El id no existe"), HttpStatus.BAD_REQUEST);
        }

        impProyect.delete(id);

        return new ResponseEntity(new Message("La educación ha sido borrada"), HttpStatus.OK);
    }
}
