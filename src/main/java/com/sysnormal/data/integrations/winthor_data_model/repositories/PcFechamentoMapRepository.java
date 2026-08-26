package com.sysnormal.data.integrations.winthor_data_model.repositories;

import com.sysnormal.data.base_data_model.repositories.BaseRepository;
import com.sysnormal.data.integrations.winthor_data_model.entities.PcFechamentoMap;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PcFechamentoMapRepository extends BaseRepository<PcFechamentoMap, Long> {

    boolean existsByNumTransVenda(Long numTransVenda);

    List<PcFechamentoMap> findByNumTransVendaIn(List<Long> numTransVendas);
}
