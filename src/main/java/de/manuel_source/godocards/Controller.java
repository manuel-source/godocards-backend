package de.manuel_source.godocards;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class Controller {

    PokeApiFeign pokeApiFeign;

    public Controller(PokeApiFeign pokeApiFeign) {
        this.pokeApiFeign = pokeApiFeign;
    }

    @GetMapping(value = "/pokemon/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> getPokemon(@PathVariable String id) {
        String pokemon = pokeApiFeign.getPokemon(id);
        return ResponseEntity
                .ok()
                .body(pokemon);
    }
}
