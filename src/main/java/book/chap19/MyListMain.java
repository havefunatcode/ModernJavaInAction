package book.chap19;

public class MyListMain {

    public static void main(String[] args) {
        MyList<Integer> myList = new MyLinkedList<>(5, new MyLinkedList<>(10, new Empty<>()));
    }

    public static MyList<Integer> primes(MyList<Integer> numbers) {
        return new LazyList<>(
                numbers.head(),
                () -> primes(
                        numbers.tail().filter(n -> n % numbers.head() != 0)
                )
        );
    }

}
