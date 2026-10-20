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
 * Entity class — cabeçalho do pedido de força de vendas, a tabela de entrada do
 * "Layout Padrão Para Integradoras" da TOTVS.
 *
 * <p>A integradora grava aqui, a package {@code INTEGRADORA} lê ({@code IMPORTADO = 1}),
 * grava o pedido no {@code PCPEDC} e devolve o resultado nas colunas de retorno. A PK é
 * {@code NUMPEDRCA, CODUSUR, CGCCLI, DTABERTURAPEDPALM}; itens e vencimentos a repetem.</p>
 *
 * <h2>Quem escreve o quê, medido em 2026-10-19</h2>
 *
 * <ul>
 *   <li><b>A package</b>: {@code IMPORTADO}, {@code NUMPED}, {@code OBSERVACAO_PC},
 *       {@code RETORNO}, {@code POSICAO_ATUAL}, {@code ATENDIDO}, {@code GEROUBRINDE},
 *       {@code VERSAOPKG}.</li>
 *   <li><b>Triggers</b>: {@code TRG_INT_PCPEDCFV} preenche {@code DTINCLUSAO} e
 *       {@code DTALTERACAO}; {@code TRG_JUMBO_INT_PCPEDCFV} rejeita ({@code IMPORTADO = 3}
 *       e {@code OBSERVACAO_PC}) pedido de origem {@code F} para cliente de tabela de
 *       preço do e-commerce.</li>
 *   <li><b>A ION</b>: {@code ION_ID}, que o pré-processamento dela usa para achar o
 *       pedido.</li>
 * </ul>
 *
 * <p>{@code UIDREGISTRO + IDPARCEIRO} é chave única aqui, no {@code PCPEDC} e no
 * {@code PCNFSAID}: a package copia o par para o pedido e o faturamento para a nota. ⚠️
 * Como toda chave única composta do Oracle, ela só ignora a linha com as <b>duas</b>
 * colunas nulas: {@code IDPARCEIRO} preenchido com {@code UIDREGISTRO} nulo pode existir
 * uma vez só por parceiro.</p>
 *
 * <p>{@code CODEMITENTE} é matrícula do {@code PCEMPR}; nulo, a package assume 8888
 * ({@code FORCA DE VENDAS}) e usa esse usuário nas permissões da rotina 2596, na filial
 * de retirada, no limite de crédito e na conta corrente do RCA.</p>
 *
 * <p>Os campos têm o nome da coluna em minúsculas, sem camelCase: são 117 colunas de um
 * layout de terceiro, geradas do dicionário do Oracle em 2026-10-19, e o contrato de
 * quem usa a entidade fala o nome da coluna (ver {@code ColunasDoWinthor} no
 * winthor-integration-service). Os comentários dos campos são os da própria coluna no
 * banco.</p>
 */
@Getter
@Setter
@Entity
@IdClass(PcPedCFvId.class)
@Table(name = "PCPEDCFV")
public class PcPedCFv extends BaseEntity {

    @Column(name = "IMPORTADO", nullable = false, precision = 1)
    private Integer importado;

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

    @Column(name = "DTFECHAMENTOPEDPALM", nullable = false)
    private LocalDateTime dtfechamentopedpalm;

    @Column(name = "NUMPEDCLI", length = 15)
    private String numpedcli;

    @Column(name = "DTENTREGA")
    private LocalDateTime dtentrega;

    @Column(name = "CODFILIAL", nullable = false, length = 2)
    private String codfilial;

    @Column(name = "CODFILIALNF", length = 2)
    private String codfilialnf;

    @Column(name = "CODFILIALRETIRA", length = 2)
    private String codfilialretira;

    @Column(name = "VLFRETE", precision = 16, scale = 3)
    private BigDecimal vlfrete;

    @Column(name = "CODCOB", nullable = false, length = 4)
    private String codcob;

    @Column(name = "CODPLPAG", nullable = false, precision = 4)
    private Integer codplpag;

    @Column(name = "CONDVENDA", nullable = false, precision = 2)
    private Integer condvenda;

    @Column(name = "OBS1", length = 50)
    private String obs1;

    @Column(name = "OBS2", length = 50)
    private String obs2;

    @Column(name = "OBSENTREGA1", length = 75)
    private String obsentrega1;

    @Column(name = "OBSENTREGA2", length = 75)
    private String obsentrega2;

    @Column(name = "OBSENTREGA3", length = 75)
    private String obsentrega3;

    @Column(name = "OBSENTREGA4", length = 75)
    private String obsentrega4;

    @Column(name = "FRETEDESPACHO", length = 1)
    private String fretedespacho;

    @Column(name = "FRETEREDESPACHO", length = 1)
    private String freteredespacho;

    @Column(name = "CODFORNECFRETE", precision = 6)
    private Integer codfornecfrete;

    @Column(name = "PRAZO1", precision = 4)
    private Integer prazo1;

    @Column(name = "PRAZO2", precision = 4)
    private Integer prazo2;

    @Column(name = "PRAZO3", precision = 4)
    private Integer prazo3;

    @Column(name = "PRAZO4", precision = 4)
    private Integer prazo4;

    @Column(name = "PRAZO5", precision = 4)
    private Integer prazo5;

    @Column(name = "PRAZO6", precision = 4)
    private Integer prazo6;

    @Column(name = "PRAZO7", precision = 4)
    private Integer prazo7;

    @Column(name = "PRAZO8", precision = 4)
    private Integer prazo8;

    @Column(name = "PRAZO9", precision = 4)
    private Integer prazo9;

    @Column(name = "PRAZO10", precision = 4)
    private Integer prazo10;

    @Column(name = "PRAZO11", precision = 4)
    private Integer prazo11;

    @Column(name = "PRAZO12", precision = 4)
    private Integer prazo12;

    @Column(name = "ORIGEMPED", nullable = false, length = 1)
    private String origemped;

    @Column(name = "NUMPEDCOMP", precision = 10)
    private Long numpedcomp;

    @Column(name = "OBSERVACAO_PC", length = 4000)
    private String observacao_pc;

    @Column(name = "RETORNO", precision = 4)
    private Integer retorno;

    @Column(name = "POSICAO_ATUAL", length = 1)
    private String posicao_atual;

    @Column(name = "SALDOATUALRCA", precision = 10, scale = 2)
    private BigDecimal saldoatualrca;

    /** Grava Data e Hora da Última Importação. */
    @Column(name = "DTINCLUSAO")
    private LocalDateTime dtinclusao;

    /** Número do pedido gravado na pcpedc. Será retornado pela package */
    @Column(name = "NUMPED", precision = 10)
    private Long numped;

    /** Indica se o pedido é complementar. */
    @Column(name = "NUMPEDORIGEM", precision = 10)
    private Long numpedorigem;

    /** Neste campo será inserido o código do cliente para gravação nos dados fiscais/impressão de cupons e notas fiscais. */
    @Column(name = "CODCLINF", precision = 6)
    private Integer codclinf;

    /** Este campo pode ser: C - cupom fiscal, N - Nota Fiscal, A - ambos. Determina como o pedido poderá ser faturado. */
    @Column(name = "TIPODOCUMENTO", length = 1)
    private String tipodocumento;

    /** Este campo determina se a Integradora validará o processo de Conta Ordem da Venda Futura */
    @Column(name = "CONTAORDEM", length = 1)
    private String contaordem;

    /** Código do cliente que será usado para o pedido TV8 */
    @Column(name = "CODCLITV8", precision = 6)
    private Integer codclitv8;

    /** Codigo do cliente que será usado em conjunto com o campo cnpj para identificar o cliente no caso de ter no cadastro mais de um cliente com mesmo cnpj */
    @Column(name = "CODCLI", precision = 6)
    private Integer codcli;

    /** Plano de pagamento para medicamentos eticos */
    @Column(name = "CODPLPAGETICO", precision = 4)
    private Integer codplpagetico;

    /** Plano de pagamento para medicamentos genericos */
    @Column(name = "CODPLPAGGENERICO", precision = 4)
    private Integer codplpaggenerico;

    /** É gravado por uma trigger quando o pedido é montado. */
    @Column(name = "CODMOTORISTA", precision = 8)
    private Integer codmotorista;

    /** Data de Alteração no registro */
    @Column(name = "DTALTERACAO")
    private LocalDateTime dtalteracao;

    /** Tipo de Prioridade de entrega */
    @Column(name = "TIPOPRIORIDADEENTREGA", length = 1)
    private String tipoprioridadeentrega;

    /** Tipo de Força de Vendas */
    @Column(name = "TIPOFV", length = 2)
    private String tipofv;

    /** Código do Motivo de Não Atendimento */
    @Column(name = "CODMOTIVONAOATEND", precision = 3)
    private Integer codmotivonaoatend;

    /** Local Desembaraço */
    @Column(name = "LOCALDESEMBARACO", length = 30)
    private String localdesembaraco;

    /** UF Desembaraço */
    @Column(name = "UFDESEMBARACO", length = 2)
    private String ufdesembaraco;

    /** Informa se o pedido gerou brinde */
    @Column(name = "GEROUBRINDE", length = 1)
    private String geroubrinde;

    /** Informa se o pedido foi atendido Total ou Parcial */
    @Column(name = "ATENDIDO", length = 1)
    private String atendido;

    /** Percentual de abatimento */
    @Column(name = "PERCDESCABATIMENTO", precision = 18, scale = 6)
    private BigDecimal percdescabatimento;

    /** Número do pedido TV1 */
    @Column(name = "NUMPEDTV1", precision = 10)
    private Long numpedtv1;

    /** Codigo da Rota */
    @Column(name = "CODROTA", precision = 3)
    private Integer codrota;

    /** Tipo de custo da bonificacao */
    @Column(name = "CUSTOBONIFICACAO", length = 1)
    private String custobonificacao;

    /** Codigo do fornecedor da bonificacao */
    @Column(name = "CODFORNECBONIFIC", precision = 6)
    private Integer codfornecbonific;

    /** codigo da bonificacao */
    @Column(name = "CODBNF", precision = 4)
    private Integer codbnf;

    /** Informa de pedido será agrupado ou não */
    @Column(name = "AGRUPAMENTO", length = 1)
    private String agrupamento;

    /** Código do Endereço de entrega */
    @Column(name = "CODENDENT", precision = 6)
    private Integer codendent;

    /** Tipo de entrega do item para venda 7 */
    @Column(name = "TIPOENTREGA", length = 2)
    private String tipoentrega;

    /** Turno de entrega do pedido */
    @Column(name = "TURNOENTREGA", length = 5)
    private String turnoentrega;

    /** Valor de entrada. */
    @Column(name = "VLENTRADA", precision = 16, scale = 3)
    private BigDecimal vlentrada;

    /** Indica se é orçamento. */
    @Column(name = "ORCAMENTO", length = 1)
    private String orcamento;

    /** Num. Pedido VAN para gravar no XML da NF-e. */
    @Column(name = "NUMPEDVANXML", length = 20)
    private String numpedvanxml;

    /** Código de endereço do cliente. */
    @Column(name = "CODENDENTCLI", precision = 6)
    private Integer codendentcli;

    /** Tipo de emissão */
    @Column(name = "TIPOEMISSAO", length = 1)
    private String tipoemissao;

    /** Protocolo */
    @Column(name = "PROTOCOLO", length = 50)
    private String protocolo;

    /** Indica contingência */
    @Column(name = "CONTINGENCIATV14", length = 1)
    private String contingenciatv14;

    /** Chave NFE */
    @Column(name = "CHAVENFE", length = 45)
    private String chavenfe;

    /** Número do pedido original que gerou a bonificação */
    @Column(name = "NUMPEDTV14", precision = 10)
    private Long numpedtv14;

    /** Indica se preço enviado está sem imposto. */
    @Column(name = "PVENDASEMIMPOSTO", length = 1)
    private String pvendasemimposto;

    /** Codigo do cliente recebedor. */
    @Column(name = "CODCLIRECEBEDOR", precision = 6)
    private Integer codclirecebedor;

    /** Valor de desconto de abatimento. */
    @Column(name = "VLDESCABATIMENTO", precision = 18, scale = 6)
    private BigDecimal vldescabatimento;

    /** Número da região utilizada para esta venda. */
    @Column(name = "NUMREGIAOBROKER", precision = 4)
    private Integer numregiaobroker;

    /** Codigo do rca profissional 2 */
    @Column(name = "CODUSUR2", precision = 4)
    private Integer codusur2;

    /** Codigo do rca profissional 3 */
    @Column(name = "CODUSUR3", precision = 4)
    private Integer codusur3;

    /** Codigo do rca profissional 4 */
    @Column(name = "CODUSUR4", precision = 4)
    private Integer codusur4;

    /** Versão da Package que Processou o Pedido */
    @Column(name = "VERSAOPKG", length = 20)
    private String versaopkg;

    /** Campo indica se o pedido é referênte a uma venda assisitda. (Processo utilizado por BH) */
    @Column(name = "VENDAASSISTIDA", length = 1)
    private String vendaassistida;

    @Column(name = "GERARDADOSNFPAULISTA", length = 1)
    private String gerardadosnfpaulista;

    @Column(name = "PRECOCOMPARTILHA", length = 1)
    private String precocompartilha;

    /** Id único do registro de assinatura */
    @Column(name = "UIDREGISTRO", precision = 10)
    private Long uidregistro;

    /** Id do parceiro da assinatura do registro */
    @Column(name = "IDPARCEIRO", length = 15)
    private String idparceiro;

    /** Assinatura do registro */
    @Column(name = "ASSINATURA", length = 100)
    private String assinatura;

    /** Define se a venda é venda triangular */
    @Column(name = "VENDATRIANGULAR", length = 1)
    private String vendatriangular;

    /** Define se o cliente faz pagamento usando cheque moradia */
    @Column(name = "PAGCHEQUEMORADIA", length = 1)
    private String pagchequemoradia;

    /** Condição de financiamento suppliercard. */
    @Column(name = "CONDFINANC", length = 9)
    private String condfinanc;

    /** Plano de quantidade de parcelas suppliercard. */
    @Column(name = "PLANOSUPPLI", precision = 2)
    private Integer planosuppli;

    /** Código da campanha de brinde */
    @Column(name = "CODBREX", precision = 6)
    private Integer codbrex;

    /** Matrícula do usuário que digitou o pedido no força de vendas */
    @Column(name = "CODEMITENTE", precision = 10)
    private Long codemitente;

    /** Indica se o pedido de venda irá passar pelas validações para gerar ou não um brinde */
    @Column(name = "GERABRINDE", length = 1)
    private String gerabrinde;

    /** Percentual de redução comissão. */
    @Column(name = "APLICARPERREDCOMISS", length = 1)
    private String aplicarperredcomiss;

    @Column(name = "INTEGRADORA", precision = 6)
    private Integer integradora;

    /** Razão Social do marketplace ou e-commerce */
    @Column(name = "DESCINTERMEDIADOR", length = 60)
    private String descintermediador;

    /** CNPJ do marketplace ou e-commerce */
    @Column(name = "CNPJINTERMEDIADOR", length = 20)
    private String cnpjintermediador;

    /** Indica que é uma venda para exportação indireta */
    @Column(name = "OPERVENDAEXPINDIRETA", length = 1)
    private String opervendaexpindireta;

    @Column(name = "ION_ID", length = 36)
    private String ion_id;

    /** Define se o preço de venda vindo do FV esta considerando a Figura de exceção */
    @Column(name = "PRECOFVSEMFIGURAEXC", length = 1)
    private String precofvsemfiguraexc;

    /** Indica se o pedido de transferencia de mercadoria gera contas a pagar */
    @Column(name = "GERACP", length = 1)
    private String geracp;

    /** Campo que identifica o pedido do força de vendas */
    @Column(name = "IDFV", length = 60)
    private String idfv;

    /** Numero do pedido TV7 que o pedido TV8 pertence */
    @Column(name = "NUMPEDENTFUT", precision = 10)
    private Long numpedentfut;

    @Column(name = "PAGOANTECIPADAMENTE", length = 1)
    private String pagoantecipadamente;

    /** Igualar a Filial à Filial NF e priorizar a tabela de preços da rotina 3314 */
    @Column(name = "PERMITIRFILIALNFNULA", length = 1)
    private String permitirfilialnfnula;

    /** Valor de outras despesas */
    @Column(name = "VLOUTRASDESP", precision = 16, scale = 3)
    private BigDecimal vloutrasdesp;

    /** Status do Agendador */
    @Column(name = "STATUSAGENDADOR", length = 1)
    private String statusagendador;

    /** Data Hora Inicio Processamento Agendador */
    @Column(name = "DTINIPROCESSAMENTOAGENDADOR")
    private LocalDateTime dtiniprocessamentoagendador;

    /** Data Hora Fim Processamento Agendador */
    @Column(name = "DTFIMPROCESSAMENTOAGENDADOR")
    private LocalDateTime dtfimprocessamentoagendador;
}
