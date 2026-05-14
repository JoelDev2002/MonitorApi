package pe.edu.idat.apimonitor.dto.checklog;

import java.util.Date;

public record CheckLogResponse(
        Long checkLogId,
        Integer codigoEstado,
        String estado,
        Double tiempoRespuesta,
        Date checkedAt,
        String nombreEndpoint
) {
}
