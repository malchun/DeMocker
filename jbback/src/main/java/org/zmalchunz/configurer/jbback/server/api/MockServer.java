package org.zmalchunz.configurer.jbback.server.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.jackson.Jacksonized;
import org.zmalchunz.configurer.jbback.mongo.utility.UuidIdentity;
import org.zmalchunz.configurer.jbback.wiremock.api.Mock;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Jacksonized
@Builder
public class MockServer extends UuidIdentity {
    @JsonProperty("mocks")
    private List<Mock> mocks;
    @JsonProperty("port")
    private int port;
}
