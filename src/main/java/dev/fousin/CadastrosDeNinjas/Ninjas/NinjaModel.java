package dev.fousin.CadastrosDeNinjas.Ninjas;

import dev.fousin.CadastrosDeNinjas.Missoes.MissaoModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name="tb_ninjas")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class NinjaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    @Column(name="img_url")
    private String imgUrl;

    private int idade;

    // @ManyToOne um ninja tem uma unica missao
    @ManyToOne
    @JoinColumn(name="missao_id") //fk
    private MissaoModel missoes;
}
