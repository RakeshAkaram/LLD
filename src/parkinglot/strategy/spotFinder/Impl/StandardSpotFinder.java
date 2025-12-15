package parkinglot.strategy.spotFinder.Impl;

import parkinglot.enums.SpotType;
import parkinglot.enums.VehicleType;
import parkinglot.model.Parkinglot;
import parkinglot.model.Spot;
import parkinglot.model.Vehicle;
import parkinglot.strategy.spotFinder.SpotFinderStrategy;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class StandardSpotFinder implements SpotFinderStrategy {
    @Override
    public Spot findSpot(Vehicle vehicle, Parkinglot parkinglot) {
        SpotType spotType = null;
        Map<SpotType, List<Spot>> spots = parkinglot.getSpots();
        //TODO: RAKARAM seperate this code (Config)
        if(vehicle.getVehicleType().equals(VehicleType.TWO_WHELLER)) spotType = SpotType.TWO_WHELLER;
        if(vehicle.getVehicleType().equals(VehicleType.FOUR_WHEELER)) spotType = SpotType.FOUR_WHEELER;
        //
        List<Spot> spotList = spots.get(spotType);
        Optional<Spot> spot = spotList.stream().filter(spot1 -> !spot1.isOccupied()).findFirst();
        return spot.orElse(null);
    }
}
