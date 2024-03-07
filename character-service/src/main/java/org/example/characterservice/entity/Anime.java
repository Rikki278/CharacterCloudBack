package org.example.characterservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "anime_character_list")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Anime {

    @Id
    private String id;
    private String name;
    private String animeTitle;
    private String description;
    private String imageUrl;
    private String userId;
}
