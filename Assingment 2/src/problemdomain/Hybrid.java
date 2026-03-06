package problemdomain;

public class Hybrid extends Vehicle{
	
	private String powerTrain;
	private int electricRange;
	
	public Hybrid(long carID, String vehicleType, String subType, int speed, double fuel, int seats, int year,
			String drivetrain, int price, int quantity, String powerTrain, int electricRange) {
		
		super(carID, vehicleType, subType, speed, fuel, seats, year, drivetrain, price, quantity);
		
		switch(powerTrain)
		{
			case "E":
				this.powerTrain = "Series Hybrid";
				break;
			case "A":
				this.powerTrain = "Parallel Hybird";
				break;
			case "PHEV":
				this.powerTrain = "Plug-in Hybrid";
				break;
		}
		this.electricRange = electricRange;
	}

}
