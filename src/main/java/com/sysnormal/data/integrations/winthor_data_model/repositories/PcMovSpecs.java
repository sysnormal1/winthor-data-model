package com.sysnormal.data.integrations.winthor_data_model.repositories;

import com.sysnormal.data.integrations.winthor_data_model.entities.PcMov;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class PcMovSpecs {

    static final Logger logger = LoggerFactory.getLogger(PcMovSpecs.class);

    public static Specification<PcMov> normalizedPK(String numTransItem) {
        logger.debug("INIT {}.{}({})","PcMovSpecs","customFindUnidadeByNumTransItem",numTransItem);
        Specification<PcMov> result = (root, query, cb) -> cb.disjunction();
        try {
            if (StringUtils.hasText(numTransItem)) {
                if (numTransItem.contains("-")) {
                    String[] recordKeysId = numTransItem.split("-");
                    if (StringUtils.hasText(recordKeysId[0])) {
                        result = (root, query, cb) -> cb.and(
                                cb.equal(root.get("numTransEnt"), Long.valueOf(recordKeysId[0])),
                                cb.equal(root.get("codProd"), Long.valueOf(recordKeysId[2])),
                                cb.equal(root.get("numSeq"), Long.valueOf(recordKeysId[3]))
                        );
                    } else {
                        result = (root, query, cb) -> cb.and(
                                cb.equal(root.get("numTransVenda"), Long.valueOf(recordKeysId[1])),
                                cb.equal(root.get("codProd"), Long.valueOf(recordKeysId[2])),
                                cb.equal(root.get("numSeq"), Long.valueOf(recordKeysId[3]))
                        );
                    }
                } else {
                    result = (root, query, cb) -> cb.equal(root.get("numTransItem"), Long.valueOf(numTransItem));
                }
            }
        } catch (Exception e) {
            logger.error("ERROR: \n{}, \n{}, \n{}", e.getMessage(), e.getCause(), e.getLocalizedMessage());
            logger.error("ERROR",e);
            e.printStackTrace();
        }

        logger.debug("END {}.{}({})","PcMovSpecs","customFindUnidadeByNumTransItem",numTransItem);
        return result;
    }

}
