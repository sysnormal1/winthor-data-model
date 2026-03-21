package com.sysnormal.data.integrations.winthor_data_model.repositories;

import com.sysnormal.data.integrations.winthor_data_model.entities.PcLogCobMag;
import com.sysnormal.data.base_data_model.repositories.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface PcLogCobMagRepository extends BaseRepository<PcLogCobMag, String> {

    @Query(value = "SELECT COUNT(1) FROM JUMBO.PCLOGCOBMAG WHERE DTGERACAO = TRUNC(SYSDATE)", nativeQuery = true)
    Long countByDtgeracaoTodayNative();
}
