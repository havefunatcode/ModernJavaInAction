package book.chap8;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static java.util.Map.entry;

public class MapMergeTest {
    public static void main(String[] args) {
        quiz();
    }

    private static void quiz() {
        Map<String, Integer> movies = new HashMap<>();
        movies.put("JamesBond", 20);
        movies.put("Matrix", 15);
        movies.put("Harry Potter", 5);
//        Iterator<Map.Entry<String, Integer>> iterator = movies.entrySet().iterator();
//
//        while (iterator.hasNext()) {
//            Map.Entry<String, Integer> entry = iterator.next();
//            if (entry.getValue() < 10) {
//                iterator.remove();
//            }
//        }

        movies.entrySet().removeIf(entry -> entry.getValue() < 10);

        System.out.println(movies);
    }

    private static void mergeTest() {
        Map<String, String> family = Map.ofEntries(
                entry("Teo", "Star Wars"),
                entry("Cristina", "James Bond")
        );
        Map<String, String> friends = Map.ofEntries(
                entry("Tom", "Matrix"),
                entry("Cristina", "Frozen")
        );

        Map<String, String> everyone = new HashMap<>(family);
        friends.forEach((k, v) ->
                everyone.merge(k, v, (movie1, movie2) -> movie1 + " & " + movie2));
        System.out.println(everyone);
    }
}
