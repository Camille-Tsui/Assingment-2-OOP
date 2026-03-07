package problemdomain;

public abstract class Vehicle {
	//variables
	private long carID;
	private String vehicleType;
	private String subType;
	private int speed;
	private double fuel;
	private int seats;
	private int year;
	private String drivetrain;
	private int price;
	private int quantity;
	
	//constructor
	public Vehicle(long carID, String vehicleType, String subType, int speed, double fuel, int seats, int year,
			String drivetrain, int price, int quantity) {
		super();
		this.carID = carID;
		this.vehicleType = vehicleType;
		this.subType = subType;
		this.speed = speed;
		this.fuel = fuel;
		this.seats = seats;
		this.year = year;
		this.drivetrain = drivetrain;
		this.price = price;
		this.quantity = quantity;
	}
	
	public boolean isAvalible() {
		if (quantity > 0) {
			return true;		
		}
		else {
			return false;
		}
	}
	
	public void checkout() {
		if (isAvalible()) {
			quantity -= 1;			
		}
	}


	@Override
	public String toString() {
		return "Car ID:\t\t" + carID +
				"\nVehicle Type:\t" + vehicleType +
				"\nSub Type:\t" + subType +
				"\nSpeed:\t\t" + speed +
				"\nFuel:\t\t" + fuel +
				"\nNumber of Seats:\t" + seats +
				"\nYear:\t\t" + year +
				"\nDriveTrain:\t\t" + drivetrain +
				"\nPrice:\t\t" + price +
				"\nAvailable:\t\t" + quantity;
	}

	//getters and setters
	public long getCarID() {
		return carID;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public String getSubType() {
		return subType;
	}

	public int getSpeed() {
		return speed;
	}

	public double getFuel() {
		return fuel;
	}

	public int getSeats() {
		return seats;
	}

	public int getYear() {
		return year;
	}

	public String getDrivetrain() {
		return drivetrain;
	}

	public int getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setCarID(long carID) {
		this.carID = carID;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void setFuel(double fuel) {
		this.fuel = fuel;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setDrivetrain(String drivetrain) {
		this.drivetrain = drivetrain;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}