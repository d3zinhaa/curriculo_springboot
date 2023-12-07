package com.example.curriculo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.curriculo.Curriculo;

@Repository
public interface CurriculoRepository extends JpaRepository<Curriculo, Long> {
    // você pode adicionar métodos personalizados aqui, se necessário
}