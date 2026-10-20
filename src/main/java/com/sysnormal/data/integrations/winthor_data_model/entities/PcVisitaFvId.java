package com.sysnormal.data.integrations.winthor_data_model.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/** Chave de {@link PcVisitaFv}: {@code CGCCLI}, {@code CODUSUR}, {@code DATA}, {@code HORAINICIAL}, {@code MINUTOINICIAL}. */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class PcVisitaFvId implements Serializable {

    private String cgccli;

    private Integer codusur;

    private LocalDateTime data;

    private Integer horainicial;

    private Integer minutoinicial;
}
