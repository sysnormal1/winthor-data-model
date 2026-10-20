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
 * Entity class — referência comercial de cliente enviada pela força de vendas.
 *
 * <p>PK {@code CGCCLI, CODREF}. Lida pela {@code IMPORTARCADASTROS} ({@code p_tiporeg}
 * 11), que devolve {@code IMPORTADO} e {@code OBSERVACAO_PC}. ⚠️ A leitura não filtra
 * por RCA. Nenhuma linha nova desde antes de 2026-07 (medido em 2026-10-20).</p>
 *
 * <p>Os campos têm o nome da coluna em minúsculas, sem camelCase: são 18 colunas de um
 * layout de terceiro, geradas do dicionário do Oracle em 2026-10-19, e o contrato de
 * quem usa a entidade fala o nome da coluna (ver {@code ColunasDoWinthor} no
 * winthor-integration-service). Os comentários dos campos são os da própria coluna no
 * banco.</p>
 */
@Getter
@Setter
@Entity
@IdClass(PcCliRefFvId.class)
@Table(name = "PCCLIREFFV")
public class PcCliRefFv extends BaseEntity {

    /** Flag de importação do pedido */
    @Column(name = "IMPORTADO", nullable = false, precision = 1)
    private Integer importado;

    /** cgc/Cpf do cliente */
    @Id
    @Column(name = "CGCCLI", nullable = false, length = 18)
    private String cgccli;

    /** sequencial para referencia por cliente */
    @Id
    @Column(name = "CODREF", nullable = false, precision = 2)
    private Integer codref;

    /** Codigo do cliente */
    @Column(name = "CODCLI", precision = 6)
    private Integer codcli;

    /** nome da referencia */
    @Column(name = "EMPREFER", length = 40)
    private String emprefer;

    /** Telefone da referencia */
    @Column(name = "TELREFER", length = 13)
    private String telrefer;

    /** Contato da referencia */
    @Column(name = "CONTATOREFER", length = 40)
    private String contatorefer;

    /** Limite de credito */
    @Column(name = "LIMCREDREFER", precision = 14, scale = 2)
    private BigDecimal limcredrefer;

    /** Data de cadastro da referencia */
    @Column(name = "DTCADASTROREFER")
    private LocalDateTime dtcadastrorefer;

    /** Data da ultima compra */
    @Column(name = "DTULTCOMPREFER")
    private LocalDateTime dtultcomprefer;

    /** Valor da ultima compra */
    @Column(name = "VLULTCOMPREFER", precision = 14, scale = 2)
    private BigDecimal vlultcomprefer;

    /** Observação */
    @Column(name = "OBS", length = 80)
    private String obs;

    /** Data da maior compra */
    @Column(name = "DTMAIORCOMPREFER")
    private LocalDateTime dtmaiorcomprefer;

    /** Valor da maior compra */
    @Column(name = "VLMAIORCOMPREFER", precision = 14, scale = 2)
    private BigDecimal vlmaiorcomprefer;

    /** Codigo de cobrança */
    @Column(name = "CODCOBREFER", length = 4)
    private String codcobrefer;

    /** Mensagem de retorno da package */
    @Column(name = "OBSERVACAO_PC", length = 4000)
    private String observacao_pc;

    /** Data de inclusão do registro na tabela */
    @Column(name = "DTINCLUSAO")
    private LocalDateTime dtinclusao;

    @Column(name = "ION_ID", length = 36)
    private String ion_id;
}
