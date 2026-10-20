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
 * Entity class — contagem de gôndola feita pelo RCA num cliente, enviada pela força de
 * vendas.
 *
 * <p>Lida pela {@code IMPORTARCADASTROS} ({@code p_tiporeg} 4), que confere o cliente, o
 * concorrente ({@code CODCONC}, em {@code PCCONCOR}) e os produtos, recusa contagem com o
 * mesmo {@code NUMCONTAGEM}, {@code CODUSUR} e cliente que o {@code PCGONDOLAC} já tenha, e
 * grava o {@code PCGONDOLAC}. {@code TRG_INT_PCGONDOLAFV} preenche as datas. Vazia nesta
 * base, como o {@code PCGONDOLAC} e o {@code PCCONCOR} (medido em 2026-10-20).</p>
 *
 * <p>Os campos têm o nome da coluna em minúsculas, sem camelCase: são 13 colunas de um
 * layout de terceiro, geradas do dicionário do Oracle em 2026-10-19, e o contrato de
 * quem usa a entidade fala o nome da coluna (ver {@code ColunasDoWinthor} no
 * winthor-integration-service). Os comentários dos campos são os da própria coluna no
 * banco.</p>
 */
@Getter
@Setter
@Entity
@IdClass(PcGondolaFvId.class)
@Table(name = "PCGONDOLAFV")
public class PcGondolaFv extends BaseEntity {

    @Column(name = "IMPORTADO", precision = 1)
    private Integer importado;

    @Id
    @Column(name = "NUMCONTAGEM", nullable = false, precision = 8)
    private Integer numcontagem;

    @Column(name = "DTCONTAGEM")
    private LocalDateTime dtcontagem;

    @Id
    @Column(name = "CODUSUR", nullable = false, precision = 4)
    private Integer codusur;

    @Id
    @Column(name = "CGCCLI", nullable = false, length = 18)
    private String cgccli;

    @Column(name = "CODCONC", length = 4)
    private String codconc;

    @Column(name = "HORAINICIAL", precision = 2)
    private Integer horainicial;

    @Column(name = "HORAFINAL", precision = 2)
    private Integer horafinal;

    @Column(name = "OBSERVACAO_PC", length = 4000)
    private String observacao_pc;

    @Column(name = "DTINCLUSAO")
    private LocalDateTime dtinclusao;

    /** Codigo do cliente que será usado em conjunto com o campo cnpj para identificar o cliente no caso de ter no cadastro mais de um cliente com mesmo cnpj */
    @Column(name = "CODCLI", precision = 6)
    private Integer codcli;

    /** Data de Alteração no registro */
    @Column(name = "DTALTERACAO")
    private LocalDateTime dtalteracao;

    /** Numero da visita */
    @Column(name = "NUMVISITA", precision = 10)
    private Long numvisita;
}
