package ort.edu.futbolTinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ort.edu.futbolTinder.entity.Partido;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Long> {
}
