package ort.edu.futbolTinder.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchDTO {
    private Long id;
    private Long hostId;
    private String fieldName;
    private String fieldAddress;
    private LocalDateTime dateTime;
    private Integer originalQuota;
    private Integer remainingQuota;
    private List<MatchPlayerDTO> matchPlayers;
    private Double longitude;
    private Double latitude;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MatchPlayerDTO{
        private Long playerId;
    }

    public Integer calculateRemainingQuota(){
        return originalQuota - matchPlayers.size();
    }
}
