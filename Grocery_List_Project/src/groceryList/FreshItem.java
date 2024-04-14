package groceryList;

/**
 * Class freshItem extends GroceryItem
 */
public class FreshItem extends GroceryItem{
	String variety;
	boolean isOrganic;
	String color;

	public FreshItem(String name, String brand, String variety, boolean isOrganic, String color) {
		super(name, brand);
		this.variety = variety;
		this.isOrganic = isOrganic;
		this.color = color;
	}

	public String getVariety() {
		return variety;
	}

	public void setVariety(String variety) {
		this.variety = variety;
	}

	public boolean isOrganic() {
		return isOrganic;
	}

	public void setOrganic(boolean isOrganic) {
		this.isOrganic = isOrganic;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	/**
	 * method returns the name, brand, color, variety, and if organic or not in a formatted string
	 * @return formatted string
	 */
	@Override
	public String toString() {
		String superString = super.toString();
		String org;
		if (isOrganic) {
			org = "(Organic)";
		} else {
			org = "";
		}
		return String.format("%s || Variety: %s %s %s", superString, org, color, variety);
	}
		
	
} // end class
