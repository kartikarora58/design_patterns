package hashMap;

public class Client {
    public static void main(String[] args) {
        Cars24HashMap<Integer,String> map = new Cars24HashMap<>();
        map.put(1,"Kartik");
        map.put(1,"Qwerty");
        System.out.println(map.get(1));
        map.delete(2);
        System.out.println(map.get(2));

    }
}
