package academy.murilo.springboot2.repository;

import academy.murilo.springboot2.domain.Anime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@DisplayName("Tests for Anime Repository")
class AnimeRepositoryTest {

    @Autowired
    private AnimeRepository animeRepository;

    @Test
    void save_PersistAnime_WhenSuccessful() {

    }

    private Anime createAnime() {
        return Anime.builder().name("Hajime no Ippo").build();
    }

}