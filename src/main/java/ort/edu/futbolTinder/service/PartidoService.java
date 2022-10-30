package ort.edu.futbolTinder.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ort.edu.futbolTinder.dto.response.PartidoDTO;
import ort.edu.futbolTinder.dto.request.PartidoRequestDTO;
import ort.edu.futbolTinder.entity.Partido;

import javax.persistence.EntityManager;
import java.util.List;

import static java.util.Collections.emptyList;
import static ort.edu.futbolTinder.utils.mapping.MapperUtils.setIfNotNull;

@Service
public class PartidoService extends CRUDService<PartidoDTO, Partido, PartidoRequestDTO> {
    public PartidoService(@Qualifier("local") JpaRepository<Partido,Long> repository, EntityManager entityManager, ModelMapper modelMapper) {
        super(repository, entityManager, modelMapper, Partido.class, PartidoDTO.class);
    }

    @Override
    protected void setEntityFieldsFromDTO(PartidoRequestDTO partidoRequestDTO, Partido partido) {
        setIfNotNull(partidoRequestDTO.getHostId(), partido::setHostId);
        setIfNotNull(partidoRequestDTO.getFieldName(), partido::setFieldAddress);
        setIfNotNull(partidoRequestDTO.getDateTime(), partido::setDateTime);
        setIfNotNull(partidoRequestDTO.getOriginalQuota(), partido::setOriginalQuota);
        setIfNotNull(partidoRequestDTO.getOriginalQuota(), partido::setRemainingQuota);
        setIfNotNull(partidoRequestDTO.getLongitude(), partido::setLongitude);
        setIfNotNull(partidoRequestDTO.getLatitude(), partido::setLatitude);
        partido.setJoinedPlayers(emptyList());

    }

    public List<PartidoDTO> findMatchCandidates(double longitude, double latitude) {
        return super.getAll(null);
    }
}
