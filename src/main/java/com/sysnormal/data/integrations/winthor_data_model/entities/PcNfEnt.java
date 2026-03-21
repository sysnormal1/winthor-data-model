package com.sysnormal.data.integrations.winthor_data_model.entities;

import com.sysnormal.data.base_data_model.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Entity class
 */
@Getter
@Setter
@Entity
@Table(name = "PCNFENT")
@Immutable
public class PcNfEnt extends BaseEntity {

    @Id
    @Column(name = "ROWID", insertable = false, updatable = false)
    private String rowId;

    @Column(name = "NUMTRANSENT")
    private Long numTransEnt;

    @Column(name = "CODCONT")
    private Long codCont;

    @Column(name = "NUMNOTA")
    private Long numNota;

    @Column(name = "ESPECIE")
    private String especie;

    @Column(name = "CHAVENFE")
    private String chaveNfe;

    @Column(name = "CODFILIAL")
    private Long codFilial;

    @Column(name = "CODFISCAL")
    private Integer codFiscal;

    @Column(name = "CODDEVOL")
    private Long codDevol;

    @Column(name = "CODUSURDEVOL")
    private Long codUsurDevol;

    @Column(name = "CODFORNEC")
    private Long codFornec;

    @Column(name = "DTEMISSAO")
    private LocalDateTime dtEmissao;

    @Column(name = "DTENT")
    private LocalDateTime dtEnt;

    @Column(name = "DTCANCEL")
    private LocalDateTime dtCancel;

    @Column(name = "NUMPEDPRINC")
    private Long numPedPrinc;

    @Column(name = "VLDESCFIN")
    private BigDecimal vlDescFin;

    @Column(name = "PERDESCFIN")
    private BigDecimal perDescFin;


    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CODFILIAL", insertable = false, updatable = false)
    private PcFilial filial;*/

    /*
    CODFORNEC CAN BY PCFORNEC OR PCCLIENT (FOR RETURNS)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CODFORNEC", insertable = false, updatable = false)
    private PcFornec ncm;*/

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CODDEVOL", insertable = false, updatable = false)
    private PcTabDev pcTabDev;*/
}
