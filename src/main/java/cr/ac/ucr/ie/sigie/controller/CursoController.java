package cr.ac.ucr.ie.sigie.controller;

import cr.ac.ucr.ie.sigie.entity.Curso;
import cr.ac.ucr.ie.sigie.interfaces.sigiebackend.ICurso;
import cr.ac.ucr.ie.sigie.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/curso")
public class CursoController {

    public void setService(CursoService service) {
        this.service = service;
    }

    @Autowired
    private CursoService service;

    @GetMapping("/")
    public ResponseEntity<List<ICurso>> list() {
        List<ICurso> cursos = service.getCursos();
        return new ResponseEntity<List<ICurso>>(cursos, HttpStatus.OK);
    }

    @PostMapping("/save")
    public void add(@RequestBody Curso curso) {
        try {
            service.save(curso);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
