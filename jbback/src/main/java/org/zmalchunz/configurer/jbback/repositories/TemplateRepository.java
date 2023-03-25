package org.zmalchunz.configurer.jbback.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.zmalchunz.configurer.jbback.api.Template;

import java.util.UUID;

@Repository
public interface TemplateRepository extends MongoRepository<Template, UUID> {
}
