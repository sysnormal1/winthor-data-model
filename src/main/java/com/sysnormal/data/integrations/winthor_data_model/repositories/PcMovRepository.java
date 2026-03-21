package com.sysnormal.data.integrations.winthor_data_model.repositories;

import com.sysnormal.data.integrations.winthor_data_model.entities.PcMov;
import com.sysnormal.data.base_data_model.repositories.BaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Repository
public interface PcMovRepository extends BaseRepository<PcMov, String> {

    static final Logger logger = LoggerFactory.getLogger(PcMovRepository.class);

    @Query("""
    SELECT
        MAX(m.codFiscal) as codFiscal
    FROM
        PcMov m
    WHERE
        m.numTransEnt = :numTransEnt
        and m.numNota = :numNota
    """)
    Optional<Integer> findMaxCodFiscalByNumTransEntAndNumNota(@Param("numTransEnt") Long numTransEnt, @Param("numNota") Long numNota);



    @Query("""
    SELECT 
        COALESCE(m.unidade, p.unidade) as unidade
    FROM 
        PcMov m
        JOIN PcProdut p ON p.codProd = m.codProd
    WHERE 
        m.numTransItem = :numTransItem
    """)
    Optional<String> findUnidadeByNumTransItem(@Param("numTransItem") Long numTransItem);

    @Query("""
    SELECT 
        COALESCE(m.unidade, p.unidade) as unidade
    FROM 
        PcMov m
        JOIN PcProdut p ON p.codProd = m.codProd
    WHERE 
        m.numTransEnt = :numTransEnt
        and m.codProd = :codProd
        and m.numSeq = :numSeq
    """)
    Optional<String> findUnidadeByNumTransEntAndCodProdAndNumSeq(@Param("numTransEnt") Long numTransEnt, @Param("codProd") Long codProd, @Param("numSeq") Integer numSeq);

    @Query("""
    SELECT 
        COALESCE(m.unidade, p.unidade) as unidade
    FROM 
        PcMov m
        JOIN PcProdut p ON p.codProd = m.codProd
    WHERE 
        m.numTransVenda = :numTransVenda
        and m.codProd = :codProd
        and m.numSeq = :numSeq
    """)
    Optional<String> findUnidadeByNumTransVendaAndCodProdAndNumSeq(@Param("numTransVenda") Long numTransVenda, @Param("codProd") Long codProd, @Param("numSeq") Integer numSeq);

    default Optional<PcMov> customFindUnidadeByNumTransItem(String numTransItem){
        logger.debug("INIT {}.{}({})",this.getClass().getSimpleName(),"customFindUnidadeByNumTransItem",numTransItem);
        Optional<PcMov> result = Optional.empty();
        if (StringUtils.hasText(numTransItem)) {
            Optional<String> strResult;
            if (numTransItem.contains("-")) {
                String[] recordKeysId = numTransItem.split("-");
                if (StringUtils.hasText(recordKeysId[0])) {
                    strResult = findUnidadeByNumTransEntAndCodProdAndNumSeq(
                            Long.valueOf(recordKeysId[0]),
                            Long.valueOf(recordKeysId[2]),
                            Integer.valueOf(recordKeysId[3])
                    );
                } else {
                    strResult = findUnidadeByNumTransVendaAndCodProdAndNumSeq(
                            Long.valueOf(recordKeysId[1]),
                            Long.valueOf(recordKeysId[2]),
                            Integer.valueOf(recordKeysId[3])
                    );
                }
            } else {
                strResult = findUnidadeByNumTransItem(Long.valueOf(numTransItem));
            }
            if (strResult.isPresent()) {
                PcMov pcMov = new PcMov();
                pcMov.setUnidade(strResult.get());
                result = Optional.of(pcMov);
            }
        }
        logger.debug("END {}.{} (result.isPresent() = {})",this.getClass().getSimpleName(),"customFindUnidadeByNumTransItem",result.isPresent());
        return result;
    };


    default Optional<PcMov> customFindByNumTransItem(String numTransItem){
        logger.debug("INIT {}.{}({})",this.getClass().getSimpleName(),"customFindByNumTransItem",numTransItem);
        Optional<PcMov> result = findAll(PcMovSpecs.normalizedPK(numTransItem)).stream().findFirst();
        logger.debug("END {}.{} (result.isPresent() = {})",this.getClass().getSimpleName(),"customFindByNumTransItem",result.isPresent());
        return result;
    };


}
