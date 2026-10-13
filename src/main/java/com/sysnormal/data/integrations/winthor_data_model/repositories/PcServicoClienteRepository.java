package com.sysnormal.data.integrations.winthor_data_model.repositories;

import com.sysnormal.data.base_data_model.repositories.BaseRepository;
import com.sysnormal.data.integrations.winthor_data_model.entities.PcServicoCliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PcServicoClienteRepository extends BaseRepository<PcServicoCliente, Long> {

    List<PcServicoCliente> findByCodServico(Long codServico);

    /**
     * A linha daquele CNPJ naquele serviço — a identidade real do registro.
     *
     * <p>⚠️ O {@code CODCLIENTE} desta tabela <b>não é</b> o {@code PCCLIENT.CODCLI}:
     * é um código do cliente <i>dentro do serviço</i>, e não há FK nem vínculo nenhum
     * com o cadastro do ERP. O único dado que liga uma linha daqui a um cliente de lá é
     * o identificador público, o <b>CNPJ</b>. Por isso a busca de negócio é esta, e não
     * por chave.</p>
     *
     * <p>O par CNPJ + serviço é o que deveria ser único; a PK é o {@code CODCLIENTE},
     * então nada no banco impede duas linhas com o mesmo par. Devolver lista é o que
     * permite perceber isso em vez de escolher uma ao acaso.</p>
     *
     * <p>O CNPJ é gravado em dígitos, sem máscara, exatamente para que esta comparação
     * seja exata.</p>
     */
    List<PcServicoCliente> findByCnpjAndCodServico(String cnpj, Long codServico);

    /**
     * A próxima chave livre, em {@code MAX+1}.
     *
     * <p>A tabela não tem sequence. E o {@code CODCLIENTE} é atribuído <b>aqui</b>, não
     * recebido: quem chama manda o CNPJ, que é a identidade, e o código é o surrogate
     * que esta tabela usa porque escolheu o campo errado para PK.</p>
     */
    @Query(value = "SELECT NVL(MAX(CODCLIENTE), 0) + 1 FROM PCSERVICOCLIENTE", nativeQuery = true)
    Long proximaChave();

}
