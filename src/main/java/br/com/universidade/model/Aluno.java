package br.com.universidade.model;

import br.com.universidade.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "aluno")
public class Aluno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String nome;

    @OneToOne
    @JoinColumn//(name = "endereco_id", table = "aluno")//unique = true, nullable=false
    private Endereco endereco;

    @Enumerated(EnumType.ORDINAL)
    @NotNull
    private StatusEnum status;

}
