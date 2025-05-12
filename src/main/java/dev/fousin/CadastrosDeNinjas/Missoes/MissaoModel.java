package dev.fousin.CadastrosDeNinjas.Missoes;

import dev.fousin.CadastrosDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="tb_missoes")
public class MissaoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dificuldade;
    //@OneToMany uma missao pode ter varios ninjas
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninjas;


    public MissaoModel() {
    }

    public MissaoModel(String nome, String dificuldade) {
        this.nome = nome;
        this.dificuldade = dificuldade;
    }

}
