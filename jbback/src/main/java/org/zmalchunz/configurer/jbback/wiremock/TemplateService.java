package org.zmalchunz.configurer.jbback.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.stubbing.StubMapping;
import org.springframework.stereotype.Service;
import org.zmalchunz.configurer.jbback.api.MockServer;
import org.zmalchunz.configurer.jbback.api.Template;
import org.zmalchunz.configurer.jbback.repositories.MockServerRepository;
import org.zmalchunz.configurer.jbback.repositories.TemplateRepository;

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
