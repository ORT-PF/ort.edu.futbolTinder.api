package ort.edu.futbolTinder.partido.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ort.edu.futbolTinder.generic.service.CRUDService;
import ort.edu.futbolTinder.partido.dto.request.PartidoRequestDTO;
import ort.edu.futbolTinder.partido.dto.response.PartidoDTO;
import ort.edu.futbolTinder.partido.entity.Partido;
import ort.edu.futbolTinder.partido.repository.PartidoRepository;

import javax.persistence.EntityManager;

import static ort.edu.futbolTinder.utils.mapping.MapperUtils.setIfNotNull;

@Service
public class PartidoService extends CRUDService<PartidoDTO, Partido, PartidoRequestDTO> {
    public PartidoService(@Qualifier("local") PartidoRepository repository, EntityManager entityManager, ModelMapper modelMapper) {
        super(repository, entityManager, modelMapper, Partido.class, PartidoDTO.class);
    }

    @Override
    protected void setEntityFieldsFromDTO(PartidoRequestDTO partidoRequestDTO, Partido partido) {
        setIfNotNull(partidoRequestDTO.getCancha(), partido::setCancha);
    }
}
