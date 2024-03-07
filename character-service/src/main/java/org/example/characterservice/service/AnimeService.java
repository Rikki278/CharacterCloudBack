package org.example.characterservice.service;


import org.example.characterservice.entity.Anime;
import org.example.characterservice.exception.EntityNotFoundException;
import org.example.characterservice.exception.UserNotFoundException;
import org.example.characterservice.repository.AnimeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class AnimeService {

    private final AnimeRepo animeRepo;

    @Autowired
    public AnimeService(AnimeRepo animeRepo) {
        this.animeRepo = animeRepo;
    }

    public Anime addAnime(Anime anime) {
        return animeRepo.save(anime);
    }

    public List<Anime> findAllAnime() {
        return animeRepo.findAll();
    }

    //find by user
    public List<Anime> findAnimeByUserId(String id) {
        return animeRepo.findByUserId(id);
    }

    public Anime updateAnime(Anime anime) {
        return animeRepo.save(anime);
    }

    public Anime findAnimeById(String id) {
        return animeRepo.findAnimeById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteAnime(String id) {
        animeRepo.deleteAnimeById(id);
    }


    public Anime updateAnimeById(String id, Anime updatedAnime) {
        System.out.println(updatedAnime);

        Anime existingAnime = animeRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Anime not found with id: " + id));

        System.out.println(existingAnime);

        // Update the existingAnime entity with values from updatedAnime
        //BeanUtils.copyProperties(updatedAnime, existingAnime, "id", "specialCode");

        existingAnime.setName(updatedAnime.getName());
        existingAnime.setDescription(updatedAnime.getDescription());
        existingAnime.setAnimeTitle(updatedAnime.getAnimeTitle());
        existingAnime.setImageUrl(updatedAnime.getImageUrl());


        return animeRepo.save(existingAnime);
    }
}
