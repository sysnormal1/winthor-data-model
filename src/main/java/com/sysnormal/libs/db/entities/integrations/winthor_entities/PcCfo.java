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
@Table(name = "PCCFO")
public class PcCfo extends BaseEntity {
    @Id
    @Column(name = "CODFISCAL")
    private Long codfiscal;

    @Column(name = "DESCCFO")
    private String descCfo;

    @Column(name = "CODOPER")
    private String codOper;

    protected static final long TABLE_ID = 30195L;
    public static long getTableId() {
        return TABLE_ID;
    }
}
