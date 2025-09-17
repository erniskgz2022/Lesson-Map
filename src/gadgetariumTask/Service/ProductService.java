package gadgetariumTask.Service;

import gadgetariumTask.enums.KeyCharacter;
import gadgetariumTask.models.Product;

import java.util.List;

public interface ProductService {
    void saveProduct( Product product);
    void updateProduct(Long id, Product newProduct);
    Product getByIdProduct(Long id);
    List <Product> searchByProductName(String name);
    List <Product> filterByCharacter(KeyCharacter key, String value);
    List <Product> sortByCharacter(KeyCharacter key);
    void  deleteByProduct(Long id);
    List<Product> getAllProduct();
    void deleteCharacterByKeyName(Long id, KeyCharacter key);
    void deleteAllCharacters(Long id);
}
