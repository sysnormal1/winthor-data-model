package com.sysnormal.data.integrations.winthor_data_model.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/** Chave de {@link PcIndIFv}: {@code CODINDENIZ}, {@code CODPROD}. */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class PcIndIFvId implements Serializable {

    private Long codindeniz;

    private Integer codprod;
}
