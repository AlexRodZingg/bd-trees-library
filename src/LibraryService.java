import org.apache.commons.lang3.NotImplementedException;
import treestructure.BookNode;

/**
 * Application to test traversing Binary Trees and Binary Search Trees.
 *
 * Represents a Library with a collection of books.
 */
public class LibraryService {

    /**
     * The root node of our tree of Books.
     * Assume this tree is sorted by ISBN.
     * The tree and its nodes should not be modified by our application.
    */
    private final BookNode books;

    /**
     * Constructs our library with a default tree of books.
     * Assume this tree is sorted by ISBN.
     *
     * @param books The root node of a tree of Books
     */
    public LibraryService(final BookNode books) {
        this.books = books;
    }

    /**
     * Determines whether or not a book is in the library
     * by searching our tree for a book with the given ISBN.
     *
     * @param isbn A given ISBN to search our library for
     * @return True if a book with the given ISBN is in our library and
     *         false otherwise
     */
    public boolean isBookInLibraryByIsbn(String isbn) {
        // PARTICIPANTS: IMPLEMENT YOUR BINARY SEARCH HERE
        if (isbn == null || isbn.equals("")) {
            return false;
        }

        BookNode curr = books;
        while (curr != null) {
            if (isbn.equals(curr.getBook().getIsbn())) {
                return true;
            } else if (isbn.compareTo(curr.getBook().getIsbn()) > 0) {
                curr = curr.getRight();
            } else {
                curr = curr.getLeft();
            }
        }
        return false;
    }


    /**
     * Determines whether or not a book is in the library
     * by searching our tree for a book with the given Title and Author.
     *
     * @param title A given title to search our library for, alongside an author's name
     * @param author The name of a given author to search our library for, alongside a title
     * @return True if a book with the given title and author is in our library, and
     *         false otherwise
     */
    public boolean isBookInLibraryByTitleAndAuthor(String title, String author) {
        // PARTICIPANTS: IMPLEMENT YOUR DEPTH FIRST SEARCH HERE
        if (title == null || title.equals("") || author == null || author.equals("")) {
            return false;
        }
        BookNode curr = books;
        return dfs(curr, title, author);
    }

    private boolean dfs(BookNode curr, String title, String author) {
        if (curr == null) {
            return false;
        }

        if (curr.getBook().getTitle().equals(title) && curr.getBook().getAuthor().equals(author)) {
            return true;
        }

        return dfs(curr.getLeft(), title, author) || dfs(curr.getRight(), title, author);
    }
}
