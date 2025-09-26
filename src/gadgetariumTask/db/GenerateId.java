package gadgetariumTask.db;

public class GenerateId {
    public static Long productId = 0L;
    public static Long genProductId () {
        return ++productId;
    }
}
