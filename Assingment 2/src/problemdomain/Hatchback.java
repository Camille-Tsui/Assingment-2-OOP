package problemdomain;

public class Hatchback extends Vehicle{
	
	private String hatchType;
	
	public Hatchback(long carID, String vehicleType, String subType, int speed, double fuel, int seats, int year,
			String drivetrain, int price, int quantity, String hatchType) {
		super(carID, vehicleType, subType, speed, fuel, seats, year, drivetrain, price, quantity);
		
		switch (hatchType)
		{
			case "S":
				this.hatchType = "Standard Liftgate";
				break;
			case "T":
				this.hatchType = "Split Liftgate";
				break;
			case "P":
				this.hatchType = "Power Liftgate";
				break;
		}
	}



	@Override
	public String toString() {
		return "Car ID:\t\t" + getCarID() + 
				"\nVehicle Type:" + getVehicleType() + 
				"\nSub Type:\t" + getSubType() + 
				"\nSpeed:\t\t" + getSpeed() +
				"\nFuel:\t\t" + getFuel() +
				"\nNumber of Seats:\t" + getSeats() +
				"\nYear:\t\t" + getYear() + 
				"\nDriveTrain:\t\t" + getDrivetrain() +
				"\nPrice:\t\t" + getPrice() + 
				"\nAvailable:\t\t" + getQuantity() + 
				"\nHatch Type:\t" + getHatchType();
	}



	public String getHatchType() {
		return hatchType;
	}

	public void setHatchType(String hatchType) {
		this.hatchType = hatchType;
	}

	
}
