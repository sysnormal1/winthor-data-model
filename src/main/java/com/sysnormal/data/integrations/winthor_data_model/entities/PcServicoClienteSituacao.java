package com.sysnormal.data.integrations.winthor_data_model.entities;

import com.sysnormal.data.base_data_model.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Entity class — a situação cadastral do cliente na Receita, por fonte.
 *
 * <p>É o destino natural da "situação na Receita", que <b>não tem coluna no
 * {@code PCCLIENT}</b> — varrido em 2026-10-09, não existe campo de situação cadastral
 * lá. Até agora a baixa era tratada só como sequência de efeitos
 * ({@code /api/clients/registration/inactivate}: {@code DTEXCLUSAO},
 * {@code CODUSUR1 = 150}, anula os demais {@code CODUSUR*} e anexa nota ao
 * {@code OBSERVACAO}); o <b>fato</b> que motivou a baixa não ficava registrado em
 * lugar nenhum do ERP.</p>
 *
 * <p>Esta tabela registra o fato: {@code STATUS} como veio da fonte,
 * {@code STATUSNORMALIZADO} para comparar, {@code DATAREGISTRO} e
 * {@code DATAENCERRAMENTO} da atividade, {@code DATAULTIMACONSULTA} para saber a
 * idade do dado, e {@code INSCRICAOESTADUAL}.</p>
 *
 * <p>⚠️ {@code CODSITUACAO} é PK global sem sequence: {@code MAX+1}. O comentário da
 * coluna {@code FONTE} no banco diz "Fonte de origem deste endereço" — copiado errado
 * da tabela de endereço.</p>
 */
@Getter
@Setter
@Entity
@Table(name = "PCSERVICOCLIENTESITUACAO")
public class PcServicoClienteSituacao extends BaseEntity {

    @Id
    @Column(name = "CODSITUACAO")
    private Long codSituacao;

    /** FK para {@link PcServicoCliente}. */
    @Column(name = "CODCLIENTE")
    private Long codCliente;

    /** A procedência desta situação. */
    @Column(name = "FONTE", length = 255)
    private String fonte;

    /** A situação como veio da fonte. */
    @Column(name = "STATUS", length = 255)
    private String status;

    /** A situação reduzida à forma que se compara. */
    @Column(name = "STATUSNORMALIZADO", length = 50)
    private String statusNormalizado;

    @Column(name = "DATAREGISTRO")
    private LocalDateTime dataRegistro;

    /** Data de encerramento da atividade — preenchida quando a empresa foi baixada. */
    @Column(name = "DATAENCERRAMENTO")
    private LocalDateTime dataEncerramento;

    /** Quando a fonte foi consultada; é o que diz a idade do dado. */
    @Column(name = "DATAULTIMACONSULTA")
    private LocalDateTime dataUltimaConsulta;

    @Column(name = "INSCRICAOESTADUAL", length = 50)
    private String inscricaoEstadual;

    @Column(name = "DATAALTERACAOCADASTRO")
    private LocalDateTime dataAlteracaoCadastro;

    @Column(name = "RESPONSAVELALTERACAOCADASTRO", length = 255)
    private String responsavelAlteracaoCadastro;

    /** {@code CLOB} na origem. */
    @Lob
    @Column(name = "INFORMACOESADICIONAIS")
    private String informacoesAdicionais;
}
