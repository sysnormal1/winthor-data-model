package com.sysnormal.data.integrations.winthor_data_model.repositories;

import com.sysnormal.commons.core.utils_core.TextUtils;
import com.sysnormal.data.integrations.winthor_data_model.entities.PcNcm;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.domain.Specification;

public class PcNcmSpecs {

    public static Specification<PcNcm> normalizedCodNcmExEquals(String codNcmEx) {
        String onlyDigits = TextUtils.onlyDigitsLeftTrim(codNcmEx);
        return (root, query, cb) ->
                cb.equal(
                        cb.trim(
                                CriteriaBuilder.Trimspec.LEADING,
                                cb.literal('0'),
                                cb.function(
                                        "regexp_replace",
                                        String.class,
                                        root.get("codNcmEx"),
                                        cb.literal("[^0-9]"),
                                        cb.literal("")
                                )
                        ),
                        onlyDigits
                );
    }
}
