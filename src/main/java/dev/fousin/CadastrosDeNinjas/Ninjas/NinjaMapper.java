package dev.fousin.CadastrosDeNinjas.Ninjas;

import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {

    public NinjaModel map(NinjaDTO ninjaDTO){
        return new NinjaModel(
                ninjaDTO.getId(),
                ninjaDTO.getNome(),
                ninjaDTO.getEmail(),
                ninjaDTO.getImgUrl(),
                ninjaDTO.getIdade(),
                ninjaDTO.getRank(),
                ninjaDTO.getMissoes()
        );
    }

    public NinjaDTO map(NinjaModel ninjaModel){
        return new NinjaDTO(
                ninjaModel.getId(),
                ninjaModel.getNome(),
                ninjaModel.getEmail(),
                ninjaModel.getImgUrl(),
                ninjaModel.getIdade(),
                ninjaModel.getRank(),
                ninjaModel.getMissoes()
        );
    }
}