package ood.parkinglot;

public abstract class Vehicle {

    enum VehicleSize {
        LARGE(2), COMPACT(1);
        private final int size;

        VehicleSize(int size) {
            this.size = size;
        }

        public int getSize() {
            return this.size;
        }
    }

    private VehicleSize vehicleSize;

    public VehicleSize getVehicleSize() {
        return vehicleSize;
    }
}
