package com.sysnormal.data.integrations.winthor_data_model.entities;

import com.sysnormal.data.base_data_model.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Entity class
 */
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
}
