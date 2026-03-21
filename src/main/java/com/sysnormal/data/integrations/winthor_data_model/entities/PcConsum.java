package com.sysnormal.data.integrations.winthor_data_model.entities;

import com.sysnormal.data.base_data_model.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity class
 */
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
}
