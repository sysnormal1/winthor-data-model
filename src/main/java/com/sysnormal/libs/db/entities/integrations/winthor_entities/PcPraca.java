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
@Table(name = "PCPRACA")
public class PcPraca extends BaseEntity {
    @Id
    @Column(name = "CODPRACA")
    private Long codPraca;

    @Column(name = "PRACA")
    private String praca;

    @Column(name = "NUMREGIAO")
    private String numRegiao;

    @Column(name = "ROTA")
    private String rota;

    @Column(name = "SEQROTA")
    private String seqRota;

    protected static final long TABLE_ID = 30017L;
    public static long getTableId() {
        return TABLE_ID;
    }
}
