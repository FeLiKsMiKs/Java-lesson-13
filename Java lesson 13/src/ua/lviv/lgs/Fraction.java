package ua.lviv.lgs;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class Fraction {
	private String deputyGroupName;

	public Fraction(String GroupName) {
		this.deputyGroupName = GroupName;
	}

	public String getDeputyGroupName() {
		return deputyGroupName;
	}

	public void setDeputyGroupName(String deputyGroupName) {
		this.deputyGroupName = deputyGroupName;
	}

	ArrayList<Deputy> deputyGroupArray = new ArrayList<Deputy>();

	public void addDeputy() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Firstname: ");
		String firstname = scanner.next();
		System.out.println("Lastname: ");
		String lastname = scanner.next();
		System.out.println("Age: ");
		int age = scanner.nextInt();
		System.out.println("Height: ");
		int height = scanner.nextInt();
		System.out.println("Weight");
		int weight = scanner.nextInt();
		System.out.println("Grafter: ");
		boolean grafter = scanner.nextBoolean();

		Deputy deputy = new Deputy(firstname, lastname, age, height, weight, grafter);

		if (deputy.isGrafter()) {
			deputy.giveBribe();
		}

		deputyGroupArray.add(deputy);
		System.out.println(deputy.toString() + " added!");
	}

	public void removeDeputy() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("¬ведите фамилию депутата:");
		String lastname = scanner.next();
		System.out.println("¬ведите им€ депутата:");
		String firstname = scanner.next();

		boolean typeCorrect = isDeputyExists(deputyGroupArray, lastname, firstname);

		if (typeCorrect) {

			Iterator<Deputy> iterator = deputyGroupArray.iterator();

			while (iterator.hasNext()) {
				Deputy nextDeputy = iterator.next();

				if (nextDeputy.getLastname().equalsIgnoreCase(lastname) && nextDeputy.getFirstname().equalsIgnoreCase(firstname)) {
					iterator.remove();
					System.out.println(nextDeputy.toString() + " deleted!");
				}
			}

		} else {
			System.out.println("Error!");
		}
	}

	public void getBribeTakers() {
		System.out.println("Grafters:");
		for (Deputy deputy : deputyGroupArray) {
			if (deputy.isGrafter()) {
				System.out.println(deputy.toString());
			}
		}
	}

	public void getLargestBribeTaker() {
		int bribeSize = 0;
		int deputyIndex = -1;

		for (int i = 0; i < deputyGroupArray.size(); i++) {
			if (deputyGroupArray.get(i).isGrafter()) {
				if (deputyGroupArray.get(i).getAmountOfBribe() > bribeSize) {
					bribeSize = deputyGroupArray.get(i).getAmountOfBribe();
					deputyIndex = deputyGroupArray.indexOf(deputyGroupArray.get(i));
				}
			}
		}

		if (deputyIndex >= 0) {
			System.out.println("The biggest grafter: " + deputyGroupArray.get(deputyIndex).toString());
		} else {
			System.out.println("There aren't any grafters");
		}
	}

	public void getAllDeputies() {
		System.out.println("Deputies in the fraction:");
		for (Deputy deputy : deputyGroupArray) {
			System.out.println(deputy.toString());
		}
	}

	public void clearDeputyGroup() {
		deputyGroupArray.clear();
		System.out.println("All deputies were deleted");
	}

	static boolean isDeputyExists(ArrayList<Deputy> deputyGroupArray, String surname, String name) {
		boolean flag = false;

		for (Deputy deputy : deputyGroupArray) {
			if (deputy.getLastname().equalsIgnoreCase(surname) && deputy.getFirstname().equalsIgnoreCase(name)) {
				flag = true;
			}
		}

		return flag;
	}

	@Override
	public String toString() {
		return "Fraction " + deputyGroupName;
	}
}
