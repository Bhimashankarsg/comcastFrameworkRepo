package practice.testng;


	import java.io.ObjectOutputStream;
	import java.io.ObjectStreamField;
	import java.io.IOException;
	import java.time.LocalDate;

	/**
	 * Represents a book in a library system.
	 *
	 * @author Jane
	 * @version 2.0
	 * @since 1.0
	 */
	public class codingStandards_javaDoc_Tags2 implements java.io.Serializable {

	    /**
	     * Unique identifier for serialization.
	     *
	     * @serial
	     */
	    private static final long serialVersionUID = 123456789L;

	    /**
	     * The title of the book.
	     *
	     * @serialField titleField String the title of the book
	     */
	    private static final ObjectStreamField titleField = new ObjectStreamField("title", String.class);

	    /**
	     * The title of the book.
	     */
	    private String title;

	    /**
	     * The author of the book.
	     */
	    private String author;

	    /**
	     * The publication date of the book.
	     */
	    private LocalDate publicationDate;

	    /**
	     * Creates a new Book with the specified title, author, and publication date.
	     *
	     * @param title the title of the book
	     * @param author the author of the book
	     * @param publicationDate the publication date of the book
	     * @throws IllegalArgumentException if any parameter is null or publication date is in the future
	     */
	    public codingStandards_javaDoc_Tags2(String title, String author, LocalDate publicationDate) throws IllegalArgumentException {
	        if (title == null || author == null || publicationDate == null || publicationDate.isAfter(LocalDate.now())) {
	            throw new IllegalArgumentException("Invalid book data");
	        }
	        this.title = title;
	        this.author = author;
	        this.publicationDate = publicationDate;
	    }

	    /**
	     * Gets the title of the book.
	     *
	     * @return the title of the book
	     */
	    public String getTitle() {
	        return title;
	    }

	    /**
	     * Sets the title of the book.
	     *
	     * @param title the new title
	     * @since 1.1
	     */
	    public void setTitle(String title) {
	        this.title = title;
	    }

	    /**
	     * Calculates the age of the book in years.
	     *
	     * @return the age of the book
	     * @see LocalDate#now()
	     */
	    public int getBookAge() {
	        return LocalDate.now().getYear() - publicationDate.getYear();
	    }

	    /**
	     * An old method to get book details. It has been replaced by {@link #getBookDetails()}.
	     *
	     * @deprecated Use {@link #getBookDetails()} instead.
	     */
	    @Deprecated
	    public String oldGetBookDetails() {
	        return title + " by " + author;
	    }

	    /**
	     * Returns the book's details in a formatted string.
	     *
	     * @return the book's details as "Title by Author"
	     */
	    public String getBookDetails() {
	        return title + " by " + author;
	    }

	    /**
	     * Writes the custom serialized data for this book.
	     *
	     * @serialData Writes out the title, author, and publicationDate fields.
	     */
	    private void writeObject(ObjectOutputStream oos) throws IOException {
	        oos.writeUTF(title);
	        oos.writeUTF(author);
	        oos.writeObject(publicationDate);
	    }

	    /**
	     * {@inheritDoc}
	     */
	    @Override
	    public String toString() {
	        return "Book [title=" + title + ", author=" + author + ", publicationDate=" + publicationDate + "]";
	    }
	}

