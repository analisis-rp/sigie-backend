package cr.ac.ucr.ie.sigie;
import cr.ac.ucr.ie.sigie.entity.*;
import cr.ac.ucr.ie.sigie.repository.CursoRepository;
import cr.ac.ucr.ie.sigie.service.CursoService;
import org.junit.jupiter.api.*;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class CursoServiceTest {
    @Mock private CursoRepository repository;
    private CursoService service;
    private AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        service = new CursoService();
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canListAll() {
        //when
        service.listAll();
        //then
        verify(repository).findAll();
    }

    @Test
    void canSave() {
        // Given
        Curso curso = new Curso();

        curso.setIdCurso(1);
        curso.setNombre("Programación V");
        curso.setCiclo("III");
        curso.setAreaDisciplinaria(new AreaDisciplinaria());
        curso.setContenidos(new ArrayList<Contenido>());
        curso.setCorrequisitos(new ArrayList<Curso>());
        curso.setCreditos(3);
        curso.setElectivo(true);
        curso.setEnfasis(new ArrayList<Enfasis>());
        curso.setHorasLaboratorio(2);
        curso.setHorasPractica(2);
        curso.setHorasTeoria(2);
        curso.setHorasTeoricoPractica(2);
        curso.setItemesDescripcion(new ArrayList<ItemDescripcion>());
        curso.setModalidad(new Modalidad());
        curso.setObjetivoGeneral("aprender");
        curso.setPlanEstudio(new PlanEstudio());
        curso.setRequisitos(new ArrayList<Curso>());
        curso.setResultadosDeAprendizaje(new ArrayList<ResultadosAprendizaje>());
        curso.setReferenciasBibliograficas(new ArrayList<ReferenciaBibliografica>());
        curso.setSigla("IF7233");
        curso.setUnidadesAcademicasPropietarias(new ArrayList<UnidadAcademica>());
        curso.setElectivos(new ArrayList<Curso>());
        // When
        service.save(curso);
        // Then
        ArgumentCaptor<Curso> cursoArgumentCaptor = ArgumentCaptor.forClass(Curso.class);
        verify(repository).save(cursoArgumentCaptor.capture());
        Curso capturedCurso = cursoArgumentCaptor.getValue();
        assertThat(capturedCurso).isEqualTo(curso);
    }

    @Test
    void get() {

        int i =1;
        repository.findById(i);


    }

    @Test
    void canDelete() {
        int i = 1;
        repository.deleteById(i);
    }
}