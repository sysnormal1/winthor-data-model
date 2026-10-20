package com.sysnormal.data.integrations.winthor_data_model.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/** Chave de {@link PcContatoFv}: {@code CGCCLI}, {@code NOMECONTATO}, {@code DTINCLUSAO}. */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class PcContatoFvId implements Serializable {

    private String cgccli;

    private String nomecontato;

    private LocalDateTime dtinclusao;
}
