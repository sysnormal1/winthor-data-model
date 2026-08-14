package com.sysnormal.data.integrations.winthor_data_model.repositories;

import com.sysnormal.data.base_data_model.repositories.BaseRepository;
import com.sysnormal.data.integrations.winthor_data_model.entities.ProdutosArmazenadosTerceiros;
import com.sysnormal.data.integrations.winthor_data_model.entities.ProdutosArmazenadosTerceirosId;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutosArmazenadosTerceirosRepository
        extends BaseRepository<ProdutosArmazenadosTerceiros, ProdutosArmazenadosTerceirosId> {

}
