package parkinglot.factory;

import parkinglot.strategy.spotFinder.Impl.StandardSpotFinder;
import parkinglot.strategy.spotFinder.SpotFinderStrategy;

import static parkinglot.utils.ParkinglotConstants.*;

public class SpotFinderFactory {
    public SpotFinderStrategy spotStratergy(String serviceType){
        switch (serviceType){
            case STANDARD:
                return new StandardSpotFinder();
            default:
                System.out.println("No strategy used");
                return new StandardSpotFinder();
        }
    }
}
