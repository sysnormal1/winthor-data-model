package com.sysnormal.data.integrations.winthor_data_model.entities;

import com.sysnormal.data.base_data_model.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Entity class
 */
@Getter
@Setter
@Entity
@Table(name = "PCSUPERV")
public class PcSuperv extends BaseEntity {
    @Id
    @Column(name = "CODSUPERVISOR")
    private Long codSupervisor;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "CODGERENTE")
    private Long codGerente;

    @Column(name = "POSICAO")
    private String posicao;

    @Column(name = "CPF")
    private String cpf;

    @Column(name = "TIPOSUPERVISOR")
    private String tipoSupervisor;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "DTDEMISSAO")
    private LocalDateTime dtDemissao;
}
