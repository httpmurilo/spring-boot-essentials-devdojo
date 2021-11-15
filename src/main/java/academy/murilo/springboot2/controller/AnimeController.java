package academy.murilo.springboot2.controller;

import academy.murilo.springboot2.service.AnimeService;
import academy.murilo.springboot2.domain.Anime;
import academy.murilo.springboot2.dto.AnimeDTO;
import academy.murilo.springboot2.dto.AnimeToEditDTO;
import academy.murilo.springboot2.util.DateUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/animes")
@Slf4j
@AllArgsConstructor
public class AnimeController {

    private DateUtil dateUtil;
    private AnimeService animeService;

    @GetMapping
    public ResponseEntity<List<Anime>> listAll() {
        log.info("Date formated {}", dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return new ResponseEntity<>(animeService.listAll(), HttpStatus.OK);
        //return ResponseEntity.ok(animeRepository.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Anime> findById(@PathVariable int id) {
        return ResponseEntity.ok(animeService.findByIdOrThrowBadRequestException(id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        animeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping()
    public ResponseEntity<Void> replace(@RequestBody AnimeToEditDTO anime) {
        animeService.replace(anime);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Anime> save(@RequestBody AnimeDTO anime) {
        return ResponseEntity.ok(animeService.save(anime));
    }
}
