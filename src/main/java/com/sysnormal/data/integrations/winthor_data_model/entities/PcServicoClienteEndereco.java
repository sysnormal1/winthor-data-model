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
 * Entity class — um endereço do cliente, por fonte.
 *
 * <h2>Por que o endereço da Receita vem para cá e não para o {@code PCCLIENTENDENT}</h2>
 *
 * <p>O {@code PCCLIENTENDENT} (rotina 3324) é tabela de <b>roteirização e fiscal</b>,
 * não depósito cadastral. Medido e conferido na documentação da TOTVS em 2026-10-13:</p>
 *
 * <ul>
 *   <li>a rotina <b>901 (Montar Carga)</b> usa a rota e o endereço da 3324 quando o
 *       parâmetro 1198 está em {@code Não} — e nesta instalação
 *       ({@code CON_INFORMARECEBEDORVENDA}) ele está;</li>
 *   <li>o grupo <b>{@code <entrega>} do XML da NF-e</b> é criado quando a cidade IBGE
 *       de entrega e o endereço de entrega estão preenchidos;</li>
 *   <li>as rotinas 316/2316 permitem escolher aquele endereço no pedido, e o parâmetro
 *       3922 faz a <b>tributação</b> sair dele (desligado aqui, mas ligável);</li>
 *   <li>a trigger {@code IONV_SYNC.TK_IONTRK_PCCLIENTENDENT} <b>não tem gate</b>: ao
 *       contrário do {@code PCCONTATO}, que só enfileira com {@code IONSYNC = 'Y'},
 *       lá a condição é {@code CODENDENTCLI > 0} — toda inserção publica para o
 *       sistema externo.</li>
 * </ul>
 *
 * <p>Esta tabela não alimenta nenhuma das três coisas. E serve melhor por desenho:
 * tem {@code FONTE}, isto é, <b>uma linha por procedência</b>, que é exatamente o que
 * a conferência precisa; os campos de texto são largos ({@code VARCHAR2(255)} contra
 * {@code ENDERENT VARCHAR2(40)} e {@code MUNICENT VARCHAR2(15)}, onde um em cada seis
 * cadastros já está truncado pelo ERP); o {@code CODIGOIBGE} é dado inerte, sem
 * consumidor fiscal; e não existe código de praça, região ou bairro para adivinhar.</p>
 *
 * <p>{@code DATAALTERACAOCADASTRO} e {@code RESPONSAVELALTERACAOCADASTRO} são o eixo
 * de histórico que o {@code PCCLIENTENDENT} não tem.</p>
 *
 * <p>⚠️ Nenhuma tela do Winthor mostra esta tabela. O operador do ERP não vê o que for
 * gravado aqui — foi decisão explícita de quem pediu.</p>
 *
 * <p>⚠️ {@code CODENDERECO} é PK <b>global</b>, não por cliente, e sem sequence:
 * {@code MAX+1}. {@code CODCLIENTE} tem FK para {@link PcServicoCliente}.</p>
 */
@Getter
@Setter
@Entity
@Table(name = "PCSERVICOCLIENTEENDERECO")
public class PcServicoClienteEndereco extends BaseEntity {

    @Id
    @Column(name = "CODENDERECO")
    private Long codEndereco;

    /** FK para {@link PcServicoCliente}. */
    @Column(name = "CODCLIENTE")
    private Long codCliente;

    /** A procedência deste endereço. É o que permite mais de uma linha por cliente. */
    @Column(name = "FONTE", length = 255)
    private String fonte;

    @Column(name = "LOGRADOURO", length = 255)
    private String logradouro;

    @Column(name = "NUMERO", length = 50)
    private String numero;

    @Column(name = "COMPLEMENTO", length = 255)
    private String complemento;

    @Column(name = "BAIRRO", length = 255)
    private String bairro;

    @Column(name = "CIDADE", length = 255)
    private String cidade;

    @Column(name = "ESTADO", length = 255)
    private String estado;

    @Column(name = "CEP", length = 255)
    private String cep;

    /** O IBGE do município. Aqui é dado, não gatilho fiscal. */
    @Column(name = "CODIGOIBGE")
    private Long codigoIbge;

    @Column(name = "DATAALTERACAOCADASTRO")
    private LocalDateTime dataAlteracaoCadastro;

    @Column(name = "RESPONSAVELALTERACAOCADASTRO", length = 255)
    private String responsavelAlteracaoCadastro;
}
