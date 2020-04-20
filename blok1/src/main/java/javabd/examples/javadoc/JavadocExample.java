package javabd.examples.javadoc;

/**
 * <p>
 * <ul>
 * Why Javadoc:
 *      <li>To generate HTML documentation</li>
 *      <li>To provide support (description of usage) in IDE's</li>
 * </ul>
 * </p>
 * <p>
 * How to generate the HTML:
 * <ul>
 *      <li>Use the Maven plugin</li>
 *      <li>Run mvn javadoc:javadoc</li>
 *      <li>Find the HTML files in the target folder</li>
 * </ul>
 * </p>
 * For more infomation see:
 * - https://en.wikipedia.org/wiki/Javadoc
 * - Ctrl + click on a class such as String
 * - View the Javadoc here: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html
 *
 * @since 1.6 (version of this application this class was added)
 * @version 2.1 (current version of this application)
 * @author Firstname LastName firstname.lastname@domain.com
 */
public class JavadocExample {

    /**
     * The divider is used to divide a number.
     */
    private int divider = 2;

    /**
     * Short oneliner
     * <p>
     * Complete description
     * </p>
     * <p>
     * More
     * </p>
     * ...
     *
     * @param argument will be divided by {@link #divider}
     * @return the argument divided by {@link #divider}
     */
    public int divideByDivider(int argument) {
        return argument / divider;
    }

}
