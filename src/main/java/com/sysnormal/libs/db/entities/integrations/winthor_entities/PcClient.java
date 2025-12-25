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
@Table(name = "PCCLIENT")
public class PcClient extends BaseEntity {
    @Id
    @Column(name = "CODCLI")
    private Long codCli;

    @Column(name = "CODFILIALNF")
    private String codFilialNf;

    @Column(name = "CODUSUR1")
    private Long codUsur1;

    @Column(name = "CGCENT")
    private String cgcEnt;

    @Column(name = "CLIENTE")
    private String cliente;

    @Column(name = "FANTASIA")
    private String fantasia;

    @Column(name = "TIPOFJ")
    private String tipoFj;

    @Column(name = "CODCNAE")
    private String codCnae;

    @Column(name = "CODATV1")
    private Long codAtv1;

    @Column(name = "CODREDE")
    private Long codRede;

    @Column(name = "CODPRACA")
    private Long codPraca;

    @Column(name = "CODCIDADE")
    private Long codCidade;

    @Column(name = "CODBAIRROENT")
    private Long codBairroEnt;

    @Column(name = "CODBAIRROCOM")
    private Long codBairroCom;

    @Column(name = "CODBAIRROCOB")
    private Long codBairroCob;

    @Column(name = "BAIRROENT")
    private String bairroEnt;

    @Column(name = "BAIRROCOM")
    private String bairroCom;

    @Column(name = "BAIRROCOB")
    private String bairroCob;

    @Column(name = "ENDERENT")
    private String enderEnt;

    @Column(name = "ENDERCOM")
    private String enderCom;

    @Column(name = "ENDERCOB")
    private String enderCob;

    @Column(name = "CEPENT")
    private String cepEnt;

    @Column(name = "CEPCOM")
    private String cepCom;

    @Column(name = "CEPCOB")
    private String cepCob;

    @Column(name = "DTNASC")
    private LocalDateTime dtNasc;

    @Column(name = "COMPLEMENTOENT")
    private String complementoEnt;

    @Column(name = "COMPLEMENTOCOM")
    private String complementoCom;

    @Column(name = "COMPLEMENTOCOB")
    private String complementoCob;

    @Column(name = "TELENT")
    private String telent;

    @Column(name = "TELCOM")
    private String telcom;

    @Column(name = "TELCOB")
    private String telcob;

    @Column(name = "OBSERVACAO")
    private String observacao;

    @Column(name = "LATITUDE")
    private String latitude;

    @Column(name = "LONGITUDE")
    private String longitude;

    @Column(name = "NUMEROENT")
    private String numeroEnt;

    @Column(name = "NUMEROCOM")
    private String numeroCom;

    @Column(name = "NUMEROCOB")
    private String numeroCob;

    @Column(name = "DTULTCOMP")
    private LocalDateTime dtUltComp;

    @Column(name = "LIMCRED")
    private BigDecimal limCred;

    @Column(name = "BLOQUEIO")
    private String bloqueio;

    @Column(name = "DTEXCLUSAO")
    private LocalDateTime dtExclusao;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CODFILIALNF", insertable = false, updatable = false)
    private PcFilial filial;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CODCIDADE", insertable = false, updatable = false)
    private PcCidade cidade;*/

    protected static final long TABLE_ID = 30150L;
    public static long getTableId() {
        return TABLE_ID;
    }
}
