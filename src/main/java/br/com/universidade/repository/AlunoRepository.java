package br.com.universidade.repository;

import br.com.universidade.model.Aluno;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface AlunoRepository extends CrudRepository<Aluno,Long> {

   @Query(value = "SELECT * FROM aluno a WHERE a.status = 1", nativeQuery = true)
    List<Aluno> encontrarTodosAlunosAtivos();

}
