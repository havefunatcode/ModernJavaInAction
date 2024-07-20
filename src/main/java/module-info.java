module ModernJavaInAction.main {
    requires java.base;

    exports book.chap14.expenses.readers;
    exports book.chap14.expenses.readers.file;
    exports book.chap14.expenses.readers.http;
}
