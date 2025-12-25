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
@Table(name = "PCNCM")
public class PcNcm extends BaseEntity {
    @Id
    @Column(name = "CODNCMEX", length = 20, nullable = false)
    private String codNcmEx;

    @Column(name = "CODNCM", length = 15, nullable = false)
    private String codncm;

    @Column(name = "DESCRICAO", length = 500, nullable = false)
    private String descricao;

    @Column(name = "CAPITULO", precision = 2, scale = 0, nullable = false)
    private Integer capitulo;

    @Column(name = "CODEX", precision = 4, scale = 0)
    private Integer codex;

    @Column(name = "DTINCLUSAO")
    private LocalDateTime dtInclusao;

    @Column(name = "DTEXCLUSAO")
    private LocalDateTime dtExclusao;

    @Column(name = "CODUSURINCLUSAO", precision = 8, scale = 0)
    private Long codUsuInclusao;

    @Column(name = "CODUSUREXCLUSAO", precision = 8, scale = 0)
    private Long codUsuExclusao;

    protected static final long TABLE_ID = 30200L;
    public static long getTableId() {
        return TABLE_ID;
    }
}
