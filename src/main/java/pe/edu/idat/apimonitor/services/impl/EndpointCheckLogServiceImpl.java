package pe.edu.idat.apimonitor.services.impl;

import org.springframework.stereotype.Service;
import pe.edu.idat.apimonitor.dto.checklog.CheckLogResponse;
import pe.edu.idat.apimonitor.services.EndpointCheckLogService;

import java.util.List;

@Service
public class EndpointCheckLogServiceImpl implements EndpointCheckLogService {
    @Override
    public List<CheckLogResponse> listarCheckLog() {
        return List.of();
    }
}
