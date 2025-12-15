package parkinglot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    private Integer ticketNo;
    private Integer spotNo; // One-on-One mapping with the Spot. Acts as FK_key
    private Spot spot;
    private String vehicleNo; // One-on-One mapping with the Spot. Acts as FK_key
    private Vehicle vehicle;
    private Date entryTime;

}
