package pe.edu.idat.apimonitor.dto.endpoint;

public record EndpointRequest(
        String nombre,
        String url,
        String method
) {
}
