package com.sysnormal.libs.db.entities.integrations.winthor_entities;

import com.sysnormal.libs.db.entities.base_entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

@Getter
@Setter
@Entity
@Table(name = "DUAL", schema = "SYS")
@Immutable //not has id column
public class Dual extends BaseEntity {

    @Id
    @Column(name = "ROWID", updatable = false, insertable = false)
    private String rowId;

    protected static final long TABLE_ID = 29999;
    public static long getTableId() {
        return TABLE_ID;
    }

}
