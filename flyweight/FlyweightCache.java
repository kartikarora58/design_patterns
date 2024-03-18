package flyweight;

import java.util.HashMap;
import java.util.Map;

public class FlyweightCache {

    public static Map<String,Robot> roboCache = new HashMap<>();
    public static Robot getRobot(String type)
    {
        if(roboCache.containsKey(type))
            return roboCache.get(type);
        Robot robot = null;
        if(type.equals("human"))
        {
            // all humans will have same sprite but they are different from computer sprite
            Sprite humanSprite = new Sprite();
            robot =  new HumanRobot(humanSprite,5,"human");
        }
        else if(type.equals("computer"))
        {
            Sprite computerSprite = new Sprite();
            robot = new Computer(computerSprite,4,"computer");
        }
        roboCache.put(type,robot);
        return robot;

    }
}
