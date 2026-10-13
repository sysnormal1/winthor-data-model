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
 * Entity class — o catálogo de serviços de enriquecimento cadastral.
 *
 * <p>É a raiz da hierarquia {@code PCSERVICO} → {@link PcServicoCliente} →
 * {@link PcServicoClienteEndereco} e irmãs. Cada linha é uma <b>oferta</b>: preço,
 * modelo de precificação, validade, quantidade de registros contratados e se foi
 * adquirida e usada.</p>
 *
 * <h2>Para que o Sysnormal a usa</h2>
 *
 * <p>O recurso nativo da TOTVS nunca foi ativado nesta instalação — as oito tabelas
 * estão vazias. O Sysnormal grava aqui uma linha própria, que representa o próprio
 * serviço de integração como origem do enriquecimento, porque
 * {@code PCSERVICOCLIENTE.CODSERVICO} tem FK <b>ENABLED e VALIDATED</b> para esta
 * tabela: sem a linha-raiz, nenhum dado de cliente entra.</p>
 *
 * <p>Esta família é o destino do endereço e da situação cadastral vindos da Receita,
 * <b>no lugar</b> do {@code PCCLIENTENDENT}: aquela tabela alimenta a rotina 901
 * (Montar Carga), o grupo {@code <entrega>} do XML da NF-e e, se o parâmetro 3922
 * estiver ligado, a tributação do pedido. Esta não alimenta nada.</p>
 *
 * <p>⚠️ {@code CODSERVICO} é PK e <b>não tem sequence</b>; a chave é calculada em
 * {@code MAX+1}, como no resto do ERP.</p>
 *
 * <p>⚠️ A tabela é da TOTVS. Uma atualização do Winthor pode ativar o recurso ou
 * alterar a estrutura, por isso o sistema de registro do dado público continua sendo o
 * banco do Sysnormal — o que vai para cá é projeção, para consulta em SQL e relatório.</p>
 */
@Getter
@Setter
@Entity
@Table(name = "PCSERVICO")
public class PcServico extends BaseEntity {

    @Id
    @Column(name = "CODSERVICO")
    private Long codServico;

    /** Identificador da oferta no fornecedor do serviço. */
    @Column(name = "IDSERVICO", length = 255)
    private String idServico;

    @Column(name = "NOME", length = 255)
    private String nome;

    @Column(name = "DESCRICAO", length = 255)
    private String descricao;

    @Column(name = "MODELOPRECIFICACAO", length = 255)
    private String modeloPrecificacao;

    /** É {@code VARCHAR2(255)} na origem, não numérico. */
    @Column(name = "PRECO", length = 255)
    private String preco;

    @Column(name = "DATAVALIDADE")
    private LocalDateTime dataValidade;

    /** {@code CHAR(1)}, <b>NOT NULL</b>. */
    @Column(name = "ADQUIRIDO", length = 1)
    private String adquirido;

    /** {@code CHAR(1)}, <b>NOT NULL</b>. */
    @Column(name = "UTILIZADO", length = 1)
    private String utilizado;

    /** {@code CHAR(1)}. */
    @Column(name = "OFERTAEXPIROU", length = 1)
    private String ofertaExpirou;

    @Column(name = "TIPOSERVICO", length = 255)
    private String tipoServico;

    @Column(name = "DATAAQUISICAO")
    private LocalDateTime dataAquisicao;

    /** Quantidade de registros contratados na oferta. */
    @Column(name = "QUANTIDADE")
    private Long quantidade;
}
