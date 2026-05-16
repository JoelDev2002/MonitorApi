package pe.edu.idat.apimonitor.services;

import pe.edu.idat.apimonitor.dto.api.ApiRequest;
import pe.edu.idat.apimonitor.dto.api.ApiResponse;

import java.util.List;

public interface ApiService {
    ApiResponse obtenerApi(Long apiId);
    ApiResponse crearApi(ApiRequest request);
    List<ApiResponse> listarAPis();
    ApiResponse actualizarApi(Long id, ApiRequest request);
    ApiResponse cambiarEstadoApi(Long id);
    void eliminarApi(Long id);
}
