package ort.edu.futbolTinder.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import ort.edu.futbolTinder.partido.entity.Partido;
import ort.edu.futbolTinder.partido.repository.PartidoRepositoryJsonImpl;
import ort.edu.futbolTinder.partido.repository.PartidoRepositoryLocalImpl;

@Configuration
public class RepositoryConfig {
    @Bean("local")
    JpaRepository<Partido, Long> partidoLocalRepository() {
        return new PartidoRepositoryLocalImpl();
    }

    @Bean("json")
    JpaRepository<Partido, Long> partidoJsonRepository() {
        return new PartidoRepositoryJsonImpl();
    }
}
