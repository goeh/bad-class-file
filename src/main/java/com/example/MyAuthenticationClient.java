package com.example;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.security.authentication.UsernamePasswordCredentials;
import io.micronaut.security.token.render.BearerAccessRefreshToken;
import org.reactivestreams.Publisher;

@Client("${my.auth.service.uri:my-auth-service}")
public interface MyAuthenticationClient {
    @Post("/login}")
    Publisher<BearerAccessRefreshToken> login(@Body UsernamePasswordCredentials credentials);

    @Get("/me")
    Publisher<UserInfo> getCurrentUser(@Header String authorization);
}
