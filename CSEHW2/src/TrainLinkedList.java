/**
 * The <code>TrainLinkedList</code> class creates a linked
 * list for the train that contains the cars
 * 
 * @author Vivian Yee
 * 		e-mail: vivian.yee@stonybrook.edu
 * 		Stonybrook ID: 112145534
 */
public class TrainLinkedList {
	private int size = 0; // Initial size of train
	private double weight = 0;  // Initial weight of train
	private double length = 0;  // Initial length of train
	private double value = 0;  // Initial value of train
	private boolean dangerous = false; // Initial danger of train
	private TrainCarNode head; // Node in train list for head
	private TrainCarNode tail; // Node in train list for tail
	private TrainCarNode cursor; // Node in train list for cursor
	private TrainLinkedList choo = null; // Train list
	
	/**
	 * Constructor for TrainLinkedList
	 */
	public TrainLinkedList() {
		head = null;
		tail = null;
		cursor = null;
	}
	
	/**
	 * Getter for cursor
	 * 
	 * @return
	 * 		Train car for cursor
	 */
	public TrainCar getCursorData() {
		return cursor.getCar();
	}
	/**
	 * Setter for cursor
	 * 
	 * @param car
	 * 		Train car of cursor
	 */
	public void setCursorData(TrainCar car) {
		cursor.setCar(car);
	}
	
	/**
	 * Sets the cursor forward in the train list
	 */
	public void cursorForward() {
		if((cursorNull())||(cursor.getNext()==null)) {
			System.out.print("No next car, cannot move cursor forward.");
		}else {
			cursor = cursor.getNext();
			System.out.print("Cursor moved forward.");
		}
	}
	
	/**
	 * Sets the cursor backward in the train list
	 */
	public void cursorBackward() {
		if((cursorNull())||(cursor.getPrev()==null)) {
			System.out.print("No previous car, cannot move cursor backward.");
		}else {
			cursor = cursor.getPrev();
			System.out.print("Cursor moved backward.");
		}
	}
	
	/**
	 * Inserts a new car after the cursor
	 * 
	 * @param newCar
	 * 		Car user wants to input
	 */
	public void insertAfterCursor(TrainCar newCar) {
		TrainCarNode node = new TrainCarNode(newCar);
		if(cursor==null) {
			head = node;
			tail = node;
			cursor = node;
		}else if(cursor.equals(tail)){
			node.setNext(cursor.getNext());
			node.setPrev(cursor);
			cursor.setNext(node);
			cursor = cursor.getNext();
			tail = tail.getNext();
			//node.getNext().setPrev(node);
		}else {
			node.setNext(cursor.getNext());
			node.setPrev(cursor);
			cursor.setNext(node);
			cursor = cursor.getNext();
		}
		weight += node.getCar().getTrainWeight();
		length += node.getCar().getTrainLength();
		size++;
	}
	
	/**
	 * Removes car at cursor
	 * 
	 * @return
	 * 		Car that is being removed
	 */
	public TrainCar removeCursor() {
		TrainCar x = getCursorData();
		if((cursor.equals(tail))&&(cursor.equals(head))){
			cursor.setCar(null);
			head = null;
			tail = null;
			cursor = null;
		}else if(cursor.equals(tail)) {
			cursor.getPrev().setNext(null);
			cursor = cursor.getPrev();
			tail = tail.getPrev();
		}else if(cursor.equals(head)) {
			cursor.getNext().setPrev(null);
			cursor = cursor.getNext();
			head = head.getNext();
		}else {
			cursor.getPrev().setNext(cursor.getNext());
			cursor.getNext().setPrev(cursor.getPrev());
			cursor = cursor.getNext();
			System.out.println("normal");
		}
		weight -= x.getTrainWeight();
		length -= x.getTrainLength();
		size--;
		return x;
	}
	
	/**
	 * Gives the size of the train
	 * 
	 * @return
	 * 		Size of the train
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Gives the length of the train in meters
	 * 
	 * @return
	 * 		The length of the train
	 */
	public double getLength() {
		return Math.round(length * 10.0) / 10.0;
	}
	
	/**
	 * Gives the value in $ of the loads in the train 
	 * 
	 * @return
	 * 		The total value of loads
	 */
	public double getValue() {
		return value;
	}
	
	/**
	 * Gives the value in tons of the car and the load in the train
	 * 
	 * @return
	 * 		The total weight of the car and loads
	 */
	public double getWeight() {
		return Math.round(weight * 10.0) / 10.0;
	}
	
	/**
	 * Determines whether the load is dangerous or not
	 * 
	 * @return
	 * 		True or false if it is dangerous or not
	 */
	public boolean isDangerous() {
		return dangerous;
	}
	
	/**
	 * Finds the product that the user asks to find
	 * Adds up the total weight and value of the load that has 
	 * that name and determines if the load is dangerous or not
	 * 
	 * @param name
	 * 		The name of the load that the user wants to find
	 */
	public void findProduct(String name) {
		int count = 0;
		int value = 0;
		int weight = 0;
		boolean danger = false;
		TrainCarNode node = head;
		while(node!=null) {
			if(!node.getCar().isEmpty()) {
				if(node.getCar().getReference().getName().equals(name)) {
					value+=node.getCar().getReference().getValue();
					weight+=node.getCar().getReference().getWeight();
					if(node.getCar().getReference().isDangerous()) {
						danger = true;
					}
					count++;
				}
			}
			node = node.getNext();
		}
		String x = "";
		if(danger) {
			x = "YES";
		}else {
			x = "NO";
		}
		if(count == 0) {
			System.out.println("No record of "+name+" on board train.");
		}else {
			System.out.println("\n        Name      Weight (t)     Value ($)   Dangerous\r\n" + 
					"    ===================================================");
			System.out.print("        ");
			System.out.printf("%-9s %-14s %-10s %4s %n",name,weight,value,x);
		}
	}
	
	/**
	 * Sets that load the user inputs into the car the cursor is on
	 * 
	 * @param load
	 * 		The load that the user provides
	 */
	public void setProduct(ProductLoad load) {
		TrainCar x = getCursorData();
		x.setReference(load);
		if(load.isDangerous()) {
			dangerous = true;
		}
		weight += x.getReference().getWeight();
		value += x.getReference().getValue();
	}
	
	/**
	 * Prints the name, weight, length, load, of the cars in the train
	 */
	public void printManifest() { 
		int count = 0;
		TrainCarNode node = head;
		while (node != null) {
			count++;
			if(cursor.getCar().equals(node.getCar())) {
				System.out.print("-->   ");
			}else {
				System.out.print("      ");
			}
			TrainCar x = node.getCar();
			if(!node.getCar().isEmpty()) {
				System.out.printf("%-5s %-13s %-11s %-4s %-9s %-14s %-9s %4s %n",count,x.getTrainLength(),
						x.getTrainWeight(),"|",x.getReference().getName(),x.getReference().getWeight(),
						x.getReference().getValue(),node.toString());
			}else {
				System.out.printf("%-5s %-13s %-11s %-4s %-9s %-14s %-9s %4s %n",count,x.getTrainLength(),
						x.getTrainWeight(),"|","Empty",0.0,0.00,"NO");
			}
			node = node.getNext();
		}
	}
	
	/**
	 * Removes the dangerous cars that are in the train
	 */
	public void removeDangerousCars() {
		if(isDangerous()) {
			TrainCarNode node = head;
			while(node != null) {
				if(!node.getCar().isEmpty()) {
					if(node.getCar().getReference().isDangerous()) {
						weight -= node.getCar().getTrainWeight();
						weight -= node.getCar().getReference().getWeight();
						value -= node.getCar().getReference().getValue();
						length -= node.getCar().getTrainLength();
						if((cursor.equals(tail))&&(cursor.equals(head))){
							node.setCar(null);
							head = null;
							tail = null;
							cursor = null;
						}else if(node.equals(tail)) {
							node.getPrev().setNext(null);
							if(cursor.equals(tail)) {
								cursor = cursor.getPrev();
							}
							tail = tail.getPrev();
						}else if(node.equals(head)){
							node.getNext().setPrev(null);
							if(cursor.equals(head)) {
								cursor = cursor.getNext();
							}
							head = head.getNext();
						}else {
							node.getPrev().setNext(node.getNext());
							node.getNext().setPrev(node.getPrev());
							cursor = cursor.getNext();
						}
						size--;
					}
				}
				node = node.getNext();
			}
		}
		dangerous = false;
	}
	
	/**
	 * Gives whether cursor is equal to null or not
	 * 
	 * @return
	 * 		If cursor is null or not
	 */
	public boolean cursorNull() {
		return(cursor == null);
	}
	
	/**
	 * Prints out the string for print train
	 */
	public String toString() {
		String x;
		if(!dangerous) {
			x = "not dangerous.";
		}else {
			x = "is dangerous.";
		}
		return("\nTrain: " + size() + " cars, " + getLength() + " meters, "
				+ getWeight() + " tons, " + getValue() + " value, " + x);
	}
}
