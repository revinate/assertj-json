package com.revinate.assertj.json;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.revinate.assertj.json.JsonPathAssert.assertThat;

public class JsonPathAssertTest {

    @BeforeClass
    public static void config() throws Exception {
        TestConfig.setDefaults();
    }

    @Test
    public void jsonPathAsString_shouldReadStringValue() throws Exception {
        DocumentContext documentContext = JsonPath.parse("{\"value\":\"foo\"}");

        assertThat(documentContext).jsonPathAsString("$.value").isEqualTo("foo");
    }

    @Test
    public void jsonPathAsInteger_shouldReadNumericValue() throws Exception {
        DocumentContext documentContext = JsonPath.parse("{\"value\":10}");

        assertThat(documentContext).jsonPathAsInteger("$.value").isEqualTo(10);
    }

    @Test
    public void jsonPathAsList_shouldReadArray() throws Exception {
        DocumentContext documentContext = JsonPath.parse("[1,2,3]");

        assertThat(documentContext).jsonPathAsListOf("$", Integer.class).containsExactly(1, 2, 3);
    }
}