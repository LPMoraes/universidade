package br.com.universidade.service;

import br.com.universidade.model.Aluno;
import br.com.universidade.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService  {

    @Autowired
    AlunoRepository alunoRepository;



    public List<Aluno> pegarTodosAlunosAtivos(){

        List<Aluno> alunoList  = alunoRepository.encontrarTodosAlunosAtivos();
        return alunoList;
    }


    public List<Aluno> pegarTodos(){
         return (List<Aluno>) alunoRepository.findAll();
    }

    public Optional<Aluno> pegarPorId(Long id){
        return alunoRepository.findById(id);
    }

    public Aluno criar(Aluno aluno){

        return alunoRepository.save(aluno);
    }

    public Aluno atualizar(Aluno aluno){

        return alunoRepository.save(aluno);
    }

    public Boolean deletar(Long id){

        alunoRepository.deleteById(id);
        return true;

    }
}
