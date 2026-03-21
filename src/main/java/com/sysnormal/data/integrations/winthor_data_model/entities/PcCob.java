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
@Table(name = "PCCOB")
public class PcCob extends BaseEntity {
    @Id
    @Column(name = "CODCOB", length = 4, nullable = false)
    private String codCob;

    @Column(name = "COBRANCA", length = 30, nullable = false)
    private String cobranca;

    @Column(name = "CARTEIRAPIX", length = 1)
    private String carteiraPix = "N";

    @Column(name = "CARTAO", length = 1)
    private String cartao;
}
