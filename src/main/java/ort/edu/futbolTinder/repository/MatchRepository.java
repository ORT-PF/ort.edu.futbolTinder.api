package ort.edu.futbolTinder.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ort.edu.futbolTinder.entity.Partido;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@Qualifier("jpa")
public interface PartidoRepository extends JpaRepository<Partido, Long> {
    List<Partido> findAllByDateTimeBetween(LocalDateTime from, LocalDateTime to);
}
