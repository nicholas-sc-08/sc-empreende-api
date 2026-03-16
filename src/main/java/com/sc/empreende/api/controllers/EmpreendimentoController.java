package com.sc.empreende.api.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sc.empreende.api.dtos.Request.EmpreendimentoCreateDTO;
import com.sc.empreende.api.dtos.Request.EmpreendimentoUpdateDTO;
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
    @Operation(summary = "Cadastrar novo empreendimento", description = "Registra uma nova iniciativa empreendedora no banco de dados de Santa Catarina. O sistema valida campos obrigatórios e garante que o e-mail informado seja único para evitar duplicidade de registros.")
    public ResponseEntity<EmpreendimentoResponseDTO> createEmpreendimento(@Valid @RequestBody EmpreendimentoCreateDTO dto) {
        EmpreendimentoResponseDTO empreendimento = empreendimentoService.createEmpreendimento(dto);
        return ResponseEntity.status(201).body(empreendimento);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar dados do empreendimento", description = "Realiza a atualização integral dos dados de um empreendimento (nome, responsável, município, segmento e e-mail). O sistema valida se o novo e-mail já não está sendo utilizado por outro registro no estado.")
    public ResponseEntity<EmpreendimentoResponseDTO> updateEmpreendimento(@Valid @RequestBody EmpreendimentoUpdateDTO dto, @PathVariable UUID id) {
        EmpreendimentoResponseDTO empreendimento = empreendimentoService.updateEmpreendimento(dto, id);
        return ResponseEntity.status(200).body(empreendimento);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Alternar status (Ativo/Inativo)", description = "Inverte o status atual do empreendimento. Se estiver Ativo, torna-se Inativo, e vice-versa. Ideal para suspender temporariamente operações sem excluir os dados do sistema.")
    public ResponseEntity<EmpreendimentoResponseDTO> updateStatusEmpreendimento(@PathVariable UUID id) {
        EmpreendimentoResponseDTO empreendimento = empreendimentoService.updateStatusEmpreendimento(id);
        return ResponseEntity.status(200).body(empreendimento);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover empreendimento", description = "Exclui permanentemente o registro de um empreendimento do sistema através do seu identificador único (UUID). Esta ação não pode ser desfeita.")
    public ResponseEntity<?> deleteByIdEmpreendimento(@PathVariable UUID id) {
        empreendimentoService.deleteByIdEmpreendimento(id);
        return ResponseEntity.noContent().build();
    }
}
