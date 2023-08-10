package org.zmalchunz.configurer.jbback.api;

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
    @JsonProperty("template-id")
    private UUID templateId;
    @JsonProperty("mock-body")
    private String mockBody;
    private Map<String, String> parameters;
}
