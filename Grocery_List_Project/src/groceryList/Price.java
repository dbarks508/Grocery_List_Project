package groceryList;

/**
 * Class has item name and corresponding price parameter 
 */
public class Price {
	String name;
	double price;
	/**
	 * @param name
	 * @param price
	 */
	public Price(String name, double price) {
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * @return String comprised of name and price
	 */
	public String toString() {
		return this.name + "   " + this.price;
	}
}
