package ort.edu.futbolTinder.partido.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ort.edu.futbolTinder.partido.entity.Partido;

public interface PartidoRepository extends JpaRepository<Partido, Long> {
}
