package com.sysnormal.libs.db.entities.integrations.winthor_entities;

import com.sysnormal.libs.db.entities.base_entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

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


    protected static final long TABLE_ID = 30088L;
    public static long getTableId() {
        return TABLE_ID;
    }
}
