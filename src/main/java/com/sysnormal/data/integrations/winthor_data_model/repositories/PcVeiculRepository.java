package com.sysnormal.data.integrations.winthor_data_model.repositories;

import com.sysnormal.data.integrations.winthor_data_model.entities.PcVeicul;
import com.sysnormal.data.base_data_model.repositories.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PcVeiculRepository extends BaseRepository<PcVeicul, Long> {

    }
