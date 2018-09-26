/**
 * The <code>TrainCarNode</code> class creates the nodes inside
 * the Linked list for the train
 * 
 * @author Vivian Yee
 * 		e-mail: vivian.yee@stonybrook.edu
 * 		Stonybrook ID: 112145534
 */
public class TrainCarNode {
	private TrainCarNode prev; // The previous node
	private TrainCarNode next; // The next node
	private TrainCar car; // The car that the node has
	
	/**
	 * Constructor for TrainCarNode
	 * 
	 * @param car
	 */
	public TrainCarNode(TrainCar car) {
		this.car = car;
	}

	/**
	 * Sets the string for when the car load is dangerous or not
	 * 
	 * @return
	 * 		Returns the string for the dangerous or not load
	 */
	public String toString() {
		String x = "";
		if(car.getReference().isDangerous()) {
			x = "YES";
		}else {
			x = "NO";
		}
		return(x);
	}
	
	/**
	 * Getter for previous node
	 * 
	 * @return
	 */
	public TrainCarNode getPrev() {
		return prev;
	}
	/**
	 * Setter for previous node
	 * 
	 * @param prev
	 */
	public void setPrev(TrainCarNode prev) {
		this.prev = prev;
	}
	
	/**
	 * Getter for next node
	 * 
	 * @return
	 */
	public TrainCarNode getNext() {
		return next;
	}
	/**
	 * Setter for next node
	 * 
	 * @param next
	 */
	public void setNext(TrainCarNode next) {
		this.next = next;
	}

	/**
	 * Getter for car
	 * 
	 * @return
	 */
	public TrainCar getCar() {
		return car;
	}
	/**
	 * Setter for car
	 * 
	 * @param car
	 */
	public void setCar(TrainCar car) {
		this.car = car;
	}
}
