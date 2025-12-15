package parkinglot.strategy.costFinder.impl;

import parkinglot.model.Ticket;
import parkinglot.strategy.costFinder.CostFinderStratergy;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

public class MinuteBasisCostFinder implements CostFinderStratergy {
    @Override
    public BigDecimal calculateCost(Ticket ticket) {
        Duration duration = Duration.between(LocalDateTime.now(),ticket.getEntryTime());
        long minutes = duration.toMinutes();
        return BigDecimal.valueOf(2*minutes);
    }
}
