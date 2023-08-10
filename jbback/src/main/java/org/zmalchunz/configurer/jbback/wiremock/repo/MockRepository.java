package org.zmalchunz.configurer.jbback.wiremock.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.zmalchunz.configurer.jbback.wiremock.api.Mock;


import java.util.UUID;

@Repository
public interface MockRepository extends MongoRepository<Mock, UUID> {
}
