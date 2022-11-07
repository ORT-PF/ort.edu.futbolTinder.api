package ort.edu.futbolTinder.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.*;

import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;


import ort.edu.futbolTinder.entity.Match;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
@Qualifier("local")
public class MatchRepositoryLocalImpl implements MatchRepository {


    ArrayList<Match> matches = new ArrayList<>();

    @Override
    public ArrayList<Match> findAll() {
        return matches;
    }


    @Override
    public List<Match> findAll(Sort sort) {
        return matches;
    }

    @Override
    public Page<Match> findAll(Pageable pageable) {
        return null;
    }


    @Override
    public List<Match> findAllById(Iterable<Long> longs) {
        List<Match> matchesById = new ArrayList<>();
        for (Match match : matches) {
            for (Long id : longs) {
                if(match.getId().equals(id)) {
                    matchesById.add(match);
                }
            }
        }
        return matchesById;
    }

    @Override
    public long count() {
        return matches.size();
    }

    @Override
    public void deleteById(Long id) {
        for (Match match : matches) {
            if(match.getId().equals(id)){
                matches.remove(match);
            }
        }

    }

    @Override
    public void delete(Match entity) {
        matches.remove(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        for (Match match : matches) {
            for (Long id : longs) {
                if(match.getId().equals(id)) {
                    matches.remove(match);
                }
            }
        }
    }

    @Override
    public void deleteAll(Iterable<? extends Match> entities) {
        for (Match match : entities) {
            matches.remove(match);
        }
    }

    @Override
    public void deleteAll() {
        matches.clear();
    }


    // VER ESTE METODO
    @Override
    public <S extends Match> S save(S entity) {
        if (matches.add(entity)) {
            return entity;
        }
        return null;
    }


    // VER ESTE METODO
    @Override
    public <S extends Match> List<S> saveAll(Iterable<S> entities) {
        List<S> agregados = new ArrayList<S>();
        for (S s : entities) {
            if (matches.add(s)) {
                agregados.add(s);
            }
        }
        return agregados;
    }


    // Y ESTE
    @Override
    public Optional<Match> findById(Long aLong) {
        Optional<Match> foundMatch = Optional.empty();
        for (Match match : matches) {
            if (match.getId().equals(aLong)) {
                foundMatch = Optional.of(match);
            }
        }
        return foundMatch;
    }

    @Override
    public boolean existsById(Long aLong) {
        boolean existe = false;

        for (Match match : matches) {
            if (match.getId().equals(aLong)) {
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
    public <S extends Match> S saveAndFlush(S entity) {
        return entity;
    }

    // VER ESTE METODO
    @Override
    public <S extends Match> List<S> saveAllAndFlush(Iterable<S> entities) {
        return (List<S>) entities;
    }


    // VER ESTE METODO
    @Override
    public void deleteAllInBatch(Iterable<Match> entities) {

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
    public Match getOne(Long aLong) {
        int indice = Math.toIntExact(aLong);
        return matches.get(indice);
    }


    @Override
    public Match getById(Long aLong) {
        for (Match match : matches) {
            if (match.getId().equals(aLong)) {
                return match;
            }
        }
        return null;
    }

    // VER ESTE METODO
    @Override
    public Match getReferenceById(Long aLong) {


        return null;
    }


    @Override
    public <S extends Match> Optional<S> findOne(Example<S> example) {
        Optional<S> matches = Optional.empty();
        for (Match match : this.matches) {
            if (match.equals(example)) {
                matches = Optional.of((S) match);
            }
        }
        return matches;
    }



    // PREGUNTAR QUE HACE ESTE METODO
    @Override
    public <S extends Match> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Match> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }


    @Override
    public <S extends Match> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Match> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Match> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Match, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public List<Match> findAllByDateTimeBetween(LocalDateTime from, LocalDateTime to) {
        return matches;
    }
}
