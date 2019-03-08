package br.com.universidade.endpoint;

import br.com.universidade.model.Curso;
import br.com.universidade.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("curso")
public class CursoEndpoint {


    @Autowired
    CursoService cursoService;

    @GetMapping
    public ResponseEntity<?> getAll(){

        return new ResponseEntity<>(cursoService.pegarTodos(), HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){

        return new ResponseEntity<>(cursoService.pegarPorId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Curso curso){

        return new ResponseEntity<>(cursoService.criar(curso), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> up(@RequestBody Curso curso){

        Optional<Curso> empty = Optional.empty();

        if(cursoService.pegarPorId(curso.getId()) == empty)
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(cursoService.atualizar(curso), HttpStatus.OK);
    }


    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> remove(@PathVariable Long id){

        Optional<Curso>  empty = Optional.empty();

        if(cursoService.pegarPorId(id) == empty)
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(cursoService.deletar(id), HttpStatus.OK);
    }
}
