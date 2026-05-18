package pe.edu.idat.apimonitor.services;

import pe.edu.idat.apimonitor.dto.endpoint.EndpointDetailResponse;
import pe.edu.idat.apimonitor.dto.endpoint.EndpointRequest;
import pe.edu.idat.apimonitor.dto.endpoint.EndpointResponse;

import java.util.List;


public interface EndpointService {
    List<EndpointResponse> listarEndpointPorApi(Long apiId);
    EndpointResponse crearEndpoint(EndpointRequest request);
    EndpointResponse actualizarEndpoint(Long endpointId, EndpointRequest request);
    EndpointDetailResponse obtenerEndpoint(Long id);
    EndpointResponse cambiarEstadoEndpoint(Long id, EndpointRequest request);
    void eliminarEndpoint(Long id);
}
