package org.ziegelbauer.wowarmoryviewer.utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.util.Base64;

@Component
@Scope("singleton")
public class BattleNetOAuth2Helper {
    private String accessToken;
    private final String clientId;
    private final String clientSecret;
    private LocalDateTime expires;
    private final HttpClient httpClient;

    public BattleNetOAuth2Helper(
            @Value("${battlenet.client-id}") String clientId,
            @Value("${battlenet.client-secret}") String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.httpClient = HttpClient.newBuilder().build();
    }

    private boolean isValid() {
        return accessToken != null
                && expires != null
                && !expires.isBefore(LocalDateTime.now());
    }

    private void refreshToken() throws URISyntaxException, IOException, InterruptedException {
        var apiKeyRequest = Base64.getEncoder().encodeToString((this.clientId + ":" + this.clientSecret).getBytes());
        var request = HttpRequest.newBuilder()
                .uri(new URI("https://us.battle.net/oauth/token"))
                .header("Authorization", "Basic " + apiKeyRequest)
                .header("Accept", "application/json")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString("grant_type=client_credentials"))
                .build();

        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper mapper = new ObjectMapper();
        var jsonString = response.body();
        OAuth2Token token;
        try {
            token = mapper.readValue(jsonString, OAuth2Token.class);
        } catch (Exception e) {
            System.out.println(e);
            token = null;
        }

        this.accessToken = token.getAccessToken();
        this.expires = LocalDateTime.now().plusSeconds(token.getExpiresIn());
    }

    public String getToken() {
        if(!this.isValid()) {
            try {
                this.refreshToken();
            }
            catch (Exception e) {

            }
        }

        return this.accessToken;
    }
}
