package parkinglot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Parkinglot {
    private List<Spot> spots = new ArrayList<>();
    private List<EntryGate> entryGates = new ArrayList<>();
    private List<ExitGate> exitGates = new ArrayList<>();
}
