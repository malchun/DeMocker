package org.zmalchunz.configurer.jbback.api;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;
import org.springframework.data.annotation.Id;

import java.util.Set;
import java.util.UUID;

@Getter
@Builder
@Document("templates")
public class Template {
    @NonNull
    @Id
    private UUID id;
    @NonNull
    private String name;
    @NonNull
    private String version;
    private String templateBody;
    private Set<String> listOfParameters;

    public static Template fromTemplateRequest(TemplateRequest templateRequest) {
        return Template.builder()
                    .id(UUID.randomUUID())
                    .name(templateRequest.getName())
                .version(templateRequest.getVersion() != null ? templateRequest.getVersion() : "0.1")
                .templateBody(templateRequest.getTemplateBody())
                .build();
    }
}
