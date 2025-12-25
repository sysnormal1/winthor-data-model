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
@Table(name = "PCBAIRRO")
public class PcBairro extends BaseEntity {
    @Id
    @Column(name = "CODBAIRRO")
    private Long codBairro;

    @Column(name = "CODCIDADE")
    private Long codCidade;

    @Column(name = "UF")
    private String uf;

    @Column(name = "DESCRICAO")
    private String descricao;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UF", insertable = false, updatable = false)
    private PcEstado ufObject;*/

    protected static final long TABLE_ID = 30010L;
    public static long getTableId() {
        return TABLE_ID;
    }
}
