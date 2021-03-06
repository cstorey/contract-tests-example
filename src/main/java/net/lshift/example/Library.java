package net.lshift.example;

/*
 * This Java source file was auto generated by running 'gradle buildInit --type java-library'
 * by 'ceri' at '16/10/17 11:06' with Gradle 2.10
 *
 * @author ceri, @date 16/10/17 11:06
 */
public class Library {
    private Shelves shelves;

    public Library(Shelves shelves) {

        this.shelves = shelves;
    }

    public boolean hasBook(String title) {
        return shelves.listBooks().contains(title);
    }

    public void checkout(String title, Client client) {
        try {
            shelves.giveBookTo(title, (book) -> client.receiveBook(book));
        } catch (Shelves.NotPresentException e) {
            client.receiveApology();
        }
    }

    public interface Client {
        void receiveBook(String book);

        void receiveApology();
    }
}
