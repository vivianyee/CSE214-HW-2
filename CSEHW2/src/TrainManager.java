import java.util.Scanner;

public class TrainManager {
	static TrainLinkedList choo = new TrainLinkedList();
	
	public static void main(String[] args) {
		input();
	}
	
	public static void input() {
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
	
	public static void goBack() {
		System.out.println("Please choose a selection from the menu.");
		input();
	}
	
	private static void cursorForward() {
		choo.cursorForward();
		input();
	}

	private static void cursorBackward() {
		choo.cursorBackward();
		input();
	}

	private static void insertAfterCursor() {
		Scanner scan3 = new Scanner(System.in);
		System.out.println("Enter car length in meters: "); 
		int clength = scan3.nextInt();
		System.out.println("Enter car weight in tons: ");
		int cweight = scan3.nextInt();
		TrainCar x = new TrainCar(clength,cweight);
		choo.insertAfterCursor(x);
		System.out.println("New train car " + clength + " meters " + cweight
				+" tons inserted into train.");
		input();
	}

	private static void removeAtCursor() {
		if(choo.cursorNull()) {
			System.out.println("\nNo car in train.");
		}else {
			System.out.println("Car successully unlinked. The "
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
				System.out.println("        Name      Weight (t)     Value ($)   Dangerous\r\n" + 
						"    ===================================================");
				System.out.println(" "+y.getName()+" "+y.getWeight()+" "+y.getValue()+danger);
			}else {
				System.out.println("Removed empty car.");
			}
		}
		input();
	}

	private static void setLoad() {
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
			}
			ProductLoad x = new ProductLoad(name,pweight,pvalue,pdangerous);
			choo.setProduct(x);
			System.out.println(pweight + " tons of " + name + " added to "
					+ "the current car.");
		}else {
			System.out.println("Car already contains load.");
		}
		input();
	}

	private static void searchName() {
		if(choo.cursorNull()) {
			System.out.println("\nNo car in train.");
		}else {
			Scanner scan6 = new Scanner(System.in);
			System.out.println("Load name: ");
			String x = scan6.nextLine();
			choo.findProduct(x);
		}
		input();
	}

	private static void printTrain() {
		System.out.println(choo.toString());
		input();
	}

	private static void printManifest() {
		if(choo.cursorNull()) {
			System.out.println("\nNo car in train.");
		}else {
			System.out.println("    CAR:                               LOAD:\r\n" + 
					"      Num   Length (m)    Weight (t)  |    "
					+ "Name      Weight (t)     Value ($)   Dangerous\r\n" + 
					"    ==================================+========"
					+ "===========================================");
			choo.printManifest();
		}
		input();
	}

	private static void removeDangerous() {
		if(choo.cursorNull()) {
			System.out.println("\nNo car in train.");
		}else {
			choo.removeDangerousCars();
			System.out.println("Dangerous cars successfully removed from the train.");
		}
		input();
	}

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
