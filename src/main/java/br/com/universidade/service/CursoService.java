package br.com.universidade.service;

import br.com.universidade.model.Curso;
import br.com.universidade.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService  {

    @Autowired
    CursoRepository cursoRepository;

    public List<Curso> pegarTodos(){
        return (List<Curso>) cursoRepository.findAll();
    }

    public Optional<Curso> pegarPorId(Long id){
        return cursoRepository.findById(id);
    }

    public Curso criar(Curso curso){

        return cursoRepository.save(curso);
    }

    public Curso atualizar(Curso curso){

        return cursoRepository.save(curso);
    }

    public Boolean deletar(Long id){

        cursoRepository.deleteById(id);
        return true;

    }
}
