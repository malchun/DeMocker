package org.zmalchunz.configurer.jbback.api;

import lombok.Builder;
import lombok.Getter;
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
    private Set<String> listOfParameters;
}
