package de.manuel_source.godocards.control;

import de.manuel_source.godocards.entity.Product;
import de.manuel_source.godocards.entity.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class Controller {

    PokeApiFeign pokeApiFeign;

    @Autowired
    ProductRepository productRepository;

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

    @PostMapping("/product")
    ResponseEntity<Product> add(@RequestBody Product product) {
        productRepository.save(product);
        return new ResponseEntity<>(productRepository.findByArticleNumber("100"), HttpStatus.CREATED);
    }
}
