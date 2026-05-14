package pe.edu.idat.apimonitor.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.Date;

@Entity(name = "endpointchecklog")
public class EndpointCheckLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long endpointCheckLogId;
    private Integer codigoEstado;
    private String estado;
    private Double tiempoRespuesta;
    private Date checkedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    private Endpoint endpoint;

}
