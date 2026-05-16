package pe.edu.idat.apimonitor.dto.api;

import pe.edu.idat.apimonitor.enums.EstadoApi;

import java.time.LocalDateTime;


public record ApiResponse(
        Long apiId,
        String nombre,
        String baseUrl,
        EstadoApi estado,
        LocalDateTime createdAt,
        LocalDateTime updateAt
) {
}
