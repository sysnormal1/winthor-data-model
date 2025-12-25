package com.sysnormal.libs.db.entities.integrations.winthor_entities;

import com.sysnormal.libs.db.entities.base_entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "PCUSUARI")
public class PcUsuari extends BaseEntity {
    @Id
    @Column(name = "CODUSUR")
    private Long codUsur;

    @Column(name = "CODFILIAL", length = 2)
    private String codFilial;

    @Column(name = "CODSUPERVISOR")
    private Long codSupervisor;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "CPF")
    private String cpf;

    @Column(name = "CGC")
    private String cgc;

    @Column(name = "CODCIDADE")
    private Long codCidade;

    @Column(name = "BAIRRO")
    private String bairro;

    @Column(name = "ENDERECO")
    private String endereco;

    @Column(name = "ENDERECO2")
    private String endereco2;

    @Column(name = "CEP")
    private String cep;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "TELEFONE1")
    private String telefone1;

    @Column(name = "TELEFONE2")
    private String telefone2;

    @Column(name = "OBS1")
    private String obs1;

    @Column(name = "OBS2")
    private String obs2;

    @Column(name = "OBSBLOQ")
    private String obsBloq;

    @Column(name = "OBSFORCAVENDAS1")
    private String obsForcaVendas1;

    @Column(name = "OBSFORCAVENDAS2")
    private String obsForcaVendas2;

    @Column(name = "OBSFORCAVENDAS3")
    private String obsForcaVendas3;

    @Column(name = "OBSFORCAVENDAS4")
    private String obsForcaVendas4;

    @Column(name = "DTTERMINO")
    private LocalDateTime dtTermino;

    @Column(name = "DTEXCLUSAO")
    private LocalDateTime dtExclusao;

    protected static final long TABLE_ID = 30091L;
    public static long getTableId() {
        return TABLE_ID;
    }
}
