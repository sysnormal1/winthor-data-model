package com.sysnormal.data.integrations.winthor_data_model.repositories;

import com.sysnormal.data.integrations.winthor_data_model.entities.PcPrest;
import com.sysnormal.data.integrations.winthor_data_model.entities.PcPrestId;
import com.sysnormal.data.base_data_model.repositories.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@Repository
public interface PcPrestRepository extends BaseRepository<PcPrest, PcPrestId> {

    @Query(value = """
        SELECT 
            p.* 
         FROM PCPREST p
         WHERE p.NUMTRANSVENDA = :numTrans
           AND p.DTPAG IS NULL
           AND p.DTCANCEL IS NULL
           AND p.CODCOB NOT IN (:codCobExcluidos)
           AND p.VALOR = :valor
           AND NVL(p.PREST, '1') = :prest
         FOR UPDATE NOWAIT
        """, nativeQuery = true)
    Optional<PcPrest> findValidPcPrestForUpdateNoWait(
            @Param("numTrans") Long numTrans,
            @Param("valor") BigDecimal valor,
            @Param("prest") String prest,
            @Param("codCobExcluidos") List<String> codCobExcluidos
    );

    Optional<PcPrest> findByIdNumTransVendaAndIdPrestAndValorAndDtPagIsNotNull(Long numTransVenda, String prest, BigDecimal valor);
}
