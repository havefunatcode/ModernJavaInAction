package book.chap9.design_pattern.observer;

public class NYTimes implements Observer{
    @Override
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("money")) {
            System.out.println("Breaking news in NY! " + tweet);
        }
    }
}
