
public class TrainCar {
	private double trainLength;
	private double trainWeight;
	private ProductLoad reference = null;
	
	public TrainCar(double trainLength, double trainWeight) {
		this.trainLength = trainLength;
		this.trainWeight = trainWeight;
	}
	
	public boolean isEmpty() {
		return (reference == null);
	}
	
	public double getTrainLength() {
		return trainLength;
	}
	
	public double getTrainWeight() {
		return trainWeight;
	}
	
	public ProductLoad getReference() {
		return reference;
	}
	public void setReference(ProductLoad reference) {
		this.reference = reference;
	}

}
