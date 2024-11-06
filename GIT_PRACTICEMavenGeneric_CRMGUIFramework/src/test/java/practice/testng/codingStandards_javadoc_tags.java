package practice.testng;


	import java.io.ObjectOutputStream;
	import java.io.ObjectStreamField;
	import java.io.IOException;

	/**
	 * This class represents a simple model of a Person.
	 *
	 * @author John Doe
	 * @version 1.3
	 * @since 1.0
	 * @see <a href="https://example.com">External Documentation</a>
	 */
	public class codingStandards_javadoc_tags implements java.io.Serializable {

	    /**
	     * The unique ID for serialization.
	     *
	     * @serial
	     */
	    private static final long serialVersionUID = 1L;

	    /**
	     * The name of the person.
	     *
	     * @serialField nameField String the name of the person
	     */
	    private static final ObjectStreamField nameField = new ObjectStreamField("name", String.class);

	    /**
	     * The age of the person.
	     */
	    private int age;

	    /**
	     * Constructs a new Person with a specified age.
	     *
	     * @param age the age to be set
	     * @return 
	     * @since 1.0
	     */
	    public void Person(int age) {
	        this.age = age;
	    }

	    /**
	     * Gets the age of the person.
	     *
	     * @return the age
	     */
	    public int getAge() {
	        return age;
	    }

	    /**
	     * Sets the age of the person.
	     *
	     * @param age the age to set
	     * @throws IllegalArgumentException if age is negative
	     */
	    public void setAge(int age) throws IllegalArgumentException {
	        if (age < 0) {
	            throw new IllegalArgumentException("Age cannot be negative");
	        }
	        this.age = age;
	    }

	    /**
	     * This method calculates the square of a number.
	     *
	     * @param number the number to square
	     * @return the square of the number
	     * @see Math#pow(double, double)
	     */
	    public double square(double number) {
	        return Math.pow(number, 2);
	    }

	    /**
	     * An old method that does not perform any specific action.
	     *
	     * @deprecated Use {@link #newMethod()} instead.
	     */
	    @Deprecated
	    public void oldMethod() {
	        // Old logic
	    }

	    /**
	     * A new method introduced to replace {@link #oldMethod()}.
	     */
	    public void newMethod() {
	        // New logic
	    }

	    /**
	     * Writes the custom serialized data for this object.
	     *
	     * @serialData Writes out the age field.
	     */
	    private void writeObject(ObjectOutputStream oos) throws IOException {
	        oos.writeInt(age);
	    }

	    /**
	     * {@inheritDoc}
	     */
	    @Override
	    public String toString() {
	        return "Person [age=" + age + "]";
	    }
	}



