package ort.edu.futbolTinder.generic.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import ort.edu.futbolTinder.generic.entity.AppEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static ort.edu.futbolTinder.utils.resolvers.SortingResolver.resolveSorting;

@RequiredArgsConstructor
public abstract class CRUDService<DTO, Entity extends AppEntity, RequestDTO> {
    protected final JpaRepository<Entity, Long> repository;
    protected final EntityManager entityManager;
    protected final ModelMapper modelMapper;
    protected final Class<Entity> entityClass;
    protected final Class<DTO> dtoClass;

    public List<DTO> getAll(String sort) {
        return getAllEntities(resolveSorting(sort))
                .stream()
                .map(this::mapToDTO)
                .collect(toList());
    }

    public DTO get(Long id) {
        return mapToDTO(getEntity(id));
    }

    public Long add(RequestDTO requestDTO) throws Exception {
        Entity entity = newEntity();
        return updateAndSaveEntity(requestDTO, entity);
    }

    public List<Long> addAll(List<RequestDTO> requestDTOs) throws Exception {
        List<Long> ids = new ArrayList<>();
        for (RequestDTO requestDTO : requestDTOs) {
            ids.add(this.add(requestDTO));
        }
        return ids;
    }

    public Long update(Long id, RequestDTO requestDTO) {
        Entity entity = getEntity(id);
        return updateAndSaveEntity(requestDTO, entity);
    }

    public Long delete(Long id) {
        repository.deleteById(id);
        return id;
    }

    private List<Entity> getAllEntities(Sort sort) {
        return repository.findAll(sort);
    }

    private Entity getEntity(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Unable to find entity of type "));
    }

    protected DTO mapToDTO(Entity entity) {
        return modelMapper.map(entity, dtoClass);
    }

    private Entity newEntity() throws Exception {
        return entityClass.getDeclaredConstructor().newInstance();
    }

    private Long updateAndSaveEntity(RequestDTO requestDTO, Entity entity) {
        setEntityFieldsFromDTO(requestDTO, entity);
        return repository.save(entity).getId();
    }

    protected abstract void setEntityFieldsFromDTO(RequestDTO requestDTO, Entity entity);

}
