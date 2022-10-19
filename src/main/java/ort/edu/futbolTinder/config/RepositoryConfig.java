package ort.edu.futbolTinder.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ort.edu.futbolTinder.partido.repository.PartidoRepository;
import ort.edu.futbolTinder.partido.repository.PartidoRepositoryLocalImpl;

@Configuration
public class RepositoryConfig {
    @Bean
    PartidoRepository partidoRepository() {
        return new PartidoRepositoryLocalImpl();
    }
}
