package academy.murilo.springboot2.mapper;

import academy.murilo.springboot2.domain.Anime;
import academy.murilo.springboot2.dto.AnimeDTO;
import academy.murilo.springboot2.dto.AnimeToEditDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class AnimeMapper {
    public static final AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);
    public abstract Anime toAnime(AnimeDTO animeDTO);
    public abstract Anime toAnime(AnimeToEditDTO animeDTO);
}
