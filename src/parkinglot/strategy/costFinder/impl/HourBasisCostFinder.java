package parkinglot.strategy.costFinder.impl;

import parkinglot.model.Ticket;
import parkinglot.strategy.costFinder.CostFinderStratergy;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

public class HourBasisCostFinder implements CostFinderStratergy {
    @Override
    public BigDecimal calculateCost(Ticket ticket) {
        Duration duration = Duration.between(LocalDateTime.now().plusHours(3),ticket.getEntryTime());
        long hours = Math.abs(duration.toHours());
        ticket.setDuration(hours);
        return BigDecimal.valueOf(20*hours);
    }
}
