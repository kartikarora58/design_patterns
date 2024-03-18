package flyweight;

public class Client {
    public static void main(String[] args) {
        for(int i=0;i<100000;i++)
        {
            Robot humanRobot = FlyweightCache.getRobot("human");
            humanRobot.display(i,i);
            System.out.println(humanRobot.hashCode());
        }
        for(int i=0;i<100000;i++)
        {
            Robot computer = FlyweightCache.getRobot("computer");
            computer.display(i,i);
            System.out.println(computer.hashCode());
        }
    }
}
