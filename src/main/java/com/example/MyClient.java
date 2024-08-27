package com.example;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;

import java.util.List;

@Client("${app.service.uri}")
public interface MyClient {
    @Post
    KeyValue setRoot(@Body KeyValue body);

    @Get
    KeyValue getRoot();

    @Get("/{id}")
    KeyValue getById(String id);

    @Get("/{id}/items")
    List<KeyValue> getItems(String id);
}
