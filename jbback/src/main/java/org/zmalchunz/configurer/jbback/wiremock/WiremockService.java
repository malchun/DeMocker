package org.zmalchunz.configurer.jbback.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.stubbing.StubMapping;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.zmalchunz.configurer.jbback.api.Mock;
import org.zmalchunz.configurer.jbback.api.MockServer;
import org.zmalchunz.configurer.jbback.repositories.MockServerRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class WiremockService {

    private final MockServerRepository mockServerRepository;
    private Map<UUID, WireMockServer> runningServers;

    public WiremockService(MockServerRepository mockServerRepository) {
        this.mockServerRepository = mockServerRepository;
    }

    public void runMockServer(MockServer mockServer) {
        log.debug("runMockServer {}", mockServer.getId());
        WireMockServer wireMockServer = new WireMockServer(WireMockConfiguration.options().port(mockServer.getPort()));
        mockServer.getMocks().forEach(mock -> wireMockServer.addStubMapping(StubMapping.buildFrom(mock.getMockBody())));
        try {
            runningServers.put(mockServer.getId(), wireMockServer);
            wireMockServer.start();
        } catch (Exception e) {
            log.error("Couldn't start server");
            log.debug("Exception: ", e);
        }
    }


    public void stopMockServer(UUID mockServerId) {
        log.debug("stopMockServer {}", mockServerId);
        try {
            Optional<WireMockServer> wireMockServerOptional = Optional.of(runningServers.get(mockServerId));
            wireMockServerOptional.ifPresentOrElse(
                    wireMockServer -> {
                        wireMockServer.stop();
                        runningServers.remove(mockServerId);
                    },
                    () -> log.info("Running server with id {} not found", mockServerId)
            );
        } catch (Exception e) {
            log.error("Couldn't stop server");
            log.debug("Exception: ", e);
        }
    }

    public void runMockServer(UUID mockServerId) {
        log.debug("runMockServer {}", mockServerId);
        mockServerRepository.findById(mockServerId).ifPresent(this::runMockServer);
    }

    public UUID createMockServer(Integer port, List<Mock> mocks) {
        log.debug("createMockServer");
        MockServer newServer = MockServer.builder().port(port).mocks(mocks).build();
        return mockServerRepository.save(newServer).getId();
    }

    public UUID createMockServer(MockServer newMockServer) {
        log.debug("createMockServer");
        return mockServerRepository.save(newMockServer).getId();
    }

    public List<MockServer> getMockSevers() {
        log.debug("getMockServers");
        return mockServerRepository.findAll();
    }
}
