//package name
package carParkSystem;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class WestminsterCarParkManager implements CarParkManager {
	private static Scanner sc = new Scanner(System.in);
	private ArrayList<Vehicle> vehicleList;//declaring the array list
	private static int slotCounter = 20;//count the no.of vehicles currently parked

	public static void main(String[] args) {

		WestminsterCarParkManager manager = new WestminsterCarParkManager();//creating a new object of the  class 
		manager.vehicleList = new ArrayList<>();

		// displaying the welcome page
		System.out.println();
		System.out.println("WELCOME TO Westminster Car Park");
		System.out.println("------------------------------------");
		System.out.println();

		System.out.println("			Menu \n");
		System.out.println("1.Add a Vehicle to the car park ");
		System.out.println("2.Delete a Vehicle from the car park");
		System.out.println("  Print");
		System.out.println("	a.Vehicles Currently Parked");
		System.out.println("	b.Percentage of currently parked Vehicles");
		System.out.println("	c.The vehicle that has been parked for a maximum amount of time)");
		System.out.println("	d.Print vehicle list by user entered date");
		System.out.println("	e.Parking Charges");
		System.out.println("	f.Last vehicle parked");
		System.out.println("3.Exit the menu");
		manager.display();

	}

	public void display() {

		// String to hold the menu option
		String option;
		
		do {
			System.out.println(" \n \n Enter an Option:");
			option = sc.next().toLowerCase();
			//checking the menu option entered by the user
			switch (option) {
			case "1":
				addVehicle();
				break;
			case "2":
				deleteVehicle();
				break;
			case "3":
				System.out.println("Thank You!!");
				System.exit(0);
				break;

			case "a":
				printCurrentlyParkedvehicleList();
				break;
			case "b":
				printvehicleListPercentage();
				break;
			case "c":
				PrintMaxParkedVehicle();
				break;
			case "d":
				printUserEnteredDateVehicleList();
				break;
			case "e":
				printParkingCharges();
				break;
			case "f":
				lastParked();
				break;

			default:
				System.out.println("Invalid Input");

			}
		} while (!option.equals(3));
	}

	@Override
	// Method for adding a new Vehicle
	public void addVehicle() {

		// string to hold the vehicle type selection
		int type;
		if (slotCounter > 0) {
			DateTime dateTime = new DateTime();

			System.out.println("Please enter the ID Plate number of the Vehicle:");
			String idPlate = sc.next();

			System.out.println("Please enter the Brand of the Vehicle");
			String brand = sc.next();

			String time;
			String[] timeArray;

			// loop until the time is valid
			do {
				System.out.println("Please enter the entrance Time in the format of " + "hh:mm");

				time = sc.next().toString();
				timeArray = time.split(":");

				// display an error if the time is invalid
				if (Integer.parseInt(timeArray[0]) >= 24 || Integer.parseInt(timeArray[1]) >= 60) {
					System.out.println("\n Invalid time. Please try again.\n ");
					continue;
				}

			} while (Integer.parseInt(timeArray[0]) >= 24 || Integer.parseInt(timeArray[1]) >= 60);

			// setting the time
			dateTime.setHour(Integer.parseInt(timeArray[0]));
			dateTime.setMinute(Integer.parseInt(timeArray[1]));

			String date;
			String[] dateArray;

			// loop until the date is valid
			do {
				System.out.println("Please enter the entrance Date in the format of " + "YYYY/MM/DD");

				date = sc.next();
				dateArray = date.split("/");

				// display an error if the date is invalid
				if (Integer.parseInt(dateArray[1]) > 12 || Integer.parseInt(dateArray[2]) > 31) {
					System.out.println("\n Invalid date. Please try again.\n ");
					continue;

					// checks if the year is a 4 digit number or not
				} else if ((int) Math.log10(Integer.parseInt(dateArray[0])) + 1 < 4) {
					System.out.println("\n The year you entered appears to be invalid. Please try again.\n ");
					continue;
				}

			} while ((int) Math.log10(Integer.parseInt(dateArray[0])) + 1 < 4 || Integer.parseInt(dateArray[1]) > 12
					|| Integer.parseInt(dateArray[2]) > 31);

			// sets the date
			dateTime.setYear(Integer.parseInt(dateArray[0]));
			dateTime.setMonth(Integer.parseInt(dateArray[1]));
			dateTime.setDay(Integer.parseInt(dateArray[2]));

			System.out.println("Please select the type of the Vehicle");
			System.out.println("\t 1. Car");
			System.out.println("\t 2. Van");
			System.out.println("\t 3. Motorbike");

			type = sc.nextInt();

			switch (type) {
			case 1:
				System.out.println("Please enter the number of Doors of the Car");
				int doors = sc.nextInt();

				System.out.println("Please enter the Color of the Car");
				String color = sc.next();

				Car car = new Car();//create new object of a car
				car.setVehicleIdPlate(idPlate);
				car.setVehicleBrand(brand);
				car.setVehicleType("car");
				car.setVehicleEntryTimeDate(dateTime);
				car.setNumDoors(doors);
				car.setColor(color);

				vehicleList.add(car);//adding the car to the array list
				slotCounter--;
				System.out.println("You have been assigned a parking lot for your car");

				break;
			case 2:
				System.out.println("Please enter the Size of the cargo");
				int cargoSize = sc.nextInt();

				Van van = new Van();//create new object of a van
				van.setVehicleIdPlate(idPlate);
				van.setVehicleBrand(brand);
				van.setVehicleType("van");
				van.setVehicleEntryTimeDate(dateTime);
				van.setCargoVolume(cargoSize);

				if (slotCounter > 1) {
					vehicleList.add(van);//adding the van to the array list
					slotCounter = slotCounter - 2;
					System.out.println("You have been assigned a parking lot for your van");
				} else {
					System.out.println("Sorry car park is full!");
				}

				break;
			case 3:
				System.out.println("Please enter the Size of the bike engine");
				int bikeEngineSize = sc.nextInt();
				MotorBike bike = new MotorBike();//create new object of a motor bike
				bike.setVehicleIdPlate(idPlate);
				bike.setVehicleBrand(brand);
				bike.setVehicleType("motorbike");
				bike.setVehicleEntryTimeDate(dateTime);
				bike.setEngineSize(bikeEngineSize);

				vehicleList.add(bike);//adding the car to the array list
				slotCounter--;
				System.out.println("You have been assigned a parking lot for your motor bike");

				break;
			default:
				System.out.println("Invalid vehicle type.");
			}
		} else {
			System.out.println("Sorry car park is full!");
		}
		System.out.println("Available Parking Slots : " + (slotCounter));

	}

	@Override
	public void deleteVehicle() {
		System.out.print("Enter ID Plate : ");
		String idPlate = sc.next();

		for (int list = 0; list < vehicleList.size(); list++) {
			if (idPlate.equals(vehicleList.get(list).getVehicleIdPlate())) {
				if (vehicleList.get(list).getVehicleType().equals("van")) {
					slotCounter = slotCounter + 2;
				} else {
					slotCounter++;
				}
				System.out.println("A "+vehicleList.get(list).getVehicleType()+" is leaving the car park");
				vehicleList.remove(list);
				
			} else {
				System.out.println("There isnt a vehicle currently parked with that plate ID");
			}

		}
	}

	public void printCurrentlyParkedvehicleList() {
		if(vehicleList.size()==0){
			System.out.println("There are no vehicles currently parked");
		}else{
			System.out.println("Vehicles currently parked:");
		for (int i = vehicleList.size() - 1; i >= 0; i--) {
			
			System.out.println("\n\tVehicle ID Plate : " + vehicleList.get(i).getVehicleIdPlate() + "\n\tVehicle Brand : "
					+ vehicleList.get(i).getVehicleBrand() + "\n\tVehicle Brand : "
					+ vehicleList.get(i).getVehicleType());
		}
		System.out.println("The no.of available Parking Slots : " + (slotCounter));
		}
	}

	public void printvehicleListPercentage() {
		System.out.print("Enter Vehicle Type : ");
		String vehicleType = sc.next().toLowerCase();
		double percentage = 0;
		int countCars = 0;
		int countVans = 0;
		int countMotorBikes = 0;

		for (int i = 0; i < vehicleList.size(); i++) {
			if (vehicleList.get(i).getVehicleType().equals("car")) {
				countCars++;
			} else if (vehicleList.get(i).getVehicleType().equals("van")) {
				countVans += 2;
			} else if (vehicleList.get(i).getVehicleType().equals("motorbike")) {
				countMotorBikes++;
			}
		}

		if (vehicleType.equals("car")) {
			percentage = (double) Math.round(((countCars * 1.0 / (20 - slotCounter)) * 100) * 100) / 100;
			System.out.println("Percentage of Cars out of all the vehicles parked : " + percentage + "%");
		} else if (vehicleType.equals("van")) {
			percentage = (double) Math.round(((countVans * 1.0 / (20 - slotCounter)) * 100) * 100) / 100;
			System.out.println("Percentage of Vans out of all the vehicles parked : " + percentage + "%");
		} else if (vehicleType.equals("motorbike")) {
			percentage = (double) Math.round(((countMotorBikes * 1.0 / (20 - slotCounter)) * 100) * 100) / 100;
			System.out.println("Percentage of Motorbikes out of all the vehicles parked : " + percentage + "%");
		} else {
			System.out.println("Invaild Vehicle Type...");
		}

	}

	public void PrintMaxParkedVehicle() {

		int maxParkedVehicle = 0;

		for (int i = 0; i < (vehicleList.size() - 1); i++) {
			int day1 = ((vehicleList.get(i).getVehicleEntryTimeDate().getDay()) * 24 * 60);
			int hour1 = ((vehicleList.get(i).getVehicleEntryTimeDate().getHour()) * 60);
			int min1 = (vehicleList.get(i).getVehicleEntryTimeDate().getMinute());
			int day2 = ((vehicleList.get(i + 1).getVehicleEntryTimeDate().getDay()) * 24 * 60);
			int hour2 = (vehicleList.get(i + 1).getVehicleEntryTimeDate().getHour()) * 60;
			int min2 = vehicleList.get(i + 1).getVehicleEntryTimeDate().getMinute();

			if (day1 < day2) {

				maxParkedVehicle = i+1;
			} else if (day1 == day2) {
				if (hour1 < hour2) {
					maxParkedVehicle = i;
				} else if (hour1 == hour2) {
					if (min1 < min2) {
						maxParkedVehicle = i;
					} else {
						maxParkedVehicle = i + 1;
					}
				} else {
					maxParkedVehicle = i + 1;
				}

			} else {
				maxParkedVehicle = i;
			}

		}
		System.out.println("The vehicle that has been parked for a maximum amount of time is \n\tVehicle ID : "
				+ vehicleList.get(maxParkedVehicle).getVehicleIdPlate() + "\n\tType : "
				+ vehicleList.get(maxParkedVehicle).getVehicleType() + "\n\tEntry Date : "
				+ vehicleList.get(maxParkedVehicle).getVehicleEntryTimeDate().getYear() + "/"
				+ vehicleList.get(maxParkedVehicle).getVehicleEntryTimeDate().getMonth() + "/"
				+ vehicleList.get(maxParkedVehicle).getVehicleEntryTimeDate().getDay() + "\n\tEntry Time : "
				+ vehicleList.get(maxParkedVehicle).getVehicleEntryTimeDate().getHour() + ":"
				+ vehicleList.get(maxParkedVehicle).getVehicleEntryTimeDate().getMinute());

	}

	public void printUserEnteredDateVehicleList() {
		String date;
		String[] dateArray;
		int count = 0;

		// loop until the date is valid
		do {
			System.out.println("Please enter the entrance Date in the format of " + "YYYY/MM/DD");

			date = sc.next();
			dateArray = date.split("/");

			// display an error if the date is invalid
			if (Integer.parseInt(dateArray[1]) > 12 || Integer.parseInt(dateArray[2]) > 31) {
				System.out.println("\n Invalid date. Please try again.\n ");
				continue;

				// checks if the year is a 4 digit number or not
			} else if ((int) Math.log10(Integer.parseInt(dateArray[0])) + 1 < 4) {
				System.out.println("\n The year you entered appears to be invalid. Please try again.\n ");
				continue;
			} else {

			}

		} while ((int) Math.log10(Integer.parseInt(dateArray[0])) + 1 < 4 || Integer.parseInt(dateArray[1]) > 12
				|| Integer.parseInt(dateArray[2]) > 31);
		int year = Integer.parseInt(dateArray[0]);
		int month = Integer.parseInt(dateArray[1]);
		int day = Integer.parseInt(dateArray[2]);

		for (int i = 0; i < vehicleList.size(); i++) {
			if ((day == vehicleList.get(i).getVehicleEntryTimeDate().getDay())
					&& (month == vehicleList.get(i).getVehicleEntryTimeDate().getMonth())
					&& (year == vehicleList.get(i).getVehicleEntryTimeDate().getYear())) {
				System.out.println("The vehicles that you searched for are as follows: ");
				System.out.println("\n\tVehicle ID Plate : " + vehicleList.get(i).getVehicleIdPlate()
						+ "\n\tVehicle Brand : " + vehicleList.get(i).getVehicleBrand() + "\n\tVehicle Brand : "
						+ vehicleList.get(i).getVehicleType());
				count++;
			} 
		}
		if(count==0){
			System.out.println("There are no vehicles that has been parked on that date");
		}
	}

	public void printParkingCharges() {

		String[] timeArray;
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-HH");
		timeArray = dateFormat.format(date).split("-");
		int day = Integer.parseInt(timeArray[0]);
		int hour = Integer.parseInt(timeArray[1]);
		int parkingCharge = 0;

		for (int i = 0; i < vehicleList.size(); i++) {
			int entryDay = vehicleList.get(i).getVehicleEntryTimeDate().getDay();
			int entryHour = vehicleList.get(i).getVehicleEntryTimeDate().getHour();
			int dayDifference = day - entryDay;
			int hourDifference;

			if (day == entryDay) {
				dayDifference = 0;
				hourDifference = hour - entryHour;
			} else if (entryDay > day) {
				dayDifference = (day + 30) - entryDay;
				if (hour == entryHour) {
					hourDifference = 0;
				} else if (entryHour > hour) {
					hourDifference = (hour + 24) - entryHour;
				} else {
					hourDifference = hour - entryHour;
				}
			} else {
				dayDifference = day - entryDay;
				if (hour == entryHour) {
					hourDifference = 0;
				} else if (entryHour > hour) {
					hourDifference = (hour + 24) - entryHour;
				} else {
					hourDifference = hour - entryHour;
				}
			}

			if (dayDifference == 0) {
				if (hourDifference < 4) {
					parkingCharge = hourDifference * 3;
				} else if (hourDifference < 25) {
					parkingCharge = hourDifference * 4;
					if (parkingCharge > 30) {
						parkingCharge = 30;
					}
				}
			} else {
				if (hourDifference < 4) {
					parkingCharge = hourDifference * 3;
				} else if (hourDifference < 25) {
					parkingCharge = hourDifference * 4;
					if (parkingCharge > 30) {
						parkingCharge = 30;
					}
				}
				parkingCharge = parkingCharge + (30 * dayDifference);
			}
			System.out.println("ID Plate No : " + vehicleList.get(i).getVehicleIdPlate() + "\nParking Charge : "
					+ parkingCharge + "£");
		}
	}

	private void lastParked() {
		int lastParked = 0;
		for (int i = 0; i < (vehicleList.size() - 1); i++) {
			int day1 = ((vehicleList.get(i).getVehicleEntryTimeDate().getDay()) * 24 * 60);
			int hour1 = ((vehicleList.get(i).getVehicleEntryTimeDate().getHour()) * 60);
			int min1 = (vehicleList.get(i).getVehicleEntryTimeDate().getMinute());
			int day2 = ((vehicleList.get(i + 1).getVehicleEntryTimeDate().getDay()) * 24 * 60);
			int hour2 = (vehicleList.get(i + 1).getVehicleEntryTimeDate().getHour()) * 60;
			int min2 = vehicleList.get(i + 1).getVehicleEntryTimeDate().getMinute();

			if (day1 < day2) {

				lastParked = i;
			} else if (day1 == day2) {
				if (hour1 < hour2) {
					lastParked = i+1;
				} else if (hour1 == hour2) {
					if (min1 < min2) {
						lastParked = i+1;
					} else {
						lastParked = i ;
					}
				} else {
					lastParked = i ;
				}

			} else {
				lastParked = i+1;
			}

		}
		System.out.println("The Vehicle the has been parked lastly is \n\tVehicle ID : "
				+ vehicleList.get(lastParked).getVehicleIdPlate() + "\n\tType : "
				+ vehicleList.get(lastParked).getVehicleType() + "\n\tEntry Date : "
				+ vehicleList.get(lastParked).getVehicleEntryTimeDate().getYear() + "/"
				+ vehicleList.get(lastParked).getVehicleEntryTimeDate().getMonth() + "/"
				+ vehicleList.get(lastParked).getVehicleEntryTimeDate().getDay() + "\n\tEntry Time : "
				+ vehicleList.get(lastParked).getVehicleEntryTimeDate().getHour() + ":"
				+ vehicleList.get(lastParked).getVehicleEntryTimeDate().getMinute());

	}

}
