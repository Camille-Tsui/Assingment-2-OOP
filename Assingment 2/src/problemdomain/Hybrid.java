package problemdomain;

public class Hybrid extends Vehicle {

    private String powerTrain;
    private int electricRange;

    public Hybrid(long carID, String vehicleType, String subType, int speed, double fuel, int seats, int year,
                  String drivetrain, int price, int quantity, String powerTrain, int electricRange) {

        super(carID, vehicleType, subType, speed, fuel, seats, year, drivetrain, price, quantity);

        switch (powerTrain) {
        case "E":
            this.powerTrain = "Series Hybrid";
            break;
        case "A":
            this.powerTrain = "Parallel Hybrid";
            break;
        case "PHEV":
            this.powerTrain = "Plug-in Hybrid";
            break;
        }

        this.electricRange = electricRange;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nPower Train:\t" + powerTrain +
                "\nElectric Range:\t" + electricRange;
    }

    public String getPowerTrain() {
        return powerTrain;
    }

    public void setPowerTrain(String powerTrain) {
        this.powerTrain = powerTrain;
    }

    public int getElectricRange() {
        return electricRange;
    }

    public void setElectricRange(int electricRange) {
        this.electricRange = electricRange;
    }
}