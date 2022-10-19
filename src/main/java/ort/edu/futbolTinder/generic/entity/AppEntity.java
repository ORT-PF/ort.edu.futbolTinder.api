package ort.edu.futbolTinder.generic.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public abstract class AppEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    protected Long id;
}
