package javabd.examples.passby;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PassByValueOrByReferenceTest {
    private PassByValueOrByReference passByValueOrByReference = new PassByValueOrByReference();

    @Test
    public void testInt() {
        int i = 1;
        passByValueOrByReference.changeInt(i);
        assertEquals(1, i);
    }

    @Test
    public void testString() {
        String s = "test";
        passByValueOrByReference.changeString(s);
        assertEquals("test", s);
    }

    @Test
    public void testChangeBook() {
        Book book = new Book("original name");
        passByValueOrByReference.changeBook(book);
        assertEquals("changed name", book.getName());
        // Still points to the same address, but the book changed at the address
    }

    @Test
    public void testNewBook() {
        Book book = new Book("original name");
        passByValueOrByReference.newBook(book);
        assertEquals("original name", book.getName());
        // Still points to the same address.
    }
}
