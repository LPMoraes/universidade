package br.com.universidade.model;


import br.com.universidade.enums.StatusEnum;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "disciplina")
public class Disciplina implements Serializable {

    private Long id;
    private String name;
    private Date Inicio;
    private Curso curso;
    private List<Aluno> turma;
    private StatusEnum status;

    public Disciplina() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToOne
    @JoinColumn(name = "curso_id")
    public Curso getCurso() {
        return curso;
    }


    @Temporal(TemporalType.DATE)
    @Column(name = "data_inicio", nullable = false)
    public Date getInicio() {
        return Inicio;
    }

    public void setInicio(Date inicio) {
        Inicio = inicio;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @ManyToMany
    @JoinTable(
            name = "turma",
            joinColumns = @JoinColumn(name = "disciplina_id"),
            inverseJoinColumns = @JoinColumn(name = "aluno_id")
    )
    public List<Aluno> getTurma() {
        return turma;
    }

    public void setTurma(List<Aluno> turma) {
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
