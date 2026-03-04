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
				System.out.println(line);
			}
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
