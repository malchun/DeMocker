package org.zmalchunz.configurer.jbback.resource;

import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;
import org.zmalchunz.configurer.jbback.api.MockRunRequest;
import org.zmalchunz.configurer.jbback.api.Template;
import org.zmalchunz.configurer.jbback.api.TemplateRequest;
import org.zmalchunz.configurer.jbback.repositories.TemplateRepository;
import org.zmalchunz.configurer.jbback.wiremock.WiremockService;

import java.util.List;

@RestController("/")
@AllArgsConstructor
public class MainResource {

    private TemplateRepository templateRepository;
    private WiremockService wiremockService;

    @GetMapping("/template")
    @ResponseBody
    public List<Template> getTemplates() {
        return templateRepository.findAll();
    }

    @PostMapping("/template")
    @ResponseBody
    public String addTemplates(@RequestBody TemplateRequest newTemplateRequest) {
        Template template = Template.fromTemplateRequest(newTemplateRequest);
        templateRepository.insert(template);
        return template.getId().toString();
    }

    @PostMapping("/mock/run")
    @ResponseBody
    public String runMock(@RequestBody MockRunRequest mockRunRequest) {
        Template template = templateRepository.findById(mockRunRequest.getTemplateId()).get();
        wiremockService.runMock(template);
        return "Success";
    }
}
