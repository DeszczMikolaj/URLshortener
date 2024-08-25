package org.example;

import java.util.Random;

public class RandomStringProvider implements RandomKeyProvider{

    final String characterBase;
    final Random random;

    final Integer keyLength;

    public RandomStringProvider(String characterBase, Random random, Integer keyLength) {
        this.characterBase = characterBase;
        this.random = random;
        this.keyLength = keyLength;
    }

    public String generateRandomKey() {
        StringBuilder keyBuilder = new StringBuilder();

        for(int i=0; i<keyLength; i++) {
            int randomIndex = random.nextInt(characterBase.length());
            keyBuilder.append(characterBase.charAt(randomIndex));
        }
        return keyBuilder.toString();
    }

}
