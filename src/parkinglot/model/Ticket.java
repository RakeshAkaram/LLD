package parkinglot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalDateTime;
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
    private LocalDateTime entryTime;
    private String entryGateNo;
    private String existGateNo;
    private BigDecimal amountPaid;
    private long duration;

}
