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
@Table(name = "PCPAIS")
public class PcPais extends BaseEntity {
    @Id
    @Column(name = "CODPAIS")
    private Long codPais;

    @Column(name = "DESCRICAO")
    private String descricao;
}
