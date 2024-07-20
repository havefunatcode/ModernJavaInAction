package book.chap15.pubSub;

interface Publisher<T> {
    void subscribe(Subscriber<? super T> subscriber);
}
