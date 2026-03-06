package manager;

import java.io.*;
import java.util.*;

import problemdomain.*;

public class VehicleManager {
	private ArrayList<Vehicle> vehicles = new ArrayList<>();
	private String fileName = "res/vehicles.txt";
	private Scanner keyboard = new Scanner(System.in);
	
	public VehicleManager() {
		loadVehicles();
		
		int option = 0;
		
		while (option != 5) {
			displayMenu();
			
			System.out.print("\nEnter option: ");
			option = keyboard.nextInt();
			
			switch (option)
			{
				case 1:
					purchaseVehicle();
					break;
				case 2:
					displayVehiclesByType();
					break;
				case 3:
					displayVehiclesBySubtype();
					break;
				case 4:
					produceRandomListOfVechicles();
					break;
				case 5:
					save();
					break;
				default:
					System.out.println("Invalid option!");
					
			}
		}
	}


	private void loadVehicles() {
		File file = new File(fileName);
		try {
			Scanner input = new Scanner(file);
			
			while (input.hasNext()) {
				String line = input.nextLine();
				String[] fields = line.split(";");
				
				long carId = Long.parseLong(fields[0]);
				String vehicleType = fields[1];
				String subType = fields[2];
				int speed = Integer.parseInt(fields[3]);
				double fuel = Double.parseDouble(fields[4]);
				int seats = Integer.parseInt(fields[5]);
				int year = Integer.parseInt(fields[6]);
				String drivetrain = fields[7];
				int price = Integer.parseInt(fields[8]);
				int quality = Integer.parseInt(fields[9]);
				
				Vehicle vehicle = null;
				
				switch(vehicleType) // edit as needed
				{
					case "Hatchback":
						vehicle = new Hatchback(carId, vehicleType, subType, speed, fuel, seats, year, drivetrain, price, quality, fields[10]);
						break;
					case "Hybrid":
						vehicle = new Hybrid(carId, vehicleType, subType, speed, fuel, seats, year, drivetrain, price, quality, fields[10], Integer.parseInt(fields[11]));
						break;
					case "PickupTruck":
						vehicle = new PickupTruck(carId, vehicleType, subType, speed, fuel, seats, year, drivetrain, price, quality, fields[10], Long.parseLong(fields[11]));
						break;
					case "Sedan":
						//vehicle = new Sedan();
						break;
					case "SUV":
						//vehicle = new SUV();
						break;
				}
				vehicles.add(vehicle);
				
			}
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private void displayMenu() {
		System.out.println("Welcome to DriverMasters");
		System.out.println("Please choose any option below");
		System.out.println("--------------------------------");
		System.out.println("1\tPurchase Vehicle");
		System.out.println("2\tDisplay Vehicles by Type");
		System.out.println("3\tDisplay Vehicles by Subtype");
		System.out.println("4\tProduce a Random List of Vehicles");
		System.out.println("5\tSave and Exit");
	}
	
	private void purchaseVehicle() {
		
	}
	
	//This function is unfinished and needs to be fixed
	private void displayVehiclesByType() {
		System.out.print("Enter vehicle type to search for: (Sedan, SUV, Hatchback, Pickup Truck and Hybrid car) ");
		String vehicleTypeName = keyboard.nextLine();
		
		for (Vehicle vehicle: vehicles) {
			if(vehicle instanceof vehicleTypeName) {
				System.out.println(vehicle.toString());
				System.out.println();
			}
		}
	}
	
	private void displayVehiclesBySubtype() {
		
	}
	
	private void produceRandomListOfVechicles () {
		
	}
	
	private void save() {
		
	}
}