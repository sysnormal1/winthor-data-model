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
 * Entity class — o log de operações do enriquecimento cadastral.
 *
 * <p>É o log <b>do recurso</b>, não um log por campo: registra que uma operação
 * aconteceu, com que resultado e por quem, e não o valor anterior e o novo. Para o
 * {@code PCCLIENT} esse papel é do {@code PCLOGALTCLI}, alimentado por
 * {@code PcClientAuditedWriter}; esta família não tem log por campo no ERP, e é aqui
 * que a escrita se registra.</p>
 *
 * <p>⚠️ {@code USUARIOLOGADO} é <b>e-mail</b>, não matrícula — o comentário da coluna
 * no banco diz isso, e é coerente com o recurso ter sido desenhado para um produto web
 * da TOTVS. É a diferença em relação ao resto do serviço, que assina com a matrícula
 * {@code 265} ({@code PCEMPR SYSNORMAL-WINTHOR-INTEGRATION-SERVICE}).</p>
 *
 * <p>{@code RESULTADOOPERACAO} é {@code SUCESSO} ou {@code FALHA}, pelo comentário da
 * coluna.</p>
 *
 * <p>⚠️ {@code CODHISTORICO} é PK global sem sequence: {@code MAX+1}.</p>
 */
@Getter
@Setter
@Entity
@Table(name = "PCSERVICOCLIENTEHISTORICO")
public class PcServicoClienteHistorico extends BaseEntity {

    @Id
    @Column(name = "CODHISTORICO")
    private Long codHistorico;

    /** FK para {@link PcServicoCliente}. */
    @Column(name = "CODCLIENTE")
    private Long codCliente;

    @Column(name = "DATAMODIFICACAO")
    private LocalDateTime dataModificacao;

    /** É e-mail, não matrícula. */
    @Column(name = "USUARIOLOGADO", length = 255)
    private String usuarioLogado;

    /** {@code SUCESSO} ou {@code FALHA}. */
    @Column(name = "RESULTADOOPERACAO", length = 50)
    private String resultadoOperacao;

    @Column(name = "TIPOOPERACAO", length = 255)
    private String tipoOperacao;

    @Column(name = "DESCRICAO", length = 255)
    private String descricao;
}
