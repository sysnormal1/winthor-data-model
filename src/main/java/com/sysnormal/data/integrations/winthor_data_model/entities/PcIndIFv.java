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
 * Entity class — item da troca ou indenização da força de vendas ({@link PcIndCFv}).
 *
 * <p>PK {@code CODINDENIZ, CODPROD}: um produto aparece uma vez por indenização.
 * {@code TRG_INT_PCINDIFV} preenche {@code DTINCLUSAO} e {@code DTALTERACAO}.</p>
 *
 * <p>Os campos têm o nome da coluna em minúsculas, sem camelCase: são 9 colunas de um
 * layout de terceiro, geradas do dicionário do Oracle em 2026-10-19, e o contrato de
 * quem usa a entidade fala o nome da coluna (ver {@code ColunasDoWinthor} no
 * winthor-integration-service). Os comentários dos campos são os da própria coluna no
 * banco.</p>
 */
@Getter
@Setter
@Entity
@IdClass(PcIndIFvId.class)
@Table(name = "PCINDIFV")
public class PcIndIFv extends BaseEntity {

    @Id
    @Column(name = "CODINDENIZ", nullable = false, precision = 10)
    private Long codindeniz;

    @Id
    @Column(name = "CODPROD", nullable = false, precision = 6)
    private Integer codprod;

    @Column(name = "QT", nullable = false, precision = 20, scale = 6)
    private BigDecimal qt;

    @Column(name = "PVENDA", nullable = false, precision = 12, scale = 3)
    private BigDecimal pvenda;

    @Column(name = "OBS", length = 60)
    private String obs;

    @Column(name = "OBSERVACAO_PC", length = 4000)
    private String observacao_pc;

    /** Data de Inclusão no registro */
    @Column(name = "DTINCLUSAO")
    private LocalDateTime dtinclusao;

    /** Data de Alteração no registro */
    @Column(name = "DTALTERACAO")
    private LocalDateTime dtalteracao;

    /** Informa se o produto avariado é para ser recolhido. */
    @Column(name = "RECOLHER", length = 1)
    private String recolher;
}
