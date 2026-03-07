package problemdomain;

public class Sedan extends Vehicle {

	private String trunkSize;

	public Sedan(long carID, String vehicleType, String subType, int speed,
			double fuel, int seats, int year, String drivetrain,
			int price, int quantity, String trunkSize) {

		super(carID, vehicleType, subType, speed, fuel, seats, year, drivetrain, price, quantity);
		this.trunkSize = trunkSize;
	}

	public String getTrunkSize() {
		return trunkSize;
	}

	public void setTrunkSize(String trunkSize) {
		this.trunkSize = trunkSize;
	}

	@Override
	public String toString() {
		return super.toString() +
				"\nTrunk Size:\t" + getTrunkSizeDescription();
	}

	public String getTrunkSizeDescription() {
		switch (trunkSize) {
			case "L":
				return "Large/spacious Trunk";
			case "M":
				return "Moderate Trunk";
			case "S":
				return "Small Trunk";
			default:
				return trunkSize;
		}
	}
}