package ort.edu.futbolTinder.partido.repository;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;
import ort.edu.futbolTinder.partido.entity.Partido;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public class PartidoRepositoryLocalImpl implements PartidoRepository {
    List<Partido> partidos = new ArrayList<>();

    @Override
    public List<Partido> findAll() {
        return partidos;
    }

    @Override
    public List<Partido> findAll(Sort sort) {
        return partidos;
    }

    @Override
    public Page<Partido> findAll(Pageable pageable) {
        return new PageImpl<>(partidos);
    }

    @Override
    public List<Partido> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {
        partidos.removeIf(p -> aLong.equals(p.getId()));
    }

    @Override
    public void delete(Partido entity) {
        partidos.remove(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Partido> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Partido> S save(S entity) {
        partidos.add(entity);
        return entity;
    }

    @Override
    public <S extends Partido> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Partido> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Partido> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Partido> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }


    @Override
    public void deleteAllInBatch(Iterable<Partido> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Partido getOne(Long aLong) {
        return null;
    }

    @Override
    public Partido getById(Long aLong) {
        return null;
    }

    @Override
    public Partido getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Partido> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Partido> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Partido> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Partido> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Partido> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Partido> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Partido, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
