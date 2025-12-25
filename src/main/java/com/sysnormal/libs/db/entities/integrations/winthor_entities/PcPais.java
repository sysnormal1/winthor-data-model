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
@Table(name = "PCPAIS")
public class PcPais extends BaseEntity {
    @Id
    @Column(name = "CODPAIS")
    private Long codPais;

    @Column(name = "DESCRICAO")
    private String descricao;

    protected static final long TABLE_ID = 30007L;
    public static long getTableId() {
        return TABLE_ID;
    }
}
