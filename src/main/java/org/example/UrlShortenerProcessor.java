package org.example;


public class UrlShortenerProcessor {

    private String domainName;
    private RandomKeyProvider randomKeyProvider;

    public UrlShortenerProcessor(String domainName, RandomKeyProvider randomKeyProvider) {
        this.domainName = domainName;
        this.randomKeyProvider = randomKeyProvider;
    }


    public String shortUrl(String longUrl) {
        return domainName + randomKeyProvider.generateRandomKey();
    }
}
