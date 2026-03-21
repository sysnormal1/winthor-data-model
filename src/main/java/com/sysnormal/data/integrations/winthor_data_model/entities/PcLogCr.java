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
@Table(name = "PCLOGCR")
@Immutable //not has id column
public class PcLogCr extends BaseEntity {

    @Id
    @Column(name = "ROWID", updatable = false, insertable = false)
    private String rowId;

    @Column(name = "CODCLI", nullable = false)
    private Long codCli;

    @Column(name = "CODFILIAL", length = 2, nullable = false)
    private String codFilial;

    @Column(name = "CODFUNC", nullable = false)
    private Long codFunc;

    @Column(name = "DATA", nullable = false)
    private LocalDateTime data;

    @Column(name = "DUPLIC", nullable = false)
    private Long duplic;

    @Column(name = "NUMTRANSVENDA", nullable = false)
    private Long numTransVenda;

    @Column(name = "PREST", length = 2, nullable = false)
    private String prest;

    @Column(name = "ROTINA", length = 40, nullable = false)
    private String rotina;

    @Column(name = "VLRJUROSCOB")
    private BigDecimal vlrJurosCob;

    @Column(name = "VLRORIGINAL")
    private BigDecimal vlrOriginal;
}
