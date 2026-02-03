package com.sysnormal.libs.db.entities.integrations.winthor_entities;

import com.sysnormal.libs.db.entities.base_entities.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "PCPEDI")
@Immutable // opcional, se só leitura
public class PcPedI extends BaseEntity {

    @Id
    @Column(name = "ROWID", insertable = false, updatable = false)
    private String rowId;

    @Column(name = "NUMPED")
    private Integer numPed;

    @Column(name = "CODPROD")
    private Integer codProd;

    @Column(name = "NUMSEQ")
    private Integer numSeq;

    @Column(name = "DATA")
    private LocalDateTime data;

    @Column(name = "QT")
    private BigDecimal qt;

    @Column(name = "PVENDA")
    private BigDecimal pVenda;

    @Column(name = "PTABELA")
    private BigDecimal pTabela;

    @Column(name = "VLCUSTOFIN")
    private BigDecimal vlCustoFin;

    @Column(name = "VLDESCFIN")
    private BigDecimal vlDescFin;

    @Column(name = "PERDESCFIN")
    private BigDecimal perDescFin;



    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "NUMPED", referencedColumnName = "NUMPED", insertable = false, updatable = false)
    private PcPedC pcPedC;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "CODPROD", referencedColumnName = "CODPROD", insertable = false, updatable = false)
    private PcProdut pcProdut;




    protected static final long TABLE_ID = 30217L;
    public static long getTableId() {
        return TABLE_ID;
    }
}
