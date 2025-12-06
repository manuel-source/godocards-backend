package de.manuel_source.godocards.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, String> {

    Product findByArticleNumber(String articleNumber);
}
