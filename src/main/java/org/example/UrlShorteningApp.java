package org.example;

public class UrlShorteningApp {
    static ConfigReader configReader = new ConfigReader();

    public static void main(String[] args) {

        RandomKeyProvider randomKeyProvider = getRandomKeyProvider();
        UrlShortenerProcessor urlShortenerProcessor = new UrlShortenerProcessor("https://mydomain.com/", randomKeyProvider);

        System.out.println(urlShortenerProcessor.shortUrl("myLoongURL"));
    }

    private static RandomKeyProvider getRandomKeyProvider() {
        KeyProviderFactory keyProviderFactory = new KeyProviderFactory();
        configureKeyProviderFactory(keyProviderFactory);
        String keyProviderType = configReader.getProperty("keyGenerator.type");
        return keyProviderFactory.getKeyProvider(keyProviderType);
    }

    private static void configureKeyProviderFactory(KeyProviderFactory keyProviderFactory) {
        String stringKeyLength = configReader.getProperty("keyGenerator.keyLength");
        String stringKeyCharacterBase = configReader.getProperty("keyGenerator.characterBase");

        if(stringKeyLength != null) {
            keyProviderFactory.setStringKeyLength(Integer.valueOf(stringKeyLength));
        }

        if(stringKeyCharacterBase != null) {
            keyProviderFactory.setCharacterBase(stringKeyCharacterBase);
        }
    }


}