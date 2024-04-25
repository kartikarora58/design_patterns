package org.cricbuzz;

import java.util.Random;

public class Util {
    public static int generateRandom(int min,int max)
    {
        // generate random number >=min and <=max
        max = max+1;
        Random random = new Random();
        int randomNumber = random.nextInt(max-min+1) + min;
        return randomNumber;

    }
}
