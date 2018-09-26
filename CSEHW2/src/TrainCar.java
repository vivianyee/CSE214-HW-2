/**
 * The <code>TrainCar</code> class creates a train car
 * inside the linked list
 * 
 * @author Vivian Yee
 * 		e-mail: vivian.yee@stonybrook.edu
 * 		Stonybrook ID: 112145534
 */
public class TrainCar {
	private double trainLength; // Name for train length
	private double trainWeight; // Name for train weight
	private ProductLoad reference = null; // Name for product load reference
	
	/**
	 * Constructor for TrainCar class
	 * 
	 * @param trainLength
	 * @param trainWeight
	 */
	public TrainCar(double trainLength, double trainWeight) {
		this.trainLength = trainLength;
		this.trainWeight = trainWeight;
	}
	
	/**
	 * Test whether train car is empty or not
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return (reference == null);
	}
	
	/**
	 * Getter for train length
	 * 
	 * @return
	 */
	public double getTrainLength() {
		return trainLength;
	}
	
	/**
	 * Getter for train weight
	 * 
	 * @return
	 */
	public double getTrainWeight() {
		return trainWeight;
	}
	
	/**
	 * Getter for product load reference
	 * 
	 * @return
	 */
	public ProductLoad getReference() {
		return reference;
	}
	/**
	 * Setter for product load reference
	 * 
	 * @param reference
	 */
	public void setReference(ProductLoad reference) {
		this.reference = reference;
	}

}
