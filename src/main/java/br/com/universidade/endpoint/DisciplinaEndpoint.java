package br.com.universidade.endpoint;

import br.com.universidade.model.Disciplina;
import br.com.universidade.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("disciplina")
public class DisciplinaEndpoint {


    @Autowired
    DisciplinaService disciplinaService;

    @GetMapping
    public ResponseEntity<?> getAll(){

        return new ResponseEntity<>(disciplinaService.pegarTodos(), HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){

        return new ResponseEntity<>(disciplinaService.pegarPorId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Disciplina disciplina){

        return new ResponseEntity<>(disciplinaService.criar(disciplina), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> up(@RequestBody Disciplina disciplina){

        Optional<Disciplina> empty = Optional.empty();

        if(disciplinaService.pegarPorId(disciplina.getId()) == empty)
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(disciplinaService.atualizar(disciplina), HttpStatus.OK);
    }


    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> remove(@PathVariable Long id){

        Optional<Disciplina>  empty = Optional.empty();

        if(disciplinaService.pegarPorId(id) == empty)
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(disciplinaService.deletar(id), HttpStatus.OK);
    }
}
