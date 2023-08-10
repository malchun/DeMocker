package org.zmalchunz.configurer.jbback.template.engine;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleTemplateEngine {

    private static Pattern defaultPattern = Pattern.compile("[$][{](\\w+)}");

    public static String format(String template, Map<String, String> parameters) {
        StringBuilder newTemplate = new StringBuilder(template);
        List<String> valueList = new ArrayList<>();

        Matcher matcher = defaultPattern.matcher(template);

        while (matcher.find()) {
            String key = matcher.group(1);

            String paramName = "${" + key + "}";
            int index = newTemplate.indexOf(paramName);
            if (index != -1) {
                newTemplate.replace(index, index + paramName.length(), "%s");
                valueList.add(parameters.get(key));
            }
        }

        return String.format(newTemplate.toString(), valueList.toArray());
    }

    public static Set<String> getParameters(String template) {
        Set<String> result = new HashSet<String>();
        Matcher matcher = defaultPattern.matcher(template);

        while (matcher.find()) {
            String key = matcher.group(1);

            result.add(key);
        }
        return result;
    }
}
