package com.sysnormal.data.integrations.winthor_data_model.repositories;

import com.sysnormal.data.integrations.winthor_data_model.entities.PcPedI;
import com.sysnormal.data.base_data_model.repositories.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PcPedIRepository extends BaseRepository<PcPedI, String> {

    Optional<PcPedI> findByNumPedAndCodProdAndNumSeq(Integer numPed, Integer codProd, Integer numSeq);
}
