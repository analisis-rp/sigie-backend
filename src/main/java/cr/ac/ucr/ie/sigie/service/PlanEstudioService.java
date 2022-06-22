package cr.ac.ucr.ie.sigie.service;

import cr.ac.ucr.ie.sigie.interfaces.sigiebackend.IPlanEstudio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cr.ac.ucr.ie.sigie.entity.PlanEstudio;
import cr.ac.ucr.ie.sigie.repository.PlanEstudioRepository;
import java.util.List;

@Service
@Transactional
public class PlanEstudioService {

    @Autowired
    private PlanEstudioRepository repository;

    public List<PlanEstudio> listAll() {
        return repository.findAll();
    }

    public List<IPlanEstudio> getPlanesEstudio(){
        return repository.findAllBy();
    }

    public void save(PlanEstudio planEstudio) {
        repository.save(planEstudio);
    }

    public PlanEstudio get(int id) {
        return repository.findById(id).get();
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
