package groceryList;

/**
 * class SnackITem extends GroceryItem
 */
public class SnackItem extends GroceryItem{
	Size size;

	/**
	 * Constructor initializes fields
	 * @param name    name of item
	 * @param brand   brand of item
	 * @param size    size of item
	 */
	public SnackItem(String name, String brand, Size size) {
		super(name, brand);
		this.size = size;
	} // end constructor

	/**
	 * gets size
	 * @return size 
	 */
	public Size getSize() {
		return size;
	}

	/**
	 * Sets size
	 * @param size set to this size
	 */
	public void setSize(Size size) {
		this.size = size;
	}
	
	/**
	 * Method returns string comprised of name, brand and size of SnackItem
	 * @return formatted string 
	 */
	@Override
	public String toString() {
		return String.format("%s (%s size)", super.toString(), 
				this.getSize().toString().toLowerCase());
	}

} // end class
