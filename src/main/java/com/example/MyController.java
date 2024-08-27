package com.example;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

import java.util.Map;

@Controller
@ExecuteOn(TaskExecutors.BLOCKING)
@Secured(SecurityRule.IS_AUTHENTICATED)
public class MyController {

    @Post
    public KeyValue createRoot(@Body KeyValue body) {
        return body;
    }

    @Get
    public KeyValue root() {
        return KeyValue.of("hello", "world");
    }

    @Get("/{id}")
    public KeyValue id(String id) {
        return KeyValue.of("hello", id);
    }

    @Get("/foo")
    public KeyValue foo() {
        return KeyValue.of("hello", "foo");
    }
}
