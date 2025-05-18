package dev.fousin.CadastrosDeNinjas.Ninjas;

import dev.fousin.CadastrosDeNinjas.Missoes.MissaoModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name="tb_ninjas")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
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


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
}





