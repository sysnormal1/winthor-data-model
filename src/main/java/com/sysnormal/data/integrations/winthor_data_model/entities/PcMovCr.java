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
@Table(name = "PCMOVCR")
@Immutable //not has id column
public class PcMovCr extends BaseEntity {

    @Id
    @Column(name = "ROWID", updatable = false, insertable = false)
    private String rowId;

    @Column(name = "NUMTRANS", nullable = false)
    private Long numTrans;

    @Column(name = "DATA", nullable = false)
    private LocalDateTime data;

    @Column(name = "CODBANCO", nullable = false)
    private Integer codBanco;

    @Column(name = "CODCOB", length = 4, nullable = false)
    private String codCob;

    @Column(name = "HISTORICO", length = 200, nullable = false)
    private String historico;

    @Column(name = "HISTORICO2", length = 200)
    private String historico2;

    @Column(name = "VALOR", nullable = false)
    private BigDecimal valor;

    @Column(name = "TIPO", length = 1, nullable = false)
    private String tipo;

    @Column(name = "NUMCARR")
    private Long numCarr;

    @Column(name = "NUMDOC", length = 20)
    private String numDoc;

    @Column(name = "VLSALDO", nullable = false)
    private BigDecimal vlSaldo;

    @Column(name = "DTCOMPENSACAO")
    private LocalDateTime dtCompensacao;

    @Column(name = "CODFUNCCOMP")
    private Long codFuncComp;

    @Column(name = "HORA", nullable = false)
    private Integer hora;

    @Column(name = "MINUTO", nullable = false)
    private Integer minuto;

    @Column(name = "CODFUNC", nullable = false)
    private Long codFunc;

    @Column(name = "CODCONTADEB")
    private Long codContaDeb;

    @Column(name = "CODCONTACRED")
    private Long codContaCred;

    @Column(name = "INDICE", length = 1, nullable = false)
    private String indice;

    @Column(name = "CODROTINALANC")
    private Long codRotinaLanc;

    @Column(name = "ROTINALANCAMENTO", length = 100)
    private String rotinaLancamento;
}
