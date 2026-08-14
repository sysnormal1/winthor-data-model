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
public class ProdutosArmazenadosTerceirosId implements Serializable {

    @Column(name = "CGCTERCEIRO", nullable = false)
    private Long cgcTerceiro;

    // aqui CODFILIAL e NUMBER, e nao VARCHAR2 como no PCEST
    @Column(name = "CODFILIAL", nullable = false)
    private Long codFilial;

    @Column(name = "CODPROD", nullable = false)
    private Long codProd;

    // equals e hashCode obrigatórios para chaves compostas
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProdutosArmazenadosTerceirosId)) return false;
        ProdutosArmazenadosTerceirosId that = (ProdutosArmazenadosTerceirosId) o;
        return Objects.equals(cgcTerceiro, that.cgcTerceiro)
                && Objects.equals(codFilial, that.codFilial)
                && Objects.equals(codProd, that.codProd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cgcTerceiro, codFilial, codProd);
    }
}
