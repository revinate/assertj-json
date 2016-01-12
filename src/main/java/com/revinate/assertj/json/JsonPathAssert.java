package com.revinate.assertj.json;

import com.jayway.jsonpath.DocumentContext;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.AbstractCharSequenceAssert;
import org.assertj.core.api.AbstractIntegerAssert;
import org.assertj.core.api.Assertions;

public class JsonPathAssert extends AbstractAssert<JsonPathAssert, DocumentContext> {

    public JsonPathAssert(DocumentContext actual) {
        super(actual, JsonPathAssert.class);
    }

    public static JsonPathAssert assertThat(DocumentContext documentContext) {
        return new JsonPathAssert(documentContext);
    }

    public AbstractCharSequenceAssert<?, String> jsonPathAsString(String path) {
        return Assertions.assertThat(actual.read(path, String.class));
    }

    public AbstractIntegerAssert<?> jsonPathAsInteger(String path) {
        return Assertions.assertThat(actual.read(path, Integer.class));
    }
}
