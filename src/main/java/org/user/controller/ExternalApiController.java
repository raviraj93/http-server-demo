package org.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.user.domain.ExternalApiDomain;
import org.user.externalapi.ExternalApiService;

@RestController
@RequestMapping("/external")
public class ExternalApiController {
    private final ExternalApiService externalApiService;

    public ExternalApiController(ExternalApiService externalApiService) {
        this.externalApiService = externalApiService;
    }

    @GetMapping
    public ResponseEntity<ExternalApiDomain> getExternalData() {
        ExternalApiDomain response = externalApiService.fetchExternalData();
        return ResponseEntity.ok(response);
    }
}


