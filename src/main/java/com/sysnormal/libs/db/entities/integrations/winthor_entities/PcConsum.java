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
@Table(name = "PCCONSUM")
public class PcConsum extends BaseEntity {
    @Id
    @Column(name = "CGC", length = 20, nullable = false)
    private String cgc;

    @Column(name = "PROXNUMTRANS")
    private Long proxNumTrans;

    @Column(name = "PROXNUMLANC")
    private Long proxNumLanc;

    protected static final long TABLE_ID = 30001;
    public static long getTableId() {
        return TABLE_ID;
    }
}
