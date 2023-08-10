package org.zmalchunz.configurer.jbback.server;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.zmalchunz.configurer.jbback.server.api.MockServer;
import org.zmalchunz.configurer.jbback.server.api.MockServerCreateRequest;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/server")
@AllArgsConstructor
public class MockServerResource {

    private final WiremockService wiremockService;

    @GetMapping
    @ResponseBody
    public List<MockServer> getMockServer() {
        return wiremockService.getMockSevers();
    }

    @PostMapping
    @ResponseBody
    public UUID createMockServer(@RequestBody MockServerCreateRequest mockServerCreateRequest) {
        return wiremockService.createMockServer(mockServerCreateRequest.toMockServer());
    }

    @PostMapping("/{id}/run")
    @ResponseBody
    public String runMock(@PathVariable UUID id) {
        wiremockService.runMockServer(id);
        return "Success";
    }

    @PostMapping("/{id}/stop")
    @ResponseBody
    public String stopMock(@PathVariable UUID id) {
        wiremockService.stopMockServer(id);
        return "Success";
    }
}
