package rajviryadav.com.library;

import java.util.Random;

public class RandomNumber
{
    public static int generate_random(int min, int max)
    {
        return new Random().nextInt((max - min) + 1) + min;
    }
}
