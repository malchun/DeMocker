package org.zmalchunz.configurer.jbback.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;

import java.util.UUID;

@Data
@Jacksonized
@Builder
public class TemplateRequest {
    private String name;
    private String version;
    @JsonProperty("template-body")
    private String templateBody;

    public Template toTemplate() {
        return Template.builder()
                .name(this.getName())
                .version(this.getVersion() != null ? this.getVersion() : "0.1")
                .templateBody(this.getTemplateBody())
                .build();
    }
}
