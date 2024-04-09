package groceryList;


/**
 * Class Grocery Item
 */
public class GroceryItem {
	String name;
	String brand;
	/**
	 * @param name
	 * @param brand
	 */
	public GroceryItem(String name, String brand) {
		this.name = name;
		this.brand = brand;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
} // end class
