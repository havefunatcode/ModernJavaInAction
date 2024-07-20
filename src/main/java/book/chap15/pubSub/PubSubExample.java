package book.chap15.pubSub;

public class PubSubExample {
    public static void main(String[] args) {
        simpleCellTest();
    }

    private static void simpleCellTest() {
        SimpleCell c3 = new SimpleCell("C3");
        SimpleCell c2 = new SimpleCell("C2");
        SimpleCell c1 = new SimpleCell("C1");

        c1.subscribe(c3);

        c1.onNext(10);
        c2.onNext(20);
    }

    private static void arithmeticCellTest() {
        ArithmeticCell c3 = new ArithmeticCell("C3");
        SimpleCell c2 = new SimpleCell("C2");
        SimpleCell c1 = new SimpleCell("C1");

        c1.subscribe(c3::setLeft);
        c1.subscribe(c3::setRight);

        c1.onNext(10);
        c2.onNext(20);
        c1.onNext(15);
    }
}
