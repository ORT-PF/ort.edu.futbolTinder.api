package ort.edu.futbolTinder.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ort.edu.futbolTinder.dto.request.PartidoRequestDTO;
import ort.edu.futbolTinder.dto.response.MatchCandidateDTO;
import ort.edu.futbolTinder.dto.response.PartidoDTO;
import ort.edu.futbolTinder.entity.Partido;
import ort.edu.futbolTinder.repository.PartidoRepository;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Predicate;

import static java.time.LocalDateTime.now;
import static java.util.Collections.emptyList;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static ort.edu.futbolTinder.utils.geography.GeographyUtils.calculateDistance;
import static ort.edu.futbolTinder.utils.mapping.MapperUtils.setIfNotNull;

@Service
public class PartidoService extends CRUDService<PartidoDTO, Partido, PartidoRequestDTO> {
    private final PartidoRepository partidoRepository;

    public PartidoService(@Qualifier("jpa") PartidoRepository repository, EntityManager entityManager, ModelMapper modelMapper) {
        super(repository, entityManager, modelMapper, Partido.class, PartidoDTO.class);
        partidoRepository = repository;
    }

    @Override
    protected PartidoDTO mapToDTO(Partido entity) {
        PartidoDTO partidoDTO = super.mapToDTO(entity);
        partidoDTO.setJoinedPlayers(emptyList());
        partidoDTO.setRemainingQuota(partidoDTO.getOriginalQuota());
        return partidoDTO;
    }

    @Override
    protected void setEntityFieldsFromDTO(PartidoRequestDTO partidoRequestDTO, Partido partido) {
        setIfNotNull(partidoRequestDTO.getHostId(), partido::setHostId);
        setIfNotNull(partidoRequestDTO.getFieldName(), partido::setFieldName);
        setIfNotNull(partidoRequestDTO.getFieldAddress(), partido::setFieldAddress);
        setIfNotNull(partidoRequestDTO.getDateTime(), partido::setDateTime);
        setIfNotNull(partidoRequestDTO.getOriginalQuota(), partido::setOriginalQuota);
        setIfNotNull(partidoRequestDTO.getLongitude(), partido::setLongitude);
        setIfNotNull(partidoRequestDTO.getLatitude(), partido::setLatitude);
    }

    public List<MatchCandidateDTO> matchCandidates(double latitude, double longitude, Long playerId, double distance, int days) {
        LocalDateTime from = now();
        LocalDateTime to = from.plusDays(days);
        return partidoRepository.findAllByDateTimeBetween(from, to)
                .stream()
                .filter(notJoined(playerId))
                .filter(hasRemainingQuota())
                .map(m -> mapToMatchCandidateDTO(latitude, longitude, m))
                .filter(distanceIsLowerThan(distance))
                .sorted(comparing(MatchCandidateDTO::getDistance))
                .collect(toList());
    }

    private static Predicate<MatchCandidateDTO> distanceIsLowerThan(double distance) {
        return m -> m.getDistance() < distance;
    }
    /* Endpoint unirse a partido que guarda a los jugadores que se unieron ->
        Validaciones: Si no quedan cupos(409), tratar de re-unirme (400)
     * filtrar partidos que no queden cupos
     * filtrar partidos a los que ya me uní
     * endpoint de partidos a los que me uní
     * */
    private static Predicate<Partido> notJoined(Long playerId) {
        //Filtrar partidos de los que soy participante
        return m -> true;
    }

    private static Predicate<Partido> hasRemainingQuota() {
        //filtrar partidos con originalQuota-joinedPlayers.size = 0
        return m -> true;
    }

    private MatchCandidateDTO mapToMatchCandidateDTO(double latitude, double longitude, Partido m) {
        MatchCandidateDTO mcDTO = modelMapper.map(m, MatchCandidateDTO.class);
        mcDTO.setRemainingQuota(m.getOriginalQuota());
        mcDTO.setDistance(calculateDistance(latitude, longitude, m.getLatitude(), m.getLongitude()));
        return mcDTO;
    }
}
