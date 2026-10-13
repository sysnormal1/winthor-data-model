package com.sysnormal.data.integrations.winthor_data_model.entities;

import com.sysnormal.data.base_data_model.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity class — um telefone do cliente, por fonte.
 *
 * <p>⚠️ <b>O telefone da Receita não vem para cá.</b> Ele continua indo para o
 * {@link PcContato} pela rota {@code /api/clients/contacts/append}, que está em
 * produção desde 2026-10-10. O motivo é o oposto do caso do endereço: o
 * {@code PCCONTATO} <b>tem tela</b> no ERP e uso real — é onde moram os sócios —, e o
 * operador precisa ver o telefone. Aqui ninguém veria.</p>
 *
 * <p>A entidade existe porque a tabela existe e a família foi mapeada inteira, não
 * porque haja gravação prevista nela.</p>
 *
 * <p>⚠️ {@code CODTELEFONE} é PK global sem sequence: {@code MAX+1}. O comentário da
 * coluna no banco diz "Código de identificação do endereço" — está copiado errado da
 * tabela de endereço, um dos sinais de que o recurso nativo nunca foi terminado.</p>
 */
@Getter
@Setter
@Entity
@Table(name = "PCSERVICOCLIENTETELEFONE")
public class PcServicoClienteTelefone extends BaseEntity {

    @Id
    @Column(name = "CODTELEFONE")
    private Long codTelefone;

    /** FK para {@link PcServicoCliente}. */
    @Column(name = "CODCLIENTE")
    private Long codCliente;

    /** A procedência deste telefone. */
    @Column(name = "FONTE", length = 255)
    private String fonte;

    @Column(name = "NUMERO", length = 50)
    private String numero;
}
