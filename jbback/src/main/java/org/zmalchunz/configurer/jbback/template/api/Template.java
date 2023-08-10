package org.zmalchunz.configurer.jbback.template.api;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;
import org.zmalchunz.configurer.jbback.mongo.utility.UuidIdentity;

import java.util.Set;

@Getter
@Builder
@Document("templates")
public class Template extends UuidIdentity {
    @NonNull
    private String name;
    @NonNull
    private String version;
    private String templateBody;
    @Setter
    private Set<String> parameters;
}
