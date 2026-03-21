package com.sysnormal.data.integrations.winthor_data_model.repositories;

import com.sysnormal.data.integrations.winthor_data_model.entities.PcSuperv;
import com.sysnormal.data.base_data_model.repositories.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PcSupervRepository extends BaseRepository<PcSuperv, Long> {

    }
