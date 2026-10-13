package com.sysnormal.data.integrations.winthor_data_model.entities;

import com.sysnormal.data.base_data_model.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity class — um CNAE do cliente, com a marca de primário.
 *
 * <p>Complementa, sem substituir, o {@code PCCLIENT.CODCNAE}: lá cabe <b>um</b> CNAE, o
 * principal, e ele é gravado pela rota de cadastro resolvendo a forma mascarada contra
 * o {@code PCCNAE} (que tem FK {@code FK_PCCLIENT_PCCNAE} ENABLED e VALIDATED, então o
 * valor precisa existir no catálogo). Aqui cabem <b>todos</b>, inclusive os
 * secundários, que a Receita fornece e o cadastro do ERP não tem onde pôr.</p>
 *
 * <p>⚠️ {@code CODCNAE} é a <b>PK</b> desta tabela, apesar do nome: é chave surrogate
 * da linha, não o código do CNAE. O código fica em {@code NUMERO}
 * ({@code VARCHAR2(50)}), o que preserva a máscara da origem. Sem sequence:
 * {@code MAX+1}.</p>
 *
 * <p>{@code PRIMARIO} é {@code CHAR(1)}: {@code 'S'} para o principal, {@code 'N'}
 * para os demais — é o único comentário de coluna correto da família.</p>
 */
@Getter
@Setter
@Entity
@Table(name = "PCSERVICOCLIENTECNAE")
public class PcServicoClienteCnae extends BaseEntity {

    /** PK surrogate da linha, não o código do CNAE — este fica em {@code NUMERO}. */
    @Id
    @Column(name = "CODCNAE")
    private Long codCnae;

    /** FK para {@link PcServicoCliente}. */
    @Column(name = "CODCLIENTE")
    private Long codCliente;

    /** O código do CNAE, com a máscara da origem. */
    @Column(name = "NUMERO", length = 50)
    private String numero;

    @Column(name = "DESCRICAO", length = 255)
    private String descricao;

    /** {@code CHAR(1)}: {@code 'S'} se é o CNAE primário, {@code 'N'} se não. */
    @Column(name = "PRIMARIO", length = 1)
    private String primario;
}
