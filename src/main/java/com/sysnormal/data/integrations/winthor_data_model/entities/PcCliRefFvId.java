package com.sysnormal.data.integrations.winthor_data_model.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/** Chave de {@link PcCliRefFv}: {@code CGCCLI}, {@code CODREF}. */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class PcCliRefFvId implements Serializable {

    private String cgccli;

    private Integer codref;
}
