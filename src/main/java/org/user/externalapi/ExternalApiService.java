package org.user.externalapi;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.user.domain.ExternalApiDomain;
import org.user.mapper.ExternalApiMapper;
import org.user.response.ExternalApiResponse;

@Service
public class ExternalApiService {

    private static final String EXTERNAL_API_URL = "https://jsonplaceholder.typicode.com/todos/1";
    private final RestTemplate restTemplate;
    private final ExternalApiMapper externalApiMapper;

    public ExternalApiService(RestTemplate restTemplate, ExternalApiMapper externalApiMapper) {
        this.restTemplate = restTemplate;
        this.externalApiMapper = externalApiMapper;
    }

    public ExternalApiDomain fetchExternalData() {
        ExternalApiResponse response = restTemplate.getForObject(EXTERNAL_API_URL, ExternalApiResponse.class);
        return externalApiMapper.toDomain(response);
    }
}


