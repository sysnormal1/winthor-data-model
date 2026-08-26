package com.sysnormal.data.integrations.winthor_data_model.entities;

import com.sysnormal.data.base_data_model.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity class
 *
 * Guarda o xml da nota eletrônica. O app dos motoristas baixa esse xml junto com a carga.
 * A chave é composta por NUMTRANSACAO e MOVIMENTO: NUMTRANSACAO casa com PCNFSAID.NUMTRANSVENDA e
 * MOVIMENTO distingue a saída ('S') da entrada, então filtrar por NUMTRANSACAO sozinho traz mais de
 * uma linha.
 */
@Getter
@Setter
@Entity
@Table(name = "PCDOCELETRONICO")
public class PcDocEletronico extends BaseEntity {

    @EmbeddedId
    private PcDocEletronicoId id;

    @Lob
    @Column(name = "XMLNFE")
    private String xmlNfe;
}
