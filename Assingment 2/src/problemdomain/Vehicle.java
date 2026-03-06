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
		return "";
	}
	

}
