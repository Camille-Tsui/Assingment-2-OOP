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
				int quantity = Integer.parseInt(fields[9]);
				
				Vehicle vehicle = null;
				
				switch(vehicleType)
				{
					case "Hatchback":
						vehicle = new Hatchback(carId, vehicleType, subType, speed, fuel, seats, year, drivetrain, price, quantity, fields[10]);
						break;
					case "Hybrid":
						vehicle = new Hybrid(carId, vehicleType, subType, speed, fuel, seats, year, drivetrain, price, quantity, fields[10], Integer.parseInt(fields[11]));
						break;
					case "Pickup Truck":
						vehicle = new PickupTruck(carId, vehicleType, subType, speed, fuel, seats, year, drivetrain, price, quantity, fields[10], Long.parseLong(fields[11]));
						break;
					case "Sedan":
						vehicle = new Sedan(carId, vehicleType, subType, speed, fuel, seats, year, drivetrain, price, quantity, fields[10]);
						break;
					case "SUV":
						vehicle = new SUV(carId, vehicleType, subType, speed, fuel, seats, year, drivetrain, price, quantity);
						break;
				}
				if(vehicle != null) {
					vehicles.add(vehicle);
				}
			}
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private void displayMenu() {
		System.out.println("Welcome to DriveMasters");
		System.out.println("Please choose any option below");
		System.out.println("--------------------------------");
		System.out.println("1\tPurchase Vehicle");
		System.out.println("2\tDisplay Vehicles by Type");
		System.out.println("3\tDisplay Vehicles by Subtype");
		System.out.println("4\tProduce a Random List of Vehicles");
		System.out.println("5\tSave & Exit");
	}
	
	private void purchaseVehicle() {
		System.out.print("Enter CarId: ");
		long carId = keyboard.nextLong();
		
		for (Vehicle vehicle : vehicles) {
			if(vehicle.getCarID() == carId) {
				if(vehicle.isAvalible()) {
					vehicle.checkout();
					System.out.println("\nThe Vehicle \"" + vehicle.getVehicleType() + " " + vehicle.getSubType() + "\" has been checked out.\n");
				}
				else {
					System.out.println("The vehicle is not available.\n");
				}
				return;
			}
		}
		System.out.println("Invalid CarId!");
	}
	
	//This function is unfinished and needs to be fixed
	private void displayVehiclesByType() {
		keyboard.nextLine();
		System.out.print("Enter vehicle type to search for: (Sedan, SUV, Hatchback, Pickup Truck and Hybrid car) ");
		String vehicleTypeName = keyboard.nextLine();
		System.out.println("Matching vehicles: ");
		
		for (Vehicle vehicle: vehicles) {
			if(vehicle.getVehicleType().equalsIgnoreCase(vehicleTypeName)) {
				System.out.println(vehicle.toString());
				System.out.println();
			}
		}
	}
	
	private void displayVehiclesBySubtype() {

	    System.out.println("#\tSub Type");
	    System.out.println("1\tSedan");
	    System.out.println("2\tHatchBack");
	    System.out.println("3\tSUV");
	    System.out.println("4\tHybrid");
	    System.out.println("5\tPickup Truck");

	    System.out.print("\nEnter type of vehicle: ");
	    int option = keyboard.nextInt();
	    keyboard.nextLine();

	    switch (option) {

	    case 1:
	        System.out.print("Enter a format (L for Large/Spacious trunk, S for Small Trunk, or M for Moderate Trunk): ");
	        String format = keyboard.nextLine();

	        System.out.println("\nMatching Vehicles:");

	        for (Vehicle v : vehicles) {
	            if (v instanceof Sedan) {
	                Sedan sedan = (Sedan) v;

	                if (sedan.getTrunkSize().equalsIgnoreCase(format)) {
	                    System.out.println(sedan);
	                    System.out.println();
	                }
	            }
	        }
	        break;
	        
	    case 2:
	        System.out.print("Enter HatchType (S for Standard Liftgate, T for Split Liftgate, P for Power Liftgate): ");
	        String hatchType = keyboard.nextLine();

	        System.out.println("\nMatching Vehicles:");

	        for (Vehicle v : vehicles) {
	            if (v instanceof Hatchback) {
	                Hatchback hatch = (Hatchback) v;

	                if (hatch.getHatchType().substring(0,1).equalsIgnoreCase(hatchType)) {
	                    System.out.println(hatch);
	                    System.out.println();
	                }
	            }
	        }
	        break;        

	    case 3:
	        System.out.print("Enter DriveTrain (FWD, AWD, RWD): ");
	        String driveTrain = keyboard.nextLine();

	        System.out.println("\nMatching Vehicles:");

	        for (Vehicle v : vehicles) {
	            if (v instanceof SUV) {
	                SUV suv = (SUV) v;

	                if (suv.getDrivetrain().equalsIgnoreCase(driveTrain)) {
	                    System.out.println(suv);
	                    System.out.println();
	                }
	            }
	        }
	        break;

	    case 4: {
	        System.out.print("Enter a PowerTrain (E for Series Hybrid , A for Parallel Hybrid, PHEV for Plug-in Hybrid): ");
	        String power = keyboard.nextLine().trim().toUpperCase();

	        String target = "";
	        if (power.equals("E")) target = "Series Hybrid";
	        else if (power.equals("A")) target = "Parallel Hybrid";
	        else if (power.equals("PHEV")) target = "Plug-in Hybrid";

	        System.out.println("\nMatching Vehicles:");

	        for (Vehicle v : vehicles) {
	            if (v instanceof Hybrid) {
	                Hybrid h = (Hybrid) v;
	                if (h.getPowerTrain() != null && h.getPowerTrain().equalsIgnoreCase(target)) {
	                    System.out.println(h);
	                    System.out.println();
	                }
	            }
	        }
	        break;
	    }

	    case 5: {
	        System.out.print("Enter CargoBeds (SB for Short Beds , EB for Extended Beds, DB for Dump Beds): ");
	        String bed = keyboard.nextLine().trim().toUpperCase();

	        System.out.println("\nMatching Vehicles:");

	        for (Vehicle v : vehicles) {
	            if (v instanceof PickupTruck) {
	                PickupTruck truck = (PickupTruck) v;

	                String truckBed = truck.getCargoBed();

	                if ((bed.equals("SB") && truckBed.equalsIgnoreCase("Short Bed")) ||
	                    (bed.equals("EB") && truckBed.equalsIgnoreCase("Extended Bed")) ||
	                    (bed.equals("DB") && truckBed.equalsIgnoreCase("Dump Bed"))) {

	                    System.out.println(truck);
	                    System.out.println();
	                }
	            }
	        }
	        break;
	    }
	    }
	}
	
	private void produceRandomListOfVechicles () {
		System.out.print("Enter number of vehicles to display: ");
		int number = keyboard.nextInt();
		
		Random rand = new Random();
		System.out.println("\nRandom Vehicles:");
		for(int i = 0; i < number; i++) {
			int index = rand.nextInt(vehicles.size());
			System.out.println(vehicles.get(index).toString());
			System.out.println("\n----------------------------------");
		}
	}
	
	private void save() {
		System.out.println("Saving Vehicles... Done!");
		System.out.println("");
		System.out.println("Goodbye!");
	}
}