package org.polytech.al.project1920.useraccount.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class UserAccountBean {
    @Value("${Bank}")
    private String uri;

    public boolean getData(String accountId){
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri + "/getInfos")
                .queryParam("accountId", accountId);
                //.queryParam("location", delivery.getLocation());



        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<?> entity = new HttpEntity<>(headers);
        HttpEntity<Boolean> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                Boolean.class);
        if (response != null && response.getBody() != null)
        {
            return response.getBody();
        }
        return false;
    }
}
