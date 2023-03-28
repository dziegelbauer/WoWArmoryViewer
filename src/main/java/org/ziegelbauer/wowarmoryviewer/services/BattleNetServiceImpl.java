package org.ziegelbauer.wowarmoryviewer.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import org.ziegelbauer.wowarmoryviewer.model.dto.blizzardapi.EquipmentApiResponse;
import org.ziegelbauer.wowarmoryviewer.model.dto.blizzardapi.ItemMediaApiResponse;
import org.ziegelbauer.wowarmoryviewer.utility.BattleNetOAuth2Helper;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class BattleNetServiceImpl implements BattleNetService {
    private final HttpClient webClient;
    private final BattleNetOAuth2Helper battleNetOAuth2Helper;
    private final ObjectMapper mapper;

    public BattleNetServiceImpl(BattleNetOAuth2Helper battleNetOAuth2Helper) {

        this.webClient = HttpClient.newBuilder().build();
        this.battleNetOAuth2Helper = battleNetOAuth2Helper;
        this.mapper = new ObjectMapper();
    }

    @Override
    public EquipmentApiResponse getCharacterEquipment(String realmSlug, String name) {
        try {
            var query = UriComponentsBuilder
                    .fromHttpUrl("https://us.api.blizzard.com")
                    .path("/profile/wow/character/" + realmSlug + "/" + name + "/equipment")
                    .queryParam("namespace", "profile-us")
                    .queryParam("locale", "en_US")
                    .queryParam("access_token", battleNetOAuth2Helper.getToken())
                    .build();

            var request = HttpRequest.newBuilder()
                    .uri(query.toUri())
                    .header("Accept", "application/json")
                    .header("Authorization", "Bearer " + battleNetOAuth2Helper.getToken())
                    .GET()
                    .build();

            var response = webClient.send(request, HttpResponse.BodyHandlers.ofString());
            //String data = response.body();

            return mapper.readValue(response.body(), EquipmentApiResponse.class);
        } catch(Exception e) {
            return null;
        }
    }

    @Override
    public byte[] getItemIcon(Integer itemId) {
        try {
            var endPointQuery = UriComponentsBuilder
                    .fromHttpUrl("https://us.api.blizzard.com/data/wow/media/item/" + itemId)
                    .queryParam("namespace", "static-us")
                    .queryParam("locale", "en_US")
                    .queryParam("access_token", battleNetOAuth2Helper.getToken())
                    .build();

            var locationRequest = HttpRequest.newBuilder()
                    .uri(endPointQuery.toUri())
                    .header("Accept", "application/json")
                    .header("Authorization", "Bearer " + battleNetOAuth2Helper.getToken())
                    .GET()
                    .build();

            var responseString = webClient.send(locationRequest, HttpResponse.BodyHandlers.ofString()).body();

            var itemMediaAsset = mapper.readValue(responseString, ItemMediaApiResponse.class);
            var jpegPath = itemMediaAsset.getAssets()
                    .stream()
                    .filter(asset -> asset.getAssetType().equals("icon"))
                    .findFirst()
                    .get()
                    .getUrl();

            var query = UriComponentsBuilder
                    .fromHttpUrl(jpegPath)
                    .queryParam("access_token", battleNetOAuth2Helper.getToken())
                    .build();

            var imageRequest = HttpRequest.newBuilder()
                    .uri(query.toUri())
                    .header("Accept", "application/json")
                    .header("Authorization", "Bearer " + battleNetOAuth2Helper.getToken())
                    .GET()
                    .build();

            var response = webClient.send(imageRequest, HttpResponse.BodyHandlers.ofByteArray());

            return response.body();
        } catch(Exception e) {
            return new byte[0];
        }
    }
}
