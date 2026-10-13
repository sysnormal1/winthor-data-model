package com.sysnormal.data.integrations.winthor_data_model.entities;

import com.sysnormal.data.base_data_model.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity class — o enriquecimento cadastral de um cliente.
 *
 * <p>O meio da hierarquia: {@link PcServico} → {@code PCSERVICOCLIENTE} →
 * {@link PcServicoClienteEndereco}, {@link PcServicoClienteTelefone},
 * {@link PcServicoClienteSituacao}, {@link PcServicoClienteSocio},
 * {@link PcServicoClienteCnae} e {@link PcServicoClienteHistorico}.</p>
 *
 * <h2>⚠️ {@code CODCLIENTE} não é o {@code PCCLIENT.CODCLI}</h2>
 *
 * <p>É o código do cliente <b>dentro do serviço</b> de enriquecimento. Não há FK nem
 * vínculo nenhum, nem fictício, entre esta tabela e o {@code PCCLIENT} — conferido. O
 * <b>único</b> dado que liga uma linha daqui a um cliente do ERP é o identificador
 * público: o <b>CNPJ</b>.</p>
 *
 * <p>Consequência: o mesmo CNPJ pode aparecer em dois serviços diferentes, com
 * {@code CODCLIENTE} distintos. A identidade do registro é o par <b>CNPJ +
 * {@code CODSERVICO}</b>; o {@code CODCLIENTE} é só o surrogate que a tabela usa como
 * PK.</p>
 *
 * <p>Por isso o {@code CODCLIENTE} <b>não é atribuído por quem chama</b>: o serviço o
 * resolve pelo par CNPJ + serviço e, não achando, gera {@code MAX+1}. Um
 * {@code CODCLIENTE} vindo no corpo é tratado como <i>afirmação a conferir</i> — se já
 * existir e não casar com o CNPJ e o serviço informados, a gravação é recusada.</p>
 *
 * <p>O {@code CNPJ} é gravado <b>em dígitos, sem máscara</b>, justamente para que essa
 * resolução seja exata: a mesma empresa gravada com e sem máscara produziria duas
 * linhas que o par não distingue.</p>
 *
 * <p>⚠️ {@code CODSERVICO} tem FK <b>ENABLED e VALIDATED</b> para {@link PcServico}.
 * A coluna aceita nulo no banco, mas gravá-la nula desliga a linha da raiz e some com
 * a procedência do dado — o serviço sempre a preenche.</p>
 *
 * <p>Os campos de estimativa ({@code ESTIMATIVAPORTE},
 * {@code ESTIMATIVAQTDEFUNCIONARIOS}, {@code ESTIMATIVAFAIXAFATURAMENTO},
 * {@code SCOREATIVIDADE}) são de <b>bureau</b>, não da Receita: o desenho original era
 * de um serviço pago de enriquecimento. Ficam nulos quando a fonte é a Receita, que
 * não os fornece.</p>
 */
@Getter
@Setter
@Entity
@Table(name = "PCSERVICOCLIENTE")
public class PcServicoCliente extends BaseEntity {

    /**
     * O código do cliente <b>no serviço</b>, e a PK. Não é o {@code PCCLIENT.CODCLI}.
     */
    @Id
    @Column(name = "CODCLIENTE")
    private Long codCliente;

    /** FK para {@link PcServico}. */
    @Column(name = "CODSERVICO")
    private Long codServico;

    /** Em dígitos, sem máscara — é metade da identidade do registro. */
    @Column(name = "CNPJ", length = 50)
    private String cnpj;

    @Column(name = "RAZAOSOCIAL", length = 255)
    private String razaoSocial;

    @Column(name = "NOMEFANTASIA", length = 255)
    private String nomeFantasia;

    @Column(name = "CAPITALINVESTIMENTO", length = 255)
    private String capitalInvestimento;

    /** Dado de bureau, não da Receita. */
    @Column(name = "ESTIMATIVAPORTE", length = 50)
    private String estimativaPorte;

    /** Dado de bureau, não da Receita. */
    @Column(name = "ESTIMATIVAQTDEFUNCIONARIOS", length = 50)
    private String estimativaQtdeFuncionarios;

    /** Dado de bureau, não da Receita. */
    @Column(name = "ESTIMATIVAFAIXAFATURAMENTO", length = 50)
    private String estimativaFaixaFaturamento;

    /** Dado de bureau, não da Receita. */
    @Column(name = "SCOREATIVIDADE", length = 50)
    private String scoreAtividade;
}
