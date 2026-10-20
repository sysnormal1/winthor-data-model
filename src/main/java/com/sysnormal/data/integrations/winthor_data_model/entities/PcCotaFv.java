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
 * Entity class — cotação de preço de concorrente feita pelo RCA num cliente, enviada pela
 * força de vendas.
 *
 * <p>Lida pela {@code IMPORTARCADASTROS} ({@code p_tiporeg} 8), que grava o
 * {@code PCCOTA}. ⚠️ {@code CODCONC} é obrigatório e a package o confere no
 * {@code PCCONCOR}, que está vazio nesta base: até alguém cadastrar concorrente, toda
 * cotação é recusada. Vazia, como o {@code PCCOTA} (medido em 2026-10-20).</p>
 *
 * <p>Os campos têm o nome da coluna em minúsculas, sem camelCase: são 32 colunas de um
 * layout de terceiro, geradas do dicionário do Oracle em 2026-10-19, e o contrato de
 * quem usa a entidade fala o nome da coluna (ver {@code ColunasDoWinthor} no
 * winthor-integration-service). Os comentários dos campos são os da própria coluna no
 * banco.</p>
 */
@Getter
@Setter
@Entity
@IdClass(PcCotaFvId.class)
@Table(name = "PCCOTAFV")
public class PcCotaFv extends BaseEntity {

    /** Código do produto */
    @Id
    @Column(name = "CODPROD", nullable = false, precision = 8)
    private Integer codprod;

    /** Sequencial do produto */
    @Id
    @Column(name = "NUMSEQ", nullable = false, precision = 20)
    private Long numseq;

    /** Codigo do Concorrente */
    @Id
    @Column(name = "CODCONC", nullable = false, length = 40)
    private String codconc;

    /** CGC do cliente */
    @Id
    @Column(name = "CGCCLI", nullable = false, length = 18)
    private String cgccli;

    /** Codigo do rca */
    @Id
    @Column(name = "CODUSUR", nullable = false, precision = 8)
    private Integer codusur;

    /** Data */
    @Id
    @Column(name = "DATA", nullable = false)
    private LocalDateTime data;

    /** Codigo do cliente */
    @Column(name = "CODCLI", precision = 8)
    private Integer codcli;

    /** Mensagem de retorno da package */
    @Column(name = "OBSERVACAO_PC", length = 300)
    private String observacao_pc;

    /** Flag de controle de importação */
    @Column(name = "IMPORTADO", nullable = false, precision = 1)
    private Integer importado;

    /** Preço cotado */
    @Column(name = "PUNIT", nullable = false, precision = 18, scale = 6)
    private BigDecimal punit;

    /** Numero da regiao */
    @Column(name = "NUMREGIAO", nullable = false, precision = 4)
    private Integer numregiao;

    /** Codigo da Filial */
    @Column(name = "CODFILIAL", length = 2)
    private String codfilial;

    /** Preço de tabela do produto cotado */
    @Column(name = "PTABELA", precision = 18, scale = 6)
    private BigDecimal ptabela;

    /** Codigo do plano de pagamento */
    @Column(name = "CODPLPAG", nullable = false, precision = 4)
    private Integer codplpag;

    /** Custo Financeiro */
    @Column(name = "CUSTOFIN", precision = 18, scale = 6)
    private BigDecimal custofin;

    /** Custo Real */
    @Column(name = "CUSTOREAL", precision = 18, scale = 6)
    private BigDecimal custoreal;

    /** Prazo */
    @Column(name = "PRAZO", precision = 4)
    private Integer prazo;

    /** Data Documento */
    @Column(name = "DATADOC")
    private LocalDateTime datadoc;

    /** Preço concorrente 1 */
    @Column(name = "PRECOCON1", precision = 10, scale = 2)
    private BigDecimal precocon1;

    /** Preço concorrente 2 */
    @Column(name = "PRECOCON2", precision = 10, scale = 2)
    private BigDecimal precocon2;

    /** Preço concorrente 3 */
    @Column(name = "PRECOCON3", precision = 10, scale = 2)
    private BigDecimal precocon3;

    /** Preço concorrente 4 */
    @Column(name = "PRECOCON4", precision = 10, scale = 2)
    private BigDecimal precocon4;

    /** Preço concorrente 5 */
    @Column(name = "PRECOCON5", precision = 10, scale = 2)
    private BigDecimal precocon5;

    /** observação */
    @Column(name = "OBS", length = 30)
    private String obs;

    /** Observação 2 */
    @Column(name = "OBS2", length = 500)
    private String obs2;

    /** Flag de indicação de estoque */
    @Column(name = "ESTOQUE", length = 1)
    private String estoque;

    /** Codigo Auxiliar */
    @Column(name = "CODAUXILIAR", precision = 20)
    private Long codauxiliar;

    /** Lista */
    @Column(name = "LISTA", precision = 6)
    private Integer lista;

    /** Percentual Maximo de desconto do Mercado */
    @Column(name = "PERCMAXDESCMERCADO", precision = 7, scale = 4)
    private BigDecimal percmaxdescmercado;

    /** Codigo do produto no concorrente */
    @Column(name = "CODPRODCONC", precision = 6)
    private Integer codprodconc;

    /** Data de inclusão da Cotação */
    @Column(name = "DTINCLUSAO")
    private LocalDateTime dtinclusao;

    /** Data de Alteração da Cotação */
    @Column(name = "DTALTERACAO")
    private LocalDateTime dtalteracao;
}
