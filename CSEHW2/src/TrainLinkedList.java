
public class TrainLinkedList {
	private int size = 0;
	private boolean dangerous = false;
	private TrainCarNode head;
	private TrainCarNode tail;
	private TrainCarNode cursor;
	private TrainLinkedList choo = null;
	
	public TrainLinkedList() {
		head = null;
		tail = null;
		cursor = null;
	}
	
	public TrainCar getCursorData() {
		return cursor.getCar();
	}
	public void setCursorData(TrainCar car) {
		cursor.setCar(car);
	}
	
	public void cursorForward() {
		if((cursorNull())||(cursor.getNext()==null)) {
			System.out.print("No next car, cannot move cursor forward.");
		}else {
			cursor = cursor.getNext();
			System.out.print("Cursor moved forward.");
		}
	}
	
	public void cursorBackward() {
		if((cursorNull())||(cursor.getPrev()==null)) {
			System.out.print("No previous car, cannot move cursor backward.");
		}else {
			cursor = cursor.getPrev();
			System.out.print("Cursor moved backward.");
		}
	}
	
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
		size++;
	}
	
	public TrainCar removeCursor() {
		TrainCar x = getCursorData();
		if((cursor.equals(tail))&&(cursor.equals(head))){
			cursor.setCar(null);
			head = null;
			tail = null;
			cursor = null;
			return x;
		}else if(cursor.equals(tail)) {
			cursor.getPrev().setNext(null);
			cursor = cursor.getPrev();
			tail = tail.getPrev();
			size--;
			return x;
		}else if(cursor.equals(head)) {
			cursor.getNext().setPrev(null);
			cursor = cursor.getNext();
			head = head.getNext();
			size--;
			return x;
		}else {
			cursor.getPrev().setNext(cursor.getNext());
			cursor.getNext().setPrev(cursor.getPrev());
			cursor = cursor.getNext();
			System.out.println("normal");
			size--;
			return x;
		}
	}
	
	public int size() {
		return size;
	}
	
	public double getLength() {
		TrainCarNode node = head;
		double length = 0;
		while (node != null) {
			length+=node.getCar().getTrainLength();
			node = node.getNext();
		}
		return length;
	}
	
	public double getValue() {
		TrainCarNode node = head;
		double value = 0;
		while (node != null) {
			if(!node.getCar().isEmpty()) {
				value+=node.getCar().getReference().getValue();
			}
			node = node.getNext();
		}
		return value;
	}
	
	public double getWeight() {
		TrainCarNode node = head;
		double weight = 0;
		while (node != null) {
			weight+=node.getCar().getTrainWeight();
			if(!node.getCar().isEmpty()) {
				weight+=node.getCar().getReference().getWeight();
			}
			node = node.getNext();
		}
		return weight;
		
	}
	
	public boolean isDangerous() {
		TrainCarNode node = head;
		while(node != null) {
			if(!node.getCar().isEmpty()) {
				if(node.getCar().getReference().isDangerous()) {
					return true;
				}
			}
			node = node.getNext();
		}
		return false;
	}
	
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
			x = "is dangerous.";
		}else {
			x = "not dangerous.";
		}
		if(count == 0) {
			System.out.println("No record of "+name+" on board train.");
		}else {
			System.out.println(name + " has a total of "+weight+" tons, "+value
					+" dollars and " + x);
		}
	}
	
	public void setProduct(ProductLoad load) {
		TrainCar x = getCursorData();
		x.setReference(load);
		if(load.isDangerous()) {
			dangerous = true;
		}
	}
	
//	System.out.print("      ");
//	System.out.printf("%-5s %-13s %-11s %-4s %-9s %-14s %-8s %4s %n",1,1,1,11,1,1,1,1);
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
			if(head.getCar().equals(node.getCar())) {
				System.out.print("h   ");
			}
			if(tail.getCar().equals(node.getCar())) {
				System.out.print("t   ");
			}
			TrainCar x = node.getCar();
			if(!node.getCar().isEmpty()) {
				System.out.printf("%-5s %-13s %-11s %-4s %-9s %-14s %-9s %4s %n",count,x.getTrainLength(),
						x.getTrainWeight(),"|",x.getReference().getName(),x.getReference().getWeight(),
						x.getReference().getValue(),node.toString());
			}else {
				System.out.printf("%-5s %-13s %-11s %-4s %-9s %-14s %-10s %4s %n",count,x.getTrainLength(),
						x.getTrainWeight(),"|","Empty",0.0,0.00,"NO");
			}
			node = node.getNext();
		}
	}
	
	public void removeDangerousCars() {
		if(isDangerous()) {
			TrainCarNode node = head;
			while(node != null) {
				if(!node.getCar().isEmpty()) {
					if(node.getCar().getReference().isDangerous()) {
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
						}
					}
				}
				node = node.getNext();
			}
		}
		dangerous = false;
		size--;
	}
	
	public boolean cursorNull() {
		return(cursor == null);
	}
	
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
