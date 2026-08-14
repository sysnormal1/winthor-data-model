package com.sysnormal.data.integrations.winthor_data_model.entities;

import com.sysnormal.data.base_data_model.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Entity class
 *
 * Estoque em poder de armazem terceiro. Tabela criada pela equipe dentro do schema
 * JUMBO, nao e nativa do winthor. Nao tem custo: a valoracao usa o custo do PCEST
 * do mesmo produto.
 */
@Getter
@Setter
@Entity
@Table(name = "PRODUTOS_ARMAZENADOS_TERCEIROS")
public class ProdutosArmazenadosTerceiros extends BaseEntity {

    @EmbeddedId
    private ProdutosArmazenadosTerceirosId id;

    @Column(name = "QT")
    private BigDecimal qt;

    /** Marca se a quantidade deve ser somada ao saldo do winthor. */
    @Column(name = "SOMAR_WINT")
    private Integer somarWint;
}
