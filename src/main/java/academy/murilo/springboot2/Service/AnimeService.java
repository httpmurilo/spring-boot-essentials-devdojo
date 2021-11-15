package academy.murilo.springboot2.Service;

import academy.murilo.springboot2.domain.Anime;
import academy.murilo.springboot2.dto.AnimeDTO;
import academy.murilo.springboot2.repository.AnimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimeService {

    private AnimeRepository animeRepository;
    public List<Anime> listAll() {
        return animeRepository.findAll();
    }

    public Anime findById(long id) {
        return animeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not found"));
    }

    public Anime save(AnimeDTO animeDTO) {
        Anime anime = Anime.builder().name(animeDTO.getName()).build();
        return animeRepository.save(anime);
    }

    public void delete(int id) {
        animeRepository.delete(findById(id));
    }

    public void replace(Anime anime) {
        animeRepository.save(anime);
    }
}
