package ort.edu.futbolTinder.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PARTIDOS")
public class Match extends AppEntity {

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
    @Column(name = "LONGITUDE", nullable = false)
    private Double longitude;
    @Column(name = "LATITUDE", nullable = false)
    private Double latitude;
    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL)
    private List<MatchPlayer> matchPlayers;

    public int calculateRemainingQuota(){
        return originalQuota - matchPlayers.size();
    }
}
