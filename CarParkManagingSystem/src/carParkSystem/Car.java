//package name
package carParkSystem;

//sub Class of abstract class Vehicle
public class Car extends Vehicle {
	// declare variables
	private int numDoors;
	private String color;

	// Getters
	// getting the no.of doors of a car
	public int getNumDoors() {
		return numDoors;
	}

	// getting the color of a car
	public String getColor() {
		return color;
	}

	// Setters
	// setting the no.of doors of a car
	public void setNumDoors(int numDoors) {
		this.numDoors = numDoors;
	}

	// setting the color of a car
	public void setColor(String color) {
		this.color = color;
	}

}
