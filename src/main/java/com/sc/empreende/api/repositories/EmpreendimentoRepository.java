package com.sc.empreende.api.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sc.empreende.api.entities.Empreendimento;

@Repository
public interface EmpreendimentoRepository extends JpaRepository<Empreendimento, UUID>{
    public Optional<Empreendimento> findByEmail(String email);
}
