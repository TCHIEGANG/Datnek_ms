package com.lib.models.models.language;

import com.lib.models.models.BaseActiveModel;
import com.lib.models.models.language.config.Level;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = Language.TABLE_NAME)
public class Language extends BaseActiveModel {
    public static final String TABLE_NAME = "language";
    public static final String SPOKEN_LEVEL_COLUMN = "spokenLevel";
    public static final String WRITTEN_LEVEL_COLUMN = "writtenLevel";
    public static final String COMPREHENSION_LEVEL_COLUMN = "comprehensionLevel";
    public static final String CODE_COLUMN = "code";

    @ManyToOne
    @JoinColumn(name=SPOKEN_LEVEL_COLUMN )
    private Level spokenLevel;

    @ManyToOne
    @JoinColumn(name=SPOKEN_LEVEL_COLUMN )
    private Level writtenLevel;

    @ManyToOne
    @JoinColumn(name=SPOKEN_LEVEL_COLUMN )
    private Level comprehensionLevel;

    @Column(name = CODE_COLUMN, nullable = false)
    private String code;

    @Override
    public String getLog() {
        return null;
    }

    @Override
    public String getLogDetail() {
        return null;
    }
}
