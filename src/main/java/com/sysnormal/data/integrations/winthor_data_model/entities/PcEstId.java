package com.sysnormal.data.integrations.winthor_data_model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;


@Embeddable
@Getter
@Setter
public class PcEstId implements Serializable {

    // CODFILIAL e VARCHAR2 no PCEST, ao contrario da maioria das tabelas do winthor
    @Column(name = "CODFILIAL", nullable = false)
    private String codFilial;

    @Column(name = "CODPROD", nullable = false)
    private Long codProd;

    // equals e hashCode obrigatórios para chaves compostas
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PcEstId)) return false;
        PcEstId that = (PcEstId) o;
        return Objects.equals(codFilial, that.codFilial)
                && Objects.equals(codProd, that.codProd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codFilial, codProd);
    }
}
