package com.sysnormal.data.integrations.winthor_data_model.repositories;

import com.sysnormal.data.integrations.winthor_data_model.entities.PcEst;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.util.List;

public class PcEstSpecs {

    public static Specification<PcEst> codFilialIn(List<String> codFiliais) {
        if (codFiliais == null || codFiliais.isEmpty()) {
            return null;
        }
        return (root, query, cb) -> root.get("id").get("codFilial").in(codFiliais);
    }

    public static Specification<PcEst> codProdIn(List<Long> codProds) {
        if (codProds == null || codProds.isEmpty()) {
            return null;
        }
        return (root, query, cb) -> root.get("id").get("codProd").in(codProds);
    }

    /** Saldo geral diferente de zero, para nao devolver o cadastro inteiro sem estoque. */
    public static Specification<PcEst> comSaldo() {
        return (root, query, cb) -> cb.and(
                cb.isNotNull(root.get("qtEstGer")),
                cb.notEqual(root.get("qtEstGer"), BigDecimal.ZERO)
        );
    }
}
