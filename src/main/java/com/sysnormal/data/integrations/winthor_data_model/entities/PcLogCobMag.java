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
import java.time.LocalDate;

/**
 * Entity class
 */
@Getter
@Setter
@Entity
@Table(name = "PCLOGCOBMAG")
@Immutable
public class PcLogCobMag extends BaseEntity {

    @Id
    @Column(name = "ROWID", insertable = false, updatable = false)
    private String rowId;

    @Column(name = "CODSUBOCORRENCIA")
    private String codsubocorrencia;

    @Column(name = "CODOCORRENCIA")
    private String codocorrencia;

    @Column(name= "NUMTRANSVENDAS")
    private Long numtransvendas;

    @Column(name = "DATA")
    private LocalDate data;

    @Column(name = "CODFUNC")
    private Long codFunc;

    @Column(name = "CODFILIAL")
    private Long codFilial;

    @Column(name = "CODBANCO")
    private Long codBanco;

    @Column(name = "PREST")
    private String prest;

    @Column(name = "VLCUSTAS")
    private BigDecimal vlCustas;

    @Column(name = "VLDESPESAS")
    private BigDecimal vlDespesas;

    @Column(name = "CODFILIALCM")
    private String codFilialCm;

    @Column(name = "DTGERACAO")
    private LocalDate dtGeracao;

    @Column(name = "NOSSONUMBCO")
    private String nossoNumBco;

    @Column(name = "ARQRETORNO")
    private String arqRetorno;

    @Column(name = "USUARIO")
    private String usuario;

    @Column(name = "MAQUINA")
    private Long rotinaLanc;
}
