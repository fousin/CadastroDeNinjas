package dev.fousin.CadastrosDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    //adicionar ninja
    @PostMapping("")
    public String createNinja() {
        return "Cadastrado com sucesso";
    }

    //mostrar todos os ninjas
    @GetMapping("")
    public String getNinjas() {
        return "Cadastrado com sucesso";
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
