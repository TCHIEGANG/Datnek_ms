package com.lib.mapper.language.config;


import com.lib.dto.Language.config.LevelDto;
import com.lib.mapper.GenericMapper;
import com.lib.models.models.language.config.Level;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class LevelMapper {

    private static LevelMapper singleton;

    /**
     * Récupère ou créer l'instance
     *
     * @return LevelMapper
     */
    public static LevelMapper getInstance() {
        if (singleton == null) {
            singleton = new LevelMapper();
        }
        return singleton;
    }

    /**
     * maps list of levels into list of LevelDto
     *
     * @param levels list of permission to be mapped
     * @return list of LevelDto mapped
     */
    public List<LevelDto> asDtos(List<Level> levels){
        List<LevelDto> levelDtos = new ArrayList<>();
        if (!CollectionUtils.isEmpty(levels)){
            for (Level level: levels){
                levelDtos.add(GenericMapper.INSTANCE.asDto(level));
            }
        }
        return levelDtos;
    }

}
