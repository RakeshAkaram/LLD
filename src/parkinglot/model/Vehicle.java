package parkinglot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import parkinglot.enums.VehicleType;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Vehicle {
    private String vehicleNo;
    private VehicleType vehicleType;
}
