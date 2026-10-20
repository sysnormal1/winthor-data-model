package com.sysnormal.data.integrations.winthor_data_model.entities;

import com.sysnormal.data.base_data_model.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Entity class — vencimento (parcela) do pedido de força de vendas ({@link PcPedCFv}).
 *
 * <p>PK: a do cabeçalho mais {@code NUMPARCELA}. Vazia nesta base em 2026-10-19.</p>
 *
 * <p>Os campos têm o nome da coluna em minúsculas, sem camelCase: são 6 colunas de um
 * layout de terceiro, geradas do dicionário do Oracle em 2026-10-19, e o contrato de
 * quem usa a entidade fala o nome da coluna (ver {@code ColunasDoWinthor} no
 * winthor-integration-service). Os comentários dos campos são os da própria coluna no
 * banco.</p>
 */
@Getter
@Setter
@Entity
@IdClass(PcPedCVctoFvId.class)
@Table(name = "PCPEDCVCTOFV")
public class PcPedCVctoFv extends BaseEntity {

    @Id
    @Column(name = "NUMPEDRCA", nullable = false, precision = 10)
    private Long numpedrca;

    @Id
    @Column(name = "CODUSUR", nullable = false, precision = 4)
    private Integer codusur;

    @Id
    @Column(name = "CGCCLI", nullable = false, length = 18)
    private String cgccli;

    @Id
    @Column(name = "DTABERTURAPEDPALM", nullable = false)
    private LocalDateTime dtaberturapedpalm;

    /** Número da parcela */
    @Id
    @Column(name = "NUMPARCELA", nullable = false, precision = 10)
    private Long numparcela;

    /** Data de vencimento */
    @Column(name = "DTVENC")
    private LocalDateTime dtvenc;
}
