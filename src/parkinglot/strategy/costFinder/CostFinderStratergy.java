package parkinglot.strategy.costFinder;

import parkinglot.model.Ticket;

import java.math.BigDecimal;

public interface CostFinderStratergy {
    BigDecimal calculateCost(Ticket ticket);
}
