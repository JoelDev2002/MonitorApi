package pe.edu.idat.apimonitor.dto.endpoint;

import pe.edu.idat.apimonitor.enums.EstadoApi;

import java.time.LocalDateTime;

public record EndpointDetailResponse(
        Long endpointId,
        String nombre,
        String url,
        String method,
        EstadoApi estado,
        LocalDateTime createdAt,
        LocalDateTime updateAt,
        String nombreApi
) {
}
