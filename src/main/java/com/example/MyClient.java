package com.example;

import io.micronaut.http.HttpHeaders;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;

import java.util.List;

@Client("${app.service.uri}")
public interface MyClient {
    @Post
    KeyValue setRoot(@Header(HttpHeaders.AUTHORIZATION) String auth, @Body KeyValue body);

    @Get
    KeyValue getRoot(@Header(HttpHeaders.AUTHORIZATION) String auth);

    @Get("/foo")
    KeyValue getFoo(@Header(HttpHeaders.AUTHORIZATION) String auth);

    @Get("/{id}")
    KeyValue getId(@Header(HttpHeaders.AUTHORIZATION) String auth, String id);

    @Get("/{id}/relations")
    List<KeyValue> getRelations(@Header(HttpHeaders.AUTHORIZATION) String auth, String id);
}
