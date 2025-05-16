package dev.fousin.CadastrosDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/")
    public String boasVindas(){
        return "Hello, World!";
    }

    //adicionar ninja
    @PostMapping("/ninja")
    public String create(){
        return "Cadastrado com sucesso";
    }
    //mostrar todos os ninjas
    @GetMapping("/ninjas")
    public String getNinjas(){
        return "Cadastrado com sucesso";
    }

    //procurar ninja por id
    @GetMapping("/ninja/{id}")
    public String getNinjaById(@PathVariable Long id){
        return "ninja encontrado" + id;
    }

    //aterar dados
    @PutMapping("/ninja/{id}")
    public String updateNinja(@PathVariable Long id){
        return "ninja atualizado" + id;
    }

    //deletar ninja
    @DeleteMapping("/ninja/{id}")
    public String deleteNinja(@PathVariable Long id){
        return "ninja deletado" + id;
    }


}
