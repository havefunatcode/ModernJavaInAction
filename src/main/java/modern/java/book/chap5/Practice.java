package modern.java.book.chap5;

import modern.java.book.chap5.model.DefaultTransactionFactory;
import modern.java.book.chap5.model.Trader;
import modern.java.book.chap5.model.Transaction;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;

public class Practice {
    public static void main(String[] args) {
        List<Transaction> defaultTransaction = DefaultTransactionFactory.getDefaultTransaction();
        System.out.println("================================================================================");
        System.out.println("First Question");
        firstQuestion(defaultTransaction);
        System.out.println("================================================================================");

        System.out.println("Second Question");
        secondQuestion(defaultTransaction);
        System.out.println("================================================================================");

        System.out.println("Third Question");
        thirdQuestion(defaultTransaction);
        System.out.println("================================================================================");

        System.out.println("Fourth Question");
        fourthQestion(defaultTransaction);
        System.out.println("================================================================================");

        System.out.println("Fifth Question");
        fifthQuestion(defaultTransaction);
        System.out.println("================================================================================");

        System.out.println("Sixth Question");
        sixthQuestion(defaultTransaction);
        System.out.println("================================================================================");

        System.out.println("Seventh Question");
        seventhQuestion(defaultTransaction);
        System.out.println("================================================================================");

        System.out.println("Eighth Question");
        eighthQuestion(defaultTransaction);
        System.out.println("================================================================================");
    }

    private static void firstQuestion(List<Transaction> defaultTransaction) {
        List<Transaction> filteredTransactions = defaultTransaction.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .collect(Collectors.toList());

        filteredTransactions.forEach(System.out::println);
    }

    private static void secondQuestion(List<Transaction> defaultTransaction) {
        List<String> uniqueWorkCities = defaultTransaction.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());

        uniqueWorkCities.forEach(System.out::println);
    }

    private static void thirdQuestion(List<Transaction> defaultTransaction) {
        List<Trader> cambridgeWorkers = defaultTransaction.stream()
                .map(Transaction::getTrader)
                .filter(trader -> Objects.equals(trader.getCity(), "Cambridge"))
                .distinct()
                .sorted(comparing(Trader::getName))
                .collect(Collectors.toList());

        cambridgeWorkers.forEach(System.out::println);
    }

    private static void fourthQestion(List<Transaction> defaultTransaction) {
        String allTraders = defaultTransaction.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
//                .sorted(comparing(s -> s))
//                .collect(Collectors.toList());
//                .reduce("", (n1, n2) -> n1 + n2);
                .sorted()
                .collect(joining());

//        allTraders.forEach(System.out::println);
        System.out.println(allTraders);
    }

    private static void fifthQuestion(List<Transaction> defaultTransaction) {
        boolean hasMilanInCity = defaultTransaction.stream()
                .anyMatch(transaction -> Objects.equals(transaction.getTrader().getCity(), "Milan"));

        System.out.println("Milan is in cities? " + hasMilanInCity);
    }

    private static void sixthQuestion(List<Transaction> defaultTransaction) {
        List<Integer> cambridgeTradersTransactions = defaultTransaction.stream()
                .filter(transaction -> Objects.equals(transaction.getTrader().getCity(), "Cambridge"))
                .map(Transaction::getValue)
                .collect(Collectors.toList());

        cambridgeTradersTransactions.forEach(System.out::println);
    }

    private static void seventhQuestion(List<Transaction> defaultTransaction) {
//        int maxValueInTransactions = defaultTransaction.stream()
//                .max(comparing(Transaction::getValue))
//                .get()
//                .getValue();
        int maxValueInTransactions = defaultTransaction.stream()
                        .map(Transaction::getValue)
                        .reduce(Integer::max)
                        .orElseThrow().intValue();

        System.out.println("Max transaction value is : " + maxValueInTransactions);
    }

    private static void eighthQuestion(List<Transaction> defaultTransaction) {
//        int minValueInTransactions = defaultTransaction.stream()
//                .min(comparing(Transaction::getValue))
//                .get()
//                .getValue();

        int minValueInTransactions = defaultTransaction.stream()
                        .map(Transaction::getValue)
                        .reduce(Integer::min)
                        .orElseThrow().intValue();

        System.out.println("Max transaction value is : " + minValueInTransactions);
    }

}
