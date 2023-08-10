package org.zmalchunz.configurer.jbback.resource;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.zmalchunz.configurer.jbback.api.MockServer;
import org.zmalchunz.configurer.jbback.api.MockServerCreateRequest;
import org.zmalchunz.configurer.jbback.api.Template;
import org.zmalchunz.configurer.jbback.api.TemplateRequest;
import org.zmalchunz.configurer.jbback.wiremock.TemplateService;
import org.zmalchunz.configurer.jbback.wiremock.WiremockService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/mockserver")
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
        UUID id = wiremockService.createMockServer(mockServerCreateRequest.toMockServer());
        return id;
    }

    @PostMapping("/{id}/run")
    @ResponseBody
    public String runMock(@PathVariable UUID id) {
        wiremockService.runMockServer(id);
        return "Success";
    }
}
