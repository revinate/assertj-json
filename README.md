# AssertJ Json

[![Build Status](https://travis-ci.org/revinate/assertj-json.svg?branch=master)](https://travis-ci.org/revinate/assertj-json)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.revinate/assertj-json/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.revinate/assertj-json)
[![codecov.io](https://codecov.io/github/revinate/assertj-json/coverage.svg?branch=master)](https://codecov.io/github/revinate/assertj-json?branch=master)
[![Javadoc](https://javadoc-emblem.rhcloud.com/doc/com.revinate/assert-json/badge.svg)](http://www.javadoc.io/doc/com.revinate/assert-json)

A set of AssertJ assertions to validate JSON.

## JsonPath

Use `JsonPathAssert` to extract values using JsonPath and validate as a Java string, integer or list.

Example:
```java
DocumentContext ctx = JsonPath.parse("{\"value\":\"a text value\"}");

assertThat(ctx).jsonPathAsString("$.value").contains("text").endsWith("value");
```

### Runtime configuration
`JsonPathAssert` uses [JayWay JsonPath](https://github.com/jayway/JsonPath) under the covers. In order to execute more
complex extractions like array of strings to `List<String>` you need to have Jackson or Gson in your classpath and
configure JsonPath to use one of them.

One option is to execute the following snipped of code in a `@BeforeClass` method
in your test class.
```java
Configuration.setDefaults(new Configuration.Defaults() {
    private final JsonProvider jsonProvider = new JacksonJsonProvider();
    private final MappingProvider mappingProvider = new JacksonMappingProvider();

    @Override
    public JsonProvider jsonProvider() {
        return jsonProvider;
    }

    @Override
    public MappingProvider mappingProvider() {
        return mappingProvider;
    }

    @Override
    public Set<Option> options() {
        return EnumSet.noneOf(Option.class);
    }
});
```
