package com.sysnormal.libs.db.entities.integrations.winthor_entities;

import com.sysnormal.libs.db.entities.base_entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "PCCARREG")
public class PcCarreg extends BaseEntity {
    @Id
    @Column(name = "NUMCAR", nullable = false)
    private Long numCar;

    @Column(name = "DTSAIDA")
    private LocalDateTime dtSaida;

    @Column(name = "CODMOTORISTA")
    private Long codMotorista;

    @Column(name = "CODVEICULO")
    private Long codVeiculo;

    @Column(name = "TOTPESO")
    private BigDecimal totPeso;

    @Column(name = "VLTOTAL")
    private BigDecimal vlTotal;

    @Column(name = "NUMNOTAS")
    private Integer numNotas;

    @Column(name = "NUMENT")
    private Integer numEnt;

    @Column(name = "DESTINO")
    private String destino;

    @Column(name = "DT_CANCEL")
    private LocalDateTime dtCancel;


    protected static final long TABLE_ID = 30050L;
    public static long getTableId() {
        return TABLE_ID;
    }
}
