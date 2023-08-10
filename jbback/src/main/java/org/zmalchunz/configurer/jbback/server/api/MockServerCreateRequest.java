package org.zmalchunz.configurer.jbback.server.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;
import org.zmalchunz.configurer.jbback.wiremock.api.Mock;

import java.util.List;

@Data
@Jacksonized
@Builder
public class MockServerCreateRequest {
    @JsonProperty("mocks")
    private List<Mock> mocks;
    @JsonProperty("port")
    private int port;
    public MockServer toMockServer() {
        return MockServer.builder()
                .port(port)
                .mocks(mocks)
                .build();
    }
}
