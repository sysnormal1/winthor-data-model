package com.sysnormal.libs.db.entities.integrations.winthor_entities;

import com.sysnormal.libs.db.entities.base_entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "PCESTADO")
public class PcEstado extends BaseEntity {
    @Id
    @Column(name = "UF", length = 2)
    private String uf;

    @Column(name = "CODPAIS")
    private Long codPais;

    @Column(name = "CODIBGE")
    private Long codIBGE;

    @Column(name = "ESTADO")
    private String estado;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CODPAIS", insertable = false, updatable = false)
    private PcPais pais;*/

    protected static final long TABLE_ID = 30008L;
    public static long getTableId() {
        return TABLE_ID;
    }
}
