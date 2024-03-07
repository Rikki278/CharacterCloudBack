package org.example.characterservice.controller;

import org.example.characterservice.entity.Anime;
import org.example.characterservice.service.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/anime")
public class AnimeController {

    private final AnimeService animeService;

    @Autowired
    public AnimeController(AnimeService animeService) {
        this.animeService = animeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Anime>> getAllAnime() {
        List<Anime> anime = animeService.findAllAnime();
        return new ResponseEntity<>(anime, HttpStatus.OK);
    }


    //ПОШУК АНІМЕ ПО АЙДІ ЮЗЕРА
    @GetMapping("/user/{id}/anime-title")
    public ResponseEntity<List<Anime>> getAnimeByUserAccount(@PathVariable String id) {
        List<Anime> userAnime = animeService.findAnimeByUserId(id);
        return ResponseEntity.ok(userAnime);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Anime> getAnimeById(@PathVariable("id") String id) {
        Anime anime = animeService.findAnimeById(id);
        return new ResponseEntity<>(anime, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Anime> addAnime(@RequestBody Anime anime) {
        Anime newAnime = animeService.addAnime(anime);
        return new ResponseEntity<>(newAnime, HttpStatus.CREATED);
    }

//    @PutMapping("/update")
//    public ResponseEntity<Anime> updateAnime(@RequestBody Anime anime) {
//        Anime updateAnime = animeService.updateAnime(anime);
//        return new ResponseEntity<>(updateAnime, HttpStatus.CREATED);
//    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Anime> updateAnimeById(@PathVariable("id") String id, @RequestBody Anime anime) {
        Anime updateAnimeById = animeService.updateAnimeById(id, anime);
        return new ResponseEntity<>(updateAnimeById, HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAnime(@PathVariable("id") String id) {
        animeService.deleteAnime(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
