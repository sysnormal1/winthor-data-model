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

    protected static final long TABLE_ID = 30016L;
    public static long getTableId() {
        return TABLE_ID;
    }
}
