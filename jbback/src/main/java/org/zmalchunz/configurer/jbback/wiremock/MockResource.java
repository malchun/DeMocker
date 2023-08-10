package org.zmalchunz.configurer.jbback.wiremock;

import org.springframework.web.bind.annotation.*;
import org.zmalchunz.configurer.jbback.wiremock.api.Mock;
import org.zmalchunz.configurer.jbback.wiremock.api.MockCreateRequest;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/mock")
public class MockResource {

    private final MockService mockService;

    public MockResource(MockService mockService) {
        this.mockService = mockService;
    }

    @GetMapping
    @ResponseBody
    public List<Mock> getMocks() {
        return mockService.getMocks();
    }

    @PostMapping
    @ResponseBody
    public UUID createMockServer(@RequestBody MockCreateRequest mockCreateRequest) {
        return mockService.createMock(mockCreateRequest.toMock());
    }

//    @PostMapping("/{id}/run/{serverId}")
//    @ResponseBody
//    public String runMock(@PathVariable UUID id, @PathVariable UUID serverId) {
//        mockService.runMockServer(id);
//        return "Success";
//    }
}
