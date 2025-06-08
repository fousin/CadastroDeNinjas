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
    public NinjaDTO createNinja(@RequestBody NinjaDTO ninja) {
        return ninjaService.createNinja(ninja);
    }

    //mostrar todos os ninjas
    @GetMapping("")
    public List<NinjaDTO> getNinjas() {
        return ninjaService.getNinjas();
    }

    //procurar ninja por id
    @GetMapping("/{id}")
    public NinjaDTO getNinjaById(@PathVariable Long id) {
        return ninjaService.getNinja(id);
    }

    //aterar dados
    @PutMapping("/{id}")
    public NinjaDTO updateNinja(@PathVariable Long id, @RequestBody NinjaDTO atualizacao) {
        return ninjaService.updateNinja(id, atualizacao);
    }

    //deletar ninja
    @DeleteMapping("/{id}")
    public String deleteNinja(@PathVariable Long id) {
        return ninjaService.deleteNinja(id);
    }


}
