package javabd.examples.passby;

public class PassByValueOrByReference {

    public void changeString(String value) {
        value = "newvalue";
    }

    public void changeInt(int value) {
        value = 42;
    }

    public void changeBook(Book book) {
        book.setName("changed name");
    }

    public void newBook(Book book) {
        Book newBook = new Book("new name");
        // Reference 'book' is reassigned to 'newbook'. Original method reference from the caller isn't changed.
        book = newBook;
    }
}
