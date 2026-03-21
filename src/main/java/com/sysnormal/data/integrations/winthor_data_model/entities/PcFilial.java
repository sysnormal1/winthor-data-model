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
@Table(name = "PCFILIAL")
public class PcFilial extends BaseEntity {
    @Id
    @Column(name = "CODIGO")
    private Long codigo;

    @Column(name = "CIDADE")
    private String cidade;

    @Column(name = "CGC")
    private String cgc;

    @Column(name = "RAZAOSOCIAL")
    private String razaoSocial;

    @Column(name = "FANTASIA")
    private String fantasia;

    @Column(name = "UF")
    private String uf;

    @Column(name = "CODCLI")
    private String codCli;

    @Column(name = "TIPOFILIAL")
    private Integer tipoFilial;

    @Column(name = "DTEXCLUSAO")
    private LocalDateTime dtExclusao;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CODCLI", insertable = false, updatable = false)
    private PcClient cliente;*/
}
