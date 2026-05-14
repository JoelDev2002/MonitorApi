package pe.edu.idat.apimonitor.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import pe.edu.idat.apimonitor.enums.EstadoApi;

import java.util.Date;

@Entity(name = "api")
public class Api {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long apiId ;

    private String nombre;
    private String baseUrl;
    private EstadoApi estado;
    private Date createdAt;
    private Date updateAt;
}
