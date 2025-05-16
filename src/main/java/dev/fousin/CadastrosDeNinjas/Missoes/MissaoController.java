package dev.fousin.CadastrosDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missoes")
public class MissaoController {

    //adicionar missao
    @PostMapping("")
    public String createMissao() {
        return "Cadastrado com sucesso";
    }

    //mostrar todos os missaos
    @GetMapping("")
    public String missoes(){
        return "todas as missoes";
    }


    //procurar missao por id
    @GetMapping("/{id}")
    public String getMissaoById(@PathVariable Long id){
        return "missao encontrad " + id;
    }

    //aterar dados
    @PutMapping("/{id}")
    public String updateMissao(@PathVariable Long id){
        return "missao atualizada " + id;
    }

    //deletar missao
    @DeleteMapping("/{id}")
    public String deleteMissao(@PathVariable Long id){
        return "missao deletada " + id;
    }
}
