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
		this.hatchType = hatchType;
	}
	
}
