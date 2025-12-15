package parkinglot.strategy.spotFinder;

import parkinglot.model.Parkinglot;
import parkinglot.model.Spot;
import parkinglot.model.Vehicle;

public interface SpotFinderStrategy {
    Spot findSpot(Vehicle vehicle, Parkinglot parkinglot);
}
