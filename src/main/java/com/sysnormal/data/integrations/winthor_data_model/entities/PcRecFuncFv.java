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
 * Entity class — recado do RCA para um funcionário da empresa, enviado pela força de
 * vendas.
 *
 * <p>Lido pela {@code IMPORTARCADASTROS} ({@code p_tiporeg} 3), que confere o
 * destinatário ({@code CODFUNCDEST}, matrícula do {@code PCEMPR}) e grava o
 * {@code PCRECFUNC}; recusa recado com o mesmo {@code NUMRECADOFV} e {@code CODUSUR} que
 * o {@code PCRECFUNC} já tenha. {@code NUMRECADOFV} é PK global aqui, sem sequence.
 * {@code TRG_INT_PCRECFUNCFV} preenche as datas. Nenhuma linha nova desde 2022 (medido em
 * 2026-10-20).</p>
 *
 * <p>Os campos têm o nome da coluna em minúsculas, sem camelCase: são 9 colunas de um
 * layout de terceiro, geradas do dicionário do Oracle em 2026-10-19, e o contrato de
 * quem usa a entidade fala o nome da coluna (ver {@code ColunasDoWinthor} no
 * winthor-integration-service). Os comentários dos campos são os da própria coluna no
 * banco.</p>
 */
@Getter
@Setter
@Entity
@Table(name = "PCRECFUNCFV")
public class PcRecFuncFv extends BaseEntity {

    @Column(name = "IMPORTADO", nullable = false, precision = 1)
    private Integer importado;

    @Column(name = "CODFUNCDEST", nullable = false, precision = 8)
    private Integer codfuncdest;

    @Column(name = "ASSUNTO", length = 100)
    private String assunto;

    @Column(name = "TEXTORECADO", nullable = false, length = 4000)
    private String textorecado;

    @Id
    @Column(name = "NUMRECADOFV", nullable = false, precision = 12)
    private Long numrecadofv;

    @Column(name = "CODUSUR", nullable = false, precision = 4)
    private Integer codusur;

    @Column(name = "OBSERVACAO_PC", length = 4000)
    private String observacao_pc;

    /** Grava Data e Hora da Última Importação. */
    @Column(name = "DTINCLUSAO")
    private LocalDateTime dtinclusao;

    /** Data de Alteração no registro */
    @Column(name = "DTALTERACAO")
    private LocalDateTime dtalteracao;
}
