package pe.edu.idat.apimonitor.services;

import pe.edu.idat.apimonitor.dto.checklog.CheckLogResponse;

import java.util.List;

public interface EndpointCheckLogService {
    List<CheckLogResponse> listarCheckLog();

}
