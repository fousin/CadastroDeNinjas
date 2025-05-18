package dev.fousin.CadastrosDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissaoController {
    private MissaoService missaoService;

    public MissaoController(MissaoService missaoService) {
        this.missaoService = missaoService;
    }

    //adicionar missao
    @PostMapping("")
    public String createMissao() {
        return "Cadastrado com sucesso";
    }

    //mostrar todos os missaos
    @GetMapping("")
    public List<MissaoModel> missoes(){
        return missaoService.getMissoes();
    }


    //procurar missao por id
    @GetMapping("/{id}")
    public String getMissaoById(@PathVariable Long id){
        return "missao encontrada " + missaoService.getMissao(id);
    }

    //aterar dados
    @PutMapping("/{id}")
    public String updateMissao(@PathVariable Long id, @RequestBody MissaoModel atualizacao){
        return "missao atualizada " + missaoService.updateMissao(id, atualizacao);
    }

    //deletar missao
    @DeleteMapping("/{id}")
    public String deleteMissao(@PathVariable Long id){
        return missaoService.delteMissao(id) ;
    }
}
