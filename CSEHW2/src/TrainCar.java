
public class TrainCar {
	private double trainLength;
	private double trainWeight;
	private ProductLoad reference = null;
	
	public TrainCar(double trainLength, double trainWeight, ProductLoad reference) {
		this.trainLength = trainLength;
		this.trainWeight = trainWeight;
		this.reference = reference;
	}
	
	public boolean isEmpty() {
		
	}
	
	public double getTrainLength() {
		return trainLength;
	}
	public void setTrainLength(double trainLength) {
		this.trainLength = trainLength;
	}
	
	public double getTrainWeight() {
		return trainWeight;
	}
	public void setTrainWeight(double trainWeight) {
		this.trainWeight = trainWeight;
	}
	
	public ProductLoad getReference() {
		return reference;
	}
	public void setReference(ProductLoad reference) {
		this.reference = reference;
	}

}
