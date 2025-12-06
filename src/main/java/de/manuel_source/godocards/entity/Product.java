package de.manuel_source.godocards.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {
    @Id
    @JsonProperty("articleNumber")
    private String articleNumber;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("image")
    private String image;

    @JsonProperty("type")
    private String type;

    @JsonProperty("category")
    private String category;

    @JsonProperty("price")
    private BigDecimal price;
}
