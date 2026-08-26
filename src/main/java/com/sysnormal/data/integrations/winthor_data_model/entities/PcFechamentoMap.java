package com.sysnormal.data.integrations.winthor_data_model.entities;

import com.sysnormal.data.base_data_model.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Entity class
 *
 * Destino do fechamento de caixa do motorista: cada parcela de PCPREST acertada na rua vira uma linha
 * aqui, com TIPOFECHAMENTO = 'Acerto de Carregamento'.
 *
 * A tabela não tem chave primária declarada no Winthor. NUMSEQ é usada como @Id por vir da sequence
 * DFSEQ_PCFECHAMENTOMAP_NUMSEQ e ser, na prática, o identificador da linha — é escolha de modelagem
 * desta biblioteca, não uma constraint do banco.
 *
 * A inserção real é um INSERT ... SELECT a partir de PCPREST e não passa por persist: fica como query
 * nativa no serviço que faz o fechamento. Esta entidade serve para consultar, sobretudo para a
 * checagem de pré-existência por NUMTRANSVENDA que evita fechar a mesma nota duas vezes.
 */
@Getter
@Setter
@Entity
@Table(name = "PCFECHAMENTOMAP")
public class PcFechamentoMap extends BaseEntity {

    @Id
    @Column(name = "NUMSEQ")
    private Long numSeq;

    @Column(name = "NUMTRANSVENDA")
    private Long numTransVenda;

    @Column(name = "CODCLI")
    private Long codCli;

    @Column(name = "PREST", length = 2)
    private String prest;

    @Column(name = "DUPLIC")
    private Long duplic;

    @Column(name = "NUMCAR")
    private Long numCar;

    @Column(name = "NUMCHECKOUT")
    private Long numCheckout;

    @Column(name = "CODFUNCCHECKOUT")
    private Long codFuncCheckout;

    @Column(name = "VALOR")
    private BigDecimal valor;

    @Column(name = "DTVENC")
    private LocalDateTime dtVenc;

    @Column(name = "CODCOB", length = 4)
    private String codCob;

    @Column(name = "VPAGO")
    private BigDecimal vPago;

    @Column(name = "TXPERM")
    private BigDecimal txPerm;

    @Column(name = "DTPAG")
    private LocalDateTime dtPag;

    @Column(name = "DTEMISSAO")
    private LocalDateTime dtEmissao;

    @Column(name = "PERDESC")
    private BigDecimal perDesc;

    @Column(name = "CODFILIAL", length = 2)
    private String codFilial;

    @Column(name = "DTVENCORIG")
    private LocalDateTime dtVencOrig;

    @Column(name = "CODCOBORIG", length = 4)
    private String codCobOrig;

    @Column(name = "NSUTEF", length = 15)
    private String nsuTef;

    @Column(name = "PRESTTEF")
    private Long prestTef;

    @Column(name = "QTPARCELASPOS")
    private Long qtParcelasPos;

    @Column(name = "OBSERVACAOMAP", length = 4000)
    private String observacaoMap;

    @Column(name = "DATA")
    private LocalDateTime data;

    @Column(name = "GERAPARCELAMENTOTEF", length = 1)
    private String geraParcelamentoTef;

    @Column(name = "INFORMADADOSBXCCRED", length = 1)
    private String informaDadosBxCCred;

    @Column(name = "DESDCARTAOFECHCARGA", length = 1)
    private String desdCartaoFechCarga;

    @Column(name = "USOUPARCELAMENTOAUTOMATICO", length = 1)
    private String usouParcelamentoAutomatico;

    @Column(name = "USOUPARCELAMENTOMANUAL", length = 1)
    private String usouParcelamentoManual;

    @Column(name = "TITCOMNUMCARCAIXA", length = 1)
    private String titComNumCarCaixa;

    @Column(name = "PERMITEVENDAECF402", length = 1)
    private String permiteVendaEcf402;

    @Column(name = "TIPOFECHAMENTO", length = 100)
    private String tipoFechamento;
}
