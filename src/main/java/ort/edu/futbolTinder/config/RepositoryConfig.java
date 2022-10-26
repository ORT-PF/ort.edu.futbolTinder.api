package ort.edu.futbolTinder.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import ort.edu.futbolTinder.partido.entity.Partido;
import ort.edu.futbolTinder.partido.repository.PartidoRepository;
import ort.edu.futbolTinder.partido.repository.PartidoRepositoryJsonImpl;
import ort.edu.futbolTinder.partido.repository.PartidoRepositoryLocalImpl;

import javax.persistence.EntityManager;

@Configuration
@RequiredArgsConstructor
public class RepositoryConfig {
    EntityManager entityManager;

    @Bean("local")
    PartidoRepository partidoLocalRepository() {
        return new PartidoRepositoryLocalImpl();
    }

    @Bean("json")
    PartidoRepository partidoJsonRepository() {
        return new PartidoRepositoryJsonImpl();
    }

    @Bean("db")
    JpaRepository<Partido, Long> partidoDBRepository() {
        return new SimpleJpaRepository<>(Partido.class, entityManager);
    }
}
