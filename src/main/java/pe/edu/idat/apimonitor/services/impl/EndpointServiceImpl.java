package pe.edu.idat.apimonitor.services.impl;

import org.aspectj.apache.bcel.Repository;
import org.springframework.stereotype.Service;
import pe.edu.idat.apimonitor.dto.endpoint.EndpointDetailResponse;
import pe.edu.idat.apimonitor.dto.endpoint.EndpointRequest;
import pe.edu.idat.apimonitor.dto.endpoint.EndpointResponse;
import pe.edu.idat.apimonitor.entity.Api;
import pe.edu.idat.apimonitor.entity.Endpoint;
import pe.edu.idat.apimonitor.enums.EstadoApi;
import pe.edu.idat.apimonitor.repository.ApiRepository;
import pe.edu.idat.apimonitor.repository.EndpointRepository;
import pe.edu.idat.apimonitor.services.EndpointService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EndpointServiceImpl implements EndpointService {

    private final EndpointRepository repository;
    private final ApiRepository apiRepository;

    public EndpointServiceImpl(EndpointRepository repository, ApiRepository apiRepository) {
        this.repository = repository;
        this.apiRepository = apiRepository;
    }

    @Override
    public List<EndpointResponse> listarEndpointPorApi(Long apiId) {
        return repository.findByEliminadoFalse()
                .stream()
                .map(endpoint -> new EndpointResponse(
                        endpoint.getEndpointId(),
                        endpoint.getNombre(),
                        endpoint.getUrl(),
                        endpoint.getMethod(),
                        endpoint.getEstado()
                )).toList();
    }

    @Override
    public EndpointResponse crearEndpoint(EndpointRequest request) {
        Api api= apiRepository.findById(request.apiId())
                .orElseThrow(()-> new RuntimeException("no existe la api"));

        Endpoint newEndpoint =new Endpoint(
            request.nombre(),request.url(),request.method(),api
        );

        Endpoint endpointSave=repository.save(newEndpoint);

        return new EndpointResponse(
                endpointSave.getEndpointId(),
                endpointSave.getNombre(),
                endpointSave.getUrl(),
                endpointSave.getMethod(),
                endpointSave.getEstado()
        );
    }

    @Override
    public EndpointResponse actualizarEndpoint(Long endpointId,EndpointRequest request) {
        Endpoint endpoint=repository.findById(endpointId)
                .orElseThrow(()-> new RuntimeException("endpoint no encontrado"));
        if (endpoint.getEliminado() || endpoint.getEstado()== EstadoApi.INACTIVO) throw new RuntimeException("endpoint no se puede usar");

        endpoint.setNombre(request.nombre());
        endpoint.setNombre(request.url());
        endpoint.setNombre(request.method());
        endpoint.setNombre(request.nombre());

        Endpoint updateEnpoint =repository.save(endpoint);


        return new EndpointResponse(
                updateEnpoint.getEndpointId(),
                updateEnpoint.getNombre(),
                updateEnpoint.getUrl(),
                updateEnpoint.getMethod(),
                updateEnpoint.getEstado()
        );
    }

    @Override
    public EndpointDetailResponse obtenerEndpoint(Long id) {
        Endpoint endpoint=repository.findById(id)
                .orElseThrow(()-> new RuntimeException("endpoint no encontrado"));
        if(endpoint.getEliminado()) throw new RuntimeException("el endpoint esta eliminado ");

        return new EndpointDetailResponse(
                endpoint.getEndpointId(),
                endpoint.getNombre(),
                endpoint.getUrl(),
                endpoint.getMethod(),
                endpoint.getEstado(),
                endpoint.getCreatedAt(),
                endpoint.getUpdateAt(),
                endpoint.getApi().getNombre()
        );
    }
    @Override
    public EndpointResponse cambiarEstadoEndpoint(Long id, EndpointRequest request){
        Endpoint endpoint=repository.findById(id)
                .orElseThrow(()->new RuntimeException("no se encontro el endpoint"));
        if (endpoint.getEliminado()) throw new RuntimeException("el endpoint esta eliminado");

        endpoint.setEstado(
                (endpoint.getEstado()== EstadoApi.ACTIVO)
                ? EstadoApi.INACTIVO
                : EstadoApi.ACTIVO
        );
        Endpoint endpointSave= repository.save(endpoint);

        return new EndpointResponse(
                endpointSave.getEndpointId(),
                endpointSave.getNombre(),
                endpointSave.getUrl(),
                endpointSave.getMethod(),
                endpointSave.getEstado()
            );
    }

    @Override
    public void eliminarEndpoint(Long id) {
        Endpoint endpoint=repository.findById(id)
                .orElseThrow(()->new RuntimeException("no se encontro el endpoint"));
        if (endpoint.getEliminado()) throw new RuntimeException("el endpoint ya fue eliminado");

        endpoint.setEliminado(true);
        repository.save(endpoint);
    }
}
