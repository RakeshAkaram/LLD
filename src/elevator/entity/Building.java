package elevator.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Building {
    private List<Floor> floors = new ArrayList<>();
    public static Integer floorNo = 1;
    public void addFloor(){
        Floor floor = new Floor(floorNo++,new ExternalButton(),new ExternalButton());
        floors.add(floor);
    }
    public void removeFloor(){
        Floor floor = floors.get(floors.size() - 1);
        floorNo--;
        floors.remove(floor);
    }
}
