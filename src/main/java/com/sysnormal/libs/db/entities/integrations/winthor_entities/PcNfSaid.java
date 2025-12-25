package com.sysnormal.libs.db.entities.integrations.winthor_entities;

import com.sysnormal.libs.db.entities.base_entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "PCNFSAID")
public class PcNfSaid extends BaseEntity {
    @Id
    @Column(name = "NUMTRANSVENDA")
    private Long numTransVenda;

    @Column(name = "NUMNOTA")
    private Long numNota;

    @Column(name = "ESPECIE")
    private String especie;

    @Column(name = "CONDVENDA")
    private Integer condVenda;

    @Column(name = "CHAVENFE")
    private String chaveNfe;

    @Column(name = "CODFISCAL")
    private Integer codFiscal;

    @Column(name = "CODFISCALNF")
    private Integer codFiscalNf;

    @Column(name = "CODFILIAL")
    private Long codFilial;

    @Column(name = "NUMCAR")
    private Long numCar;

    @Column(name = "CODDEVOL")
    private Long codDevol;

    @Column(name = "CODUSUR")
    private Long codUsur;

    @Column(name = "CODCLI")
    private Long codCli;

    @Column(name = "CODFORNEC")
    private Long codFornec;

    @Column(name = "DTSAIDA")
    private LocalDateTime dtSaida;

    @Column(name = "DTCANCEL")
    private LocalDateTime dtCancel;

    @Column(name = "NUMPED")
    private Long numPed;

    @Column(name = "VLDESCFIN")
    private BigDecimal vlDescFin;

    @Column(name = "PERDESCFIN")
    private BigDecimal perDescFin;

    protected static final long TABLE_ID = 30211L;
    public static long getTableId() {
        return TABLE_ID;
    }
}
