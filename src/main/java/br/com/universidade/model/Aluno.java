package br.com.universidade.model;

import br.com.universidade.enums.StatusEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "aluno")
public class Aluno implements Serializable {


    private Long id;
    private String nome;
    private Curso curso;
    private List<Disciplina> turma;
    private StatusEnum status;

    public Aluno() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @OneToOne
    @JoinColumn(name = "curso_id")
    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @ManyToMany
    @JoinTable(
            name = "turma",
            joinColumns = @JoinColumn(name = "aluno_id"),
            inverseJoinColumns = @JoinColumn(name = "disciplina_id")
    )
    public List<Disciplina> getTurma() {
        return turma;
    }

    public void setTurma(List<Disciplina> turma) {
        this.turma = turma;
    }

    @Enumerated(EnumType.ORDINAL)
    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }
}
