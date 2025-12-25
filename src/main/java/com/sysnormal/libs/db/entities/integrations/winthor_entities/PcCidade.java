package com.sysnormal.libs.db.entities.integrations.winthor_entities;

import com.sysnormal.libs.db.entities.base_entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "PCCIDADE")
public class PcCidade extends BaseEntity {
    @Id
    @Column(name = "CODCIDADE")
    private Long codCidade;

    @Column(name = "UF")
    private String uf;

    @Column(name = "CODIBGE")
    private Long codIBGE;

    @Column(name = "NOMECIDADE")
    private String nomeCidade;

    @Column(name = "POPULACAO")
    private Long populacao;

    @Column(name = "LATITUDE")
    private BigDecimal latitude;

    @Column(name = "LONGITUDE")
    private BigDecimal longitude;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UF", insertable = false, updatable = false)
    private PcEstado ufObject;*/

    protected static final long TABLE_ID = 30009L;
    public static long getTableId() {
        return TABLE_ID;
    }
}
