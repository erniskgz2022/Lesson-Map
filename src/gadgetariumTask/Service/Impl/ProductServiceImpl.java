package gadgetariumTask.Service.Impl;

import gadgetariumTask.Service.ProductService;
import gadgetariumTask.enums.KeyCharacter;
import gadgetariumTask.models.Product;

import java.util.*;

public class ProductServiceImpl implements ProductService {
    Map<Long,Product> products = new HashMap<>();
    @Override
    public void saveProduct(Product product) {
        products.put(product.getId(),product);
    }

    @Override
    public void updateProduct(Long id, Product newProduct) {
        try {
            if (products.containsKey(id)){
                products.put(id,newProduct);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Product getByIdProduct(Long id) {
        return products.get(id);
    }

    @Override
    public List<Product> searchByProductName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product p : products.values()) {
            if (p.getName().toLowerCase().contains(name.toLowerCase())){
                result.add(p);
            }
        }
        return result;
    }

    @Override
    public List<Product> filterByCharacter(KeyCharacter key, String value) {
        List<Product> result = new ArrayList<>();
        for (Product p : products.values()) {
            for (Map<KeyCharacter, String> character : p.getCharacters()) {
                if (character.containsKey(key) && character.get(key).equalsIgnoreCase(value)){
                    result.add(p);
                }
            }
        }
        return result;
    }

    @Override
    public List<Product> sortByCharacter(KeyCharacter key) {
        List<Product> sorted = new ArrayList<>(products.values());
        sorted.sort(Comparator.comparing(p -> p.getCharacters().stream()
                .filter(map -> map.containsKey(key))
                .map(map -> map.get(key))
                .findFirst().orElse("")));

        return sorted;
    }

    @Override
    public void deleteByProduct(Long id) {
        products.remove(id);
    }

    @Override
    public List<Product> getAllProduct() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void deleteCharacterByKeyName(Long id, KeyCharacter key) {
        Product product = products.get(id);
        if (product != null){
            for (Map<KeyCharacter, String> character : product.getCharacters()) {
                character.clear();
            }
        }
    }



    @Override
    public void deleteAllCharacters(Long id) {
        Product product = products.get(id);
        if (product != null){
            for (Map<KeyCharacter, String> character : product.getCharacters()) {
                character.clear();
            }
        }
    }
}
