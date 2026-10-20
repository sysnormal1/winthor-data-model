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
 * Entity class — item do pedido de força de vendas ({@link PcPedCFv}).
 *
 * <p>PK: a do cabeçalho mais {@code CODPROD, NUMSEQ}. Não há FK para o cabeçalho; quem
 * grava garante que ele exista.</p>
 *
 * <h2>Quem escreve o quê, medido em 2026-10-19</h2>
 *
 * <ul>
 *   <li><b>A package</b>: {@code NUMPED}, {@code QT_FATURADA}, {@code OBSERVACAO_PC},
 *       {@code CORTE}, {@code RESTRICAOTRANSP}, {@code VERSAOPKG}.</li>
 *   <li><b>Triggers</b>: {@code TRG_INT_PCPEDIFV} preenche {@code DTINCLUSAO} e
 *       {@code DTALTERACAO}; ⚠️ {@code SYSNORMAL.TRG_WINT_PCPEDIFV_MESSAGES} calcula o
 *       disponível a cada item inserido e, se negativar, grava alerta em
 *       {@code SYSNORMAL.MESSAGES} para o RCA do pedido.</li>
 *   <li><b>A ION</b>: {@code ION_ID}.</li>
 * </ul>
 *
 * <p>Os campos têm o nome da coluna em minúsculas, sem camelCase: são 81 colunas de um
 * layout de terceiro, geradas do dicionário do Oracle em 2026-10-19, e o contrato de
 * quem usa a entidade fala o nome da coluna (ver {@code ColunasDoWinthor} no
 * winthor-integration-service). Os comentários dos campos são os da própria coluna no
 * banco.</p>
 */
@Getter
@Setter
@Entity
@IdClass(PcPedIFvId.class)
@Table(name = "PCPEDIFV")
public class PcPedIFv extends BaseEntity {

    @Id
    @Column(name = "NUMPEDRCA", nullable = false, precision = 10)
    private Long numpedrca;

    @Id
    @Column(name = "CGCCLI", nullable = false, length = 18)
    private String cgccli;

    @Id
    @Column(name = "CODUSUR", nullable = false, precision = 4)
    private Integer codusur;

    @Id
    @Column(name = "DTABERTURAPEDPALM", nullable = false)
    private LocalDateTime dtaberturapedpalm;

    @Id
    @Column(name = "CODPROD", nullable = false, precision = 6)
    private Integer codprod;

    @Column(name = "QT", nullable = false, precision = 20, scale = 6)
    private BigDecimal qt;

    @Column(name = "PVENDA", nullable = false, precision = 18, scale = 6)
    private BigDecimal pvenda;

    @Column(name = "CODAUXILIAR", precision = 20)
    private Long codauxiliar;

    @Id
    @Column(name = "NUMSEQ", nullable = false, precision = 20)
    private Long numseq;

    @Column(name = "CODFILIALRETIRA", length = 2)
    private String codfilialretira;

    @Column(name = "QT_FATURADA", precision = 20, scale = 6)
    private BigDecimal qt_faturada;

    @Column(name = "OBSERVACAO_PC", length = 4000)
    private String observacao_pc;

    /** Data de Inclusão no registro */
    @Column(name = "DTINCLUSAO")
    private LocalDateTime dtinclusao;

    /** Determina o tipo de unidade para frios. */
    @Column(name = "UNIDADE_FRIOS", length = 2)
    private String unidade_frios;

    /** Serve para o palm enviar para a package a informação se o item é bonificado */
    @Column(name = "BONIFIC", length = 1)
    private String bonific;

    /** Informar código do combo */
    @Column(name = "CODCOMBO", precision = 10)
    private Long codcombo;

    /** Informar se item utiliza politica de desconto prioritaria */
    @Column(name = "POLITICAPRIORITARIA", length = 1)
    private String politicaprioritaria;

    /** Data de Alteração no registro */
    @Column(name = "DTALTERACAO")
    private LocalDateTime dtalteracao;

    /** Percentual de Desconto enviado pelo EDI */
    @Column(name = "PERCDESCEDI", precision = 18, scale = 6)
    private BigDecimal percdescedi;

    /** Código do Motivo de Não Atendimento */
    @Column(name = "CODMOTIVONAOATEND", precision = 3)
    private Integer codmotivonaoatend;

    /** Percentual de Desconto do Boleto */
    @Column(name = "PERDESCBOLETO", precision = 12, scale = 4)
    private BigDecimal perdescboleto;

    /** Código do Produto no OL */
    @Column(name = "CODPRODOL", length = 20)
    private String codprodol;

    /** Informa se teve corte ou não no item do pedido */
    @Column(name = "CORTE", length = 1)
    private String corte;

    /** Informa se o item foi sugestão de venda */
    @Column(name = "SUGESTAO", length = 1)
    private String sugestao;

    /** Tipo de entrega do item para venda 7 */
    @Column(name = "TIPOENTREGA", length = 2)
    private String tipoentrega;

    /** Número do pedido no winthor */
    @Column(name = "NUMPED", precision = 10)
    private Long numped;

    /** Indica o tipo de restrição de transporte. */
    @Column(name = "RESTRICAOTRANSP", length = 1)
    private String restricaotransp;

    /** Define se o produto será a enviar(E) ou recolher(R) nos pedidos TV11 */
    @Column(name = "TIPOTV11", length = 1)
    private String tipotv11;

    /** Versão da Package que Processou o Pedido */
    @Column(name = "VERSAOPKG", length = 20)
    private String versaopkg;

    /** Valor da base de calculo na Uf de destino */
    @Column(name = "VLBASEPARTDEST", precision = 18, scale = 6)
    private BigDecimal vlbasepartdest;

    /** Aliquota de FCP (fundo de combate a pobreza) */
    @Column(name = "ALIQFCP", precision = 18, scale = 6)
    private BigDecimal aliqfcp;

    /** Aliquota de ICMS interna na UF de destino */
    @Column(name = "ALIQINTERNADEST", precision = 18, scale = 6)
    private BigDecimal aliqinternadest;

    /** Valor do FUNCEP */
    @Column(name = "VLFCPPART", precision = 18, scale = 6)
    private BigDecimal vlfcppart;

    /** Valor do ICMS Interestadual para a UF Destino */
    @Column(name = "VLICMSPARTDEST", precision = 18, scale = 6)
    private BigDecimal vlicmspartdest;

    /** Valor de ICMS de partilha (valor que deverá ser utilizado para acrescer o valor do produto) */
    @Column(name = "VLICMSPART", precision = 18, scale = 6)
    private BigDecimal vlicmspart;

    /** Percentual provisório de partilha de ICMS */
    @Column(name = "PERCPROVPART", precision = 5, scale = 2)
    private BigDecimal percprovpart;

    /** Valor de ICMS do diferencial de aliquota da partilha de ICMS */
    @Column(name = "VLICMSDIFALIQPART", precision = 22, scale = 6)
    private BigDecimal vlicmsdifaliqpart;

    /** Redução aplicada na base de Partilha */
    @Column(name = "PERCBASEREDPART", precision = 5, scale = 2)
    private BigDecimal percbaseredpart;

    /** Valor do ICMS de partilha para UF remetente */
    @Column(name = "VLICMSPARTREM", precision = 18, scale = 6)
    private BigDecimal vlicmspartrem;

    /** Aliquota de ICMS da UF de origem */
    @Column(name = "ALIQINTERORIGPART", precision = 18, scale = 6)
    private BigDecimal aliqinterorigpart;

    /** Indica se a quantidade do produto deve ser múltipla da quantidade master */
    @Column(name = "USAUNIDADEMASTER", length = 1)
    private String usaunidademaster;

    /** Código de simulador do desconto */
    @Column(name = "CODDESCONTOSIMULADOR", precision = 8)
    private Integer coddescontosimulador;

    /** Define se o produto irá ser com devolução de carcaça ou não */
    @Column(name = "DEVOLUCAOCARCACA", length = 1)
    private String devolucaocarcaca;

    /** Contém o valor do desconto de carcaça */
    @Column(name = "VLDESCCARCACA", precision = 18, scale = 6)
    private BigDecimal vldesccarcaca;

    /** Identifica se o combo 'A - Ativando campanha ' ou 'C - Combo Contínuo' */
    @Column(name = "TIPOCOMBO", length = 1)
    private String tipocombo;

    /** Identifica se irá movimentar conta corrente RCA ou não */
    @Column(name = "MOVIMENTACONTACORRENTERCA", length = 1)
    private String movimentacontacorrenterca;

    /** Valor da base de calculo do Fundo de Combate a Pobreza */
    @Column(name = "VLBASEFCPICMS", precision = 18, scale = 6)
    private BigDecimal vlbasefcpicms;

    /** Valor de base de calculo do Fundo de Combate a Pobreza ST */
    @Column(name = "VLBASEFCPST", precision = 18, scale = 6)
    private BigDecimal vlbasefcpst;

    /** Valor da base de calculo do FCP retido anteriormente por ST */
    @Column(name = "VLBCFCPSTRET", precision = 18, scale = 6)
    private BigDecimal vlbcfcpstret;

    /** Percentual do FCP retido anteriormente por Substituição Tributaria */
    @Column(name = "PERFCPSTRET", precision = 12, scale = 4)
    private BigDecimal perfcpstret;

    /** Valor do FCP retido por Substituição Tributária */
    @Column(name = "VLFCPSTRET", precision = 18, scale = 6)
    private BigDecimal vlfcpstret;

    /** Aliquota aplicável de cálculo do crédito(SIMPLES NACIONAL) */
    @Column(name = "PERFCPSN", precision = 12, scale = 4)
    private BigDecimal perfcpsn;

    /** Valor crédito do ICMS que pode ser aproveitado nos termos do art. 23 da LC 123 (SIMPLES NACIONAL) */
    @Column(name = "VLCREDFCPICMSSN", precision = 18, scale = 6)
    private BigDecimal vlcredfcpicmssn;

    /** Valor Fecp. */
    @Column(name = "VLFECP", precision = 18, scale = 6)
    private BigDecimal vlfecp;

    /** Valor Acrescimo FUNCEP */
    @Column(name = "VLACRESCIMOFUNCEP", precision = 18, scale = 6)
    private BigDecimal vlacrescimofuncep;

    /** Percentual Acrescimo FUNCEP */
    @Column(name = "PERACRESCIMOFUNCEP", precision = 12, scale = 4)
    private BigDecimal peracrescimofuncep;

    /** Alíquota de ICMS Fecp. */
    @Column(name = "ALIQICMSFECP", precision = 12, scale = 4)
    private BigDecimal aliqicmsfecp;

    /** Aplicar Redução de Comissão */
    @Column(name = "PERREDCOMISS", precision = 18, scale = 6)
    private BigDecimal perredcomiss;

    /** Indica o número do pedido original de comprar do item */
    @Column(name = "NUMPEDCLI", length = 15)
    private String numpedcli;

    /** Número do item no XML da nota */
    @Column(name = "NUMITEMPED", precision = 8)
    private Integer numitemped;

    /** Código da politica prioritária que será usada */
    @Column(name = "CODDESCONTO", precision = 8)
    private Integer coddesconto;

    /** Data de entrega */
    @Column(name = "DTENTREGA")
    private LocalDateTime dtentrega;

    /** Código do desconto selecionado no pedido de venda farma */
    @Column(name = "CODDESCONTOMED", precision = 8)
    private Integer coddescontomed;

    /** Resposta do Questionamento do rateio frete. */
    @Column(name = "RESPQUESTFRETE", length = 1)
    private String respquestfrete;

    @Column(name = "ION_ID", length = 36)
    private String ion_id;

    @Column(name = "BASECALCST", precision = 12, scale = 4)
    private BigDecimal basecalcst;

    @Column(name = "ST", precision = 12, scale = 4)
    private BigDecimal st;

    @Column(name = "PERCICM", precision = 12, scale = 4)
    private BigDecimal percicm;

    @Column(name = "PERCBASERED", precision = 12, scale = 4)
    private BigDecimal percbasered;

    @Column(name = "BASEICMS", precision = 12, scale = 4)
    private BigDecimal baseicms;

    @Column(name = "PERCIPI", precision = 12, scale = 4)
    private BigDecimal percipi;

    @Column(name = "VLIPI", precision = 18, scale = 6)
    private BigDecimal vlipi;

    @Column(name = "CODPROMOCAOMED", precision = 10)
    private Long codpromocaomed;

    @Column(name = "CODGRUPOFLEX", precision = 9)
    private Integer codgrupoflex;

    /** Indica que o % informado PERDESCBOLETO é relacionado a CASHBACK. */
    @Column(name = "USACASHBACK", length = 1)
    private String usacashback;

    /** Campo que identifica o pedido do força de vendas */
    @Column(name = "IDFV", length = 60)
    private String idfv;

    /** Código da restrição processado pelo agendador */
    @Column(name = "CODRESTRICAOAGENDADOR", precision = 10)
    private Long codrestricaoagendador;

    /** Data de inicio do processamento no agendador */
    @Column(name = "DTINIPROCESSAMENTOAGENDADOR")
    private LocalDateTime dtiniprocessamentoagendador;

    /** Data fim do processamento no agendador */
    @Column(name = "DTFIMPROCESSAMENTOAGENDADOR")
    private LocalDateTime dtfimprocessamentoagendador;

    /** CPF Responsável Técnico Agrícola */
    @Column(name = "CPFRESPTECNICOAGRICOLA", length = 11)
    private String cpfresptecnicoagricola;

    /** Número Receituário Agrícola */
    @Column(name = "NUMRECEITUARIOAGRICOLA", length = 40)
    private String numreceituarioagricola;
}
