package org.zmalchunz.configurer.jbback.template;

import org.springframework.stereotype.Service;
import org.zmalchunz.configurer.jbback.template.api.Template;
import org.zmalchunz.configurer.jbback.template.engine.SimpleTemplateEngine;
import org.zmalchunz.configurer.jbback.template.repo.TemplateRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TemplateService {

    private final TemplateRepository templateRepository;

    public TemplateService(TemplateRepository templateRepository) {
        this.templateRepository = templateRepository;
    }

    public UUID createTemplate(Template newTemplate) {
        newTemplate.setParameters(SimpleTemplateEngine.getParameters(newTemplate.getTemplateBody()));
        return templateRepository.save(newTemplate).getId();
    }

    public Optional<Template> getTemplate(UUID templateId) {
        return templateRepository.findById(templateId);
    }

    public List<Template> getTemplates(List<UUID> templateIds) {
        return templateRepository.findAllById(templateIds);
    }

    public List<Template> getTemplates() {
        return templateRepository.findAll();
    }
}
