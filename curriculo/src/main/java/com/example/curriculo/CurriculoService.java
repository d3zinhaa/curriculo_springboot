package com.example.curriculo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.curriculo.Curriculo;
import com.example.curriculo.CurriculoRepository;
import lombok.Data;

import java.util.List;
import java.util.Optional;
 
@Data
@Service
public class CurriculoService {
 
    private final CurriculoRepository curriculoRepository;
 
    @Autowired
    public CurriculoService(CurriculoRepository curriculoRepository) {
        this.curriculoRepository = curriculoRepository;
    }
 
    public List<Curriculo> getAllCurriculos() {
        return curriculoRepository.findAll();
    }
 
    public Optional<Curriculo> getCurriculoById(Long id) {
        return curriculoRepository.findById(id);
    }
 
    public Curriculo addCurriculo(Curriculo curriculo) {
        return curriculoRepository.save(curriculo);
    }
 
    public Optional<Curriculo> updateCurriculo(Long id, Curriculo updatedCurriculo) {
        if (curriculoRepository.existsById(id)) {
            updatedCurriculo.setId(id);
            Curriculo savedCurriculo = curriculoRepository.save(updatedCurriculo);
            return Optional.of(savedCurriculo);
        } else {
            return Optional.empty();
        }
    }
 
    public boolean deleteCurriculo(Long id) {
        if (curriculoRepository.existsById(id)) {
            curriculoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}