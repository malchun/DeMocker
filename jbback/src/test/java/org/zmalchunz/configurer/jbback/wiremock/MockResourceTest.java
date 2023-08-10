package org.zmalchunz.configurer.jbback.wiremock;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.zmalchunz.configurer.jbback.wiremock.api.Mock;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(MockResource.class)
class MockResourceTest {

    @MockBean
    private MockService mockService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MockResource mockResource;

    @Test
    public void getSuccess() throws Exception {
        // given
        Mock mock1 = Mock.builder().name("mock1").build();
        Mock mock2 = Mock.builder().name("mock2").build();
        List<Mock> mocks = List.of(mock1, mock2);
        when(mockService.getMocks()).thenReturn(mocks);

        // when
        MvcResult result = mockMvc.perform(get("/mock")).andReturn();

        // then
        assertThat(result.getResponse().getStatus()).isEqualTo(200);
        assertThat(result.getResponse().getContentAsString()).contains("mock1", "mock2");
    }
}