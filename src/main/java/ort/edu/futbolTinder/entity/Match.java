package ort.edu.futbolTinder.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PARTIDOS")
public class Partido extends AppEntity {

    @Column(name = "HOST_ID", nullable = false)
    private Long hostId;
    @Column(name = "FIELD_NAME", nullable = false)
    private String fieldName;
    @Column(name = "FIELD_ADDRESS", nullable = false)
    private String fieldAddress;
    @Column(name = "DATE_TIME", nullable = false)
    private LocalDateTime dateTime;
    @Column(name = "ORIGINAL_QUOTA", nullable = false)
    private Integer originalQuota;

    private List<JoinedPlayer> joinedPlayers;
    @Column(name = "LONGITUDE", nullable = false)
    private Double longitude;
    @Column(name = "LATITUDE", nullable = false)
    private Double latitude;

}
