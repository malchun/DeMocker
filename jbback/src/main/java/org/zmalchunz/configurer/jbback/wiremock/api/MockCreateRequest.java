package org.zmalchunz.configurer.jbback.wiremock.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.Map;
import java.util.UUID;

@Data
@Jacksonized
@Builder
public class MockCreateRequest {
    private String name;
    @JsonProperty("template-id")
    private UUID templateId;
    private Map<String, String> parameters;

    public Mock toMock() {
        return Mock.builder()
                .name(this.name)
                .templateId(this.templateId)
                .parameters(this.parameters)
                .build();
    }
}
