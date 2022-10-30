package ort.edu.futbolTinder.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import static java.lang.Boolean.TRUE;

@EqualsAndHashCode(callSuper = true)
@Data
@MappedSuperclass
public abstract class AppEntityWithLogicalDeletion extends AppEntity {
    @Column(name = "ACTIVE", nullable = false)
    protected Boolean active = TRUE;
}
