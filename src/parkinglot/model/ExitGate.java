package parkinglot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import parkinglot.enums.GateStatus;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class ExitGate {
    private String gateNo;
    private Boolean isActive;
    private GateStatus status;
    public abstract BigDecimal calculateCost(Ticket ticket);
    public abstract boolean receivePayment(BigDecimal bigDecimal);
    public abstract void freeSpot(Spot spot);
}
