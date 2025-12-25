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
@Table(name = "PCEMPR")
public class PcEmpr extends BaseEntity {

    @Id
    @Column(name = "MATRICULA")
    private Long matricula;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "DT_EXCLUSAO")
    private LocalDateTime dtExclusao;

    @Column(name = "NOME_GUERRA")
    private String nomeGuerra;

    @Column(name = "CODCIDADE")
    private Long codCidade;

    @Column(name = "ENDERECO")
    private String endereco;

    @Column(name = "BAIRRO")
    private String bairro;

    @Column(name = "CIDADE")
    private String cidade;

    @Column(name = "ESTADO")
    private String estado;

    @Column(name = "CEP")
    private String cep;

    @Column(name = "FONE")
    private String fone;

    @Column(name = "CODSETOR")
    private Long codSetor;

    @Column(name = "SITUACAO")
    private String situacao;

    @Column(name = "CPF")
    private String cpf;

    @Column(name = "CODFILIAL")
    private Long codFilial;

    @Column(name = "CODUSUR")
    private Long codUsur;

    @Column(name = "CELULAR")
    private String celular;

    @Column(name = "TIPO")
    private String tipo;

    @Column(name = "RG")
    private String rg;

    @Column(name = "CTPS")
    private String ctps;

    @Column(name = "PIS")
    private String pis;

    @Column(name = "FUNCAO")
    private String funcao;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "CODFUNCAO")
    private Long codFuncao;

    @Column(name = "RESCISAO")
    private String rescisao;

    @Column(name = "COMPLEMENTO")
    private String complemento;

    @Column(name = "OBSERVACAO")
    private String observacao;


    protected static final long TABLE_ID = 30090L;
    public static long getTableId() {
        return TABLE_ID;
    }
}
