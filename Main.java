
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        String id = getGUID();
        System.out.println(id);
    }

    public static String getGUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
