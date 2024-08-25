package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class KeyProviderFactory {

    private String characterBase = "ABC";
    private Random random = new Random();

    private int stringKeyLength = 4;

    private int maxNumberForNumberKey = 9;

    public RandomKeyProvider getKeyProvider(String type) {
        if (type.equals("String")) {
            return new RandomStringProvider(characterBase, random, stringKeyLength);
        } else if (type.equals("Number")) {
            return new RandomNumberProvider(random, maxNumberForNumberKey);
        } else {
            throw new IllegalArgumentException("Invalid key provider type");
        }
    }
}
