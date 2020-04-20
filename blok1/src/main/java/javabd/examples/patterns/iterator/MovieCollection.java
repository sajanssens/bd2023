package javabd.examples.patterns.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MovieCollection {
    private List<Movie> movieList = new ArrayList<Movie>();

    public void add(Movie movie) {
        movieList.add(movie);
    }

    public Iterator<Movie> iterator() {
        return new MovieIterator();
    }

    class MovieIterator implements Iterator<Movie> {
        int currentIndex = 0;

        @Override
        public boolean hasNext() {
            if (currentIndex >= movieList.size()) {
                return false;
            } else {
                return true;
            }
        }

        @Override
        public Movie next() {
            return movieList.get(currentIndex++);
        }
    }

}

