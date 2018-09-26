import java.util.Scanner;

/**
 * The <code>TrainManager</code> class creates a manager for the 
 * user to input letters so that they can create the linked list
 * 
 * @author Vivian Yee
 * 		e-mail: vivian.yee@stonybrook.edu
 * 		Stonybrook ID: 112145534
 */
public class TrainManager {
	static TrainLinkedList choo = new TrainLinkedList(); // Train linked list
	
	/**
	 * Goes to <code>input<code>
	 * 
	 * @param args
	 * @throws IllegalElementException
	 */
	public static void main(String[] args) throws IllegalElementException {
		input();
	}
	
	/**
	 * Gets a case for every letter the user enters in
	 * 
	 * @throws IllegalElementException
	 */
	public static void input() throws IllegalElementException {
		menu();
		Scanner scan= new Scanner(System.in);
		String x = scan.nextLine();
		if(x.equalsIgnoreCase("F")) {
			cursorForward();
		}else if(x.equalsIgnoreCase("B")) {
			cursorBackward();
		}else if(x.equalsIgnoreCase("I")) {
			insertAfterCursor();
		}else if(x.equalsIgnoreCase("R")) {
			removeAtCursor();
		}else if(x.equalsIgnoreCase("L")) {
			setLoad();
		}else if(x.equalsIgnoreCase("S")) {
			searchName();
		}else if(x.equalsIgnoreCase("T")) {
			printTrain();
		}else if(x.equalsIgnoreCase("M")) {
			printManifest();
		}else if(x.equalsIgnoreCase("D")) {
			removeDangerous();
		}else if(x.equalsIgnoreCase("Q")) {
			System.out.println("\nProgram terminating successfully...");
			System.exit(0);
		}else {
			goBack();
		}
	}
	/**
	 * If user inputs a letter that is not in the selection, they go back
	 * 
	 * @throws IllegalElementException
	 */
	public static void goBack() throws IllegalElementException {
		System.out.println("\nPlease choose a selection from the menu.");
		input();
	}
	
	/**
	 * Moves cursor forward
	 * 
	 * @throws IllegalElementException
	 */
	private static void cursorForward() throws IllegalElementException {
		choo.cursorForward();
		input();
	}

	/**
	 * Moves cursor backward
	 * 
	 * @throws IllegalElementException
	 */
	private static void cursorBackward() throws IllegalElementException {
		choo.cursorBackward();
		input();
	}

	/**
	 * Inserts a car after cursor
	 * 
	 * <dt>Postcondition:
	 * 		Inserts a car after the cursor
	 * 
	 * @throws IllegalElementException
	 */
	private static void insertAfterCursor() throws IllegalElementException {
		Scanner scan3 = new Scanner(System.in);
		System.out.println("Enter car length in meters: "); 
			double clength = scan3.nextDouble();
		System.out.println("Enter car weight in tons: ");
		double cweight = scan3.nextDouble();
		TrainCar x = new TrainCar(clength,cweight);
		choo.insertAfterCursor(x);
		System.out.println("\nNew train car " + clength + " meters " + cweight
				+" tons inserted into train.");
		input();
	}

	/**
	 * Removes the car at the cursor
	 * 
	 * <dt>Postcondition:
	 * 		The car at the cursor is removed
	 * 
	 * @throws IllegalElementException
	 */
	private static void removeAtCursor() throws IllegalElementException {
		if(choo.cursorNull()) {
			System.out.println("\nNo car in train.");
		}else {
			System.out.println("\nCar successully unlinked. The "
					+ "following load has been removed from the train:");
			TrainCar x = choo.removeCursor();
			ProductLoad y = x.getReference();
			String danger = "";
			if(!x.isEmpty()) {
				if(y.isDangerous()) {
					danger = "YES";
				}else {
					danger = "NO";
				}
				System.out.println("\n        Name      Weight (t)     Value ($)   Dangerous\r\n" + 
						"    ===================================================");
				System.out.print("        ");
				System.out.printf("%-9s %-14s %-10s %4s %n",y.getName(),y.getWeight(),y.getValue(),danger);
			}else {
				System.out.println("Removed empty car.");
			}
		}
		input();
	}

	/**
	 * Sets the load the user provides to the cursor
	 * 
	 * <dt>Precondition:
	 * 		Value must be below the hundredth place
	 * <dt>Postcondition:
	 * 		Load is set inside cursor
	 * 
	 * @throws IllegalElementException
	 */
	private static void setLoad() throws IllegalElementException {
		if(choo.cursorNull()) {
			System.out.println("\nNo car in train.");
		}else if(choo.getCursorData().getReference()==null){
			Scanner scan5 = new Scanner(System.in);
			System.out.println("Enter produce name: ");
			String name = scan5.nextLine();
			System.out.println("Enter product weight in tons: ");
			double pweight = scan5.nextDouble();
			System.out.println("Enter product value in dollars: ");
			double pvalue = scan5.nextDouble();
			scan5.nextLine();
			System.out.println("Enter is product dangerous? (y/n): ");
			String pdang = scan5.nextLine();
			boolean pdangerous = false;
			if(pdang.equalsIgnoreCase("Y")) {
				pdangerous = true;
			}else if(pdang.equalsIgnoreCase("N")){
				pdangerous = false;
			}else {
				System.out.println("Invalid selection.");
				input();
			}
			try {
				ProductLoad x = new ProductLoad(name,pweight,pvalue,pdangerous);
				choo.setProduct(x);
				System.out.println("\n"+pweight + " tons of " + name + " added to "
						+ "the current car.");
			} catch (IllegalElementException e) {
				System.out.println(e);
			}
		}else {
			System.out.println("\nCar already contains load.");
		}
		input();
	}

	/**
	 * Searches the name that the user wants to look for
	 * 
	 * <dt>Postcondition:
	 * 		Prints the total value,weight of the load and the dangers
	 * 
	 * @throws IllegalElementException
	 */
	private static void searchName() throws IllegalElementException {
		if(choo.cursorNull()) {
			System.out.println("\nNo car in train.");
		}else {
			Scanner scan6 = new Scanner(System.in);
			System.out.println("\nLoad name: ");
			String x = scan6.nextLine();
			choo.findProduct(x);
		}
		input();
	}

	/**
	 * Prints the number of trains, total length, weight, value and 
	 * whether the car has dangerous loads or not
	 * 
	 * @throws IllegalElementException
	 */
	private static void printTrain() throws IllegalElementException {
		System.out.println(choo.toString());
		input();
	}

	/**
	 * Prints the manifest of the train
	 * 
	 * @throws IllegalElementException
	 */
	private static void printManifest() throws IllegalElementException {
		if(choo.cursorNull()) {
			System.out.println("\nNo car in train.");
		}else {
			System.out.println("\n    CAR:                               LOAD:\r\n" + 
					"      Num   Length (m)    Weight (t)  |    "
					+ "Name      Weight (t)     Value ($)   Dangerous\r\n" + 
					"    ==================================+========"
					+ "===========================================");
			choo.printManifest();
		}
		input();
	}

	/**
	 * Removes dangerous cars in the train
	 * 
	 * @throws IllegalElementException
	 */
	private static void removeDangerous() throws IllegalElementException {
		if(choo.cursorNull()) {
			System.out.println("\nNo car in train.");
		}else {
			choo.removeDangerousCars();
			System.out.println("\nDangerous cars successfully removed from the train.");
		}
		input();
	}

	/**
	 * Prints out menu
	 */
	public static void menu() {
		System.out.println("\n\nF - Move Cursor Forward \r\n" +  
				"B - Move Cursor Backward \r\n" + 
				"I - Insert Car After Cursor \r\n" + 
				"R - Remove Car At Cursor \r\n" + 
				"L - Set Load At Cursor \r\n" + 
				"S - Search For Product \r\n" + 
				"T - Print Train \r\n" + 
				"M - Print Manifest \r\n" + 
				"D - Remove Dangerous Cars \r\n" + 
				"Q - Quit \r\n");
		System.out.println("Choose a selection: ");
		
	}

}
