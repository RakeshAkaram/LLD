package parkinglot.strategy.costFinder.impl;

import parkinglot.model.Ticket;
import parkinglot.strategy.costFinder.CostFinderStratergy;

import java.math.BigDecimal;

public class StandardBasisCostFinder implements CostFinderStratergy {

    @Override
    public BigDecimal calculateCost(Ticket ticket) {
        return BigDecimal.valueOf(50);
    }
}
