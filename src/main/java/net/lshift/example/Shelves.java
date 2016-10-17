package net.lshift.example;

import java.util.Collection;
import java.util.function.Consumer;

/**
 * Created by ceri on 17/10/16.
 */
public interface Shelves {
    Collection<String> listBooks();

    void giveBookTo(String necronomicon, Consumer<String> recieveBook);

    public class NotPresentException extends RuntimeException {
    }
}
