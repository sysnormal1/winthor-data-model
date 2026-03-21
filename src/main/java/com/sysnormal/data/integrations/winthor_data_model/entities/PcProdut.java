package com.sysnormal.data.integrations.winthor_data_model.entities;

import com.sysnormal.data.base_data_model.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Entity class
 */
@Getter
@Setter
@Entity
@Table(name = "PCPRODUT")
public class PcProdut extends BaseEntity {
    @Id
    @Column(name = "CODPROD")
    private Long codProd;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "UNIDADE")
    private String unidade;

    @Column(name = "EMBALAGEM")
    private String embalagem;

    @Column(name = "NBM")
    private String nbm;

    @Column(name = "CODNCMEX")
    private String codNcmEx;

    @Column(name = "CODFORNEC")
    private Long codFornec;

    @Column(name = "CODEPTO")
    private Long codepto;

    @Column(name = "PESOLIQ")
    private BigDecimal pesoLiq;

    @Column(name = "PESOBRUTO")
    private BigDecimal pesoBruto;

    @Column(name = "PRAZOVAL")
    private Integer prazoVal;

    @Column(name = "DTEXCLUSAO")
    private LocalDateTime dtExclusao;

    @Column(name = "OBS2")
    private String obs2;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CODNCMEX", insertable = false, updatable = false)
    private PcNcm ncm;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CODFORNEC", insertable = false, updatable = false)
    private PcFornec fornecedor;*/
}
