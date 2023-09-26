/**
 * Test class for Pricer Class.
 * 
 * @author frankiebenedetto
 * 
 * @version 1.0
 * 
 */
public class Test {

    /**
     * Checks if two double values are equal within a given tolerance.
     *
     * @param expected The expected double value.
     * @param actual The actual double value to compare.
     * @param tolerance The tolerance within which the values are considered
     * equal.
     * @param description A description of the check (used for reporting).
     * @return True if the values are equal within the tolerance, false
     * otherwise.
     */
    public static boolean forEqualDoubles(double expected, double actual,
            double tolerance, String description) {
        if (Math.abs(expected - actual) > tolerance) {
            System.out.printf("%s Expected: %f, Actual: %f\n", description,
                    expected, actual);
            return false;
        } else {
            return true;
        }
    }

    /**
     * Checks if two integer values are equal.
     *
     * @param expected The expected integer value.
     * @param actual The actual integer value to compare.
     * @param description A description of the check (used for reporting).
     * @return True if the values are equal, false otherwise.
     */
    public static boolean forEqualInts(int expected, int actual,
            String description) {
        if (expected != actual) {
            System.out.printf("%s Expected: %d, Actual: %d\n", description,
                    expected, actual);
            return false;
        }
        return true;
    }

    /**
     * Checks if two string values are equal.
     *
     * @param expected The expected string value.
     * @param actual The actual string value to compare.
     * @param description A description of the check (used for reporting).
     * @return True if the values are equal, false otherwise.
     */
    public static boolean forEqualStrings(String expected, String actual,
            String description) {
        if (expected.equals(actual)) {
            return true;
        } else {
            System.out.printf("%s Expected: %s, Actual: %s\n", description,
                    expected, actual);
            return false;
        }
    }

    /**
     * Checks if a boolean value is false.
     *
     * @param actual The actual boolean value to check.
     * @param description A description of the check (used for reporting).
     * @return True if the value is false, false otherwise.
     */
    public static boolean forFalse(boolean actual, String description) {
        if (actual) {
            System.out.printf("%s Expected: false, Actual: true\n",
                    description);
            return false;
        }
        return true;
    }

    /**
     * Checks if a boolean value is true.
     *
     * @param actual The actual boolean value to check.
     * @param description A description of the check (used for reporting).
     * @return True if the value is true, false otherwise.
     */
    public static boolean forTrue(boolean actual, String description) {
        if (!actual) {
            System.out.printf("%s Expected: true, Actual: false\n",
                    description);
            return false;
        }
        return true;
    }
}
