package org.zmalchunz.configurer.jbback.wiremock;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.zmalchunz.configurer.jbback.mongocontainer.MongoContainerConfig;
import org.zmalchunz.configurer.jbback.wiremock.api.Mock;
import org.zmalchunz.configurer.jbback.wiremock.repo.MockRepository;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
@Testcontainers
@ContextConfiguration(classes = MongoContainerConfig.class)
class MockRepositoryTest {

    @Autowired
    private MockRepository mockRepository;

    @Test
    public void createMockSuccessful() {
        // given
        Mock newMock = Mock.builder().name("first").templateId(UUID.randomUUID()).build();

        // when
        Mock resultMock = mockRepository.save(newMock);

        // then
        assertThat(resultMock).isEqualTo(newMock);
    }
}