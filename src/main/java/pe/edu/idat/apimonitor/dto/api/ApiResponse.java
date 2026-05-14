package pe.edu.idat.apimonitor.dto.api;

import pe.edu.idat.apimonitor.enums.EstadoApi;

import java.util.Date;

public record ApiResponse(
        Long apiId,
        String nombre,
        String baseUrl,
        EstadoApi estado,
        Date CreatedAt
) {
}
