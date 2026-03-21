package com.sysnormal.data.integrations.winthor_data_model.repositories;

import com.sysnormal.data.integrations.winthor_data_model.entities.PcNfEnt;
import com.sysnormal.data.base_data_model.repositories.BaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PcNfEntRepository extends BaseRepository<PcNfEnt, Long> {

    static final Logger logger = LoggerFactory.getLogger(PcNfEntRepository.class);

    Optional<PcNfEnt> findByNumTransEntAndNumNota(Long numTransEnt, Long numNota);

    default Optional<PcNfEnt> customFindByPK(String pK){
        logger.debug("INIT {}.{}({})",this.getClass().getSimpleName(),"customFindByPK",pK);
        Optional<PcNfEnt> result = findAll(PcNfEntSpecs.normalizedNumTransEntAndNumNotaPK(pK)).stream().findFirst();
        logger.debug("END {}.{} (result.isPresent() = {})",this.getClass().getSimpleName(),"customFindByPK",result.isPresent());
        return result;
    };
}
