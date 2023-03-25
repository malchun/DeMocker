package org.zmalchunz.configurer.jbback.wiremock;

import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.stubbing.StubMapping;
import org.springframework.stereotype.Service;
import com.github.tomakehurst.wiremock.WireMockServer;
import org.zmalchunz.configurer.jbback.api.Template;

@Service
public class WiremockService {

    public void runMock(Template template) {
        WireMockServer wireMockServer = new WireMockServer(WireMockConfiguration.options().port(2345));
        wireMockServer.addStubMapping(StubMapping.buildFrom(template.getTemplateBody()));
        wireMockServer.start();
    }
}
