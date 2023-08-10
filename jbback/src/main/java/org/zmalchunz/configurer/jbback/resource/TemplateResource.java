package org.zmalchunz.configurer.jbback.resource;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.zmalchunz.configurer.jbback.api.Template;
import org.zmalchunz.configurer.jbback.api.TemplateRequest;
import org.zmalchunz.configurer.jbback.wiremock.TemplateService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/template")
@AllArgsConstructor
public class TemplateResource {

    private final TemplateService templateService;

    @GetMapping
    @ResponseBody
    public List<Template> getTemplates() {
        return templateService.getTemplates();
    }

    @PostMapping
    @ResponseBody
    public UUID addTemplates(@RequestBody TemplateRequest newTemplateRequest) {
        return templateService.createTemplate(newTemplateRequest.toTemplate());
    }
}
