/**
 * The <code>ProductLoad</code> class creates the loads that each
 * car will be able to contain
 * 
 * @author Vivian Yee
 * 		e-mail: vivian.yee@stonybrook.edu
 * 		Stonybrook ID: 112145534
 */
public class ProductLoad {
	private String name; // Name for product load
	private double weight; // Weight of product load
	private double value; // Value of product load
	private boolean dangerous; // If load is dangerous or not

	/**
	 * Constructor of ProductLoad class
	 * 
	 * @param name
	 * 		Name for product load
	 * @param weight
	 * 		Weight of product load
	 * @param value
	 * 		Value of product load
	 * @param dangerous
	 * 		If load is dangerous or not
	 * 
	 * @throws IllegalElementException
	 * 		Whether value is a dollar value
	 */
	public ProductLoad(String name, double weight, double value, boolean dangerous) throws IllegalElementException{
		if((value*100)%1!=0) {
			throw new IllegalElementException("Enter a dollar value.");
		}
		this.name = name;
		this.weight = weight;
		this.value = value;
		this.dangerous = dangerous;
	}

	/**
	 * Getter for name
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * Setter for name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter for weight
	 * 
	 * @return
	 */
	public double getWeight() {
		return weight;
	}
	/**
	 * Setter for weight
	 * 
	 * @param weight
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	/**
	 * Getter for value
	 * 
	 * @return
	 */
	public double getValue() {
		return value;
	}
	/**
	 * Setter for value
	 * 
	 * @param value
	 */
	public void setValue(double value) {
		this.value = value;
	}

	/**
	 * Getter for dangerous
	 * 
	 * @return
	 */
	public boolean isDangerous() {
		return dangerous;
	}
	/**
	 * Setter for dangerous
	 * 
	 * @param dangerous
	 */
	public void setDangerous(boolean dangerous) {
		this.dangerous = dangerous;
	}
}
