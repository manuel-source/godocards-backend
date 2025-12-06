package de.manuel_source.godocards.control;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "pokeapi", url = "https://pokeapi.co/api/v2")
public interface PokeApiFeign {

    @RequestMapping(method = RequestMethod.GET, value = "/pokemon/{id}", produces = "application/json")
    String getPokemon(@PathVariable("id") String id);
}
