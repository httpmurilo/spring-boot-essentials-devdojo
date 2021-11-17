package academy.murilo.springboot2.service;

import academy.murilo.springboot2.domain.Anime;
import academy.murilo.springboot2.dto.AnimeDTO;
import academy.murilo.springboot2.dto.AnimeToEditDTO;
import academy.murilo.springboot2.exception.BadRequestException;
import academy.murilo.springboot2.mapper.AnimeMapper;
import academy.murilo.springboot2.repository.AnimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AnimeService {

    @Autowired
    private AnimeRepository animeRepository;

    public List<Anime> listAll() {
        return animeRepository.findAll();
    }

    public List<Anime> findByName(String name) {
        return animeRepository.findByName(name);
    }

    public Anime findByIdOrThrowBadRequestException(long id) {
        return animeRepository.findById(id).orElseThrow(() -> new BadRequestException("Anime not found"));
    }

    @Transactional
    public Anime save(AnimeDTO animeDTO) {
        //return animeRepository.save(Anime.builder().name(animeDTO.getName()).build());
        return animeRepository.save(AnimeMapper.INSTANCE.toAnime(animeDTO));
    }

    public void delete(int id) {
        animeRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(AnimeToEditDTO anime) {
        //Anime savedAnime = findByIdOrThrowBadRequestException(anime.getId());
        Anime animeToEdit = AnimeMapper.INSTANCE.toAnime(anime);
        animeRepository.save(animeToEdit);
    }
}
