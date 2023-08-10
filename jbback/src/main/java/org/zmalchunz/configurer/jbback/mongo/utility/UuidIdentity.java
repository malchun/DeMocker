package org.zmalchunz.configurer.jbback.mongo.utility;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;

import java.util.UUID;

@Getter
@Setter
public abstract class UuidIdentity {
    @Id
    protected UUID id;
}
