package gadgetariumTask.models;

import gadgetariumTask.db.GenerateId;
import gadgetariumTask.enums.Category;
import gadgetariumTask.enums.KeyCharacter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Product {
    private Long id;
    private String name;
    private Category category;
    private List<Map<KeyCharacter,String>> characters;
    private Double price;

    public Product() {
    }

    public Product( String name, Category category,  Double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public Product( String name, Category category, List<Map<KeyCharacter, String>> characters, Double price) {
        this.id = GenerateId.genProductId();
        this.name = name;
        this.category = category;
        this.characters = characters;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Map<KeyCharacter, String>> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Map<KeyCharacter, String>> characters) {
        this.characters = characters;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "========Product=======" + "\n" +
                "ID: " + id + "\n" +
                "Name: " + name + '\n' +
                "Category: " + category + "\n" +
                characters + "\n" +
                "Price: " + price ;
    }
}
