package ort.edu.futbolTinder.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.*;

import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;


import ort.edu.futbolTinder.entity.Partido;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
@Qualifier("local")
public class PartidoRepositoryLocalImpl implements PartidoRepository {


    ArrayList<Partido> partidos = new ArrayList<>();

    @Override
    public ArrayList<Partido> findAll() {
        return partidos;
    }


    @Override
    public List<Partido> findAll(Sort sort) {
        return partidos;
    }

    @Override
    public Page<Partido> findAll(Pageable pageable) {
        return null;
    }


    @Override
    public List<Partido> findAllById(Iterable<Long> longs) {
        List<Partido> partidosPorId = new ArrayList<>();
        for (Partido partido : partidos) {
            for (Long id : longs) {
                if(partido.getId().equals(id)) {
                    partidosPorId.add(partido);
                }
            }
        }
        return partidosPorId;
    }

    @Override
    public long count() {
        return partidos.size();
    }

    @Override
    public void deleteById(Long id) {
        for (Partido partido : partidos) {
            if(partido.getId().equals(id)){
                partidos.remove(partido);
            }
        }

    }

    @Override
    public void delete(Partido entity) {
        partidos.remove(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        for (Partido partido : partidos) {
            for (Long id : longs) {
                if(partido.getId().equals(id)) {
                    partidos.remove(partido);
                }
            }
        }
    }

    @Override
    public void deleteAll(Iterable<? extends Partido> entities) {
        for (Partido partido : entities) {
            partidos.remove(partido);
        }
    }

    @Override
    public void deleteAll() {
        partidos.clear();
    }


    // VER ESTE METODO
    @Override
    public <S extends Partido> S save(S entity) {
        if (partidos.add(entity)) {
            return entity;
        }
        return null;
    }


    // VER ESTE METODO
    @Override
    public <S extends Partido> List<S> saveAll(Iterable<S> entities) {
        List<S> añadidos = new ArrayList<S>();
        for (S s : entities) {
            if (partidos.add(s)) {
                añadidos.add(s);
            }
        }
        return añadidos;
    }


    // Y ESTE
    @Override
    public Optional<Partido> findById(Long aLong) {
        Optional<Partido> partidoDevuelto = Optional.empty();
        for (Partido partido : partidos) {
            if (partido.getId().equals(aLong)) {
                partidoDevuelto = Optional.of(partido);
            }
        }
        return partidoDevuelto;
    }

    @Override
    public boolean existsById(Long aLong) {
        boolean existe = false;

        for (Partido partido : partidos) {
            if (partido.getId().equals(aLong)) {
                existe = true;
            }
        }
        return existe;
    }


    // VER ESTE METODO
    @Override
    public void flush() {

    }


    // VER ESTE METODO
    @Override
    public <S extends Partido> S saveAndFlush(S entity) {
        return entity;
    }

    // VER ESTE METODO
    @Override
    public <S extends Partido> List<S> saveAllAndFlush(Iterable<S> entities) {
        return (List<S>) entities;
    }


    // VER ESTE METODO
    @Override
    public void deleteAllInBatch(Iterable<Partido> entities) {

    }



    // VER ESTE METODO
    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    // VER ESTE METODO
    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Partido getOne(Long aLong) {
        int indice = Math.toIntExact(aLong);
        return partidos.get(indice);
    }


    @Override
    public Partido getById(Long aLong) {
        for (Partido partido : partidos) {
            if (partido.getId().equals(aLong)) {
                return partido;
            }
        }
        return null;
    }

    // VER ESTE METODO
    @Override
    public Partido getReferenceById(Long aLong) {


        return null;
    }


    @Override
    public <S extends Partido> Optional<S> findOne(Example<S> example) {
        Optional<S> partido = Optional.empty();
        for (Partido partido2 : partidos) {
            if (partido2.equals(example)) {
                partido = Optional.of((S)partido2);
            }
        }
        return partido;
    }



    // PREGUNTAR QUE HACE ESTE METODO
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
