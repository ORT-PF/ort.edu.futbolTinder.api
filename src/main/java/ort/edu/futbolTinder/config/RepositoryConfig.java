package ort.edu.futbolTinder.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import ort.edu.futbolTinder.entity.Partido;
import ort.edu.futbolTinder.repository.PartidoRepositoryJsonImpl;
import ort.edu.futbolTinder.repository.PartidoRepositoryLocalImpl;

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
