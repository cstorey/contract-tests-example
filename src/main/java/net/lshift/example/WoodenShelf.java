package net.lshift.example;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;

import java.util.Collection;
import java.util.Set;
import java.util.function.Consumer;

/**
 * Created by ceri on 17/10/16.
 */
public class WoodenShelf implements Shelves {
    private final Set<String> books;

    public WoodenShelf(Iterable<String> books) {
        this.books = Sets.newHashSet(books);
    }

    @Override
    public Collection<String> listBooks() {
        return ImmutableList.copyOf(books);
    }

    @Override
    public void giveBookTo(String title, Consumer<String> recieveBook) {
        if (books.contains(title)) {
            books.remove(title);
            recieveBook.accept(title);
        } else {
            throw new NotPresentException();
        }
    }
}