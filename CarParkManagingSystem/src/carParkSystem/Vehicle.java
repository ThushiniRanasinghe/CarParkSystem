package carParkSystem;

//Super Class
public abstract class Vehicle {

	// declare variables
	private String vehicleIdPlate, vehicleBrand;
	public String vehicleType;
	private DateTime vehicleEntryTimeDate;

	// Getters
	public String getVehicleIdPlate() {
		return vehicleIdPlate;
	}

	public String getVehicleBrand() {
		return vehicleBrand;
	}

	public String getVehicleType(){
		return vehicleType;
	}

	public DateTime getVehicleEntryTimeDate() {
		return vehicleEntryTimeDate;
	}

	
	// Setters
	public void setVehicleIdPlate(String vehicleIdPlate) {
		this.vehicleIdPlate = vehicleIdPlate;
	}

	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}

	public void setVehicleType(String vehicleType){
		this.vehicleType=vehicleType;
	}

	public void setVehicleEntryTimeDate(DateTime vehicleEntryTimeDate) {
		this.vehicleEntryTimeDate = vehicleEntryTimeDate;
	}

}
