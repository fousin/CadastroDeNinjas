package dev.fousin.CadastrosDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {
    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    //adicionar ninja
    @PostMapping("")
    public String createNinja(@RequestBody NinjaModel ninja) {
        ninjaService.createNinja(ninja);
        return "Cadastrado com sucesso";
    }

    //mostrar todos os ninjas
    @GetMapping("")
    public List<NinjaModel> getNinjas() {
        return ninjaService.getNinjas();
    }

    //procurar ninja por id
    @GetMapping("/{id}")
    public NinjaModel getNinjaById(@PathVariable Long id) {
        return ninjaService.getNinja(id);
    }

    //aterar dados
    @PutMapping("/{id}")
    public String updateNinja(@PathVariable Long id, @RequestBody NinjaModel atualizacao) {
        NinjaModel ninja = ninjaService.updateNinja(id, atualizacao);
        if(ninja != null){
            return "Ninja Atualizado com sucesso";
        }
        return "Ninja não encontrado";
    }

    //deletar ninja
    @DeleteMapping("/{id}")
    public String deleteNinja(@PathVariable Long id) {
        return ninjaService.deleteNinja(id);
    }


}
