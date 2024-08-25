package org.example;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RandomStringProviderTest {

    private RandomKeyProvider randomKeyProvider;
    private Random random = mock(Random.class);

    @Test
    void  shouldReturnStringOfAGivenLength() {
        randomKeyProvider = new RandomStringProvider("qwertyuiopasdfghjklzxcvbnm", random, 4);
        when(random.nextInt(anyInt())).thenReturn(0,1,2,0);
        String randomString = randomKeyProvider.generateRandomKey();

        assertEquals(4, randomString.length());
        assertEquals("qweq", randomString);
    }
}
