package org.example;

import java.util.Random;

public class RandomNumberProvider implements RandomKeyProvider{

    private Random random;
    private Integer maxNumber;

    public RandomNumberProvider(Random random, Integer maxNumber) {
        this.random = random;
        this.maxNumber = maxNumber;
    }

    @Override
    public String generateRandomKey() {
        return Integer.toString(new Random().nextInt(maxNumber));
    }
}
