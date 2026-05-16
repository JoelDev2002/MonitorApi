package pe.edu.idat.apimonitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.idat.apimonitor.dto.api.ApiResponse;
import pe.edu.idat.apimonitor.entity.Api;

import java.util.List;

@Repository
public interface ApiRepository extends JpaRepository<Api,Long> {
    List<Api> findByEliminadoFalse();
}
