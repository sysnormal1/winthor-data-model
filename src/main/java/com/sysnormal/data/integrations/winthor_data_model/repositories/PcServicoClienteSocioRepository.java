package com.sysnormal.data.integrations.winthor_data_model.repositories;

import com.sysnormal.data.base_data_model.repositories.BaseRepository;
import com.sysnormal.data.integrations.winthor_data_model.entities.PcServicoClienteSocio;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PcServicoClienteSocioRepository extends BaseRepository<PcServicoClienteSocio, Long> {

    List<PcServicoClienteSocio> findByCodCliente(Long codCliente);

    /**
     * A próxima chave livre, em {@code MAX+1}.
     *
     * <p>A tabela não tem sequence — o schema JUMBO inteiro tem uma só
     * ({@code SJDSEQNUMPEDRCA}, de número de pedido do RCA), que não serve. Rodando
     * dentro da transação da escrita, o valor lido é o que vai para a tabela; a corrida
     * entre transações é fechada por repetição na violação de chave.</p>
     */
    @Query(value = "SELECT NVL(MAX(CODSOCIO), 0) + 1 FROM PCSERVICOCLIENTESOCIO", nativeQuery = true)
    Long proximaChave();
}
