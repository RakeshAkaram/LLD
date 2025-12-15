package parkinglot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import parkinglot.enums.SpotType;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Spot {
    private Integer spotNo;
    private SpotType spotType;
    //private Integer floor;
    private boolean isOccupied;
    private Vehicle vehicle;
}
