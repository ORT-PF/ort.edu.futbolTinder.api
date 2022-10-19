package ort.edu.futbolTinder.utils.mapping;

import javax.persistence.EntityManager;
import java.util.Optional;
import java.util.function.Consumer;

public class MapperUtils {
    public static <V> void setIfNotNull(V value, Consumer<V> setter) {
        Optional.ofNullable(value)
                .ifPresent(setter);
    }



    public static <V> void setEntityIfNotNull(Long entityId, Consumer<V> setter, Class<V> clazz, EntityManager entityManager) {
        Optional.ofNullable(entityId)
                .map(id -> entityManager.getReference(clazz, id))
                .ifPresent(setter);
    }
}
