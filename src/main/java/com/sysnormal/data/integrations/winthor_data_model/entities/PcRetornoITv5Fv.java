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
 * Entity class — item do retorno de pedido de brinde ({@link PcRetornoCTv5Fv}).
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
@IdClass(PcRetornoITv5FvId.class)
@Table(name = "PCRETORNOITV5FV")
public class PcRetornoITv5Fv extends BaseEntity {

    /** Número do pedido do palm */
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

    /** Codigo do produto */
    @Id
    @Column(name = "CODPROD", precision = 6)
    private Integer codprod;

    /** Codigo de barras */
    @Column(name = "CODAUXILIAR", precision = 16)
    private Long codauxiliar;

    /** Quantidade de brinde gravada pela package */
    @Column(name = "QT", precision = 20, scale = 6)
    private BigDecimal qt;

    /** Quantidade atual de brinde na pcpedi */
    @Column(name = "QT_FATURADA", precision = 20, scale = 6)
    private BigDecimal qt_faturada;

    /** Codigo da Filial Retira do item */
    @Column(name = "CODFILIALRETIRA", length = 2)
    private String codfilialretira;

    /** Preco de tabela do brinde */
    @Column(name = "PTABELA", precision = 12, scale = 6)
    private BigDecimal ptabela;

    /** Numse do itemde brinde */
    @Id
    @Column(name = "NUMSEQ", precision = 20)
    private Long numseq;

    /** Data de inclusao do registro na tabela */
    @Column(name = "DTINCLUSAO")
    private LocalDateTime dtinclusao;

    /** Data de alteração do registro na tabela */
    @Column(name = "DTALTERACAO")
    private LocalDateTime dtalteracao;
}
