package dev.fousin.CadastrosDeNinjas.Missoes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MissaoController {
    @GetMapping("/")
    public String boasVindas(){
        return "Hello, World!";
    }

}
