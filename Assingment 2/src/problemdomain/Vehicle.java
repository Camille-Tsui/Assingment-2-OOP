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
	private int quality;
	
	//constructor
	public Vehicle(long carID, String vehicleType, String subType, int speed, double fuel, int seats, int year,
			String drivetrain, int price, int quality) {
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
		this.quality = quality;
	}
	
	public boolean isAvalible() {
		return;
	}
	
	public void checkout() {
		return;
	}


	@Override
	public String toString() {
		return;
	}
	

}
