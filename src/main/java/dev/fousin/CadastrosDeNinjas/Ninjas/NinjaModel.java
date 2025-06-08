package dev.fousin.CadastrosDeNinjas.Ninjas;

import dev.fousin.CadastrosDeNinjas.Missoes.MissaoModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "tb_ninjas")
@Entity
@Data
public class NinjaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    @Column(name = "img_url")
    private String imgUrl;

    @Column (name = "idade")
    private int idade;

    @Column (name="rank")
    private String rank;

    // @ManyToOne um ninja tem uma unica missao
    @ManyToOne
    @JoinColumn(name = "missao_id") //fk
    private MissaoModel missoes;

    public NinjaModel(){}

    public NinjaModel(Long id, String nome, String email, String imgUrl, int idade, String rank, MissaoModel missoes) {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public MissaoModel getMissoes() {
        return missoes;
    }

    public void setMissoes(MissaoModel missoes) {
        this.missoes = missoes;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}





