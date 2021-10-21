package com.yamo.skillsmates.mapper.version;

import com.lib.dto.version.VersionDescriptionDto;
import com.lib.dto.version.VersionDto;

import com.lib.mapper.GenericMapper;
import com.lib.models.models.version.Version;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class VersionMapper {

    private static VersionMapper singleton;

    public static VersionMapper getInstance() {

        if (singleton == null) {
            singleton = new VersionMapper();
        }
        return singleton;
    }

    public List<VersionDto> asDtos(List<Version> versions){
        List<VersionDto> versionDtos = new ArrayList<>();
        if (versions != null){
            for (Version version: versions){
                versionDtos.add(GenericMapper.INSTANCE.asDto(version));
            }
        }
        return versionDtos;
    }

    public List<Version> asEntities(VersionDescriptionDto versionDescription){
        List<Version> versions = new ArrayList<>();
        if (versionDescription != null && !CollectionUtils.isEmpty(versionDescription.getDescriptions())){
            for (String description: versionDescription.getDescriptions()){
                Version version = new Version();
                version.setDescription(description);
                version.setVersion(versionDescription.getVersion());
                versions.add(version);
            }
        }
        return versions;
    }

    public VersionDescriptionDto asDto(List<Version> versions){
        VersionDescriptionDto versionDescriptionDto = new VersionDescriptionDto();
        if (!CollectionUtils.isEmpty(versions)){
            versionDescriptionDto.setVersion(versions.get(0).getVersion());
            List<String> descriptions = new ArrayList<>();
            for (Version version: versions){
                descriptions.add(version.getDescription());
            }
            versionDescriptionDto.setDescriptions(descriptions);
        }
        return versionDescriptionDto;
    }
}

