package academy.murilo.springboot2.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class AnimeDTO {

    @NotEmpty(message = "the anime name cannot be empty")
    private String name;
}
