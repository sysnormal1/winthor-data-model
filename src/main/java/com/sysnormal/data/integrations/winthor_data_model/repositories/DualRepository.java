package com.sysnormal.data.integrations.winthor_data_model.repositories;

import com.sysnormal.data.integrations.winthor_data_model.entities.Dual;
import com.sysnormal.data.base_data_model.repositories.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;


@Repository
public interface DualRepository extends BaseRepository<Dual, String> {

    @Query(value = "SELECT PARAMFILIAL.OBTERCOMONUMBER(:paramName, :paramFilial) FROM dual", nativeQuery = true)
    BigDecimal getParamFilialComoNumber(
            @Param("paramName") String paramName,
            @Param("paramFilial") String paramFilial
    );
}
