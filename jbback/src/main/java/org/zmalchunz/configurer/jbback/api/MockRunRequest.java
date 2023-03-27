package org.zmalchunz.configurer.jbback.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.UUID;

@Data
@Jacksonized
@Builder
public class MockRunRequest {
    @JsonProperty("template-id")
    private UUID templateId;
    @JsonProperty("port")
    private int port;
}
