package groceryList;

public class Vegetable extends FreshItem{
	boolean isFrozen;
	
	public Vegetable(String name, String brand, String variety, boolean isOrganic, String color, boolean isFrozen) {
		super(name, brand, variety, isOrganic, color);
		this.isFrozen = isFrozen;
	} // end constructor

	public boolean isFrozen() {
		return isFrozen;
	}

	public void setFrozen(boolean isFrozen) {
		this.isFrozen = isFrozen;
	}
	
	@Override
	public String toString() {
		String frozen;
		if (isFrozen) {
			frozen = "frozen";
		} else {
			frozen = "not frozen/raw";
		}
		return String.format("%s [%s]", super.toString(), frozen);
	}

} // end class
