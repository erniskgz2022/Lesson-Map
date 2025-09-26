package gadgetariumTask;

import gadgetariumTask.Service.Impl.ProductServiceImpl;
import gadgetariumTask.Service.ProductService;
import gadgetariumTask.enums.Category;
import gadgetariumTask.enums.KeyCharacter;
import gadgetariumTask.models.Product;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ProductService productService = new ProductServiceImpl();

        while (true){
            System.out.println("""
                    ~~~~~~~Gadgetarium Menu
                    1 - Add product
                    2 - Get All Product
                    3 - Get Product by ID
                    4 - Update product
                    5 - Search Product by Name
                    6 - Filter by Character
                    7 - Sort by Character
                    8 - Delete product by ID
                    9 - Delete Character by Key
                    10 - Delete All Characters
                    0 = Exit
                    """);

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1 -> {
                    System.out.print("Product name: ");
                    String pName = sc.nextLine();
                    System.out.print("Category (PHONE/LAPTOP/SMARTWATCH): ");
                    Category category = Category.valueOf(sc.nextLine().toUpperCase());
                    System.out.print("Price: ");
                    Double pr = sc.nextDouble();
                    sc.nextLine();

                    List<Map< KeyCharacter, String>> chars = new ArrayList<>();
                    System.out.print("Now many characteristics?: ");
                    int count = sc.nextInt();
                    sc.nextLine();

                    for (int i = 0; i < count; i++){
                        System.out.print("Key (CPU/RAM/STORAGE/COLOR/BATTERY/CAMERA/SCREEN_SIZE): ");
                        String key = sc.nextLine();
                        System.out.print("Value: ");
                        String  value = sc.nextLine();

                        Map<KeyCharacter, String> map = new HashMap<>();
                        map.put(KeyCharacter.valueOf(key),value);
                        chars.add(map);
                    }

                    Product p = new Product(pName,category,chars,pr);
                    productService.saveProduct(p);
                    System.out.println("Product added");
                }
                case 2 -> {
                    System.out.println("All product");
                    System.out.println(productService.getAllProduct());
                }
                case 3 -> {
                    System.out.print("Product ID: ");
                    Long id = sc.nextLong();
                    System.out.println(productService.getByIdProduct(id));
                }
                case 4 -> {
                    System.out.print("Write ID: ");
                    Long pId = sc.nextLong();
                    sc.nextLine();
                    System.out.print("New name: ");
                    String name = sc.nextLine();
                    System.out.print("New Category (PHONE/LAPTOP/SMARTWATCH): ");
                    Category category = Category.valueOf(sc.nextLine().toUpperCase());
                    System.out.print("Price: ");
                    Double pr = sc.nextDouble();
                    Product product = new Product(name,category,pr);
                    productService.updateProduct(pId,product);
                    System.out.println("Success updated!!!");

                }
                case 5 -> {
                    System.out.print("Product Name: ");
                    String pName = sc.nextLine();
                    productService.searchByProductName(pName).forEach(System.out::println);
                }
                case 6 ->{
                    System.out.print("Key (CPU/RAM/STORAGE/COLOR/BATTERY/CAMERA/SCREEN_SIZE): ");
                    String key = sc.nextLine();
                    System.out.print("Value: ");
                    String val = sc.nextLine();
                    productService.filterByCharacter(KeyCharacter.valueOf(key),val).forEach(System.out::println);
                }
                case 7 ->{
                    System.out.print("Key for sorting (CPU/RAM/STORAGE/COLOR/BATTERY/CAMERA/SCREEN_SIZE): ");
                    String key = sc.nextLine();
                    productService.sortByCharacter(KeyCharacter.valueOf(key)).forEach(System.out::println);
                }
                case 8 -> {
                    System.out.print("Product ID");
                    Long id = sc.nextLong();
                    productService.deleteByProduct(id);
                    System.out.println("Deleted!!!!!");
                }
                case 9 -> {
                    System.out.print("Product ID: ");
                    Long id = sc.nextLong();
                    sc.nextLine();
                    System.out.print("Key to delete: ");
                    String key = sc.nextLine().toUpperCase();
                    productService.deleteCharacterByKeyName(id,KeyCharacter.valueOf(key));
                    System.out.println("Character deleted!!!!!!!!!");
                }
                case 10 -> {
                    System.out.print("Product ID: ");
                    Long id = sc.nextLong();
                    productService.deleteAllCharacters(id);
                    System.out.println("All characters deleted!!!!!");
                }
                case 0 -> {
                    System.out.println("Exiting");
                    System.exit(0);
                }
                default -> System.out.println("Wrong choice!!!!!!!!!!");
            }
        }
    }
}
