package com.sysnormal.libs.db.entities.integrations.winthor_entities;


import com.sysnormal.libs.db.entities.base_entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Immutable;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "PCLOGDEBCRED")
@Immutable //not has id column
public class PcLogDebCred extends BaseEntity {

    @Id
    @Column(name = "ROWID", updatable = false, insertable = false)
    private String rowId;

    @Column(name = "DATA")
    private LocalDateTime data;

    @Column(name = "DTBLOQUEIO")
    private LocalDateTime dtBloqueio;

    @Column(name = "DTBLOQCOMIS")
    private LocalDateTime dtBloqComis;

    @Column(name = "CODFUNC", precision = 8, scale = 0)
    private Long codFunc;

    @Column(name = "CODIGO", precision = 8, scale = 0)
    private Long codigo;

    @Column(name = "ROTINA", precision = 6, scale = 0)
    private Integer rotina;

    @Column(name = "VLCORRENTE", precision = 22, scale = 6)
    @ColumnDefault("0")
    private BigDecimal vlCorrente = BigDecimal.ZERO;

    @Column(name = "VLLIMCRED", precision = 22, scale = 6)
    @ColumnDefault("0")
    private BigDecimal vlLimCred = BigDecimal.ZERO;

    @Column(name = "VLCORRENTEANT", precision = 22, scale = 6)
    @ColumnDefault("0")
    private BigDecimal vlCorrenteAnt =  BigDecimal.ZERO;

    @Column(name = "VLLIMCREDANT", precision = 22, scale = 6)
    @ColumnDefault("0")
    private BigDecimal vlLimCredAnt =  BigDecimal.ZERO;

    @Column(name = "HISTORICO", length = 300)
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

    @Column(name = "VLDIFERENCA", precision = 22, scale = 6)
    @ColumnDefault("0")
    private BigDecimal vlDiferenca = BigDecimal.ZERO;

    @Column(name = "VLRESERVA", precision = 22, scale = 6)
    @ColumnDefault("0")
    private BigDecimal vlReserva = BigDecimal.ZERO;

    @Column(name = "PERCSALDORESERVA", precision = 22, scale = 6)
    @ColumnDefault("0")
    private BigDecimal percSaldoReserva = BigDecimal.ZERO;

    @Column(name = "CODFILIAL", length = 2)
    private String codFilial;

    @Column(name = "PVENDA", precision = 22, scale = 6)
    @ColumnDefault("0")
    private BigDecimal pVenda = BigDecimal.ZERO;

    @Column(name = "ST", precision = 22, scale = 6)
    @ColumnDefault("0")
    private BigDecimal st =  BigDecimal.ZERO;

    @Column(name = "PBASERCA", precision = 22, scale = 6)
    @ColumnDefault("0")
    private BigDecimal pBaseRca =  BigDecimal.ZERO;

    @Column(name = "STPBASERCA", precision = 22, scale = 6)
    @ColumnDefault("0")
    private BigDecimal stpBaseRca =   BigDecimal.ZERO;

    @Column(name = "PTABELA", precision = 22, scale = 6)
    @ColumnDefault("0")
    private BigDecimal pTabela = BigDecimal.ZERO;

    @Column(name = "STPTABELA", precision = 22, scale = 6)
    @ColumnDefault("0")
    private BigDecimal stpTabela = BigDecimal.ZERO;

    @Column(name = "BONIFC", precision = 22, scale = 6)
    @ColumnDefault("0")
    private BigDecimal bonifc = BigDecimal.ZERO;

    @Column(name = "QT", precision = 22, scale = 6)
    @ColumnDefault("0")
    private BigDecimal qt = BigDecimal.ZERO;

    @Column(name = "USADEBCREDBRINDE", length = 1)
    @ColumnDefault("N")
    private String usaDebCredBrinde = "N";

    @Column(name = "MOVIMENTACAOCONTACORRENTE", length = 1)
    private String movimentacaoContaCorrente;

    @Column(name = "AUTORIZEDICAOITEMPEDMED", length = 1)
    private String autorizaEdicaoItemPedMed;

    @Column(name = "MOTIVOAUTORIZEDICAOITEMPEDMED", length = 200)
    private String motivoAutorizEdicaoItemPedMed;

    @Column(name = "CODFUNCAUTORIZEDICAOITEMPEDMED", precision = 8, scale = 0)
    private Long codFuncAutorizEdicaoItemPedMed;

    @Column(name = "TIPOCONTACORRENTE", length = 1)
    private String tipoContaCorrente;

    protected static final long TABLE_ID = 30093L;
    public static long getTableId() {
        return TABLE_ID;
    }
}
