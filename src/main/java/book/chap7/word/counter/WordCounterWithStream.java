package book.chap7.word.counter;

public class WordCounterWithStream {
    private final int counter;
    private final boolean lastSpace;

    public WordCounterWithStream(int counter, boolean lastSpace) {
        this.counter = counter;
        this.lastSpace = lastSpace;
    }

    public WordCounterWithStream accumulate(Character c) {
        if (Character.isWhitespace(c)) {
            return lastSpace ? this : new WordCounterWithStream(counter, true);
        } else {
            return lastSpace ? new WordCounterWithStream(counter + 1, false) : this;
        }
    }

    public WordCounterWithStream combine(WordCounterWithStream wordCounterWithStream) {
        return new WordCounterWithStream(counter + wordCounterWithStream.counter, wordCounterWithStream.lastSpace);
    }

    public int getCounter() {
        return this.counter;
    }

}
