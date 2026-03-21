package com.sysnormal.data.integrations.winthor_data_model.repositories;

import com.sysnormal.data.integrations.winthor_data_model.entities.PcEmpr;
import com.sysnormal.data.base_data_model.repositories.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PcEmprRepository extends BaseRepository<PcEmpr, Long> {

    }
