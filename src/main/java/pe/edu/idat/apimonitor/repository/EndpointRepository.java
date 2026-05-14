package pe.edu.idat.apimonitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.idat.apimonitor.entity.Endpoint;

@Repository
public interface EndpointRepository extends JpaRepository<Endpoint,Long> {
}
