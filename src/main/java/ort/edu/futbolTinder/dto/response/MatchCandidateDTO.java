package ort.edu.futbolTinder.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchCandidateDTO {
    private Long id;
    private Long hostId;
    private String fieldName;
    private String fieldAddress;
    private LocalDateTime dateTime;
    private Integer remainingQuota;
    private Double longitude;
    private Double latitude;
    private Double distance;
}
