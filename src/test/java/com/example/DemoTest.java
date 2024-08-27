package com.example;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.security.authentication.UsernamePasswordCredentials;
import io.micronaut.security.token.render.BearerAccessRefreshToken;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.Map;

@MicronautTest
class DemoTest {

    @Inject
    EmbeddedApplication<?> application;

    @Inject
    @Client("/")
    HttpClient httpClient;

    private MyClient getMyClient() {
        return application.getApplicationContext().getBean(MyClient.class);
    }

    private String getAuthorizationHeader(String username, String password) {
        UsernamePasswordCredentials creds = new UsernamePasswordCredentials(username, password);
        HttpResponse<BearerAccessRefreshToken> resp = httpClient.toBlocking().exchange(HttpRequest.POST("/login", creds), BearerAccessRefreshToken.class);
        BearerAccessRefreshToken auth = resp.body();
        return "Bearer " + auth.getAccessToken();
    }

    @Test
    void testEndpoints() {
        String auth = getAuthorizationHeader("user", "password");
        MyClient client = getMyClient();

        //client.setRoot(auth, KeyValue.of("hello", "world"));
        client.getRoot(auth);
        //client.getId(auth, "42");
        //client.getFoo(auth);
    }

}
