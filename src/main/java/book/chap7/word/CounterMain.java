package book.chap7.word;

import book.chap7.word.counter.WordCounter;
import book.chap7.word.counter.WordCounterSpliterator;
import book.chap7.word.counter.WordCounterWithStream;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CounterMain {
    private static final String SENTENCE = " Nel   mezzo del cammin  di nostra  vita "
            + "mi  ritrovai in una  selva oscura"
            + " che la  dritta via era   smarrita ";
    public static void main(String[] args) {
        Stream<Character> characterStream = IntStream.range(0, SENTENCE.length()).mapToObj(SENTENCE::charAt);
        System.out.println("Found " + countWords(SENTENCE) + " words!");
        System.out.println("Found " + countWords(characterStream) + " words!");
        System.out.println("Found " + countWordsWithSpliterator() + " words!");
    }

    private static int countWords(String SENTENCE) {
        WordCounter wordCounter = new WordCounter();
        return wordCounter.countWordsIteratively(SENTENCE);
    }

    private static int countWords(Stream<Character> stream) {
        WordCounterWithStream wordCounterWithStream = stream.reduce(new WordCounterWithStream(0, true), WordCounterWithStream::accumulate, WordCounterWithStream::combine);
        return wordCounterWithStream.getCounter();
    }

    private static int countWordsWithSpliterator() {
        WordCounterSpliterator spliterator = new WordCounterSpliterator(SENTENCE);
        Stream<Character> stream = StreamSupport.stream(spliterator, true);
        return countWords(stream);
    }
}
