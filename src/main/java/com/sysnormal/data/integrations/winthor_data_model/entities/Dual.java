package com.sysnormal.data.integrations.winthor_data_model.entities;

import com.sysnormal.data.base_data_model.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

/**
 * Entity class
 */
@Getter
@Setter
@Entity
@Table(name = "DUAL", schema = "SYS")
@Immutable //not has id column
public class Dual extends BaseEntity {

    @Id
    @Column(name = "ROWID", updatable = false, insertable = false)
    private String rowId;
}
