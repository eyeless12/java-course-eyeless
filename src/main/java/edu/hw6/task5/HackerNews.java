package edu.hw6.task5;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class HackerNews {
    private static final String TOP_STORIES_URL = "https://hacker-news.firebaseio.com/v0/topstories.json";
    private static final String ITEMS_URL = "https://hacker-news.firebaseio.com/v0/item/";
    private static final Pattern PATTERN = Pattern.compile("(\"title\":\".*?\")");
    private final HttpRequest request;
    private long[] topics;

    public HackerNews() {
        try {
            request = HttpRequest.newBuilder(new URI(TOP_STORIES_URL)).GET().build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public long[] hackerNewsTopStories() {
        long[] data;
        try (var client = HttpClient.newBuilder().build()) {
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            data = parseStringLikeArray(response.body());
        } catch (IOException | InterruptedException e) {
            return new long[0];
        }
        topics = data;
        return data;
    }

    public String news(long id) {
        try {
            var newsRequest = HttpRequest.newBuilder(new URI(ITEMS_URL + "/" + id + ".json")).build();
            try (var client = HttpClient.newBuilder().build()) {
                var response = client.send(newsRequest, HttpResponse.BodyHandlers.ofString());
                return getTitle(response.body());
            } catch (IOException | InterruptedException e) {
                return null;
            }
        } catch (URISyntaxException e) {
            return null;
        }
    }

    private long[] parseStringLikeArray(String data) {
        var result = new ArrayList<Long>();
        var splitted = data.split("\\W");
        for (int i = 1; i < splitted.length - 1; i++) {
            result.add(Long.valueOf(splitted[i]));
        }
        return result.stream().mapToLong(i -> i).toArray();
    }

    private String getTitle(String data) {
        var matcher = PATTERN.matcher(data);
        if (matcher.find()) {
            return matcher.group(1).split(":")[1];
        }
        return null;
    }
}
