package com.sysnormal.data.integrations.winthor_data_model.repositories;

import com.sysnormal.data.integrations.winthor_data_model.entities.PcFilial;
import com.sysnormal.data.base_data_model.repositories.BaseRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PcFilialRepository extends BaseRepository<PcFilial, Long> {

    default Optional<PcFilial> findByByCgcRaiz(String cgc){
        Specification<PcFilial> spec = (root, query, cb) -> cb.and(
                PcFilialSpecs.cgcRoot(cgc).toPredicate(root, query, cb)
        );

        return this.findAll(spec, PageRequest.of(0,1)).stream().findFirst();
    };
}
