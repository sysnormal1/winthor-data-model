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
 * Entity class — mensagem do Winthor para o RCA, na direção contrária das outras tabelas
 * da integradora: quem grava é o Winthor (a procedure {@code ENVIARMENSAGENSRCA}), e a
 * força de vendas lê.
 *
 * <p>As rotinas do ERP avisam o RCA quando alguém altera um pedido dele, cancela um item
 * ou registra uma devolução, com a matrícula de quem fez em {@code CODFUNCEMITE}. Cada
 * linha nova entra com {@code RETORNO = 2}, "não consumida"; pelo layout da TOTVS, a
 * integradora confirma a leitura trocando-o por qualquer outro valor. 202 mil linhas com 2,
 * de 2019 até hoje, e 174 mil com 3, até 2019, da força de vendas anterior (Sovis): a ION
 * não confirma (medido em 2026-10-20).</p>
 *
 * <p>⚠️ <b>A tabela não tem chave primária</b> no Oracle. A chave desta entidade existe
 * porque o JPA exige uma, e não identifica a linha: quem identifica é o {@code ROWID}. A
 * entidade serve de estrutura das colunas; não carregue linhas por ela.</p>
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
@IdClass(PcMensFvId.class)
@Table(name = "PCMENSFV")
public class PcMensFv extends BaseEntity {

    @Id
    @Column(name = "CODUSUR", nullable = false, precision = 4)
    private Integer codusur;

    @Id
    @Column(name = "DATA", nullable = false)
    private LocalDateTime data;

    @Column(name = "MENS1", nullable = false, length = 60)
    private String mens1;

    @Column(name = "MENS2", length = 60)
    private String mens2;

    @Column(name = "MENS3", length = 60)
    private String mens3;

    @Column(name = "MENS4", length = 60)
    private String mens4;

    @Column(name = "MENS5", length = 60)
    private String mens5;

    @Column(name = "MENS6", length = 60)
    private String mens6;

    @Column(name = "MENS7", length = 60)
    private String mens7;

    @Column(name = "MENS8", length = 60)
    private String mens8;

    @Column(name = "RETORNO")
    private BigDecimal retorno;

    /** Grava Data e Hora da Última Importação. */
    @Column(name = "DTINCLUSAO")
    private LocalDateTime dtinclusao;

    @Column(name = "CODFUNCEMITE", precision = 8)
    private Integer codfuncemite;

    /** CODIGO UNICO DO REGISTRO UTILIZADO PARA A FORCA DE VENDAS SOVIS */
    @Column(name = "SOVISCODUNICOFV")
    private BigDecimal soviscodunicofv;

    /** Data de Alteração no registro */
    @Column(name = "DTALTERACAO")
    private LocalDateTime dtalteracao;
}
