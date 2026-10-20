package com.sysnormal.data.integrations.winthor_data_model.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/** Chave de {@link PcGondolaIFv}: {@code NUMCONTAGEM}, {@code CODUSUR}, {@code CGCCLI}, {@code CODPROD}. */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class PcGondolaIFvId implements Serializable {

    private Integer numcontagem;

    private Integer codusur;

    private String cgccli;

    private Integer codprod;
}
