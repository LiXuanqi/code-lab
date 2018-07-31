package ood.parkinglot;

public class ParkingSpot {

    private Vehicle vehicle;

    private Vehicle.VehicleSize capacity;

    public ParkingSpot(Vehicle.VehicleSize capacity) {
        this.capacity = capacity;
    }

    public boolean canPark(Vehicle vehicle) {
        if (vehicle != null) {
            return false;
        }
        int carSize = vehicle.getVehicleSize().getSize();
        if (carSize <= capacity.getSize()) {
            return true;
        }
        return false;
    }

    public boolean park(Vehicle vehicle) {
        if (!canPark(vehicle)) {
            return false;
        }
        this.vehicle = vehicle;
        return true;
    }

    public boolean leave() {
        this.vehicle = null;
        return true;
    }
}
