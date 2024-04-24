package groceryList;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

/**
 * GUI for Grocery App 
 * @author Dylan P, Dylan B
 */
public class GroceryGui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField itemNameField;
	private JTextField itemBrandField;
	private JTextField itemVarietyField;
	private JTextField itemColorField;
	
	// variables
	private static List<GroceryItem> groceryList = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GroceryGui frame = new GroceryGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GroceryGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		createTitle();
		
		JPanel panel = newListPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		

	} // end constructor

	/**
	 * constructs main panel for app
	 * @return panel
	 */
	private JPanel newListPanel() {
		JPanel panel = new JPanel();

		// adds list elements to panel
		JLabel lblNewLabel_1 = new JLabel("Item Name");
		lblNewLabel_1.setBounds(51, 8, 77, 11);
		panel.add(lblNewLabel_1);
		
		itemNameField = new JTextField();
		itemNameField.setBounds(136, 5, 88, 17);
		panel.add(itemNameField);
		itemNameField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Item Brand");
		lblNewLabel_2.setBounds(51, 37, 77, 11);
		panel.add(lblNewLabel_2);
		
		itemBrandField = new JTextField();
		itemBrandField.setBounds(136, 30, 88, 17);
		panel.add(itemBrandField);
		itemBrandField.setColumns(10);
		
		JCheckBox snackItemBox = new JCheckBox("Check for Snack Item");
		snackItemBox.setBounds(51, 68, 151, 21);
		panel.add(snackItemBox);
		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setBounds(213, 69, 102, 19);
		panel.add(comboBox);
		comboBox.addItem("SIZE");
		comboBox.setSelectedIndex(0);
		comboBox.addItem("Snack Size");
		comboBox.addItem("Regular Size");
		comboBox.addItem("Family Size");
		comboBox.addItem("Any Size");
		
		JCheckBox freshItemBox = new JCheckBox("Check for Fresh Item");
		freshItemBox.setBounds(51, 89, 173, 21);
		panel.add(freshItemBox);
		
		JCheckBox organicItemBox = new JCheckBox("Check for Organic");
		organicItemBox.setBounds(51, 110, 173, 21);
		panel.add(organicItemBox);
		
		JLabel lblNewLabel_3 = new JLabel("Variety");
		lblNewLabel_3.setBounds(51, 150, 77, 11);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Color");
		lblNewLabel_4.setBounds(51, 181, 77, 11);
		panel.add(lblNewLabel_4);
		
		itemVarietyField = new JTextField();
		itemVarietyField.setBounds(136, 147, 88, 17);
		panel.add(itemVarietyField);
		itemVarietyField.setColumns(10);
		
		itemColorField = new JTextField();
		itemColorField.setBounds(136, 178, 88, 17);
		panel.add(itemColorField);
		itemColorField.setColumns(10);
		
		JLabel estPriceLabel = new JLabel("");
		estPriceLabel.setBounds(355, 196, 37, 11);
		panel.add(estPriceLabel);
		
		// button to add item to list
		JButton btnNewButton = new JButton("Add to List");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// when button clicked
				SnackItem snackItem;
				FreshItem freshItem;
				
				String name;
				String brand;
				if(itemNameField.getText().equals("")) {
					name = "Name N/A";
				} else {
					name = itemNameField.getText();
				}
				
				if(itemBrandField.getText().equals("")) {
					brand = "Brand N/A";
				} else {
					brand = itemBrandField.getText();
				}
			
				// SnackItem or FreshItem
				if(snackItemBox.isSelected() && !freshItemBox.isSelected()) {
					// set size
					Size size;
					if (comboBox.getSelectedIndex() == 1) size = Size.SNACK; 
					else if (comboBox.getSelectedIndex() == 2) size = Size.REGULAR; 
					else if (comboBox.getSelectedIndex() == 2) size = Size.FAMILY; 
					else size = Size.ANY;
					
					// instantiate SnackItem add to groceryList
					snackItem = new SnackItem(name, brand, size);
					groceryList.add(snackItem);
					
					// clear fields
					snackItemBox.setSelected(false);
					comboBox.setSelectedIndex(0);
			        itemNameField.setText("");
			        itemBrandField.setText("");
				} else if(freshItemBox.isSelected() && !snackItemBox.isSelected()) {
					// set isOrganic
					boolean organic;
					if (organicItemBox.isSelected()) {
						organic = true;
					} else {
						organic = false;
					}
					
					// set variety and color 
					String variety;
					String color;
					if(itemVarietyField.getText().equals("")) {
						variety = "Variety N/A";
					} else {
						variety = itemVarietyField.getText();
					}
					
					if(itemColorField.getText().equals("")) {
						color = "Color N/A";
					} else {
						color = itemColorField.getText();
					}
					
					// instantiate FreshItem and add to groceryList
					freshItem = new FreshItem(name, brand, variety, organic, color);
					groceryList.add(freshItem);
					
					// clear fields
			        itemNameField.setText("");
			        itemBrandField.setText("");
			        freshItemBox.setSelected(false);
			        organicItemBox.setSelected(false);
			        itemVarietyField.setText("");
			        itemColorField.setText("");
				} else {
					System.out.println("Please choose snack or fresh item");
				}
				
		        System.out.println("Item added");
				for (GroceryItem g: groceryList) {
					System.out.println(g.toString());
				}
				System.out.println();
				
			} // end action performed
		}); // end add action listener
		btnNewButton.setBounds(8, 215, 115, 19);
		panel.add(btnNewButton);
		
		// print list button
		JButton printListButton = new JButton("Print List");
		printListButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// writes groceryList to file
				GroceryList gl = makeGroceryListObject();
				gl.writeToFile(groceryList);
			} // end action performed
		}); // end action listener
		printListButton.setBounds(219, 215, 96, 19);
		panel.add(printListButton);
		
		// estimate price button
		JButton estimatePriceButton = new JButton("Est. Price");
		estimatePriceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estPriceLabel.setText("");
				
				// estimates price of groceryList
				GroceryList gl = makeGroceryListObject();
				String estPrice = gl.estimatePrice();
				estPriceLabel.setText(estPrice);
			} // end action performed
		}); // end actionListener
		estimatePriceButton.setBounds(323, 215, 95, 19);
		panel.add(estimatePriceButton);
		
		return panel;
	} //end jPanel
	
	/**
	 * returns a grocery list object
	 * @return GroceryList
	 */
	private static GroceryList makeGroceryListObject() {
		return new GroceryList(groceryList, "Prices.csv");
	}

	/**
	 * adds title
	 */
	private void createTitle() {
		JLabel lblNewLabel = new JLabel("Grocery List App");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
	}
} // end class
