package com.sysnormal.libs.db.entities.integrations.winthor_entities;

import com.sysnormal.libs.db.entities.base_entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

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

    protected static final long TABLE_ID = 30089L;
    public static long getTableId() {
        return TABLE_ID;
    }
}
