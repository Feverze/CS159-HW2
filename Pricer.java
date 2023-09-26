/**
 * Doing something with the items yea.
 * 
 * @author Frank Bended
 * 
 * @version 1.0
 */

public class Pricer {
    private int boxSize;
    private double pricePerBox;
    private double pricePerIndividual;

    /**
     * Constructs a new Pricer object with the specified parameters.
     *
     * @param boxSize The size of a box for pricing calculation.
     * @param pricePerBox The price per box for pricing calculation.
     * @param pricePerIndividual The price per individual item for pricing
     * calculation.
     */
    public Pricer(int boxSize, double pricePerBox, double pricePerIndividual) {
        this.boxSize = boxSize;
        this.pricePerBox = pricePerBox;
        this.pricePerIndividual = pricePerIndividual;
    }

    /**
     * finds if an extra box is needed.
     *
     * @param numberOfItems The total number of items.
     * @return True if an extra box is needed, false otherwise.
     */
    public boolean needAnExtraBox(int numberOfItems) {
        if (numberOfItems < 0) {
            return false;
        }
        return numberOfItems % boxSize != 0;
    }

    /**
     * finds how many boxes needed.
     *
     * @param numberOfItems The total number of items.
     * @return The total number of boxes needed.
     */
    public int numberOfBoxes(int numberOfItems) {
        if (numberOfItems < 0) {
            return 0;
        }
        int fullBoxes = numberOfItems / boxSize;
        if (needAnExtraBox(numberOfItems)) {
            fullBoxes++;
        }
        return fullBoxes;
    }

    /**
     * finds how many full boxes.
     *
     * @param numberOfItems The total number of items.
     * @return The number of full boxes.
     */
    public int numberOfFullBoxes(int numberOfItems) {
        if (numberOfItems < 0) {
            return 0;
        }
        return numberOfItems / boxSize;
    }

    /**
     * finds how many extra items.
     *
     * @param numberOfItems The total number of items.
     * @return The number of extra items.
     */
    public int numberOfExtras(int numberOfItems) {
        if (numberOfItems < 0) {
            return 0;
        }
        return numberOfItems % boxSize;
    }

    /**
     * gets total price.
     *
     * @param numberOfItems The total number of items.
     * @return The total price for the items.
     */
    public double priceFor(int numberOfItems) {
        if (numberOfItems < 0) {
            return 0.0;
        }
        int fullBoxes = numberOfFullBoxes(numberOfItems);
        int extraDonuts = numberOfExtras(numberOfItems);
        double totalPrice = fullBoxes * pricePerBox
                + extraDonuts * pricePerIndividual;
        return totalPrice;
    }

}
