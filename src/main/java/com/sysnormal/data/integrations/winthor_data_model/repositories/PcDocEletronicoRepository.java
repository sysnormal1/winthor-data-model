package com.sysnormal.data.integrations.winthor_data_model.repositories;

import com.sysnormal.data.base_data_model.repositories.BaseRepository;
import com.sysnormal.data.integrations.winthor_data_model.entities.PcDocEletronico;
import com.sysnormal.data.integrations.winthor_data_model.entities.PcDocEletronicoId;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PcDocEletronicoRepository extends BaseRepository<PcDocEletronico, PcDocEletronicoId> {

    Optional<PcDocEletronico> findByIdNumTransacaoAndIdMovimento(Long numTransacao, String movimento);

    List<PcDocEletronico> findByIdNumTransacaoInAndIdMovimento(List<Long> numTransacoes, String movimento);
}
