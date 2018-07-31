package ood.parkinglot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Level {

    private final List<ParkingSpot> spots;

    Map<Vehicle, ParkingSpot> map;

    public Level(int total, Vehicle.VehicleSize vehicleSize) {
        spots = new ArrayList<>();
        for (int i = 0; i < total; i++) {
            spots.add(new ParkingSpot(vehicleSize));
        }
    }

    public boolean hasSpot(Vehicle vehicle) {
        return !getEmptySpots(vehicle).isEmpty();
    }

    public boolean park(Vehicle vehicle) {
        List<ParkingSpot> emptySpots = getEmptySpots(vehicle);
        if (emptySpots.isEmpty()) {
            return false;
        }
        ParkingSpot emptySpot = emptySpots.get(0);
        if (emptySpot.park(vehicle)) {
            map.put(vehicle, emptySpot);
            return true;
        }
        return false;
    }

    public boolean leave(Vehicle vehicle) {
        ParkingSpot spot = map.get(vehicle);
        if (spot == null) {
            System.out.println("Car is not on this level");
            return false;
        }
        spot.leave();
        map.remove(vehicle);
        return true;
    }

    private List<ParkingSpot> getEmptySpots(Vehicle vehicle) {
        List<ParkingSpot> emptySpots = new ArrayList<>();
        for (ParkingSpot spot : spots) {
            if (spot.canPark(vehicle)) {
                emptySpots.add(spot);
            }
        }
        return emptySpots;
    }
}
