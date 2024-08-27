/*
 *  Copyright 2018-2018 original authors
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.example;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.AuthenticationRequest;
import io.micronaut.security.authentication.AuthenticationResponse;
import io.micronaut.security.authentication.provider.HttpRequestAuthenticationProvider;
import jakarta.inject.Singleton;

import java.util.List;

/**
 * @author Goran Ehrsson
 * @since 1.0
 */
//@Singleton
public class TestAuthenticationProvider<T> implements HttpRequestAuthenticationProvider<T> {

    @Override
    public @NonNull AuthenticationResponse authenticate(HttpRequest<T> httpRequest, @NonNull AuthenticationRequest<String, String> authenticationRequest) {
        if (authenticationRequest.getIdentity().equals("user") && authenticationRequest.getSecret().equals("password")) {
            return AuthenticationResponse.success(authenticationRequest.getIdentity(), List.of("ROLE_USER"));
        } else {
            return AuthenticationResponse.failure();
        }
    }
}
