package net.lshift.example;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by ceri on 17/10/16.
 */
 public abstract class ShelfContract<T extends Shelves> {

    @Test
    public void evilBooksShouldIncludeNecronomicon() {
        assertThat(evilBookshelf().listBooks(), hasItem("Necronomicon"));
    }

    //         when(shelves.listBooks()).thenReturn(ImmutableList.of("Necronomicon", "Evil Dead"));
    protected abstract T evilBookshelf();
}
