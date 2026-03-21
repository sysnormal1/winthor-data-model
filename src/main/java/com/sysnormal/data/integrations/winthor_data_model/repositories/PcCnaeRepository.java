package com.sysnormal.data.integrations.winthor_data_model.repositories;

import com.sysnormal.data.integrations.winthor_data_model.entities.PcCnae;
import com.sysnormal.data.base_data_model.repositories.BaseRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PcCnaeRepository extends BaseRepository<PcCnae, String> {

    @Override
    default Optional<PcCnae> findById(String id) {
        return findAll(PcCnaeSpecs.normalizedCodCnaeEquals(id), PageRequest.of(0,1)).stream().findFirst();
    };
}
