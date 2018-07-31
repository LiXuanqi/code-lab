package ood.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private List<Level> levels;

    public ParkingLot(int levels) {
        this.levels = new ArrayList<>();
        for (int i = 0; i < levels; i++) {
            if (i % 2 == 0) {
                this.levels.add(new Level(100, Vehicle.VehicleSize.COMPACT));
            } else {
                this.levels.add(new Level(100, Vehicle.VehicleSize.LARGE));
            }
        }
    }

    public boolean hasSpot(Vehicle vehicle) {
        for (Level level : levels) {
            if (level.hasSpot(vehicle)) {
                return true;
            }
        }
        return false;
    }

    public boolean park(Vehicle vehicle) {
        for (Level level : levels) {
            if (level.park(vehicle)) {
                return true;
            }
        }
        System.out.println("This parking lot is full!");
        return false;
    }

    public boolean leave(Vehicle vehicle) {
        for (Level level : levels) {
            if (level.leave(vehicle)) {
                return true;
            }
        }
        System.out.println("Your car is not in this parking lot!");
        return false;
    }
}
