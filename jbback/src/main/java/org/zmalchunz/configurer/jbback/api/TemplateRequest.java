package org.zmalchunz.configurer.jbback.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;

@Data
@Jacksonized
@Builder
public class TemplateRequest {
    private String name;
    private String version;
    @JsonProperty("template-body")
    private String templateBody;
}
