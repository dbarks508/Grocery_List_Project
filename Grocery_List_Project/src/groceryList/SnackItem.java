package groceryList;

public class SnackItem extends GroceryItem{
	Size size;

	public SnackItem(String name, String brand, Size size) {
		super(name, brand);
		this.size = size;
	} // end constructor

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}
	
	@Override
	public String toString() {
		return String.format("%s (%s size)", super.toString(), 
				this.getSize().toString().toLowerCase());
	}

} // end class
