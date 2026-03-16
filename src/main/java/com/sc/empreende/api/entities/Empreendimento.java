package com.sc.empreende.api.entities;

import java.util.UUID;

import com.sc.empreende.api.shared.SegmentoAtuacao;
import com.sc.empreende.api.shared.StatusEmpreendimento;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_empreendimento")
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class Empreendimento {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "nome_empreendimento", nullable = true)
    private String nomeEmpreendimento;

    @Column(name = "nome_responsavel", nullable = false)
    private String nomeResponsavel;

    @Column(name = "municipio", nullable = false)
    private String municipio;

    @Column(name = "segmento", nullable = false)
    private SegmentoAtuacao segmento;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "status", nullable = false)
    private StatusEmpreendimento status;

    @PrePersist
    protected void onCreate() {
        this.status = StatusEmpreendimento.ATIVO;
    }
}
