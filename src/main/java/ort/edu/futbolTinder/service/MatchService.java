package ort.edu.futbolTinder.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ort.edu.futbolTinder.dto.request.MatchRequestDTO;
import ort.edu.futbolTinder.dto.response.MatchCandidateDTO;
import ort.edu.futbolTinder.dto.response.MatchDTO;
import ort.edu.futbolTinder.entity.Match;
import ort.edu.futbolTinder.entity.MatchPlayer;
import ort.edu.futbolTinder.repository.MatchRepository;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.time.LocalDateTime.now;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static ort.edu.futbolTinder.utils.geography.GeographyUtils.calculateDistance;
import static ort.edu.futbolTinder.utils.mapping.MapperUtils.setIfNotNull;

@Service
public class MatchService extends CRUDService<MatchDTO, Match, MatchRequestDTO> {
    private final MatchRepository matchRepository;

    public MatchService(@Qualifier("jpa") MatchRepository repository, EntityManager entityManager, ModelMapper modelMapper) {
        super(repository, entityManager, modelMapper, Match.class, MatchDTO.class);
        matchRepository = repository;
    }

    @Override
    protected MatchDTO mapToDTO(Match entity) {
        MatchDTO matchDTO = super.mapToDTO(entity);
        matchDTO.setRemainingQuota(matchDTO.calculateRemainingQuota());
        return matchDTO;
    }

    @Override
    protected void setEntityFieldsFromDTO(MatchRequestDTO matchRequestDTO, Match match) {
        setIfNotNull(matchRequestDTO.getHostId(), match::setHostId);
        setIfNotNull(matchRequestDTO.getFieldName(), match::setFieldName);
        setIfNotNull(matchRequestDTO.getFieldAddress(), match::setFieldAddress);
        setIfNotNull(matchRequestDTO.getDateTime(), match::setDateTime);
        setIfNotNull(matchRequestDTO.getOriginalQuota(), match::setOriginalQuota);
        setIfNotNull(matchRequestDTO.getLongitude(), match::setLongitude);
        setIfNotNull(matchRequestDTO.getLatitude(), match::setLatitude);
    }

    public List<MatchCandidateDTO> matchCandidates(double latitude, double longitude, Long playerId, double distance, int days) {
        LocalDateTime from = now();
        LocalDateTime to = from.plusDays(days);
        return matchRepository.findAllByDateTimeBetween(from, to)
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

    private static Predicate<Match> notJoined(Long playerId) {
        return m -> !m.getMatchPlayers().stream()
                .map(MatchPlayer::getPlayerId)
                .collect(toList()).contains(playerId);
    }

    private MatchCandidateDTO mapToMatchCandidateDTO(double latitude, double longitude, Match m) {
        MatchCandidateDTO mcDTO = modelMapper.map(m, MatchCandidateDTO.class);
        mcDTO.setRemainingQuota(m.calculateRemainingQuota());
        mcDTO.setDistance(calculateDistance(latitude, longitude, m.getLatitude(), m.getLongitude()));
        return mcDTO;
    }

    public boolean exists(Long matchId) {
        return repository.existsById(matchId);
    }

    public boolean alreadyJoinedOrHost(Long playerId, Long matchId) {
        Optional<Match> match = repository.findById(matchId);
        return match
                .map(containsPlayer(playerId))
                .orElse(false)
                || match
                .map(isHost(playerId))
                .orElse(false);
    }

    public boolean hasRemainingQuota(Long matchId) {
        return repository.findById(matchId)
                .map(matchHasRemainingQuota())
                .orElse(false);
    }

    private static Predicate<Match> hasRemainingQuota() {
        return m -> m.calculateRemainingQuota() > 0;
    }

    private static Function<Match, Boolean> isHost(Long playerId) {
        return m -> playerId.equals(m.getHostId());
    }

    private static Function<Match, Boolean> containsPlayer(Long playerId) {
        return m -> m.getMatchPlayers().stream()
                .map(MatchPlayer::getPlayerId)
                .collect(toList()).contains(playerId);
    }

    private static Function<Match, Boolean> matchHasRemainingQuota() {
        return m -> m.calculateRemainingQuota() > 0;
    }
}
