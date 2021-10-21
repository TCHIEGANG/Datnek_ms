package com.lib.mapper.language;


import com.lib.dto.Language.LanguageDto;
import com.lib.mapper.GenericMapper;
import com.lib.models.models.language.Language;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class LanguageMapper {

    private static LanguageMapper singleton;

    /**
     * Récupère ou créer l'instance
     *
     * @return LanguageMapper
     */
    public static LanguageMapper getInstance() {
        if (singleton == null) {
            singleton = new LanguageMapper();
        }
        return singleton;
    }

    /**
     * maps list of languages into list of LanguageDto
     *
     * @param languages list of permission to be mapped
     * @return list of LanguageDto mapped
     */
    public List<LanguageDto> asDtos(List<Language> languages){
        List<LanguageDto> languageDtos = new ArrayList<>();
        if (!CollectionUtils.isEmpty(languages)){
            for (Language language: languages){
                languageDtos.add(GenericMapper.INSTANCE.asDto(language));
            }
        }
        return languageDtos;
    }

}
