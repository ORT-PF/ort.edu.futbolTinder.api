package ort.edu.futbolTinder.partido.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ort.edu.futbolTinder.generic.entity.AppEntity;

import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Partido extends AppEntity {

    private Long hostId;
    private String fieldName;
    private String fieldAddress;
    private LocalDateTime dateTime;
    private Integer originalQuota;
    private Integer remainingQuota;
    private List<Long> joinedPlayers;
    private Double longitude;
    private Double latitude;

}
