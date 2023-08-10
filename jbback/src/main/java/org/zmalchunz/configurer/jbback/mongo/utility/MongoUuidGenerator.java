package org.zmalchunz.configurer.jbback.mongo.utility;

import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MongoUuidGenerator extends AbstractMongoEventListener<UuidIdentity> {
    @Override
    public void onBeforeConvert(BeforeConvertEvent<UuidIdentity> event) {
        UuidIdentity uuidIdentified = event.getSource();
        if (null == uuidIdentified.getId()) {
            uuidIdentified.setId(UUID.randomUUID());
        }
    }
}
