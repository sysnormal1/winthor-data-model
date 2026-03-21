package com.sysnormal.data.integrations.winthor_data_model.entities;

import com.sysnormal.data.base_data_model.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Entity class
 */
@Getter
@Setter
@Entity
@Table(name = "PCGERENTE")
public class PcGerente extends BaseEntity {

    @Id
    @Column(name = "CODGERENTE")
    private Long codGerente;

    @Column(name = "NOMEGERENTE")
    private String nomeGerente;

    @Column(name = "VLCORRENTE")
    private BigDecimal vlCorrente;

    @Column(name = "VLLIMCRED")
    private BigDecimal vlLimCred;

    @Column(name = "USADEBCRED")
    private String usaDebCred;

    @Column(name = "COD_CADRCA")
    private Long codCadRca;

    @Column(name = "CPF")
    private String cpf;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "TIPO")
    private String tipo;

    @Column(name = "CODGERENTESUPERIOR")
    private Long codGerenteSuperior;
}
