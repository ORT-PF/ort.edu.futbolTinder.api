package ort.edu.futbolTinder.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ort.edu.futbolTinder.entity.Match;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@Qualifier("jpa")
public interface MatchRepository extends JpaRepository<Match, Long> {
    List<Match> findAllByDateTimeBetween(LocalDateTime from, LocalDateTime to);
}
