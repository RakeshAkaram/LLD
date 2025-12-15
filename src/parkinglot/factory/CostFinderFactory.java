package parkinglot.factory;

import parkinglot.strategy.costFinder.CostFinderStratergy;
import parkinglot.strategy.costFinder.impl.HourBasisCostFinder;
import parkinglot.strategy.costFinder.impl.MinuteBasisCostFinder;
import parkinglot.strategy.costFinder.impl.StandardBasisCostFinder;

import static parkinglot.utils.ParkinglotConstants.*;

public class CostFinderFactory {
    public CostFinderStratergy costStrategy(String costStrategy){
        switch (costStrategy){
            case HOURS:
                return new HourBasisCostFinder();
            case MINUTES:
                return new MinuteBasisCostFinder();
            default:
                return new StandardBasisCostFinder();
        }
    }
}
