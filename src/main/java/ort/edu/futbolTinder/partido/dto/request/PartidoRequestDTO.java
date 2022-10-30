package ort.edu.futbolTinder.partido.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartidoRequestDTO {

    private Long hostId;
    private String fieldName;
    private String fieldAddress;
    private LocalDateTime dateTime;
    private Integer originalQuota;
    private Double longitude;
    private Double latitude;

}
