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
 * Entity class — cadastro de cliente enviado pela força de vendas, a tabela de entrada
 * de cliente do "Layout Padrão Para Integradoras" da TOTVS.
 *
 * <p>{@code TIPOOPERACAO} é {@code I} (inclusão) ou {@code A} (alteração, pelo
 * {@code CGCENT} e pelo {@code CODCLI}). Quem lê é a package {@code IMPORTARCADASTROS}
 * ({@code p_tiporeg} 1), que grava o {@code PCCLIENT} e devolve aqui {@code IMPORTADO},
 * {@code OBSERVACAO_PC} e o {@code CODCLI} criado.</p>
 *
 * <h2>Quem escreve o quê, medido em 2026-10-20</h2>
 *
 * <ul>
 *   <li><b>A package</b>: {@code IMPORTADO}, {@code OBSERVACAO_PC}, {@code CODCLI}.</li>
 *   <li><b>Trigger</b> {@code TRG_INT_PCCLIENTFV}: {@code DTINCLUSAO} e
 *       {@code DTALTERACAO}. {@code TRG_PCCLIENTFV_TRAVADELECAO} recusa apagar linha
 *       presa em {@code IMPORTADO = 4} há mais de dois dias.</li>
 *   <li><b>A ION</b>: {@code ION_ID}.</li>
 * </ul>
 *
 * <p>⚠️ A trava da package ({@code proc_alterarImportado}) compara {@code codusur1 =
 * codusur1} — a coluna com ela mesma —, então processar o cadastro de um RCA trava os
 * pendentes de todos, e só destrava os que processou. Três linhas estão presas em 4
 * desde 2019.</p>
 *
 * <p>⚠️ <b>A tabela não tem chave primária</b> no Oracle. A chave desta entidade existe
 * porque o JPA exige uma, e não identifica a linha: o mesmo cliente pode ter várias
 * linhas, uma por envio. Quem identifica a linha é o {@code ROWID}, que é como a própria
 * package {@code IMPORTARCADASTROS} devolve o resultado. A entidade serve de estrutura
 * das colunas; não carregue linhas por ela.</p>
 *
 * <p>Os campos têm o nome da coluna em minúsculas, sem camelCase: são 104 colunas de um
 * layout de terceiro, geradas do dicionário do Oracle em 2026-10-19, e o contrato de
 * quem usa a entidade fala o nome da coluna (ver {@code ColunasDoWinthor} no
 * winthor-integration-service). Os comentários dos campos são os da própria coluna no
 * banco.</p>
 */
@Getter
@Setter
@Entity
@IdClass(PcClientFvId.class)
@Table(name = "PCCLIENTFV")
public class PcClientFv extends BaseEntity {

    @Column(name = "IMPORTADO", nullable = false, precision = 1)
    private Integer importado;

    @Column(name = "TIPOOPERACAO", nullable = false, length = 1)
    private String tipooperacao;

    @Id
    @Column(name = "CGCENT", nullable = false, length = 18)
    private String cgcent;

    @Column(name = "CLIENTE", nullable = false, length = 60)
    private String cliente;

    @Column(name = "FANTASIA", length = 40)
    private String fantasia;

    @Column(name = "IEENT", nullable = false, length = 15)
    private String ieent;

    @Column(name = "IMENT", length = 15)
    private String iment;

    @Column(name = "RG", length = 20)
    private String rg;

    @Column(name = "ORGAORG", length = 10)
    private String orgaorg;

    @Column(name = "CODCLIPALM", precision = 6)
    private Integer codclipalm;

    @Column(name = "CODATV1", precision = 6)
    private Integer codatv1;

    @Column(name = "ENDERENT", length = 40)
    private String enderent;

    @Column(name = "NUMEROENT", length = 6)
    private String numeroent;

    @Column(name = "COMPLEMENTOENT", length = 80)
    private String complementoent;

    @Column(name = "BAIRROENT", length = 150)
    private String bairroent;

    @Column(name = "TELENT", length = 13)
    private String telent;

    @Column(name = "MUNICENT", length = 15)
    private String municent;

    @Column(name = "ESTENT", length = 2)
    private String estent;

    @Column(name = "CEPENT", length = 9)
    private String cepent;

    @Column(name = "PAISENT", length = 18)
    private String paisent;

    @Column(name = "PONTOREFER", length = 40)
    private String pontorefer;

    @Column(name = "ENDERCOB", length = 40)
    private String endercob;

    @Column(name = "COMPLEMENTOCOB", length = 80)
    private String complementocob;

    @Column(name = "NUMEROCOB", length = 6)
    private String numerocob;

    @Column(name = "BAIRROCOB", length = 150)
    private String bairrocob;

    @Column(name = "TELCOB", length = 13)
    private String telcob;

    @Column(name = "MUNICCOB", length = 15)
    private String municcob;

    @Column(name = "ESTCOB", length = 2)
    private String estcob;

    @Column(name = "CEPCOB", length = 9)
    private String cepcob;

    @Column(name = "ENDERCOM", length = 40)
    private String endercom;

    @Column(name = "NUMEROCOM", length = 6)
    private String numerocom;

    @Column(name = "COMPLEMENTOCOM", length = 80)
    private String complementocom;

    @Column(name = "BAIRROCOM", length = 150)
    private String bairrocom;

    @Column(name = "MUNICCOM", length = 15)
    private String municcom;

    @Column(name = "ESTCOM", length = 2)
    private String estcom;

    @Column(name = "CEPCOM", length = 9)
    private String cepcom;

    @Column(name = "TELCOM", length = 13)
    private String telcom;

    @Column(name = "FAXCOM", length = 15)
    private String faxcom;

    @Column(name = "CODUSUR1", precision = 4)
    private Integer codusur1;

    @Column(name = "CODUSUR2", precision = 4)
    private Integer codusur2;

    @Column(name = "FAXCLI", length = 15)
    private String faxcli;

    @Column(name = "CODPRACA", nullable = false, precision = 6)
    private Integer codpraca;

    @Column(name = "PREDIOPROPRIO", length = 1)
    private String predioproprio;

    @Column(name = "OBS", length = 40)
    private String obs;

    @Column(name = "OBS2", length = 40)
    private String obs2;

    @Column(name = "OBS3", length = 60)
    private String obs3;

    @Column(name = "OBS4", length = 60)
    private String obs4;

    @Column(name = "OBSCREDITO", length = 30)
    private String obscredito;

    @Column(name = "TELENT1", length = 13)
    private String telent1;

    @Column(name = "EMAIL", length = 100)
    private String email;

    @Column(name = "CAIXAPOSTAL", precision = 5)
    private Integer caixapostal;

    @Column(name = "OBSENTREGA1", length = 75)
    private String obsentrega1;

    @Column(name = "OBSENTREGA2", length = 75)
    private String obsentrega2;

    @Column(name = "OBSENTREGA3", length = 75)
    private String obsentrega3;

    @Column(name = "OBSENTREGA4", length = 75)
    private String obsentrega4;

    @Column(name = "NUMBANCO1", precision = 3)
    private Integer numbanco1;

    @Column(name = "NUMAGENCIA1", precision = 6)
    private Integer numagencia1;

    @Column(name = "NUMCCORRENTE1", length = 15)
    private String numccorrente1;

    @Column(name = "NUMBANCO2", precision = 3)
    private Integer numbanco2;

    @Column(name = "NUMAGENCIA2", precision = 6)
    private Integer numagencia2;

    @Column(name = "NUMCCORRENTE2", length = 15)
    private String numccorrente2;

    @Column(name = "QTCHECKOUT", precision = 8)
    private Integer qtcheckout;

    @Column(name = "SITE", length = 80)
    private String site;

    @Column(name = "OBSGERENCIAL1", length = 80)
    private String obsgerencial1;

    @Column(name = "OBSGERENCIAL2", length = 80)
    private String obsgerencial2;

    @Column(name = "OBSGERENCIAL3", length = 80)
    private String obsgerencial3;

    @Column(name = "LATITUDE", length = 20)
    private String latitude;

    @Column(name = "LONGITUDE", length = 20)
    private String longitude;

    @Column(name = "DATACOLETA")
    private LocalDateTime datacoleta;

    @Column(name = "OBSERVACAO_PC", length = 4000)
    private String observacao_pc;

    /** Grava Data e Hora da Última Importação. */
    @Id
    @Column(name = "DTINCLUSAO")
    private LocalDateTime dtinclusao;

    /** Codigo do cliente que será usado em conjunto com o campo cnpj para identificar o cliente no caso de ter no cadastro mais de um cliente com mesmo cnpj */
    @Column(name = "CODCLI", precision = 6)
    private Integer codcli;

    /** Data de Alteração no registro */
    @Column(name = "DTALTERACAO")
    private LocalDateTime dtalteracao;

    /** Código de cobranca */
    @Column(name = "CODCOB", length = 4)
    private String codcob;

    /** Código do plano de pagamento */
    @Column(name = "CODPLPAG", precision = 4)
    private Integer codplpag;

    /** Email NFE */
    @Column(name = "EMAILNFE", length = 100)
    private String emailnfe;

    /** Codigo cidade ibge */
    @Column(name = "CODCIDADEIBGE", precision = 10)
    private Long codcidadeibge;

    /** codigo filial NF */
    @Column(name = "CODFILIALNF", length = 2)
    private String codfilialnf;

    /** consumidor final */
    @Column(name = "CONSUMIDORFINAL", length = 1)
    private String consumidorfinal;

    /** Contribuinte */
    @Column(name = "CONTRIBUINTE", length = 1)
    private String contribuinte;

    /** cliente protesto */
    @Column(name = "CLIENTPROTESTO", length = 1)
    private String clientprotesto;

    /** envia nf por email */
    @Column(name = "ENVIONFEMAILCOM", length = 1)
    private String envionfemailcom;

    /** Dia da semana para roteirização */
    @Column(name = "DIASEMANA", length = 10)
    private String diasemana;

    /** Número da semana para roteirização */
    @Column(name = "NUMSEMANA", precision = 4)
    private Integer numsemana;

    /** Sequência para roteirização */
    @Column(name = "SEQUENCIA", precision = 4)
    private Integer sequencia;

    /** Periodicidade para roteirização */
    @Column(name = "PERIODICIDADE", length = 10)
    private String periodicidade;

    /** Indica se cliente aderiu ao simples nacional */
    @Column(name = "SIMPLESNACIONAL", length = 1)
    private String simplesnacional;

    /** Código do País */
    @Column(name = "CODPAIS", precision = 6)
    private Integer codpais;

    /** Indica a data de nascimento do pré-cadastro */
    @Column(name = "DTNASC")
    private LocalDateTime dtnasc;

    /** Indica o motivo da rejeição do pré-cadastro */
    @Column(name = "MOTIVOREJEICAO", length = 4000)
    private String motivorejeicao;

    /** Define o tipo de frete do cliente */
    @Column(name = "FRETEDESPACHO", length = 1)
    private String fretedespacho;

    /** Telefone do cliente no força de vendas */
    @Column(name = "TELCELENT", length = 13)
    private String telcelent;

    /** Data de exclusão do registro */
    @Column(name = "DTEXCLUSAO")
    private LocalDateTime dtexclusao;

    /** Código do usuário que excluiu */
    @Column(name = "CODUSUARIOEXC", precision = 8)
    private Integer codusuarioexc;

    /** Motivo da exclusão do registro */
    @Column(name = "MOTIVOEXCLUSAO", length = 200)
    private String motivoexclusao;

    /** Defini se o cliente participa do FUNCEP */
    @Column(name = "PARTICIPAFUNCEP", length = 1)
    private String participafuncep;

    /** Indica se o cliente irá calcular ST */
    @Column(name = "CALCULAST", length = 1)
    private String calculast;

    /** Indica se o cliente é optante pelo cálculo do ST fonte na importação de registros da integradora. */
    @Column(name = "CLIENTEFONTEST", length = 1)
    private String clientefontest;

    @Column(name = "VALIDARMULTIPLOVENDA", length = 1)
    private String validarmultiplovenda;

    @Column(name = "CODCNAE", length = 60)
    private String codcnae;

    /** Observação 5 */
    @Column(name = "OBS5", length = 60)
    private String obs5;

    @Column(name = "ION_ID", length = 36)
    private String ion_id;

    /** CPF/CNPJ Entrega */
    @Column(name = "CGCENTREGA", length = 18)
    private String cgcentrega;

    /** Código IBGE da Cidade de Entrega */
    @Column(name = "CODCIDADEIBGECOM", precision = 10)
    private Long codcidadeibgecom;
}
