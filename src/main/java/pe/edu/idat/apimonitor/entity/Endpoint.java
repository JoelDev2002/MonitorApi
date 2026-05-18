package pe.edu.idat.apimonitor.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import pe.edu.idat.apimonitor.enums.EstadoApi;
import java.time.LocalDateTime;


@Entity(name = "endpoint")
public class Endpoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long endpointId;

    private String nombre;
    private String url;
    private String method;
    private EstadoApi estado;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
    private Boolean eliminado;

    @ManyToOne(fetch = FetchType.LAZY)
    private Api api;

    public Endpoint(String nombre, String url, String method, Api api) {

        this.nombre = nombre;
        this.url = url;
        this.method = method;
        this.estado = EstadoApi.ACTIVO;
        this.createdAt = LocalDateTime.now();
        this.updateAt = null;
        this.eliminado = false;
        this.api = api;
    }

    public Endpoint() {
    }

    public Long getEndpointId() {
        return endpointId;
    }

    public void setEndpointId(Long endpointId) {
        this.endpointId = endpointId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public EstadoApi getEstado() {
        return estado;
    }

    public void setEstado(EstadoApi estado) {
        this.estado = estado;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public Boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(Boolean eliminado) {
        this.eliminado = eliminado;
    }

    public Api getApi() {
        return api;
    }

    public void setApi(Api api) {
        this.api = api;
    }
}
