//package name
package carParkSystem;

//sub Class of abstract class Vehicle
public class Van extends Vehicle {
	// declare variables
	private double cargoVolume;

	// Getters
	// getting the cargo volume of a van
	public double getCargoVolume() {
		return cargoVolume;
	}

	// Setters
	// setting the cargo volume of a van
	public void setCargoVolume(double cargoVolume) {
		this.cargoVolume = cargoVolume;
	}

}
