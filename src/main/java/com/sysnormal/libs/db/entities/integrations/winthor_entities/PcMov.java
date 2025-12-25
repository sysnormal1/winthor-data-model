package com.sysnormal.libs.db.entities.integrations.winthor_entities;

import com.sysnormal.libs.db.entities.base_entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "PCMOV")
@Immutable // opcional, se só leitura
public class PcMov extends BaseEntity {

    @Id
    @Column(name = "ROWID", insertable = false, updatable = false)
    private String rowId;

    @Column(name = "NUMTRANSITEM", nullable = true)
    private Long numTransItem;

    @Column(name = "NUMTRANSENT", nullable = true)
    private Long numTransEnt;

    @Column(name = "NUMTRANSVENDA", nullable = true)
    private Long numTransVenda;

    @Column(name = "NUMNOTA", nullable = true)
    private Long numNota;

    @Column(name = "CODPROD", nullable = false)
    private Long codProd;

    @Column(name = "NUMSEQ", nullable = true)
    private Integer numSeq;

    @Column(name = "DTMOV")
    private LocalDateTime dtMov;

    @Column(name = "NUMTRANSDEV")
    private Long numTransDev;

    @Column(name = "CODFORNEC")
    private Long codFornec;

    @Column(name = "CODEPTO")
    private Long codepto;

    @Column(name = "UNIDADE")
    private String unidade;

    @Column(name = "CODAUXILIAR")
    private String codAuxiliar;

    @Column(name = "CODFISCAL")
    private Integer codFiscal;

    @Column(name = "CODOPER")
    private String codOper;

    @Column(name = "NBM")
    private Long nbm;

    @Column(name = "QT")
    private BigDecimal qt;

    @Column(name = "CUSTOFIN")
    private BigDecimal custoFin;

    @Column(name = "PUNIT")
    private BigDecimal pUnit;

    @Column(name = "QTCONT")
    private BigDecimal qtCont;

    @Column(name = "PUNITCONT")
    private BigDecimal pUnitCont;

    @Column(name = "PTABELA")
    private BigDecimal pTabela;

    @Column(name = "PESOBRUTO")
    private BigDecimal pesoBruto;

    @Column(name = "PESOLIQ")
    private BigDecimal pesoLiq;

    @Column(name = "CODDEVOL")
    private Integer codDevol;

    @Column(name = "QTDEVOL")
    private BigDecimal qtDevol;

    @Column(name = "PERCDESCFIN")
    private BigDecimal percDescFin;

    @Column(name = "DTCANCEL")
    private LocalDateTime dtCancel;


    protected static final long TABLE_ID = 30213L;
    public static long getTableId() {
        return TABLE_ID;
    }
}
