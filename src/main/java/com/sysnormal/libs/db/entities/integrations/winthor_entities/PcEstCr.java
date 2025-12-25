package com.sysnormal.libs.db.entities.integrations.winthor_entities;

import com.sysnormal.libs.db.entities.base_entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "PCESTCR")
public class PcEstCr extends BaseEntity {

    @EmbeddedId
    private PcEstCrId id;

    @Column(name = "VALOR")
    private BigDecimal valor;

    protected static final long TABLE_ID = 30220;
    public static long getTableId() {
        return TABLE_ID;
    }
}
