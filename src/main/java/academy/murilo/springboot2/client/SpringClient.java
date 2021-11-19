package academy.murilo.springboot2.client;

import academy.murilo.springboot2.domain.Anime;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Log4j2
public class SpringClient {
    public static void main(String[] args) {
        ResponseEntity<Anime> entity = new RestTemplate().getForEntity("http://localhost:8080/animes/10", Anime.class);
        log.info(entity);

        Anime object = new RestTemplate().getForObject("http://localhost:8080/animes/10", Anime.class);
        //retorna diretamente um objeto
        log.info(object);

        Anime samuraiChampoo = Anime.builder().name("samurai").build();
        ResponseEntity<List<Anime>> samuraiChampooSaved = new RestTemplate().exchange("http://localhost:8080/animes", HttpMethod.POST, new HttpEntity<>(samuraiChampoo,createJsonHeader()), new ParameterizedTypeReference<>() {
        });
        log.info(samuraiChampooSaved.getBody());

        Anime kindgom = Anime.builder().name("kingdom").build();

    }

    private static HttpHeaders createJsonHeader() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return httpHeaders;
    }
}
