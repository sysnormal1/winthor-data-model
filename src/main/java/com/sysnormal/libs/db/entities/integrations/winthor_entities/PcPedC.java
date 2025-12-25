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
@Table(name = "PCPEDC")
public class PcPedC extends BaseEntity {
    @Id
    @Column(name = "NUMPED")
    private Long numPed;

    @Column(name = "NUMTRANSVENDA")
    private Long numTransVenda;

    @Column(name = "CODFILIAL")
    private Integer codFilial;

    @Column(name = "CODCLI")
    private Integer codCli;

    @Column(name = "CODUSUR")
    private Integer codUsur;

    @Column(name = "ORIGEMPED")
    private String origemPed;

    @Column(name = "CONDVENDA")
    private Integer condVenda;

    @Column(name = "NUMNOTA")
    private Long numNota;

    @Column(name = "DATA")
    private LocalDateTime data;

    @Column(name = "CHAVENFE")
    private String chaveNfe;

    @Column(name = "NUMCAR")
    private Long numCar;

    @Column(name = "VALORDESCFIN")
    private BigDecimal valorDescFin;

    @Column(name = "PERDESCFIN")
    private BigDecimal perDescFin;

    @Column(name = "DTCANCEL")
    private LocalDateTime dtCancel;

    protected static final long TABLE_ID = 30216L;
    public static long getTableId() {
        return TABLE_ID;
    }
}
