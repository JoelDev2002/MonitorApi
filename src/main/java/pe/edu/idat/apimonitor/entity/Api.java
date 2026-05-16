package pe.edu.idat.apimonitor.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import pe.edu.idat.apimonitor.enums.EstadoApi;

import java.time.LocalDateTime;


@Entity(name = "api")
public class Api {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long apiId ;

    private String nombre;
    private String baseUrl;
    private EstadoApi estado;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
    private Boolean eliminado=false;

    public Api() {
    }

    public Api(String nombre, String baseUrl, EstadoApi estado, LocalDateTime createdAt, LocalDateTime updateAt, Boolean eliminado) {
        this.nombre = nombre;
        this.baseUrl = baseUrl;
        this.estado = estado;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
        this.eliminado = eliminado;
    }

    public Long getApiId() {
        return apiId;
    }

    public void setApiId(Long apiId) {
        this.apiId = apiId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public EstadoApi getEstado() {
        return estado;
    }

    public void setEstado(EstadoApi estado) {
        this.estado = estado;
    }

    public Boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(Boolean eliminado) {
        this.eliminado = eliminado;
    }
}
