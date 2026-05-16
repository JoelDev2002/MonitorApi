package pe.edu.idat.apimonitor.services.impl;

import org.springframework.stereotype.Service;
import pe.edu.idat.apimonitor.dto.api.ApiRequest;
import pe.edu.idat.apimonitor.dto.api.ApiResponse;
import pe.edu.idat.apimonitor.entity.Api;
import pe.edu.idat.apimonitor.enums.EstadoApi;
import pe.edu.idat.apimonitor.repository.ApiRepository;
import pe.edu.idat.apimonitor.services.ApiService;

import java.time.LocalDateTime;

import java.util.List;

@Service
public class ApiServiceImpl implements ApiService {

    private final ApiRepository repository;

    public ApiServiceImpl(ApiRepository repository) {
        this.repository = repository;
    }

    @Override
    public ApiResponse obtenerApi(Long apiId) {
        Api apiEncontrado = repository.findById(apiId)
                .orElseThrow(() -> new RuntimeException("api no se encontro"));

        if (apiEncontrado.getEliminado()) throw new RuntimeException("api eliminada");

        return new ApiResponse(
                apiEncontrado.getApiId(),
                apiEncontrado.getNombre(),
                apiEncontrado.getBaseUrl(),
                apiEncontrado.getEstado(),
                apiEncontrado.getCreatedAt(),
                apiEncontrado.getUpdateAt()
        );
    }

    @Override
    public ApiResponse crearApi(ApiRequest request) {
        Api apiEntity = new Api(
                request.nombre(),
                request.baseUrl(),
                EstadoApi.ACTIVO,
                LocalDateTime.now(),
                null,
                false
        );
        Api apiSave = repository.save(apiEntity);

        return new ApiResponse(
                apiSave.getApiId(),
                apiSave.getNombre(),
                apiSave.getBaseUrl(),
                apiSave.getEstado(),
                apiSave.getCreatedAt(),
                apiSave.getUpdateAt()
        );
    }

    @Override
    public List<ApiResponse> listarAPis() {
        return repository.findByEliminadoFalse()
                .stream()
                .map(apiEntity-> new ApiResponse(
                        apiEntity.getApiId(),
                        apiEntity.getNombre(),
                        apiEntity.getBaseUrl(),
                        apiEntity.getEstado(),
                        apiEntity.getCreatedAt(),
                        apiEntity.getUpdateAt()
                ))
                .toList();

    }

    @Override
    public ApiResponse actualizarApi(Long id, ApiRequest request) {
        Api apiEncontrado=repository.findById(id)
                .orElseThrow(()-> new RuntimeException("no se encontro la api"));

        apiEncontrado.setNombre(request.nombre());
        apiEncontrado.setBaseUrl(request.baseUrl());
        apiEncontrado.setUpdateAt(LocalDateTime.now());

        Api apiSave =repository.save(apiEncontrado);
        return new ApiResponse(
                apiSave.getApiId(),
                apiSave.getNombre(),
                apiSave.getBaseUrl(),
                apiSave.getEstado(),
                apiSave.getCreatedAt(),
                apiSave.getUpdateAt()
        );
    }

    @Override
    public ApiResponse cambiarEstadoApi(Long id) {
        Api api=repository.findById(id)
                .orElseThrow(()-> new RuntimeException("no existe la api"));
        api.setEstado(
                api.getEstado() == EstadoApi.ACTIVO
                        ?EstadoApi.INACTIVO
                        :EstadoApi.ACTIVO
        );
        Api apiSave =repository.save(api);

        return new ApiResponse(
                apiSave.getApiId(),
                apiSave.getNombre(),
                apiSave.getBaseUrl(),
                apiSave.getEstado(),
                apiSave.getCreatedAt(),
                apiSave.getUpdateAt()
        );
    }

    @Override
    public void eliminarApi(Long id) {
        Api api=repository.findById(id)
                .orElseThrow(()-> new RuntimeException("no existe la api"));
        api.setEliminado(true);

        repository.save(api);
    }
}
