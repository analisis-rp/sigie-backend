package cr.ac.ucr.ie.sigie.controller;

import cr.ac.ucr.ie.sigie.entity.Modalidad;
import cr.ac.ucr.ie.sigie.service.ModalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/modalidad")
public class ModalidadController {

    @Autowired
    private ModalidadService service;

    @GetMapping("/modalidades")
    public List<Modalidad> list() {
        return service.listAll();
    }

}
