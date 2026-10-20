package com.sysnormal.data.integrations.winthor_data_model.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/** Chave de {@link PcClientFv}: {@code CGCENT}, {@code DTINCLUSAO}. */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class PcClientFvId implements Serializable {

    private String cgcent;

    private LocalDateTime dtinclusao;
}
