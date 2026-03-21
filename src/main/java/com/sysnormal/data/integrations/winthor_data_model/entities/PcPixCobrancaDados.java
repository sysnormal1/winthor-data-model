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
 * Entity class
 */
@Getter
@Setter
@Entity
@Table(name = "PCPIXCOBRANCADADOS")
public class PcPixCobrancaDados extends BaseEntity {
    @Id
    @Column( name = "NUMTRANSPAGDIGITAL", nullable = false, length = 100)
    private String numTransPagDigital;

    @Column( name = "FILIAL", length = 2)
    private String filial;

    @Column( name = "LINK", length = 250)
    private String link;

    @Column( name = "QRCODE", length = 4000)
    private String qrCode;

    @Column( name = "VENCIMENTO")
    private LocalDateTime vencimento;

    @Column( name = "DESCRICAO", length = 40000)
    private String descricao;

    @Column( name = "NUMTRANSVENDA", length = 30)
    private String numTransVenda;

    @Column( name = "PREST", length = 2)
    private String prest;

    @Column( name = "JUROS" )
    private BigDecimal juros;

    @Column( name = "EMAIL_ENVIADO", length = 1)
    private String emailEnviado;

    @Column( name = "STATUS", length = 1000)
    private String status;

    @Column( name = "EXPIRACAO" )
    private LocalDateTime expiracao;

    @Column( name = "BAIXADOPCPRESTVIAAPI", nullable = false)
    private Integer baixadoPcPrestViaApi = 0;
}
