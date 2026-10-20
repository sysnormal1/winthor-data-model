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
 * Entity class — retorno, para a força de vendas, do pedido de brinde (TV5) que o Winthor
 * gerou a partir de um pedido do RCA.
 *
 * <p>Gravada pela {@code APURARCAMPANHASBRINDES} e pela {@code INTEGRADORA}; a força de
 * vendas lê. Os itens estão em {@link PcRetornoITv5Fv}. Todas as 613 linhas estão com
 * {@code RETORNO = 2}; a mais recente é de 2026-07-29 (medido em 2026-10-20).</p>
 *
 * <p>⚠️ <b>A tabela não tem chave primária</b> no Oracle. A chave desta entidade existe
 * porque o JPA exige uma, e não identifica a linha: quem identifica é o {@code ROWID}. A
 * entidade serve de estrutura das colunas; não carregue linhas por ela.</p>
 *
 * <p>Os campos têm o nome da coluna em minúsculas, sem camelCase: são 16 colunas de um
 * layout de terceiro, geradas do dicionário do Oracle em 2026-10-19, e o contrato de
 * quem usa a entidade fala o nome da coluna (ver {@code ColunasDoWinthor} no
 * winthor-integration-service). Os comentários dos campos são os da própria coluna no
 * banco.</p>
 */
@Getter
@Setter
@Entity
@IdClass(PcRetornoCTv5FvId.class)
@Table(name = "PCRETORNOCTV5FV")
public class PcRetornoCTv5Fv extends BaseEntity {

    /** Número do pedido do palm */
    @Id
    @Column(name = "NUMPEDRCA", precision = 10)
    private Long numpedrca;

    /** Data completa do pedido no palm */
    @Column(name = "DTABERTURAPEDPALM")
    private LocalDateTime dtaberturapedpalm;

    /** Codigo do rca */
    @Id
    @Column(name = "CODUSUR", precision = 4)
    private Integer codusur;

    /** Cnpj ou cpf do cliente */
    @Column(name = "CGCCLI", length = 18)
    private String cgccli;

    /** Numero do pedido TV1 que gerou o brinde */
    @Column(name = "NUMPEDORIGEM", precision = 10)
    private Long numpedorigem;

    /** Numero do pedido TV5 gerado */
    @Id
    @Column(name = "NUMPEDTV5", precision = 10)
    private Long numpedtv5;

    /** Codigo do cliente */
    @Column(name = "CODCLI", precision = 6)
    private Integer codcli;

    /** Retorno */
    @Column(name = "RETORNO", precision = 4)
    private Integer retorno;

    /** Posição atual do pedido de brinde */
    @Column(name = "POSICAO_ATUAL", length = 1)
    private String posicao_atual;

    /** Codigo da Filial do Pedido */
    @Column(name = "CODFILIAL", length = 2)
    private String codfilial;

    /** Codigo da Filial NF do Pedido */
    @Column(name = "CODFILIALNF", length = 2)
    private String codfilialnf;

    /** Codigo da Filial Retira do Pedido */
    @Column(name = "CODFILIALRETIRA", length = 2)
    private String codfilialretira;

    /** Data de entrega do pedido */
    @Column(name = "DTENTREGA")
    private LocalDateTime dtentrega;

    /** Data de inclusao do registro na tabela */
    @Column(name = "DTINCLUSAO")
    private LocalDateTime dtinclusao;

    /** Data de alteração do registro na tabela */
    @Column(name = "DTALTERACAO")
    private LocalDateTime dtalteracao;

    /** GERARBRINDEPEDBONIFIC */
    @Column(name = "GERARBRINDEPEDBONIFIC", length = 1)
    private String gerarbrindepedbonific;
}
