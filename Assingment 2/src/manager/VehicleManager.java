package manager;

import java.io.*;
import java.util.*;

import problemdomain.*;

public class VehicleManager {
	private ArrayList<Vehicle> vehicles = new ArrayList<>();
	private String fileName = "res/vehicles.txt";
	
	public VehicleManager() {
		loadVehicles();
	}

	private void loadVehicles() {
		File file = new File(fileName);
		try {
			Scanner input = new Scanner(file);
			while (input.hasNext()) {
				String line = input.nextLine();
				String[] tokens = line.split(";");
				String vehicleType = tokens[1];
				Vehicle vehicle = null;
				//System.out.println(line);
				//System.out.println(vehicleType);
				
				switch(vehicleType) // edit as needed
				{
					case "Hatchback":
						vehicle = new Hatchback();
						break;
					case "Hybrid":
						vehicle = new Hybrid();
						break;
					case "PickupTruck":
						vehicle = new PickupTruck();
						break;
					case "Sedan":
						vehicle = new Sedan();
						break;
					case "SUV":
						vehicle = new SUV();
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
		
	}
	
	private void purchaseVehicle() {
		
	}
	
	private void dispayVehiclesBySubtype() {
		
	}
	
	private void produceRandomListOfVechicles () {
		
	}
	
	private void saveAndExit () {
		
	}
}