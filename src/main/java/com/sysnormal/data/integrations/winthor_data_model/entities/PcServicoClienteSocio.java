package com.sysnormal.data.integrations.winthor_data_model.entities;

import com.sysnormal.data.base_data_model.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity class — um sócio do cliente.
 *
 * <p>⚠️ <b>O quadro societário da Receita não vem para cá.</b> Ele vai para o
 * {@link PcContato} com {@code TIPOCONTATO = 'S'}, pelo mesmo motivo do telefone: o
 * {@code PCCONTATO} tem tela no ERP e é lá que a empresa já guarda sócio. Esta tabela
 * não tem tela.</p>
 *
 * <p>A entidade existe porque a família foi mapeada inteira.</p>
 *
 * <p>⚠️ {@code CODSOCIO} é PK global sem sequence: {@code MAX+1}. O comentário da
 * coluna no banco diz "Código de identificação do endereço" — copiado errado.</p>
 */
@Getter
@Setter
@Entity
@Table(name = "PCSERVICOCLIENTESOCIO")
public class PcServicoClienteSocio extends BaseEntity {

    @Id
    @Column(name = "CODSOCIO")
    private Long codSocio;

    /** FK para {@link PcServicoCliente}. */
    @Column(name = "CODCLIENTE")
    private Long codCliente;

    @Column(name = "RAZAOSOCIAL", length = 255)
    private String razaoSocial;

    @Column(name = "CNPJ", length = 50)
    private String cnpj;

    @Column(name = "CAPITALINVESTIDO", length = 255)
    private String capitalInvestido;

    @Column(name = "REGISTRO", length = 50)
    private String registro;
}
