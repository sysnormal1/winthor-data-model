package com.sysnormal.data.integrations.winthor_data_model.entities;

import com.sysnormal.data.base_data_model.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity class
 */
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
}
