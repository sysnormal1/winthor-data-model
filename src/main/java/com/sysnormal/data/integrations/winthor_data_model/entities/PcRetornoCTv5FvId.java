package com.sysnormal.data.integrations.winthor_data_model.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/** Chave de {@link PcRetornoCTv5Fv}: {@code CODUSUR}, {@code NUMPEDRCA}, {@code NUMPEDTV5}. */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class PcRetornoCTv5FvId implements Serializable {

    private Integer codusur;

    private Long numpedrca;

    private Long numpedtv5;
}
