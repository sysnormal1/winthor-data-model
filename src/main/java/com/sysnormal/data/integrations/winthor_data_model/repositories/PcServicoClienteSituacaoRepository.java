package com.sysnormal.data.integrations.winthor_data_model.repositories;

import com.sysnormal.data.base_data_model.repositories.BaseRepository;
import com.sysnormal.data.integrations.winthor_data_model.entities.PcServicoClienteSituacao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PcServicoClienteSituacaoRepository extends BaseRepository<PcServicoClienteSituacao, Long> {

    List<PcServicoClienteSituacao> findByCodCliente(Long codCliente);

    List<PcServicoClienteSituacao> findByCodClienteAndFonte(Long codCliente, String fonte);

    /**
     * A próxima chave livre, em {@code MAX+1}.
     *
     * <p>A tabela não tem sequence — o schema JUMBO inteiro tem uma só
     * ({@code SJDSEQNUMPEDRCA}, de número de pedido do RCA), que não serve. Rodando
     * dentro da transação da escrita, o valor lido é o que vai para a tabela; a corrida
     * entre transações é fechada por repetição na violação de chave.</p>
     */
    @Query(value = "SELECT NVL(MAX(CODSITUACAO), 0) + 1 FROM PCSERVICOCLIENTESITUACAO", nativeQuery = true)
    Long proximaChave();
}
