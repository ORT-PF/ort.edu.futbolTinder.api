package ort.edu.futbolTinder.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ort.edu.futbolTinder.entity.Partido;

@Repository
@Qualifier("jpa")
public interface PartidoRepository extends JpaRepository<Partido, Long> {
}
