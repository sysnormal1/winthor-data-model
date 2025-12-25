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
@Table(name = "PCTABDEV")
public class PcTabDev extends BaseEntity {
    @Id
    @Column(name = "CODDEVOL")
    private Long codDevol;

    @Column(name = "MOTIVO")
    private String motivo;

    @Column(name = "TIPO")
    private String tipo;

    protected static final long TABLE_ID = 30030L;
    public static long getTableId() {
        return TABLE_ID;
    }
}
