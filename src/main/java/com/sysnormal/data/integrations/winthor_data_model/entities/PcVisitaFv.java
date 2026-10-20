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
 * Entity class — visita do RCA a um cliente, enviada pela força de vendas.
 *
 * <p>Lida pela {@code IMPORTARCADASTROS} ({@code p_tiporeg} 7), que confere o cliente e
 * o motivo de não compra ({@code CODMOTIVO}, em {@code PCMOTNAOCOMPRA}), recusa visita já
 * cadastrada na mesma data e hora e grava o {@code PCVISITA}. Devolve o resultado pela
 * combinação cliente, RCA, motivo, data e horários. {@code TRG_INT_PCVISITAFV} preenche
 * as datas. Nunca usada nesta base (medido em 2026-10-20).</p>
 *
 * <p>⚠️ <b>A tabela não tem chave primária</b> no Oracle. A chave desta entidade existe
 * porque o JPA exige uma, e não identifica a linha: o mesmo cliente pode ter várias
 * linhas, uma por envio. Quem identifica a linha é o {@code ROWID}, que é como a própria
 * package {@code IMPORTARCADASTROS} devolve o resultado. A entidade serve de estrutura
 * das colunas; não carregue linhas por ela.</p>
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
@IdClass(PcVisitaFvId.class)
@Table(name = "PCVISITAFV")
public class PcVisitaFv extends BaseEntity {

    @Column(name = "CODMOTIVO", precision = 6)
    private Integer codmotivo;

    @Id
    @Column(name = "DATA", nullable = false)
    private LocalDateTime data;

    @Id
    @Column(name = "HORAINICIAL", nullable = false, precision = 2)
    private Integer horainicial;

    @Id
    @Column(name = "MINUTOINICIAL", nullable = false, precision = 2)
    private Integer minutoinicial;

    @Column(name = "HORAFINAL", nullable = false, precision = 2)
    private Integer horafinal;

    @Column(name = "MINUTOFINAL", nullable = false, precision = 2)
    private Integer minutofinal;

    @Column(name = "ASSUNTO", nullable = false, length = 4000)
    private String assunto;

    @Id
    @Column(name = "CGCCLI", nullable = false, length = 18)
    private String cgccli;

    @Id
    @Column(name = "CODUSUR", nullable = false, precision = 4)
    private Integer codusur;

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

    /** Codigo da Rota */
    @Column(name = "CODROTA", precision = 3)
    private Integer codrota;
}
