package com.sysnormal.data.integrations.winthor_data_model.repositories;

import com.sysnormal.data.integrations.winthor_data_model.entities.PcEstCr;
import com.sysnormal.data.integrations.winthor_data_model.entities.PcEstCrId;
import com.sysnormal.data.base_data_model.repositories.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PcEstCrRepository extends BaseRepository<PcEstCr, PcEstCrId> {

    @Query(value = """
        SELECT 
            p.* 
         FROM PCESTCR p
         WHERE p.CODBANCO = :codBanco
           AND p.CODCOB = :codCob
         FOR UPDATE NOWAIT
        """, nativeQuery = true)
    Optional<PcEstCr> findByCodBancoAndCodCobForUpdateNoWait(
            @Param("codBanco") Integer codBanco,
            @Param("codCob") String codCob
    );
}
