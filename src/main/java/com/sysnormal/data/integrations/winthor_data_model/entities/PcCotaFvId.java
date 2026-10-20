package com.sysnormal.data.integrations.winthor_data_model.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/** Chave de {@link PcCotaFv}: {@code CODPROD}, {@code NUMSEQ}, {@code CODCONC}, {@code CGCCLI}, {@code CODUSUR}, {@code DATA}. */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class PcCotaFvId implements Serializable {

    private Integer codprod;

    private Long numseq;

    private String codconc;

    private String cgccli;

    private Integer codusur;

    private LocalDateTime data;
}
