package groceryList;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class GroceryList provides functionality for a grocery list. Methods include
 * estimating the cost of the list, and writing the list to a file. 
 */
public class GroceryList {
	List<GroceryItem> groceryList;
	String file;
	
	/**
	 * Constructor initializes the fields
	 * @param groceryList   list of grocery items 
	 * @param file          file containing name and approximate price of items
	 */
	public GroceryList(List<GroceryItem> groceryList, String file) {
		this.groceryList = groceryList;
		this.file = file;
	}
	
	/**
	 * Method returns the number of items in List groceryList
	 * @return The number of items in groceryList
	 */
	public int getNumberOfItems() {
		return groceryList.size();
	}
	
	/**
	 * Method returns the number of vegetables in groceryList
	 * @return The number of vegetables in List groceryList
	 */
	public int getNumberOfVegetables() {
		int numOfVeg = 0;
		for (GroceryItem g : groceryList) {
			if(g instanceof Vegetable) {
				numOfVeg++;
			}
		}
		return numOfVeg;
	} 
	
	/**
	 * Method returns a List of Price objects containing the name and cost of
	 * each item/line in the file 
	 * @return A List of Price objects derived from file
	 */
	private List<Price> generatePriceList() {
		List<Price> prices = new ArrayList<>();
		try(Scanner reader = new Scanner(GroceryList.class.getResourceAsStream(file))){
			while(reader.hasNext()) {
				String line = reader.nextLine();
				try{
					line = line.strip();
					String[] splitLine = line.split(",");
				
					String name = splitLine[0];
					double p = Double.parseDouble(splitLine[1]);
					Price price = new Price(name, p);
					prices.add(price);
				} catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
					System.err.println("Error: " + line);
				}
			} // end while 
		}// end outer try
		return prices;
	} // end method
	
	/**
	 * Method provides an estimated total of shopping for groceryList
	 * based on the prices listed in file 
	 * @return String comprised of the rounded total preceded by $
	 */
	public String estimatePrice() {
		List<Price> prices = this.generatePriceList();
		double total = 0;
		
		for(int i = 0; i < prices.size(); i++) {
			Price price = prices.get(i); 
			for (GroceryItem g: groceryList) {
				if (g.name.equals(price.name)) {
					total += price.price;
				}
			} // end inner
		} // end outer
		DecimalFormat df = new DecimalFormat("#.##");
		String roundedTotal = df.format(total);
		return "$" + roundedTotal;
	} // end method
	
	/**
	 * Method writes groceryList to List.txt file
	 * @param groceryList    List of groceryItems
	 */
	public void writeToFile(List<GroceryItem> groceryList) {
		String filePath = "src/groceryList/List";
		
		try(PrintWriter writer = new PrintWriter(filePath)){
			for(GroceryItem g: groceryList) {
				writer.printf("%s", g.toString());
				writer.println();
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("Printed grocery list to List file");
	} // end method
	
} // end class
