package com.sysnormal.libs.db.entities.integrations.winthor_entities;

import com.sysnormal.libs.db.entities.base_entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "PCVEICUL")
public class PcVeicul extends BaseEntity {
    @Id
    @Column(name = "CODVEICULO")
    private Long codVeiculo;

    @Column(name = "PLACA")
    private String placa;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "SITUACAO")
    private String situacao;

    protected static final long TABLE_ID = 30040L;
    public static long getTableId() {
        return TABLE_ID;
    }
}
