package dev.fousin.CadastrosDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    final NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public List<NinjaModel> getNinjas(){
        return ninjaRepository.findAll();
    }

    public NinjaModel getNinja(Long id){
        Optional<NinjaModel> ninja = ninjaRepository.findById(id);
        return ninja.orElse(null);
    }

    public NinjaModel createNinja(NinjaModel ninja){
        return ninjaRepository.save(ninja);
    }

    public NinjaModel updateNinja(Long id, NinjaModel atualizado){
        NinjaModel ninja = getNinja(id);
        if(ninja != null){
            ninja.setNome(atualizado.getNome());
            ninja.setEmail(atualizado.getEmail());
            ninja.setImgUrl(atualizado.getImgUrl());
            ninja.setIdade(atualizado.getIdade());
            ninja.setMissoes(atualizado.getMissoes());
            return ninjaRepository.save(ninja);
        }
        return null;
    }

    public String deleteNinja(Long id){
        NinjaModel ninja = getNinja(id);
        if(ninja != null){
            ninjaRepository.delete(ninja);
            return "Ninja deletado com sucesso";
        }
        return "Ninja não encontrado";
    }

}
