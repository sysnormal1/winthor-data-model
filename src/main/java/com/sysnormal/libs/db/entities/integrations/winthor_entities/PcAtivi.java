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
@Table(name = "PCATIVI")
public class PcAtivi extends BaseEntity {
    @Id
    @Column(name = "CODATIV")
    private Long codAtiv;

    @Column(name = "RAMO")
    private String ramo;

    protected static final long TABLE_ID = 30012L;
    public static long getTableId() {
        return TABLE_ID;
    }
}
