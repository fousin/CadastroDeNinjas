package dev.fousin.CadastrosDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class MissaoController {

    //adicionar missao
    @PostMapping("/missao")
    public String create(){
        return "Cadastrado com sucesso";
    }
    //mostrar todos os missaos
    @GetMapping("/missoes")
    public String getmissaos(){
        return "Cadastrado com sucesso";
    }

    //procurar missao por id
    @GetMapping("/missao/{id}")
    public String getmissaoById(@PathVariable Long id){
        return "missao encontrado" + id;
    }

    //aterar dados
    @PutMapping("/missao/{id}")
    public String updatemissao(@PathVariable Long id){
        return "missao atualizado" + id;
    }

    //deletar missao
    @DeleteMapping("/missao/{id}")
    public String deletemissao(@PathVariable Long id){
        return "missao deletado" + id;
    }
}
