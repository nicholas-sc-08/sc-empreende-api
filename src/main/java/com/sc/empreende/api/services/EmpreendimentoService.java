package com.sc.empreende.api.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sc.empreende.api.dtos.Request.EmpreendimentoCreateDTO;
import com.sc.empreende.api.dtos.Request.EmpreendimentoUpdateDTO;
import com.sc.empreende.api.dtos.Response.EmpreendimentoResponseDTO;
import com.sc.empreende.api.entities.Empreendimento;
import com.sc.empreende.api.exceptions.EmpreendimentoEmailAlreadyExists;
import com.sc.empreende.api.exceptions.EmpreendimentoNotFoundById;
import com.sc.empreende.api.mappers.EmpreendimentoMapper;
import com.sc.empreende.api.repositories.EmpreendimentoRepository;
import com.sc.empreende.api.shared.StatusEmpreendimento;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpreendimentoService {
    private final EmpreendimentoRepository empreendimentoRepository;
    private final EmpreendimentoMapper empreendimentoMapper;
    private final EmpreendimentoValidator empreendimentoValidator;

    public List<EmpreendimentoResponseDTO> findAllEmpreendimentos() {
        List<Empreendimento> empreendimentos = empreendimentoRepository.findAll();
        return empreendimentos.stream().map(e -> empreendimentoMapper.paraDTO(e)).collect(Collectors.toList());
    }

    public EmpreendimentoResponseDTO findByIdEmpreendimento(UUID id) {
        Empreendimento empreendimento = empreendimentoRepository.findById(id).orElseThrow(() -> new EmpreendimentoNotFoundById("Empreendimento com o id: "+id+" não existe!"));
        return empreendimentoMapper.paraDTO(empreendimento);
    }

    @Transactional
    public EmpreendimentoResponseDTO createEmpreendimento(EmpreendimentoCreateDTO dto) {
        Empreendimento entidade = empreendimentoMapper.paraEntidade(dto);
        empreendimentoRepository.findByEmail(dto.email()).ifPresent(e -> { throw new EmpreendimentoEmailAlreadyExists("Empreendimento com o email "+dto.email()+" já existe!"); });

        Empreendimento empreendimento = empreendimentoRepository.save(entidade);
        
        return empreendimentoMapper.paraDTO(empreendimento);
    }

    @Transactional
    public EmpreendimentoResponseDTO updateEmpreendimento(EmpreendimentoUpdateDTO dto, UUID id) {
        Empreendimento entidade = empreendimentoRepository.findById(id).orElseThrow(() -> new EmpreendimentoNotFoundById("Empreendimento com o id: "+id+" não existe!"));
        empreendimentoValidator.validarAtualizacao(entidade, dto);

        Empreendimento novoEmpreendimento = empreendimentoMapper.paraEntidade(dto, id, entidade.getStatus());

        Empreendimento empreendimento = empreendimentoRepository.save(novoEmpreendimento);
        return empreendimentoMapper.paraDTO(empreendimento);
    }

    @Transactional
    public EmpreendimentoResponseDTO updateStatusEmpreendimento(UUID id) {
        Empreendimento entidade = empreendimentoRepository.findById(id).orElseThrow(() -> new EmpreendimentoNotFoundById("Empreendimento com o id: "+id+" não existe!"));
        empreendimentoValidator.validarStatusEmpreendimento(entidade);
        
        Empreendimento empreendimento = empreendimentoRepository.save(entidade);
        return empreendimentoMapper.paraDTO(empreendimento);
    }

    @Transactional
    public void deleteByIdEmpreendimento(UUID id) {
        empreendimentoRepository.findById(id).orElseThrow(() -> new EmpreendimentoNotFoundById("Empreendimento com o id "+id+" não existe!"));
        empreendimentoRepository.deleteById(id);
    }
}
