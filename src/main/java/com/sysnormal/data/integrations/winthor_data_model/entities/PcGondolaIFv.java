package com.sysnormal.data.integrations.winthor_data_model.entities;

import com.sysnormal.data.base_data_model.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Entity class — produto contado na gôndola ({@link PcGondolaFv}).
 *
 * <p>PK: a da contagem mais {@code CODPROD}. {@code TRG_INT_PCGONDOLAIFV} preenche as
 * datas.</p>
 *
 * <p>Os campos têm o nome da coluna em minúsculas, sem camelCase: são 12 colunas de um
 * layout de terceiro, geradas do dicionário do Oracle em 2026-10-19, e o contrato de
 * quem usa a entidade fala o nome da coluna (ver {@code ColunasDoWinthor} no
 * winthor-integration-service). Os comentários dos campos são os da própria coluna no
 * banco.</p>
 */
@Getter
@Setter
@Entity
@IdClass(PcGondolaIFvId.class)
@Table(name = "PCGONDOLAIFV")
public class PcGondolaIFv extends BaseEntity {

    @Id
    @Column(name = "NUMCONTAGEM", nullable = false, precision = 8)
    private Integer numcontagem;

    @Id
    @Column(name = "CODPROD", nullable = false, precision = 6)
    private Integer codprod;

    @Column(name = "QT", nullable = false, precision = 16, scale = 3)
    private BigDecimal qt;

    @Column(name = "PVENDA", nullable = false, precision = 12, scale = 3)
    private BigDecimal pvenda;

    @Id
    @Column(name = "CODUSUR", nullable = false, precision = 4)
    private Integer codusur;

    @Id
    @Column(name = "CGCCLI", nullable = false, length = 18)
    private String cgccli;

    @Column(name = "OBSERVACAO_PC", length = 4000)
    private String observacao_pc;

    /** Data de Inclusão no registro */
    @Column(name = "DTINCLUSAO")
    private LocalDateTime dtinclusao;

    /** Data de Alteração no registro */
    @Column(name = "DTALTERACAO")
    private LocalDateTime dtalteracao;

    /** Quantidade de perdas */
    @Column(name = "QTPERDAS", precision = 16, scale = 3)
    private BigDecimal qtperdas;

    /** Giro Sellout */
    @Column(name = "GIROSELLOUT", precision = 16, scale = 3)
    private BigDecimal girosellout;

    /** Giro Medio */
    @Column(name = "GIROMEDIO", precision = 16, scale = 3)
    private BigDecimal giromedio;
}
