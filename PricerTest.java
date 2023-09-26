/**
 * A driver that can be used to test the Pricer class.
 * 
 * @author CS159 Professors
 * @version 1
 */
public class PricerTest {

	/**
	 * The entry point of the driver.
	 * 
	 * @param args The command-line arguments (which are ignored)
	 */
	public static void main(String[] args) {

		double tolerance = 0.01;
		String description;
		Pricer cookiePricer, donutPricer;
		
		
		// Tests for donuts
		
		donutPricer = new Pricer(12, 9.99, 0.99);
		
		int[] donuts = {-30, 0, 5, 7, 12, 13, 23, 36, 98};
		
		System.out.println("Tests that were Failed:");

		System.out.println("");
		int[] expectedFullBoxes = {0, 0, 0, 0, 1, 1, 1, 3, 8};
		for (int i=0; i<donuts.length; i++) {
			description = String.format("donutPricer.numberOfFullBoxes(%d)", donuts[i]);
			Test.forEqualInts(expectedFullBoxes[i], donutPricer.numberOfFullBoxes(donuts[i]), description);
		}

		System.out.println("");
		int[] expectedExtras = {0, 0, 5, 7, 0, 1, 11, 0, 2};
		for (int i=0; i<donuts.length; i++) {
			description = String.format("donutPricer.numberOfExtras(%d)", donuts[i]);
			Test.forEqualInts(expectedExtras[i], donutPricer.numberOfExtras(donuts[i]), description);
		}

		System.out.println("");
		boolean[] expectedNeedExtra = {false, false, true, true, false, true, true, false, true};
		for (int i=0; i<donuts.length; i++) {
			description = String.format("donutPricer.needAnExtraBox(%d)", donuts[i]);
			if (expectedNeedExtra[i]) Test.forTrue(donutPricer.needAnExtraBox(donuts[i]), description);
			else Test.forFalse(donutPricer.needAnExtraBox(donuts[i]), description);
		}
		
		System.out.println("");
		int[] expectedBoxes = {0, 0, 1, 1, 1, 2, 2, 3, 9};
		for (int i=0; i<donuts.length; i++) {
			description = String.format("donutPricer.numberOfBoxes(%d)", donuts[i]);
			Test.forEqualInts(expectedBoxes[i], donutPricer.numberOfBoxes(donuts[i]), description);
		}

		System.out.println("");
		double[] expectedPrice = {0.00, 0.00, 4.95, 6.93, 9.99, 10.98, 20.88, 29.97, 81.90};
		for (int i=0; i<donuts.length; i++) {
			description = String.format("donutPricer.priceFor(%d)", donuts[i]);
			Test.forEqualDoubles(expectedPrice[i], donutPricer.priceFor(donuts[i]), tolerance, description);
		}

		// Tests for cookies
		
		cookiePricer = new Pricer(36, 17.99, 0.75);

		int[] cookies = {-80, 0, 15, 36, 150};
		
		System.out.println("");
		double[] expectedCookiePrice = {0.00, 0.00, 11.25, 17.99, 76.46};
		for (int i=0; i<cookies.length; i++) {
			description = String.format("cookiePricer.priceFor(%d)", cookies[i]);
			Test.forEqualDoubles(expectedCookiePrice[i], cookiePricer.priceFor(cookies[i]), tolerance, description);
		}
		
		// Re-test for donuts (just in case)

		System.out.println("");
		for (int i=0; i<donuts.length; i++) {
			description = String.format("After testing cookiePricer - donutPricer.priceFor(%d)", donuts[i]);
			Test.forEqualDoubles(expectedPrice[i], donutPricer.priceFor(donuts[i]), tolerance, description);
		}

	}
	
}
