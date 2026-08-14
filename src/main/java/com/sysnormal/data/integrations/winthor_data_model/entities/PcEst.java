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
 *
 * Estoque por produto e filial. Colunas medidas como sempre vazias nesta base
 * (CUSTOPROXIMACOMPRA, CUSTOFORNEC, QTTRANSITO, QTPENDENTE) ficam de fora de proposito.
 */
@Getter
@Setter
@Entity
@Table(name = "PCEST")
public class PcEst extends BaseEntity {

    @EmbeddedId
    private PcEstId id;

    // saldos
    @Column(name = "QTESTGER")
    private BigDecimal qtEstGer;

    @Column(name = "QTEST")
    private BigDecimal qtEst;

    @Column(name = "QTRESERV")
    private BigDecimal qtReserv;

    @Column(name = "QTBLOQUEADA")
    private BigDecimal qtBloqueada;

    // custos
    @Column(name = "CUSTOREP")
    private BigDecimal custoRep;

    @Column(name = "CUSTOFIN")
    private BigDecimal custoFin;

    @Column(name = "CUSTOCONT")
    private BigDecimal custoCont;

    @Column(name = "CUSTOREAL")
    private BigDecimal custoReal;

    @Column(name = "CUSTOULTENT")
    private BigDecimal custoUltEnt;

    @Column(name = "CUSTOREALLIQ")
    private BigDecimal custoRealLiq;

    @Column(name = "CUSTOFISCAL")
    private BigDecimal custoFiscal;

    // giro e venda
    @Column(name = "QTGIRODIA")
    private BigDecimal qtGiroDia;

    @Column(name = "QTVENDMES")
    private BigDecimal qtVendMes;

    @Column(name = "QTVENDMES1")
    private BigDecimal qtVendMes1;

    @Column(name = "QTVENDMES2")
    private BigDecimal qtVendMes2;

    @Column(name = "QTVENDMES3")
    private BigDecimal qtVendMes3;

    @Column(name = "QTDEVOLMES")
    private BigDecimal qtDevolMes;

    // datas
    @Column(name = "DTULTENT")
    private LocalDateTime dtUltEnt;

    @Column(name = "DTULTSAIDA")
    private LocalDateTime dtUltSaida;

    @Column(name = "DTULTFAT")
    private LocalDateTime dtUltFat;
}
