package org.example.characterservice.repository;

import org.example.characterservice.entity.Anime;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface AnimeRepo extends MongoRepository<Anime, String> {

    void deleteAnimeById(String id);

    Optional<Anime> findAnimeById(String id);

    List<Anime> findByUserId(String id);

}
