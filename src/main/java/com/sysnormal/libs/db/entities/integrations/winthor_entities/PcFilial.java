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

    protected static final long TABLE_ID = 30011L;
    public static long getTableId() {
        return TABLE_ID;
    }
}
