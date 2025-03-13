package org.user.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.user.domain.ExternalApiDomain;
import org.user.externalapi.ExternalApiService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.http.HttpStatus.OK;

@ExtendWith(MockitoExtension.class)
class ExternalApiControllerTest {

    @Mock
    private ExternalApiService externalApiService;

    @InjectMocks
    private ExternalApiController externalApiController;

    @Test
    void getExternalData_ShouldReturnValidResponse() {
        // Arrange
        ExternalApiDomain mockResponse = new ExternalApiDomain(1, 101, "Sample Task", true);
        when(externalApiService.fetchExternalData()).thenReturn(mockResponse);

        // Act
        ResponseEntity<ExternalApiDomain> response = externalApiController.getExternalData();

        // Assert
        assertNotNull(response);
        assertEquals(OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(mockResponse.getTaskId(), response.getBody().getTaskId());
        assertEquals(mockResponse.getTaskTitle(), response.getBody().getTaskTitle());
        assertEquals(mockResponse.isCompleted(), response.getBody().isCompleted());

        // Verify that the service was called once
        verify(externalApiService, times(1)).fetchExternalData();
    }
}
