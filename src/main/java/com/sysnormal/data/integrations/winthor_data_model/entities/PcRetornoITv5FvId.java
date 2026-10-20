package com.sysnormal.data.integrations.winthor_data_model.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/** Chave de {@link PcRetornoITv5Fv}: {@code CODUSUR}, {@code NUMPEDTV5}, {@code CODPROD}, {@code NUMSEQ}. */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class PcRetornoITv5FvId implements Serializable {

    private Integer codusur;

    private Long numpedtv5;

    private Integer codprod;

    private Long numseq;
}
