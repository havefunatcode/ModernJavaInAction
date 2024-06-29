package book.chap13.rule.explicit;

public class C implements A, B {

    public void hello() {
        B.super.hello();
    }

    public static void main(String[] args) {
        new C().hello();
    }
}
