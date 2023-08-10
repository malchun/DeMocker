package org.zmalchunz.configurer.jbback.template;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.zmalchunz.configurer.jbback.template.api.Template;
import org.zmalchunz.configurer.jbback.template.api.TemplateRequest;

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
