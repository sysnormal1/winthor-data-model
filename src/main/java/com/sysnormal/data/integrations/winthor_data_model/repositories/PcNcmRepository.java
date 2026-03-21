package com.sysnormal.data.integrations.winthor_data_model.repositories;

import com.sysnormal.data.integrations.winthor_data_model.entities.PcNcm;
import com.sysnormal.data.base_data_model.repositories.BaseRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PcNcmRepository extends BaseRepository<PcNcm, String> {

    @Override
    default Optional<PcNcm> findById(String id) {
        return findAll(PcNcmSpecs.normalizedCodNcmExEquals(id), PageRequest.of(0,1)).stream().findFirst();
    };
}
