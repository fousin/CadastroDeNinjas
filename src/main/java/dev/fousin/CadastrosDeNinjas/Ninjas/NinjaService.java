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

    public List<NinjaDTO> getNinjas() {
        return ninjaRepository.findAll().stream().map(ninjaMapper::map).toList();
    }

    public NinjaDTO getNinja(Long id) {
        Optional<NinjaModel> ninja = ninjaRepository.findById(id);
        return ninja.map(ninjaMapper::map).orElse(null);
    }

    public NinjaDTO createNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    public NinjaDTO updateNinja(Long id, NinjaDTO ninjaDTO) {
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
        if(!ninjaExistente.isPresent()) {
            return null;
        }

        NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDTO);
        ninjaAtualizado.setId(id);
        NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);

        return ninjaMapper.map(ninjaSalvo);
    }

    public String deleteNinja(Long id) {
        ninjaRepository.deleteById(id);
        return "Ninja deletado com sucesso";
    }

}
