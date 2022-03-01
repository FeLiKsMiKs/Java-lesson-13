package ua.lviv.lgs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class VerkhovnaRada {
	private static VerkhovnaRada instance = new VerkhovnaRada();

	private VerkhovnaRada() {
	}

	public static VerkhovnaRada getInstance() {
		if (instance == null) {
			instance = new VerkhovnaRada();
		}

		return instance;
	}

	
	ArrayList<Fraction> VerkhRada = new ArrayList<Fraction>();

	public void addFraction() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Name of Fraction:");
		String deputyGroupName = sc.next();

		Fraction fraction = new Fraction(deputyGroupName);

		VerkhRada.add(fraction);
		System.out.println(fraction.toString() + " added to VerkhRada");
	}

	public void removeFraction() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Name of Fraction:");
		String deputyGroupName = sc.next();

		boolean typeCorrect = isDeputyGroupExists(VerkhRada, deputyGroupName);

		if (typeCorrect) {

			Iterator<Fraction> iterator = VerkhRada.iterator();

			while (iterator.hasNext()) {
				Fraction newFraction = iterator.next();

				if (newFraction.getDeputyGroupName().equalsIgnoreCase(deputyGroupName)) {
					iterator.remove();
					System.out.println(newFraction.toString() + " removed from Fraction:!");
				}
			}

		} else {
			System.out.println("Error!");
		}
	}

	public void allFractions() {
		System.out.println("All fractions:");
		for (Fraction deputyGroup : VerkhRada) {
			System.out.println(deputyGroup.toString());
		}
	}

	public void clearFractions() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Name of Fraction:");
		String deputyGroupName = sc.next();

		boolean typeCorrect = isDeputyGroupExists(VerkhRada, deputyGroupName);

		if (typeCorrect) {
			for (Fraction deputyGroup : VerkhRada) {
				if (deputyGroup.getDeputyGroupName().equalsIgnoreCase(deputyGroupName)) {
					deputyGroup.clearDeputyGroup();
				}
			}

		} else {
			System.out.println("Error");
		}
	}

	public void displayFraction() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Name of Fraction:");
		String deputyGroupName = sc.next();

		for (Fraction deputyGroup : VerkhRada) {
			if (deputyGroup.getDeputyGroupName().equalsIgnoreCase(deputyGroupName)) {
				System.out.println(deputyGroup.toString());
				deputyGroup.getAllDeputies();
			}
		}
	}
	public void addDeputyToFraction() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Name of Fraction:");
		String deputyGroupName = sc.next();

		boolean typeCorrect = isDeputyGroupExists(VerkhRada, deputyGroupName);

		if (typeCorrect) {
			for (Fraction fraction : VerkhRada) {
				if (fraction.getDeputyGroupName().equalsIgnoreCase(deputyGroupName)) {
					fraction.addDeputy();
				}
			}

		} else {
			System.out.println("Error!");
		}
	}
	
	public void removeDeputyFromFraction() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Name of Fraction");
		String deputyGroupName = sc.next();

		boolean typeCorrect = isDeputyGroupExists(VerkhRada, deputyGroupName);

		if (typeCorrect) {
			for (Fraction fraction : VerkhRada) {
				if (fraction.getDeputyGroupName().equalsIgnoreCase(deputyGroupName)) {
					fraction.removeDeputy();
				}
			}

		} else {
			System.out.println("Error");
		}
	}
	static boolean isDeputyGroupExists(ArrayList<Fraction> VerkhRada, String deputyGroupName) {
		boolean flag = false;

		for (Fraction deputyGroup : VerkhRada) {
			if (deputyGroup.getDeputyGroupName().equalsIgnoreCase(deputyGroupName)) {
				flag = true;
			}
		}

		return flag;
	}
}
