package org.zmalchunz.configurer.jbback.template.engine;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleTemplateEngineTest {

    @ParameterizedTest(name = "{0} is successfully parsed")
    @MethodSource("provideTemplatesAndParameters")
    void getParametersSuccess(String template, String[] expectedParameters) {
        // when
        Set<String> parameters = SimpleTemplateEngine.getParameters(template);

        // then
        assertThat(parameters.size()).isEqualTo(expectedParameters.length);
        assertThat(parameters).containsExactlyInAnyOrder(expectedParameters);
    }

    private static Stream<Arguments> provideTemplatesAndParameters() {
        return Stream.of(
                Arguments.of("Template without parameters", new String[]{}),
                Arguments.of("Template with empty parameter ${}", new String[]{}),
                Arguments.of("Malformed template ${param", new String[]{}),
                Arguments.of("One parameter template ${parameter1}", new String[]{"parameter1"}),
                Arguments.of("Two parameter template ${parameter1} ${parameter2}", new String[]{"parameter1", "parameter2"})
        );
    }

    @ParameterizedTest(name = "{0} is successfully formatted")
    @MethodSource("provideTemplatesAndValueMaps")
    void formatSuccess(String template, Map<String, String> values, String expectedString) {
        // when
        String resultString = SimpleTemplateEngine.format(template, values);

        // then
        assertThat(resultString).isEqualTo(expectedString);
    }

    private static Stream<Arguments> provideTemplatesAndValueMaps() {
        return Stream.of(
                Arguments.of("Template without parameters", Map.of(), "Template without parameters"),
                Arguments.of("Template with empty parameter ${}", Map.of(), "Template with empty parameter ${}"),
                Arguments.of("Malformed template ${param", Map.of(), "Malformed template ${param"),
                Arguments.of("One parameter template ${parameter1}", Map.of("parameter1", "filled"),
                        "One parameter template filled"),
                Arguments.of("Two parameter template ${parameter1} ${parameter2}",
                        Map.of("parameter1", "filled", "parameter2", "out"),
                        "Two parameter template filled out"));
    }
}
