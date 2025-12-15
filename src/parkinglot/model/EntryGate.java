package parkinglot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import parkinglot.enums.GateStatus;
import parkinglot.factory.SpotFinderFactory;
import parkinglot.strategy.spotFinder.SpotFinderStrategy;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntryGate {
    private String gateNo;
    private Boolean isActive;
    private GateStatus status;
    private String spotFinderType;
    private static Integer ticketCounter = 1;
    public Ticket issueTicket(Vehicle vehicle,Parkinglot parkinglot){
        SpotFinderStrategy spotFinderStrategy = new SpotFinderFactory().spotStratergy(this.spotFinderType);
        Spot spot = spotFinderStrategy.findSpot(vehicle, parkinglot);

        //Spot allocation
        spot.setOccupied(true);
        spot.setVehicle(vehicle);
        //Issue ticket
        Ticket ticket = new Ticket();
        ticket.setTicketNo(ticketCounter++);
        ticket.setEntryGateNo(this.gateNo);
        ticket.setEntryTime(LocalDateTime.now());
        ticket.setSpotNo(spot.getSpotNo());
        ticket.setSpot(spot);
        ticket.setVehicleNo(vehicle.getVehicleNo());
        ticket.setVehicle(vehicle);

        return ticket;
    }
}
