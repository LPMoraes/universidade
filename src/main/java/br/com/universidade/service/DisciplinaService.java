package br.com.universidade.service;

import br.com.universidade.model.Disciplina;
import br.com.universidade.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService{

    @Autowired
    DisciplinaRepository disciplinaRepository;

    public List<Disciplina> pegarTodos(){
        return (List<Disciplina>) disciplinaRepository.findAll();
    }

    public Optional<Disciplina> pegarPorId(Long id){
        return disciplinaRepository.findById(id);
    }

    public Disciplina criar(Disciplina disciplina){

        return disciplinaRepository.save(disciplina);
    }

    public Disciplina atualizar(Disciplina disciplina){

        return disciplinaRepository.save(disciplina);
    }

    public Boolean deletar(Long id){

        disciplinaRepository.deleteById(id);
        return true;

    }
}
