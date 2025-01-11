package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class URLShortenerTest {

    @Test
    void shortenAndRetrieveTest() {
        URLShortener shortener = new URLShortener();

        String longUrl1 = "https://www.example.com/some/really/long/url";
        String shortUrl1 = shortener.shorten(longUrl1);

        assertNotNull(shortUrl1);
        assertEquals(longUrl1, shortener.retrieve(shortUrl1));

        String longUrl2 = "https://www.example.com/two/really/long/url";
        String shortUrl2 = shortener.shorten(longUrl2);
        assertEquals(longUrl2, shortener.retrieve(shortUrl2));

        String longUrl3 = "https://www.example.com/three/really/long/url";
        String shortUrl3 = shortener.shorten(longUrl3);
        assertEquals(longUrl3, shortener.retrieve(shortUrl3));
    }

    @Test
    void sameURLTest() {
        URLShortener shortener = new URLShortener();

        String longUrl = "https://www.example.com/some/really/long/url";
        String shortUrl1 = shortener.shorten(longUrl);
        String shortUrl2 = shortener.shorten(longUrl);

        assertEquals(shortUrl1, shortUrl2);
    }

}
