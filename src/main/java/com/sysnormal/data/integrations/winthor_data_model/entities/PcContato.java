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
    @Column(name = "TIPOCONTATO", length = 1)
    private String tipoContato;

    @Column(name = "NOMECONTATO", length = 40)
    private String nomeContato;

    @Column(name = "CARGO", length = 30)
    private String cargo;

    /** CPF ou CNPJ com mascara. */
    @Column(name = "CGCCPF", length = 18)
    private String cgcCpf;

    /** So digitos, preenchido por trigger do ERP a partir do CGCCPF. */
    @Column(name = "CGCCPFAUX", length = 14)
    private String cgcCpfAux;

    @Column(name = "RG", length = 20)
    private String rg;

    @Column(name = "DOC", length = 20)
    private String doc;

    @Column(name = "DTNASCIMENTO")
    private LocalDateTime dtNascimento;

    /** Percentual de participacao do socio. */
    @Column(name = "PARTICIPSOCIO")
    private BigDecimal participSocio;

    /** Data de entrada na sociedade. */
    @Column(name = "DTSOCIEDADE")
    private LocalDateTime dtSociedade;

    @Column(name = "NOMECONJUGE", length = 40)
    private String nomeConjuge;

    @Column(name = "DTNASCCONJUGE")
    private LocalDateTime dtNascConjuge;

    @Column(name = "ENDERECO", length = 40)
    private String endereco;

    @Column(name = "BAIRRO", length = 150)
    private String bairro;

    @Column(name = "CIDADE", length = 30)
    private String cidade;

    @Column(name = "ESTADO", length = 2)
    private String estado;

    @Column(name = "CEP", length = 9)
    private String cep;

    @Column(name = "TELEFONE", length = 18)
    private String telefone;

    @Column(name = "CELULAR", length = 18)
    private String celular;

    @Column(name = "EMAIL", length = 50)
    private String email;

    @Column(name = "HOBBIE", length = 50)
    private String hobbie;

    @Column(name = "TIME", length = 30)
    private String time;

    @Column(name = "OBS", length = 1000)
    private String obs;

    @Column(name = "AUTORCH", length = 1)
    private String autorCh;

    @Column(name = "AUTORIZADO", length = 1)
    private String autorizado;

    @Column(name = "MOTIVONAOAUTORIZADO", length = 2000)
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

    @Column(name = "AGENCIA", length = 6)
    private String agencia;

    @Column(name = "CONTA", length = 10)
    private String conta;

    @Column(name = "SENHA", length = 32)
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
    @Column(name = "ION_ID", length = 36)
    private String ionId;
}
