package org.zmalchunz.configurer.jbback.wiremock.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.jackson.Jacksonized;
import org.zmalchunz.configurer.jbback.mongo.utility.UuidIdentity;

import java.util.Map;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@Jacksonized
@Builder
public class Mock extends UuidIdentity {
    @JsonProperty("name")
    private String name;
    @JsonProperty("template-id")
    private UUID templateId;
    @JsonProperty("template-body")
    private String templateBody;
    private Map<String, String> parameters;
}
