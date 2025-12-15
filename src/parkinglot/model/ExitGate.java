package parkinglot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import parkinglot.enums.GateStatus;
import parkinglot.factory.CostFinderFactory;
import parkinglot.strategy.costFinder.CostFinderStratergy;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExitGate {
    private String gateNo;
    private Boolean isActive;
    private GateStatus status;
    private String costFinderType;
    public BigDecimal calculateCost(Ticket ticket){
        CostFinderStratergy costFinderStratergy = new CostFinderFactory().costStrategy(this.costFinderType);
        return costFinderStratergy.calculateCost(ticket);
    }
    public boolean receivePayment(BigDecimal amountPaid, BigDecimal payable){
        if(payable.equals(amountPaid)){
            return true;
        }
        return false;
    }
    public void freeSpot(Spot spot){
        spot.setOccupied(false);
        spot.setVehicle(null);
    }
}
