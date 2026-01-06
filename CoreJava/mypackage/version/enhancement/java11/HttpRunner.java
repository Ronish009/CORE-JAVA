package mypackage.version.enhancement.java11;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

record Coordinate(int maximum, int minimum) {}
public class HttpRunner {
    public static void main(String[] args) throws Exception{
      /* HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8000/limits"))
                .GET().build();
        HttpResponse<String> response = httpClient.send(httpRequest,HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        ObjectMapper mapper = new ObjectMapper();
        Coordinate config = mapper.readValue(response.body(), Coordinate.class);
        System.out.println(config);*/

        Object obj = "Hello Java 17";
        if (obj instanceof String s) {
            System.out.println("Length: " + s.length());
        }

        System.out.println(switch (obj) {
            case String s -> "It's a String: " + s;
            default       -> "Something else";
        });
        Object o = "Rony";
        var k = switch (o){
            case String s when s.length()==4 ->"Preeti";
            case Integer s->"Integer";
            case Long s->"Long";
            default -> "Something else";
        };
        System.out.println(k);
    }


}
