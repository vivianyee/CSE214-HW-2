
public class ProductLoad {
	private String name;
	private double weight;
	private double value;
	private boolean dangerous;

	public ProductLoad(String name, double weight, double value, boolean dangerous){
		this.name = name;
		this.weight = weight;
		this.value = value;
		this.dangerous = dangerous;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}

	public boolean isDangerous() {
		return dangerous;
	}
	public void setDangerous(boolean dangerous) {
		this.dangerous = dangerous;
	}
}
