package net.lshift.example;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

/**
 * Created by ceri on 17/10/16.
 */
 public abstract class ShelfContract<T extends Shelves> {

    public static final String NECRONOMICON = "Necronomicon";
    public static final ImmutableList<String> EVIL_BOOKS = ImmutableList.of(NECRONOMICON, "Evil Dead");
    public static final ImmutableList<String> NICE_BOOKS = ImmutableList.of("I love bees");

    @Test
    public void evilBooksShouldIncludeNecronomicon() {
        assertThat(evilBookshelf().listBooks(), hasItem(NECRONOMICON));
    }

    // when(shelves.listBooks()).thenReturn(EVIL_BOOKS);
    protected abstract T evilBookshelf();

    // Can give book to client, see: {@link LibraryTest#canRemoveFromBookshelf()}
    @Test
    public void canGiveExistingBookToClient() {
        List<String> books = Lists.newArrayList();
        evilBookshelf().giveBookTo(NECRONOMICON, books::add);
        assertThat(books, contains(NECRONOMICON));
    }

    @Test(expected=Shelves.NotPresentException.class)
    public void cannotGiveOutNonExistentBook() {
        evilBookshelf().giveBookTo("Cthulhu just wants a hug", (_x) -> {});
    }
}
