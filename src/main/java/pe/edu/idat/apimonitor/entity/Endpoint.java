package pe.edu.idat.apimonitor.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import pe.edu.idat.apimonitor.enums.EstadoApi;

import java.util.Date;

@Entity(name = "endpoint")
public class Endpoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long endpointId;

    private String nombre;
    private String url;
    private String method;
    private EstadoApi estado;
    private Date createdAt;
    private Date updateAt;

    @ManyToOne(fetch = FetchType.LAZY)
    private Api api;
}
