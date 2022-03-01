package ua.lviv.lgs;

import java.io.InputStream;
import java.util.Scanner;

public class Menu {
static void menu() {
	System.out.println("Enter 1 to add fraction");
	System.out.println("Enter 2 to remove fraction");
	System.out.println("Enter 3 to show all fractions");
	System.out.println("Enter 4 to remove the fraction");
	System.out.println("Enter 5 to display the fraction");
	System.out.println("Enter 6 to add deputy to fraction");
	System.out.println("Enter 7 to remove deputy from fraction");
}
public static void main(String[] args) {
	Scanner sc =new Scanner(System.in);
while (true) {
	menu();
	switch (sc.nextInt()) {

	case 1: {
		VerkhovnaRada.getInstance().addFraction();
		break;
	}
	
	case 2: {
		VerkhovnaRada.getInstance().removeFraction();
		break;
	}
	
	case 3: {
		VerkhovnaRada.getInstance().allFractions();
		break;
	}
	
	case 4: {
		VerkhovnaRada.getInstance().removeFraction();
		break;
	}
	
	case 5: {
		VerkhovnaRada.getInstance().displayFraction();
		break;
	}
	case 6: {
		VerkhovnaRada.getInstance().addDeputyToFraction();
		break;
	}
	
	case 7: {
		VerkhovnaRada.getInstance().removeDeputyFromFraction();
		break;
	}
	default: {
		System.out.println("Enter number from 1 to 7");
		break;
	}
}
}
}
}
