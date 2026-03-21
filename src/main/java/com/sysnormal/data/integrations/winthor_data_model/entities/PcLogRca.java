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
import java.math.BigInteger;
import java.time.LocalDateTime;

/**
 * Entity class
 */
@Getter
@Setter
@Entity
@Table(name = "PCLOGRCA")
@Immutable //not has id column
public class PcLogRca extends BaseEntity {

    @Id
    @Column(name = "ROWID", updatable = false, insertable = false)
    private String rowId;

    @Column(name = "DATA", nullable = false)
    private LocalDateTime data;

    @Column(name = "DTBLOQUEIO")
    private LocalDateTime dtBloqueio;

    @Column(name = "DTBLOQCOMIS")
    private LocalDateTime dtBloqcomis;

    @Column(name = "CODFUNC", nullable = false, precision = 8, scale = 0)
    private Long codFunc;

    @Column(name = "CODUSUR", nullable = false, precision = 8, scale = 0)
    private Long codUsur;

    @Column(name = "ROTINA", nullable = false, precision = 6, scale = 0)
    private Integer rotina;

    @Column(name = "VLCORRENTE", precision = 10, scale = 2)
    private BigDecimal vlCorrente;

    @Column(name = "VLLIMCRED", precision = 10, scale = 2)
    private BigDecimal vlLimCred;

    @Column(name = "VLCORRENTEANT", precision = 10, scale = 2)
    private BigDecimal vlCorrenteAnt;

    @Column(name = "VLLIMCREDANT", precision = 10, scale = 2)
    private BigDecimal vlLimCredAnt;

    @Column(name = "HISTORICO", length = 60)
    private String historico;

    @Column(name = "NUMPED", precision = 10, scale = 0)
    private Long numPed;

    @Column(name = "POSICAO", length = 1)
    private String posicao;

    @Column(name = "NUMTRANSVENDA", precision = 10, scale = 0)
    private Long numTransVenda;

    @Column(name = "NUMTRANSENT", precision = 10, scale = 0)
    private Long numTransEnt;

    @Column(name = "CODPROD", precision = 6, scale = 0)
    private Integer codProd;

    @Column(name = "NUMSEQ", precision = 20, scale = 0)
    private BigInteger numSeq;

    @Column(name = "HISTORICO2", length = 300)
    private String historico2;

    @Column(name = "VLDIFERENCA", precision = 14, scale = 6)
    private BigDecimal vlDiferenca;

    @Column(name = "VLRESERVA", precision = 18, scale = 6)
    private BigDecimal vlReserva;

    @Column(name = "PERCSALDORESERVA", precision = 5, scale = 2)
    private BigDecimal percSaldoReserva;

    @Column(name = "CODFILIAL", length = 2)
    private String codFilial;

    @Column(name = "HISTORICOTRANSF", length = 200)
    private String historicoTransf;

    @Column(name = "SEQLOGRCA", precision = 18, scale = 0)
    private BigDecimal seqLogRca;

    @Column(name = "ION_ID", length = 36)
    private String ionId;
}
