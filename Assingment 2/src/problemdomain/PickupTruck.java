package problemdomain;

public class PickupTruck extends Vehicle {

	private String cargoBed;
	private long cargoCapacity;
	
	public PickupTruck(long carID, String vehicleType, String subType, int speed, double fuel, int seats, int year,
			String drivetrain, int price, int quantity, String cargoBed, long cargoCapacity) {
		super(carID, vehicleType, subType, speed, fuel, seats, year, drivetrain, price, quantity);
		
		switch(cargoBed)
		{
			case "SB":
				this.cargoBed = "Short Bed";
				break;
			case "EB":
				this.cargoBed = "Extended Bed";
				break;
			case "DB":
				this.cargoBed = "Dump Bed";
				break;
		}
		
		this.cargoCapacity = cargoCapacity;
	}

	@Override
	public String toString() {
	    return super.toString() +
	            "\nCargo Capacity:\t" + cargoCapacity +
	            "\nCargo Beds:\t" + cargoBed;
	}

	public String getCargoBed() {
		return cargoBed;
	}

	public void setCargoBed(String cargoBed) {
		this.cargoBed = cargoBed;
	}

	public long getCargoCapacity() {
		return cargoCapacity;
	}

	public void setCargoCapacity(long cargoCapacity) {
		this.cargoCapacity = cargoCapacity;
	}
}