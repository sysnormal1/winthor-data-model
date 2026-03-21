package com.sysnormal.data.integrations.winthor_data_model.repositories;

import com.sysnormal.data.integrations.winthor_data_model.entities.PcClient;
import com.sysnormal.data.base_data_model.repositories.BaseRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * allow extends on client apps
 */
@NoRepositoryBean
public interface PcClientBaseRepository extends BaseRepository<PcClient, Long> {

    }

