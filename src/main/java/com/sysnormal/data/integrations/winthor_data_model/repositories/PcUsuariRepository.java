package com.sysnormal.data.integrations.winthor_data_model.repositories;

import com.sysnormal.data.integrations.winthor_data_model.entities.PcUsuari;
import com.sysnormal.data.base_data_model.repositories.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PcUsuariRepository extends BaseRepository<PcUsuari, Long> {

    @Query(
    value = """
        SELECT
            PCUSUARI.*
        FROM
            JUMBO.PCUSUARI
        WHERE
            CODUSUR = :codusur FOR UPDATE
    """,
    nativeQuery = true)
    Optional<PcUsuari> getUsuariAndFlexForUpdate(@Param("codusur") long codusur);

}
