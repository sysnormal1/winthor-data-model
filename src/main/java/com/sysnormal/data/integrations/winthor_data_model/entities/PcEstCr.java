package com.sysnormal.data.integrations.winthor_data_model.entities;

import com.sysnormal.data.base_data_model.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Entity class
 */
@Getter
@Setter
@Entity
@Table(name = "PCESTCR")
public class PcEstCr extends BaseEntity {

    @EmbeddedId
    private PcEstCrId id;

    @Column(name = "VALOR")
    private BigDecimal valor;
}
