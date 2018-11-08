package de.predic8.oauth2jwt;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class DiscoveryController {

    @GetMapping(value = "/.well-known/openid-configuration", produces = "application/json")
    public WellKnown getWellKnown() {
        return new WellKnown(
                "http://localhost:8080",
                "http://localhost:8080/oauth/authorize",
                "http://localhost:8080/oauth/token",
                "http://localhost:8080/oauth/check_token",
                null,
                null,
                Arrays.asList("code", "token"),
                Arrays.asList("authorization_code"),
                null,
                null,
                null,
                null,
                null,
                null
        );
    }
}
