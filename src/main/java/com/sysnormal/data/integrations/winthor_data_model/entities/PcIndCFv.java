package com.sysnormal.data.integrations.winthor_data_model.entities;

import com.sysnormal.data.base_data_model.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Entity class — troca ou indenização enviada pela força de vendas, sobre um pedido que
 * já está no {@code PCPEDC}.
 *
 * <p>Lida pela package {@code IMPORTARINDENIZACOES} ({@code p_tiporeg} 6), que acha o
 * pedido por {@code NUMPEDRCA + CODUSUR + CODCLI} (sem pedido complementar e sem brinde),
 * aceita uma só por pedido e grava o {@code PCINDC}. {@code TIPOINDENIZ} é {@code I}
 * (indenização) ou {@code T} (troca, que exige pedido bonificado). Devolve aqui
 * {@code IMPORTADO}, {@code OBSERVACAO_PC} e {@code NUMINDENIZ}.</p>
 *
 * <p>⚠️ A indenização ({@code I}) gera lançamento financeiro: a package tira o
 * {@code PROXNUMLANC} do {@code PCCONSUM} e grava o {@code PCLANC}.</p>
 *
 * <p>{@code CODINDENIZ} é PK global, sem sequence. A trava da package
 * ({@code func_lockindenizacao}) acha a linha por {@code NUMPEDRCA, CODUSUR, DATA,
 * CGCCLI}: com {@code DATA} nula ela não trava, e a linha não é processada.
 * {@code TRG_INT_PCINDCFV} preenche {@code DTINCLUSAO} e {@code DTALTERACAO}. Uma linha
 * só nesta base, de 2020 (medido em 2026-10-20).</p>
 *
 * <p>Os campos têm o nome da coluna em minúsculas, sem camelCase: são 15 colunas de um
 * layout de terceiro, geradas do dicionário do Oracle em 2026-10-19, e o contrato de
 * quem usa a entidade fala o nome da coluna (ver {@code ColunasDoWinthor} no
 * winthor-integration-service). Os comentários dos campos são os da própria coluna no
 * banco.</p>
 */
@Getter
@Setter
@Entity
@Table(name = "PCINDCFV")
public class PcIndCFv extends BaseEntity {

    @Id
    @Column(name = "CODINDENIZ", nullable = false, precision = 10)
    private Long codindeniz;

    @Column(name = "DATA")
    private LocalDateTime data;

    @Column(name = "CGCCLI", nullable = false, length = 18)
    private String cgccli;

    @Column(name = "CODFILIAL", nullable = false, length = 2)
    private String codfilial;

    @Column(name = "NUMPEDRCA", nullable = false, precision = 10)
    private Long numpedrca;

    @Column(name = "TIPOINDENIZ", nullable = false, length = 1)
    private String tipoindeniz;

    @Column(name = "CODUSUR", nullable = false, precision = 4)
    private Integer codusur;

    @Column(name = "OBS", length = 80)
    private String obs;

    @Column(name = "OBSERVACAO_PC", length = 4000)
    private String observacao_pc;

    @Column(name = "IMPORTADO", precision = 1)
    private Integer importado;

    /** Grava Data e Hora da Última Importação. */
    @Column(name = "DTINCLUSAO")
    private LocalDateTime dtinclusao;

    /** Codigo do cliente que será usado em conjunto com o campo cnpj para identificar o cliente no caso de ter no cadastro mais de um cliente com mesmo cnpj */
    @Column(name = "CODCLI", precision = 6)
    private Integer codcli;

    /** Data de Alteração no registro */
    @Column(name = "DTALTERACAO")
    private LocalDateTime dtalteracao;

    /** Número da indenização gravada na pcindc. */
    @Column(name = "NUMINDENIZ", precision = 10)
    private Long numindeniz;

    /** Flag utilizado pelos fornecedores de FV. */
    @Column(name = "RETORNO", precision = 4)
    private Integer retorno;
}
