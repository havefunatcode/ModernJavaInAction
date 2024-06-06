package book.chap9.design_pattern.observer;

public class Guardian implements Observer {
    @Override
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("World")) {
            System.out.println("Yet more news from London... " + tweet);
        }
    }
}
