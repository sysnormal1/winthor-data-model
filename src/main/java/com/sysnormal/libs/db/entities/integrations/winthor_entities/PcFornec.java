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
@Table(name = "PCFORNEC")
public class PcFornec extends BaseEntity {
    @Id
    @Column(name = "CODFORNEC")
    private Long codFornec;

    @Column(name = "TIPOPESSOA")
    private String tipoPessoa;

    @Column(name = "CGC")
    private String cgc;

    @Column(name = "FORNECEDOR")
    private String fornecedor;

    @Column(name = "FANTASIA")
    private String fantasia;

    @Column(name = "ESTADO")
    private String estado;

    @Column(name = "CODCIDADE")
    private Long codCidade;

    @Column(name = "BAIRROCOB")
    private String bairroCob;

    @Column(name = "ADM_BAIRRO")
    private String admBairro;

    @Column(name = "COM_BAIRRO")
    private String comBairro;

    @Column(name = "BAIRRO")
    private String bairro;

    @Column(name = "REP_BAIRRO")
    private String repBairro;

    @Column(name = "ENDERCOB")
    private String enderCob;

    @Column(name = "ADM_ENDERECO")
    private String admEndereco;

    @Column(name = "COM_ENDERECO")
    private String comEndereco;

    @Column(name = "ENDER")
    private String ender;

    @Column(name = "REP_ENDERECO")
    private String repEndereco;

    @Column(name = "CEPCOB")
    private String cepCob;

    @Column(name = "ADM_CEP")
    private String admCep;

    @Column(name = "COM_CEP")
    private String comCep;

    @Column(name = "CEP")
    private String cep;

    @Column(name = "REP_CEP")
    private String repCep;

    @Column(name = "TELCOB")
    private String telCob;

    @Column(name = "TELEFONECOM")
    private String telefoneCom;

    @Column(name = "TELEFONEADM")
    private String telefoneAdm;

    @Column(name = "TELREP")
    private String telRep;

    @Column(name = "TELFAB")
    private String telFab;

    @Column(name = "TELEXREP")
    private String telExRep;

    @Column(name = "TELEXFAB")
    private String telExFab;

    @Column(name = "COMPLEMENTOEND")
    private String complementoEnd;

    @Column(name = "OBS")
    private String obs;

    @Column(name = "NUMEROEND")
    private String numeroEnd;

    @Column(name = "DTEXCLUSAO")
    private LocalDateTime dtExclusao;

    protected static final long TABLE_ID = 30014L;
    public static long getTableId() {
        return TABLE_ID;
    }
}
