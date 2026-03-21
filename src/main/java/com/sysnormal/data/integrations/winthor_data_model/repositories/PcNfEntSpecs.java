package com.sysnormal.data.integrations.winthor_data_model.repositories;

import com.sysnormal.data.integrations.winthor_data_model.entities.PcNfEnt;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class PcNfEntSpecs {

    public static Specification<PcNfEnt> normalizedNumTransEntAndNumNotaPK(String pK) {
        Specification<PcNfEnt> result = (root, query, cb) -> cb.disjunction();

        if (StringUtils.hasText(pK)) {
            if (pK.contains("-")) {
                String[] recordKeysId = pK.split("-");
                if (recordKeysId.length > 1 && StringUtils.hasText(recordKeysId[1])) {
                    result = (root, query, cb) -> cb.and(
                            cb.equal(root.get("numTransEnt"), Long.valueOf(recordKeysId[0])),
                            cb.equal(root.get("numNota"), Long.valueOf(recordKeysId[1]))
                    );
                } else {
                    result = (root, query, cb) -> cb.equal(root.get("numTransEnt"), Long.valueOf(recordKeysId[0]));    
                }
            } else {
                result = (root, query, cb) -> cb.equal(root.get("numTransEnt"), Long.valueOf(pK));
            }
        }


        return result;
    }

}
