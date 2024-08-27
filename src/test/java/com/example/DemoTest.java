package com.example;

import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

@MicronautTest
class DemoTest {

    @Inject
    EmbeddedApplication<?> application;

    private MyClient getMyClient() {
        return application.getApplicationContext().getBean(MyClient.class);
    }

    @Test
    void testEndpoints() {
        MyClient client = getMyClient();

        client.getRoot();
        //client.setRoot(KeyValue.of("hello", "world"));
        //client.getById("42");
        //client.getItems("42");
    }
}
