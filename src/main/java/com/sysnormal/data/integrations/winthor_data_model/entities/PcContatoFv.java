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
 * Entity class — contato de cliente enviado pela força de vendas ({@link PcClientFv}).
 *
 * <p>Ligado ao cliente pelo {@code CGCCLI}. Lido pela {@code IMPORTARCADASTROS}
 * ({@code p_tiporeg} 2), que grava o {@code PCCONTATO} e devolve {@code IMPORTADO} e
 * {@code OBSERVACAO_PC} em todas as linhas pendentes do mesmo {@code CGCCLI}. ⚠️ A
 * leitura não filtra por RCA. {@code TRG_INT_PCCONTATOFV} preenche {@code DTINCLUSAO} e
 * {@code DTALTERACAO}; {@code ION_ID} é da ION.</p>
 *
 * <p>⚠️ <b>A tabela não tem chave primária</b> no Oracle. A chave desta entidade existe
 * porque o JPA exige uma, e não identifica a linha: o mesmo cliente pode ter várias
 * linhas, uma por envio. Quem identifica a linha é o {@code ROWID}, que é como a própria
 * package {@code IMPORTARCADASTROS} devolve o resultado. A entidade serve de estrutura
 * das colunas; não carregue linhas por ela.</p>
 *
 * <p>Os campos têm o nome da coluna em minúsculas, sem camelCase: são 24 colunas de um
 * layout de terceiro, geradas do dicionário do Oracle em 2026-10-19, e o contrato de
 * quem usa a entidade fala o nome da coluna (ver {@code ColunasDoWinthor} no
 * winthor-integration-service). Os comentários dos campos são os da própria coluna no
 * banco.</p>
 */
@Getter
@Setter
@Entity
@IdClass(PcContatoFvId.class)
@Table(name = "PCCONTATOFV")
public class PcContatoFv extends BaseEntity {

    @Column(name = "IMPORTADO", nullable = false, precision = 1)
    private Integer importado;

    @Id
    @Column(name = "CGCCLI", nullable = false, length = 18)
    private String cgccli;

    @Id
    @Column(name = "NOMECONTATO", nullable = false, length = 40)
    private String nomecontato;

    @Column(name = "TIPOCONTATO", nullable = false, length = 1)
    private String tipocontato;

    @Column(name = "CGCCPF", length = 18)
    private String cgccpf;

    @Column(name = "DTNASCIMENTO")
    private LocalDateTime dtnascimento;

    @Column(name = "HOBBIE", length = 50)
    private String hobbie;

    @Column(name = "TIME", length = 30)
    private String time;

    @Column(name = "NOMECONJUGE", length = 40)
    private String nomeconjuge;

    @Column(name = "DTNASCCONJUGE")
    private LocalDateTime dtnascconjuge;

    @Column(name = "ENDERECO", length = 40)
    private String endereco;

    @Column(name = "BAIRRO", length = 150)
    private String bairro;

    @Column(name = "CIDADE", length = 30)
    private String cidade;

    @Column(name = "CEP", length = 9)
    private String cep;

    @Column(name = "CARGO", length = 30)
    private String cargo;

    @Column(name = "TELEFONE", length = 18)
    private String telefone;

    @Column(name = "CELULAR", length = 18)
    private String celular;

    @Column(name = "EMAIL", length = 50)
    private String email;

    @Column(name = "ESTADO", length = 2)
    private String estado;

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

    @Column(name = "ION_ID", length = 36)
    private String ion_id;
}
