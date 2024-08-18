package book.chap19;

import java.util.NoSuchElementException;

public class Empty<T> implements MyList<T>{
    @Override
    public T head() {
        throw new UnsupportedOperationException();
    }

    public MyList<T> tail() {
        throw new UnsupportedOperationException();
    }
}
