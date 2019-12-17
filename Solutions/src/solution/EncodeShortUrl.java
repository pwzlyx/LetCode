package solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EncodeShortUrl {
    private Map<String, String> shortUrl = new HashMap<>();
    private String key = getKey();

    private String getKey() {
        StringBuilder key = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++){
            String alphaBet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
            key.append(alphaBet.charAt(random.nextInt(62)));
        }
        return key.toString();
    }

    public String encode(String longUrl){
        while (shortUrl.containsKey(key)){
            key = getKey();
        }
        shortUrl.put(key, longUrl);
        return "http://tinyurl.com/" + key;
    }

    public String decode(String url){
       return shortUrl.get(url.replace("http://tinyurl.com/", ""));
    }

    public static void main(String[] args){
        String longUrl = "dev.m.haodf.com/touch/showorderlist";
        EncodeShortUrl encodeShortUrl = new EncodeShortUrl();
        String shortUrl = encodeShortUrl.encode(longUrl);
        System.out.println(shortUrl);

        System.out.println(encodeShortUrl.decode(shortUrl));
    }
}
