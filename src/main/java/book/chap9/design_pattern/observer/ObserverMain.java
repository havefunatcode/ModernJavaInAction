package book.chap9.design_pattern.observer;

public class ObserverMain {
    public static void main(String[] args) {
        Feed feed = new Feed();
//        feed.registerObserver(new NYTimes());
//        feed.registerObserver(new Guardian());
//        feed.registerObserver(new LeMonde());
//        feed.notifyObservers("Hello World!");

        feed.registerObserver((String tweet) -> {
            if (tweet != null && tweet.contains("hello")) {
                System.out.println("Breaking news in NY! " + tweet);
            }
        });

        feed.registerObserver((String tweet) -> {
            if (tweet != null && tweet.contains("there")) {
                System.out.println("Yet more news from London... " + tweet);
            }
        });

        feed.notifyObservers("hello there my name is havefunatcode");
    }
}
