package elevator.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Floor {
    private Integer floorNo;
    private ExternalButton upButton;
    private ExternalButton downButton;
}
