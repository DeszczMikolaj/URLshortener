package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UrlShortenerProcessorTest {


    @Test
    void shouldReturnConcatenateDomainNameAndGeneratedKey() {
        RandomKeyProvider randomKeyProvider = mock(RandomKeyProvider.class);
        UrlShortenerProcessor urlShortenerProcessor = new UrlShortenerProcessor("https://shortme.com/", randomKeyProvider);

        when(randomKeyProvider.generateRandomKey()).thenReturn("randomKey");
        String longUrl = "https://LongUrl.com/abcdefg";
        String shortUrl = urlShortenerProcessor.shortUrl(longUrl);


        assertEquals("https://shortme.com/randomKey", shortUrl);
    }
}
