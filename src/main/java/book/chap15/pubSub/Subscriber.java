package book.chap15.pubSub;

interface Subscriber <T>{
    void onNext(T t);
}
