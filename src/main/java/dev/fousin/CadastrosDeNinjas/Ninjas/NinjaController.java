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
    public String createNinja() {
        return "Cadastrado com sucesso";
    }

    //mostrar todos os ninjas
    @GetMapping("")
    public List<NinjaModel> getNinjas() {
        return ninjaService.getNinjas();
    }

    //procurar ninja por id
    @GetMapping("/{id}")
    public String getNinjaById(@PathVariable Long id) {
        return "ninja encontrado" + id;
    }

    //aterar dados
    @PutMapping("/{id}")
    public String updateNinja(@PathVariable Long id) {
        return "ninja atualizado" + id;
    }

    //deletar ninja
    @DeleteMapping("/{id}")
    public String deleteNinja(@PathVariable Long id) {
        return "ninja deletado" + id;
    }


}
