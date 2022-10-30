package ort.edu.futbolTinder.partido.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ort.edu.futbolTinder.generic.entity.AppEntity;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Partido extends AppEntity {
    private String cancha;
}
