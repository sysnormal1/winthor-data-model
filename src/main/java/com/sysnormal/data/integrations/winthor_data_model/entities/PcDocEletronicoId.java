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
public class PcDocEletronicoId implements Serializable {

    @Column(name = "NUMTRANSACAO", nullable = false)
    private Long numTransacao;

    @Column(name = "MOVIMENTO", length = 1, nullable = false)
    private String movimento;



    // equals e hashCode obrigatórios para chaves compostas

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PcDocEletronicoId)) return false;
        PcDocEletronicoId that = (PcDocEletronicoId) o;
        return Objects.equals(numTransacao, that.numTransacao)
                && Objects.equals(movimento, that.movimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numTransacao, movimento);
    }
}
