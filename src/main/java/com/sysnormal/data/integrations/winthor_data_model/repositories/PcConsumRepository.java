package com.sysnormal.data.integrations.winthor_data_model.repositories;

import com.sysnormal.data.integrations.winthor_data_model.entities.PcConsum;
import com.sysnormal.data.base_data_model.repositories.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PcConsumRepository extends BaseRepository<PcConsum, String> {

    @Query(value = """
        SELECT 
            p.cgc,
            nvl(p.PROXNUMTRANS,0) as PROXNUMTRANS,
            nvl(p.PROXNUMLANC,0) as PROXNUMLANC
         FROM PCCONSUM p
         WHERE to_number(regexp_replace(p.CGC,'[^0-9]','')) = to_number(regexp_replace(:cgc,'[^0-9]',''))
         FOR UPDATE
        """, nativeQuery = true)
    Optional<PcConsum> findByCgcForUpdate(
            @Param("cgc") String cgc
    );
}
