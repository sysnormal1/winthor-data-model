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
public class PcEstCrId implements Serializable {

    @Column(name = "CODBANCO", nullable = false)
    private Integer codBanco;

    @Column(name = "CODCOB", length = 4, nullable = false)
    private String codCob;

    // equals e hashCode obrigatórios para chaves compostas
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PcEstCrId)) return false;
        PcEstCrId that = (PcEstCrId) o;
        return Objects.equals(codBanco, that.codBanco)
                && Objects.equals(codCob, that.codCob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codBanco, codCob);
    }
}