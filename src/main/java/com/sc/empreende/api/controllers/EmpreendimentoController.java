package com.sc.empreende.api.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sc.empreende.api.dtos.Request.EmpreendimentoCreateDTO;
import com.sc.empreende.api.dtos.Response.EmpreendimentoResponseDTO;
import com.sc.empreende.api.services.EmpreendimentoService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/empreendimento")
public class EmpreendimentoController {
    private final EmpreendimentoService empreendimentoService;

    @GetMapping
    @Operation(summary = "Lista todos os empreendimentos", description = "Retorna uma lista completa de todos os empreendimentos cadastrados no ecossistema de Santa Catarina, incluindo detalhes de responsáveis e segmentos.")
    public ResponseEntity<List<EmpreendimentoResponseDTO>> findAllEmpreendimentos() {
        List<EmpreendimentoResponseDTO> empreendimentos = empreendimentoService.findAllEmpreendimentos();
        return ResponseEntity.status(200).body(empreendimentos);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar empreendimento por ID", description = "Recupera os detalhes específicos de um único empreendimento catarinense através do seu identificador único (UUID).")
    public ResponseEntity<EmpreendimentoResponseDTO> findByIdEmpreendimento(@PathVariable UUID id) {
        EmpreendimentoResponseDTO empreendimento = empreendimentoService.findByIdEmpreendimento(id);
        return ResponseEntity.status(200).body(empreendimento);
    }

    @PostMapping
    public ResponseEntity<EmpreendimentoResponseDTO> createEmpreendimento(@Valid @RequestBody EmpreendimentoCreateDTO dto) {
        EmpreendimentoResponseDTO empreendimento = empreendimentoService.createEmpreendimento(dto);
        return ResponseEntity.status(201).body(empreendimento);
    }
}
