package com.lib.mapper;

import com.lib.dto.Language.LanguageDto;
import com.lib.dto.Language.config.LevelDto;
import com.lib.dto.version.VersionDto;
import com.lib.models.models.language.Language;
import com.lib.models.models.language.config.Level;
import com.lib.models.models.version.Version;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.Mapper;
import fr.xebia.extras.selma.Selma;

@Mapper(withIgnoreMissing = IgnoreMissing.ALL)
public interface GenericMapper {

    /**
     * Instance of the mapper
     */
    GenericMapper INSTANCE = Selma.getMapper(GenericMapper.class);

    Language asEntity(LanguageDto languageDto);
    Version asEntity(VersionDto versionDto);
    Level asEntity(LevelDto levelDto);

    LanguageDto asDto(Language language);
    VersionDto asDto(Version version);
    LevelDto asDto(Level level);
}
