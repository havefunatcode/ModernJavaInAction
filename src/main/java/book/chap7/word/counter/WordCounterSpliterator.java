package book.chap7.word.counter;

import java.util.Spliterator;
import java.util.function.Consumer;

public class WordCounterSpliterator implements Spliterator<Character> {
    private final String string;
    private int currentChar = 0;

    public WordCounterSpliterator(String string) {
        this.string = string;
    }

    // WordCounter.accumulate()만 적용된다.
    @Override
    public boolean tryAdvance(Consumer<? super Character> action) {
        // 현재 문자 소비
        action.accept(string.charAt(currentChar++));
        // 소비할 문자가 남아있는 경우 true
        return currentChar < string.length();
    }

    @Override
    public Spliterator<Character> trySplit() {
        int currentSize = string.length() - currentChar;
        if (currentSize < 10) {
            // 파싱할 문자열을 순차 처리할 수 있을 만큼 충분히 작아졌다.
            return null;
        }

        // 문자열 파싱을 문자열의 중간을 기준으로 한다.
        for (int splitPos = currentSize / 2 + currentChar; splitPos < string.length(); splitPos++) {
            // 다음 공백이 나올 때까지 분할 위치를 뒤로 이동시킨다.
            // 단어 중간을 분할하지 않도록 빈 문자가 나올때까지 분할 위치를 이동시킨다.
            if (Character.isWhitespace(string.charAt(splitPos))) {
                WordCounterSpliterator spliterator = new WordCounterSpliterator(string.substring(currentChar, splitPos));
                // WordCounterSpliterator의 시작 위치를 분할 위치로 설정한다.
                currentChar = splitPos;
                return spliterator;
            }
        }

        return null;
    }

    @Override
    public long estimateSize() {
        return string.length() - currentChar;
    }

    @Override
    public int characteristics() {
        return ORDERED + SIZED + SUBSIZED + NONNULL + IMMUTABLE;
    }
}
