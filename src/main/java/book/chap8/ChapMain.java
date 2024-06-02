package book.chap8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ChapMain {
    public static void main(String[] args) {
        listFactoryTest();
        listOfTest();
        setOfTest();
        mapOfTest();
    }

    private static void mapOfTest() {
        Map<String, Integer> ageOfFirends = Map.of("Raphael", 30, "Olivia", 25, "Tom", 28);
        System.out.println(ageOfFirends);
    }

    private static void setOfTest() {
        Set<String> friends = Set.of("Raphael", "Olivia", "Rachael");
//        Set<String> friends = Set.of("Raphael", "Olivia", "Olivia");
        System.out.println(friends);
    }

    private static void listOfTest() {
        List<String> friends = Arrays.asList("Raphael", "Olivia", "Rachael");
//        friends.add("Tom");
        System.out.println(friends);
    }

    private static void listFactoryTest() {
        List<String> friends = Arrays.asList("Raphael", "Olivia", "Rachael");
//        friends.add("Tom");
        System.out.println(friends);
    }
}
