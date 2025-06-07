package dev.fousin.CadastrosDeNinjas.Ninjas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Data
@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    public List<NinjaModel> getNinjas(){
        return ninjaRepository.findAll();
    }

    public NinjaModel getNinja(Long id){
        Optional<NinjaModel> ninja = ninjaRepository.findById(id);
        return ninja.orElse(null);
    }

    public NinjaDTO createNinja(NinjaDTO ninjaDTO){
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    public NinjaDTO updateNinja(Long id, NinjaDTO ninjaDTo){
        NinjaModel ninja = ninjaRepository.findById(id).orElse(null);
        if(ninja != null){
            ninja = ninjaMapper.map(ninjaDTo);
            ninja = ninjaRepository.save(ninja);
            return ninjaMapper.map(ninja);
        }
        return null;
    }

    public String deleteNinja(Long id){
        ninjaRepository.deleteById(id) ;
        return "Ninja deletado com sucesso";
    }

}
