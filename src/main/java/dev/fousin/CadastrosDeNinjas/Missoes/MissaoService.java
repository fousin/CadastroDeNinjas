package dev.fousin.CadastrosDeNinjas.Missoes;

import dev.fousin.CadastrosDeNinjas.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissaoService {
    private MissaoRepository missaoRepository;
    private MissaoMapper missaoMapper;
    public MissaoService(MissaoRepository missaoRepository, MissaoMapper missaoMapper) {
        this.missaoRepository = missaoRepository;
        this.missaoMapper = missaoMapper;
    }

    public MissaoDTO createMissao(MissaoDTO missaoDTO) {
        MissaoModel missao = missaoMapper.map(missaoDTO);
        missao = missaoRepository.save(missao);
        return missaoMapper.map(missao);
    }

    public List<MissaoDTO> getMissoes() {
        return missaoRepository.findAll().stream().map(missaoMapper::map).toList();
    }

    public MissaoDTO getMissao(Long id) {
        Optional<MissaoModel> missao = missaoRepository.findById(id);
        return missao.map(missaoMapper::map).orElse(null);
    }

    public MissaoDTO updateMissao(Long id, MissaoDTO atualizado) {
        Optional<MissaoModel> missao = missaoRepository.findById(id);
        if(!missao.isPresent()){ return null; }

        MissaoModel missaoAtualizado = missaoMapper.map(atualizado);
        missaoAtualizado.setId(id);
        MissaoModel missaoSalva = missaoRepository.save(missaoAtualizado);

        return missaoMapper.map(missaoSalva);
    }

    public String deleteMissao(Long id) {
        missaoRepository.deleteById(id);
        return "Missao deletada com sucesso";
    }

}


