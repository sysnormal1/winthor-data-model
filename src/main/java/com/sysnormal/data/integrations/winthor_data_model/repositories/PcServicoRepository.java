package com.sysnormal.data.integrations.winthor_data_model.repositories;

import com.sysnormal.data.base_data_model.repositories.BaseRepository;
import com.sysnormal.data.integrations.winthor_data_model.entities.PcServico;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PcServicoRepository extends BaseRepository<PcServico, Long> {

    /**
     * As linhas com aquele {@code IDSERVICO}.
     *
     * <p>Devolve lista, e não {@code Optional}, de propósito: <b>não há restrição de
     * unicidade</b> no banco sobre a coluna. Como o {@code IDSERVICO} é o que resolve a
     * FK das linhas de cliente, duas linhas com o mesmo valor tornariam a resolução
     * ambígua — e quem resolve precisa poder perceber isso em vez de escolher uma ao
     * acaso.</p>
     */
    List<PcServico> findByIdServico(String idServico);

    /**
     * A próxima chave livre, em {@code MAX+1}.
     *
     * <p>A tabela não tem sequence — o schema JUMBO inteiro tem uma só
     * ({@code SJDSEQNUMPEDRCA}, de número de pedido do RCA), que não serve. Rodando
     * dentro da transação da escrita, o valor lido é o que vai para a tabela; a corrida
     * entre transações é fechada por repetição na violação de chave.</p>
     */
    @Query(value = "SELECT NVL(MAX(CODSERVICO), 0) + 1 FROM PCSERVICO", nativeQuery = true)
    Long proximaChave();
}
