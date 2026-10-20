package com.sysnormal.data.integrations.winthor_data_model.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/** Chave de {@link PcPedCVctoFv}: {@code NUMPEDRCA}, {@code CODUSUR}, {@code CGCCLI}, {@code DTABERTURAPEDPALM}, {@code NUMPARCELA}. */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class PcPedCVctoFvId implements Serializable {

    private Long numpedrca;

    private Integer codusur;

    private String cgccli;

    private LocalDateTime dtaberturapedpalm;

    private Long numparcela;
}
