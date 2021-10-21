package com.lib.models.models.language.config;

import com.lib.models.models.BaseActiveModel;
import com.lib.models.models.BaseModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = Level.TABLE_NAME)
public class Level extends BaseModel {
    public static final String TABLE_NAME = "level";
    public static final String CODE_COLUMN = "code";
    public static final String LABEL_COLUMN = "label";

    @Column(name = CODE_COLUMN, nullable = false)
    private String code;

    @Column(name = LABEL_COLUMN, nullable = false)
    private String label;

    @Override
    public String getLog() {
        return null;
    }

    @Override
    public String getLogDetail() {
        return null;
    }
}
