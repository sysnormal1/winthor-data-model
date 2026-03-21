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
}
