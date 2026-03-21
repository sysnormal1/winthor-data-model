package com.sysnormal.data.integrations.winthor_data_model.entities;

import com.sysnormal.data.base_data_model.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
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
@Table(name = "PCPREST")
public class PcPrest extends BaseEntity {

    @EmbeddedId
    private PcPrestId id;

    @Column(name = "CODCOB", length = 4, nullable = false)
    private String codCob;

    @Column(name = "CODFILIAL", length = 2, nullable = false)
    private String CodFilial;

    @Column(name = "DUPLIC", nullable = false)
    private Long Duplic;

    @Column(name = "CODCLI", nullable = false)
    private Long CodCli;

    @Column(name = "VALOR", nullable = false)
    private BigDecimal valor;

    @Column(name = "DTPAG")
    private LocalDateTime dtPag;

    @Column(name = "VPAGO")
    private BigDecimal vPago;

    @Column(name = "TXPERM")
    private BigDecimal txPerm;

    @Column(name = "VALORDESC")
    private BigDecimal valorDesc;

    @Column(name = "PERDESC")
    private BigDecimal perDesc;

    @Column(name = "VALORMULTA")
    private BigDecimal valorMulta;

    @Column(name = "VLRDESPBANCARIAS")
    private BigDecimal vlrDespBancarias;

    @Column(name = "VLRDESPCARTORAIS")
    private BigDecimal vlrDespCartorais;

    @Column(name = "VLROUTROSACRESC")
    private BigDecimal vlrOutrosAcresc;

    @Column(name = "VLRTOTDESPESASEJUROS")
    private BigDecimal vlrTotDespesasEJuros;

    @Column(name = "DTVENCVALE")
    private LocalDateTime dtVencVale;

    @Column(name = "CODHISTVALE")
    private Integer codHistVale;

    @Column(name = "CODFUNCVALE")
    private Integer codFuncVale;

    @Column(name = "DTULTALTER")
    private LocalDateTime dtUltAlter;

    @Column(name = "CODFUNCULTALTER")
    private Integer codFuncUltAlter;

    @Column(name = "DTBAIXA")
    private LocalDateTime dtBaixa;

    @Column(name = "CODBAIXA")
    private Integer codBaixa;

    @Column(name = "DTFECHA")
    private LocalDateTime dtFecha;

    @Column(name = "DTCXMOT")
    private LocalDateTime dtCxMot;

    @Column(name = "CODFUNCCXMOT")
    private Integer codFuncCxMot;

    @Column(name = "CARTORIO", length = 1)
    private String cartorio;

    @Column(name = "PROTESTO", length = 1)
    private String protesto;

    @Column(name = "OBS2", length = 100)
    private String obs2;

    @Column(name = "OBSTITULO", length = 1000)
    private String obsTitulo;

    @Column(name = "CODBANCO")
    private Integer codBanco;

    @Column(name = "CODBARRA", length = 44)
    private String codBarra;

    @Column(name = "LINHADIG", length = 65)
    private String linhaDig;

    @Column(name = "CODCOBBANCO", length = 4)
    private String codCobBanco;

    @Column(name = "NUMDIASCARENCIA")
    private Integer numDiasCarencia;

    @Column(name = "DATAHORAMINUTOBAIXA")
    private LocalDateTime dataHoraMinutoBaixa;

    @Column(name = "CODFUNCFECHA")
    private Integer codFuncFecha;

    @Column(name = "NUMTRANS")
    private Long numTrans;

    @Column(name = "ROTINALANCULTALT", length = 48)
    private String rotinaLancUltAlt;

    @Column(name = "ROTINAPAG", length = 100)
    private String rotinaPag;

    @Column(name = "ROTINAFECHA", length = 100)
    private String rotinaFecha;

    @Column(name = "DTCANCEL")
    private LocalDateTime dtCancel;
}
