package ort.edu.futbolTinder.partido.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ort.edu.futbolTinder.partido.entity.Partido;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Long> {
}
