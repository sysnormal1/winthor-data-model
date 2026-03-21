package com.sysnormal.data.integrations.winthor_data_model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

/**
 * Entity class
 */
@Embeddable
@Getter
@Setter
public class PcPrestId implements Serializable {

    @Column(name = "NUMTRANSVENDA", nullable = false)
    private Long numTransVenda;

    @Column(name = "PREST", length = 2, nullable = false)
    private String prest;



    // equals e hashCode obrigatórios para chaves compostas

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PcPrestId)) return false;
        PcPrestId that = (PcPrestId) o;
        return Objects.equals(numTransVenda, that.numTransVenda)
                && Objects.equals(prest, that.prest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numTransVenda, prest);
    }
}