package academy.murilo.springboot2.controller;

import academy.murilo.springboot2.domain.Anime;
import academy.murilo.springboot2.util.DateUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/anime")
@Slf4j
@AllArgsConstructor
public class AnimeController {

    private DateUtil dateUtil;

    @GetMapping("/list")
    public List<Anime> listAll() {
        log.info("Date formated {}", dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return Arrays.asList(new Anime("DBZ"), new Anime("Bersek"));
    }
}
