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
@Table(name = "PCCNAE")
public class PcCnae extends BaseEntity {
    @Id
    @Column(name = "CODCNAE")
    private String codCnae;

    @Column(name = "CODATIV1")
    private Long codAtiv1;

    @Column(name = "DESCCNAE")
    private String descCnae;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UF", insertable = false, updatable = false)
    private PcEstado ufObject;*/
}
