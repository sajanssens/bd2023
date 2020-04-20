package javabd.examples.patterns.iterator;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class MovieCollectionTest {
    private static MovieCollection movieCollection;

    @Before
    public void init() {
        movieCollection = new MovieCollection();
        for (int i = 0; i < 10; i++) {
            movieCollection.add(new Movie("Name " + i));
        }
    }

    @Test
    public void testNext() {
        Iterator<Movie> movieIterator = movieCollection.iterator();
        for (int i = 0; i < 10; i++) {
            Movie movie = movieIterator.next();
            assertEquals("Name " + i, movie.getTitle());
        }
    }

    @Test
    public void testHasNext() {
        Iterator<Movie> movieIterator = movieCollection.iterator();
        for (int i = 0; i < 10; i++) {
            boolean hasNext = movieIterator.hasNext();
            assertTrue(hasNext);
            // We don't use the resulting movie, but need to use next() to advance to the next item.
            movieIterator.next();
        }
        assertFalse(movieIterator.hasNext());
    }
}
