package br.com.universidade.model;


import br.com.universidade.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "disciplina")
public class Disciplina implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Date dataInicio;

    @OneToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

   // private List<Aluno> turma;

    @Enumerated(EnumType.ORDINAL)
    private StatusEnum status;

}
