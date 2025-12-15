package parkinglot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import parkinglot.enums.SpotType;

import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Parkinglot {
    private Map<SpotType,List<Spot>> spots = new HashMap<>();
    private List<EntryGate> entryGates = new ArrayList<>();
    private List<ExitGate> exitGates = new ArrayList<>();

    public EntryGate getEntryGateByNo(String gateNo){
        Optional<EntryGate> entryGateOptional = entryGates.stream().filter(entryGate -> entryGate.getGateNo().equals(gateNo)).findFirst();
        return entryGateOptional.orElse(null);
    }

    public ExitGate getExitGateByNo(String gateNo){
        Optional<ExitGate> exitGateOptional = exitGates.stream().filter(exitGate -> exitGate.getGateNo().equals(gateNo)).findFirst();
        return exitGateOptional.orElse(null);
    }

    public Spot getSpotByNo(Integer spotNo){
        List<Spot> spotList = new ArrayList<>();
        spotList.addAll(spots.get(SpotType.TWO_WHELLER));
        spotList.addAll(spots.get(SpotType.FOUR_WHEELER));
        Optional<Spot> optionalTwoSpot = spotList.stream().filter(spot -> spot.getSpotNo().equals(spotNo)).findFirst();
        return optionalTwoSpot.orElse(null);
    }
}
