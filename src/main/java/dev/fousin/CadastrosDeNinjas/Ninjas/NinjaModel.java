package dev.fousin.CadastrosDeNinjas.Ninjas;

import dev.fousin.CadastrosDeNinjas.Missoes.MissaoModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="tb_ninjas")
public class NinjaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private int idade;
    // @ManyToOne um ninja tem uma unica missao
    @ManyToOne
    @JoinColumn(name="missao_id") //fk
    private MissaoModel missoes;

    public NinjaModel() {
    }

    public NinjaModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }


}
