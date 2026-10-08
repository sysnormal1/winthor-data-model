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
 * Entity class — os contatos do cliente.
 *
 * <p>Uma tabela só para todos os papéis ligados ao cliente, separados pelo
 * {@code TIPOCONTATO} de uma letra: {@code C} comprador, {@code F} funcionário,
 * {@code G} gerente, {@code P} procurador, {@code S} <b>sócio</b> e {@code T} pessoa
 * física. O {@code S} é a contraparte, no Winthor, do quadro societário da Receita.</p>
 *
 * <p>⚠️ {@code CODCONTATO} é a chave primária e é <b>global</b>, não por cliente — e
 * não há sequence do Oracle que a alimente: o ERP calcula {@code MAX+1}.</p>
 */
@Getter
@Setter
@Entity
@Table(name = "PCCONTATO")
public class PcContato extends BaseEntity {

    @Id
    @Column(name = "CODCONTATO")
    private Long codContato;

    @Column(name = "CODCLI")
    private Long codCli;

    /** C comprador, F funcionario, G gerente, P procurador, S socio, T pessoa fisica. */
    @Column(name = "TIPOCONTATO")
    private String tipoContato;

    @Column(name = "NOMECONTATO")
    private String nomeContato;

    @Column(name = "CARGO")
    private String cargo;

    /** CPF ou CNPJ com mascara. */
    @Column(name = "CGCCPF")
    private String cgcCpf;

    /** So digitos, preenchido por trigger do ERP a partir do CGCCPF. */
    @Column(name = "CGCCPFAUX")
    private String cgcCpfAux;

    @Column(name = "RG")
    private String rg;

    @Column(name = "DOC")
    private String doc;

    @Column(name = "DTNASCIMENTO")
    private LocalDateTime dtNascimento;

    /** Percentual de participacao do socio. */
    @Column(name = "PARTICIPSOCIO")
    private BigDecimal participSocio;

    /** Data de entrada na sociedade. */
    @Column(name = "DTSOCIEDADE")
    private LocalDateTime dtSociedade;

    @Column(name = "NOMECONJUGE")
    private String nomeConjuge;

    @Column(name = "DTNASCCONJUGE")
    private LocalDateTime dtNascConjuge;

    @Column(name = "ENDERECO")
    private String endereco;

    @Column(name = "BAIRRO")
    private String bairro;

    @Column(name = "CIDADE")
    private String cidade;

    @Column(name = "ESTADO")
    private String estado;

    @Column(name = "CEP")
    private String cep;

    @Column(name = "TELEFONE")
    private String telefone;

    @Column(name = "CELULAR")
    private String celular;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "HOBBIE")
    private String hobbie;

    @Column(name = "TIME")
    private String time;

    @Column(name = "OBS")
    private String obs;

    @Column(name = "AUTORCH")
    private String autorCh;

    @Column(name = "AUTORIZADO")
    private String autorizado;

    @Column(name = "MOTIVONAOAUTORIZADO")
    private String motivoNaoAutorizado;

    @Column(name = "DTBLOQUEIO")
    private LocalDateTime dtBloqueio;

    @Column(name = "DTDESBLOQUEIO")
    private LocalDateTime dtDesbloqueio;

    @Column(name = "CODFUNCBLOQUEIO")
    private Long codFuncBloqueio;

    @Column(name = "CODFUNCDESBLOQUEIO")
    private Long codFuncDesbloqueio;

    @Column(name = "CODBANCO")
    private Long codBanco;

    @Column(name = "AGENCIA")
    private String agencia;

    @Column(name = "CONTA")
    private String conta;

    @Column(name = "SENHA")
    private String senha;

    /**
     * Controle de uma integracao do proprio ERP.
     *
     * <p>⚠️ O {@code IONSYNC} fica DE FORA de proposito. Ele e {@code CHAR(1)}, e nao
     * {@code VARCHAR2}, e nenhuma entidade deste model mapeia coluna {@code CHAR} --
     * seria a primeira. O {@code hbm2ddl=validate} compara o codigo de tipo JDBC, e
     * {@code CHAR} contra {@code VARCHAR} e exatamente onde ele reclama. Como nada no
     * ecossistema le essa coluna, mapea-la so acrescentaria risco de o servico nao
     * subir. Se um dia for preciso, confira o comportamento do validate antes.</p>
     */
    @Column(name = "ION_ID")
    private String ionId;
}
