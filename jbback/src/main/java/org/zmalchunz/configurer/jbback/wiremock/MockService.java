package org.zmalchunz.configurer.jbback.wiremock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.zmalchunz.configurer.jbback.wiremock.api.Mock;
import org.zmalchunz.configurer.jbback.template.api.Template;
import org.zmalchunz.configurer.jbback.template.TemplateService;
import org.zmalchunz.configurer.jbback.wiremock.api.NotEnoughParametersException;
import org.zmalchunz.configurer.jbback.wiremock.repo.MockRepository;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class MockService {

    private final MockRepository mockRepository;
    private final TemplateService templateService;

    public MockService(MockRepository mockRepository, TemplateService templateService) {
        this.mockRepository = mockRepository;
        this.templateService = templateService;
    }

    public List<Mock> getMocks() {
        return mockRepository.findAll();
    }

    public UUID createMock(Mock newMock) {
        Template template = templateService.getTemplate(newMock.getTemplateId()).get();
        if (template.getParameters().equals(newMock.getParameters().keySet())) {
            log.error("Not all parameters available");
            throw new NotEnoughParametersException("Not all parameters available");
        }
        newMock.setTemplateBody(template.getTemplateBody());
        return mockRepository.save(newMock).getId();
    }
}