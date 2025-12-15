package parkinglot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import parkinglot.enums.GateStatus;
import parkinglot.factory.SpotFinderFactory;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class EntryGate {
    private String gateNo;
    private Boolean isActive;
    private GateStatus status;
    private SpotFinderFactory spotFinderFactory;
    public abstract Ticket issueTicket(Vehicle vehicle);
    public abstract Spot findSpot(Vehicle vehicle);
}
