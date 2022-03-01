package ua.lviv.lgs;

import java.util.Scanner;

public class Deputy extends Human{
private String firstname;
private String lastname;
private int age;
private Boolean grafter;
private int amountOfBribe;




public Deputy(String firstname,String lastname, int age, int weight, int height,  Boolean grafter) {
	super(weight, height);
	this.age = age;
	this.firstname = firstname;
	this.lastname = lastname;
	this.grafter = grafter;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getFirstname() {
	return firstname;
}public boolean isGrafter() {
	return grafter;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public Boolean getGrafter() {
	return grafter;
}
public void setGrafter(Boolean grafter) {
	this.grafter = grafter;
}
public int getAmountOfBribe() {
	return amountOfBribe;
}
public void setAmountOfBribe(int amountOfBribe) {
	this.amountOfBribe = amountOfBribe;
}
public String grafterSt() {
if (this.grafter) {
	return "grafter!";
	
}else {
	return "isn't a grafter";
}
}
public void giveBribe() {
	if (this.grafter == false) {
		System.out.println("He isn't a grafter");
	}

	if (this.grafter == true) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите сумму взятки:");
		int bribeAmount = scanner.nextInt();

		if (bribeAmount > 5000) {
			System.out.println("Police will imprison him");
		} else {
			this.amountOfBribe = bribeAmount;
		}
	}
}
@Override
public String toString() {
	return firstname + " " + lastname + " " + age + " years " + super.getWeight()
	+ " kg " + super.getHeight() + " m " + grafterSt();
}


}


