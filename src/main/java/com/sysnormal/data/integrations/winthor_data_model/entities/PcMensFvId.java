package com.sysnormal.data.integrations.winthor_data_model.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/** Chave de {@link PcMensFv}: {@code CODUSUR}, {@code DATA}. */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class PcMensFvId implements Serializable {

    private Integer codusur;

    private LocalDateTime data;
}
