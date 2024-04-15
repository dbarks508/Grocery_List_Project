package groceryList;

public class Fruit extends FreshItem {
	boolean isRipe;

	public Fruit(String name, String brand, String variety, boolean isOrganic, String color, boolean isRipe) {
		super(name, brand, variety, isOrganic, color);
		this.isRipe = isRipe;
	} // end constructor

	public boolean isRipe() {
		return isRipe;
	}

	public void setRipe(boolean isRipe) {
		this.isRipe = isRipe;
	}
	
	@Override
	public String toString() {
		String ripe;
		if (isRipe) {
			ripe = "ripe";
		} else {
			ripe = "under-ripe/green";
		}
		return String.format("%s [%s]", super.toString(), ripe);
	}

} // end class
