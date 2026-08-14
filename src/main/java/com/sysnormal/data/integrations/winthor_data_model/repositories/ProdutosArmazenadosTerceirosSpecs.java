package com.sysnormal.data.integrations.winthor_data_model.repositories;

import com.sysnormal.data.integrations.winthor_data_model.entities.ProdutosArmazenadosTerceiros;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.util.List;

public class ProdutosArmazenadosTerceirosSpecs {

    public static Specification<ProdutosArmazenadosTerceiros> codFilialIn(List<Long> codFiliais) {
        if (codFiliais == null || codFiliais.isEmpty()) {
            return null;
        }
        return (root, query, cb) -> root.get("id").get("codFilial").in(codFiliais);
    }

    public static Specification<ProdutosArmazenadosTerceiros> codProdIn(List<Long> codProds) {
        if (codProds == null || codProds.isEmpty()) {
            return null;
        }
        return (root, query, cb) -> root.get("id").get("codProd").in(codProds);
    }

    /** A tabela guarda o cadastro do vinculo, e a maior parte das linhas esta zerada. */
    public static Specification<ProdutosArmazenadosTerceiros> comSaldo() {
        return (root, query, cb) -> cb.and(
                cb.isNotNull(root.get("qt")),
                cb.notEqual(root.get("qt"), BigDecimal.ZERO)
        );
    }
}
