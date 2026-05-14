package pe.edu.idat.apimonitor.dto.endpoint;

import pe.edu.idat.apimonitor.enums.EstadoApi;

import java.util.Date;

public record EndpointResponse(
        Long endpointId,
        String nombre,
        String url,
        String method,
        EstadoApi estado,
        Date CreatedAt,
        String nombreApi

) {
}
