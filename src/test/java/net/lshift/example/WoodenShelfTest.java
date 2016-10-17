package net.lshift.example;

import com.google.common.collect.ImmutableList;

/**
 * Created by ceri on 17/10/16.
 */
public class WoodenShelfTest extends ShelfContract<WoodenShelf> {
    @Override
    protected WoodenShelf evilBookshelf() {
        return new WoodenShelf(ImmutableList.of("Necronomicon"));
    }

}
