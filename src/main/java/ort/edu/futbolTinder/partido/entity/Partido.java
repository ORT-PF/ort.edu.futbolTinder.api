package ort.edu.futbolTinder.partido.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ort.edu.futbolTinder.generic.entity.AppEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Partido extends AppEntity {
    private String cancha;
}
