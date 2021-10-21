package com.lib.dto.version;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.lib.dto.BaseActiveModelDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class VersionDto extends BaseActiveModelDto {

    private String version;
    private String description;

    @Override
    public String getLog() {
        return null;
    }

    @Override
    public String getLogDetail() {
        return null;
    }
}
