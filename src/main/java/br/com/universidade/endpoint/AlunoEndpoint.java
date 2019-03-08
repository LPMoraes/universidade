package br.com.universidade.endpoint;

import br.com.universidade.model.Aluno;
import br.com.universidade.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("aluno")
public class AlunoEndpoint {

        @Autowired
        AlunoService alunoService;

        @GetMapping
        public ResponseEntity<?> getAll(){

            return new ResponseEntity<>(alunoService.pegarTodos(), HttpStatus.OK);
        }

        @GetMapping(path = "/{id}")
        public ResponseEntity<?> getById(@PathVariable Long id){

                return new ResponseEntity<>(alunoService.pegarPorId(id), HttpStatus.OK);
        }

        @PostMapping
        public ResponseEntity<?> add(@RequestBody Aluno aluno){

                return new ResponseEntity<>(alunoService.criar(aluno), HttpStatus.CREATED);
        }

        @PutMapping(path = "/{id}")
        public ResponseEntity<?> up(@RequestBody Aluno aluno){

                return new ResponseEntity<>(alunoService.atualizar(aluno), HttpStatus.OK);
        }


        @DeleteMapping(path = "/{id}")
        public ResponseEntity<?> remove(@PathVariable Long id){

                return new ResponseEntity<>(alunoService.deletar(id), HttpStatus.OK);
        }

}
