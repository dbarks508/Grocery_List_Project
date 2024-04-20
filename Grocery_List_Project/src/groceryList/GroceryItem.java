package groceryList;


/**
 * Class Grocery Item
 * @author Dylan B, Dylan P, Ruman K
 */
public class GroceryItem {
	String name;
	String brand;
	
	/**
	 * @param name     Name of GroceryItem
	 * @param brand    Brand of GroceryItem
	 */
	public GroceryItem(String name, String brand) {
		this.name = name;
		this.brand = brand;
	}
	/**
	 * @return Name of GroceryItem
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name   Name of GroceryItem
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return Brand of GroceryItem
	 */
	public String getBrand() {
		return brand;
	}
	/**
	 * @param brand    Brand of GroceryItem
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	/**
	 * Method returns the name and brand of the GroceryItem as a formatted String
	 * @return String of name and brand
	 */
	@Override
	public String toString() {
		return String.format(" Name: %s || Brand: %s", name, brand);
	}
	
} // end class
