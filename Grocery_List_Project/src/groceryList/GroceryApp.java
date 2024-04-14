package groceryList;

/**
 * Class GroceryApp
 */
public class GroceryApp {

	/**
	 * Main method for testing. 
	 * @param args
	 */
	public static void main(String[] args) {
		FreshItem item1 = new FreshItem("apple", "dole", "honey crisp", true, "red");
//		item1.setOrganic(false);
		System.out.println(item1.toString());

	} // end main

} // end class
