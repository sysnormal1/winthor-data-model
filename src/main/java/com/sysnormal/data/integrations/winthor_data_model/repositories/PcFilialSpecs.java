package com.sysnormal.data.integrations.winthor_data_model.repositories;

import com.sysnormal.commons.core.utils_core.TextUtils;
import com.sysnormal.data.integrations.winthor_data_model.entities.PcFilial;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Expression;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;

public class PcFilialSpecs {

    private static final Logger logger = LoggerFactory.getLogger(PcFilialSpecs.class);


    public static Specification<PcFilial> cgcRoot(String rawId) {
        logger.debug("xxxxxxxxxxxxxxx 0, {}", rawId);
        String onlyDigits = TextUtils.onlyDigitsLeftTrim(rawId.replaceAll("\\D", ""));
        logger.debug("xxxxxxxxxxxxxxx 1, {}", onlyDigits);


        if (onlyDigits.length() < 3) {
            return (root, query, cb) -> cb.disjunction();
        }

        String trimmedParam = onlyDigits.substring(0, onlyDigits.length() - Math.min(6,onlyDigits.length())) + "0001";
        logger.debug("xxxxxxxxxxxxxxx 3, {}", trimmedParam);

        return (root, query, cb) -> {
            Expression<String> cgcClean = cb.function(
                    "regexp_replace",
                    String.class,
                    root.get("cgc"),
                    cb.literal("[^0-9]"),
                    cb.literal("")
            );


            Expression<String> trimExpression = cb.trim(
                    CriteriaBuilder.Trimspec.LEADING,
                    cb.literal('0'),
                    cb.function(
                            "substr",
                            String.class,
                            cgcClean,
                            cb.literal(1),
                            cb.diff(
                                    cb.function("length", Integer.class, cgcClean),
                                    cb.literal(2)
                            )
                    )
            );

            return cb.equal(trimExpression, trimmedParam);
        };
    }
}

