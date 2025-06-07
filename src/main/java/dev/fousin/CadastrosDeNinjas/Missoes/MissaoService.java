package dev.fousin.CadastrosDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissaoService {
    MissaoRepository missaoRepository;

    public MissaoService(MissaoRepository missaoRepository) {
        this.missaoRepository = missaoRepository;
    }

    public MissaoModel createMissao(MissaoModel missao) {
        return missaoRepository.save(missao);
    }

    public List<MissaoModel> getMissoes() {
        return missaoRepository.findAll();
    }

    public MissaoModel getMissao(Long id) {
        return missaoRepository.findById(id).orElse(null);
    }

    public MissaoModel updateMissao(Long id, MissaoModel atualizado) {
        MissaoModel missao = getMissao(id);
        if (missao == null) {
            return null;
        }

        missao.setNome(atualizado.getNome());
        missao.setDificuldade(atualizado.getDificuldade());
        missao.setNinjas(atualizado.getNinjas());

        return missaoRepository.save(missao);
    }

    public String deleteMissao(Long id) {
        MissaoModel missao = getMissao(id);
        if (missao == null) {
            return "Missão não encontrada";
        }

        missaoRepository.delete(missao);
        return "Missão deletada com sucesso";
    }

}


