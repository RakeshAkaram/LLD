package parkinglot.model;

import parkinglot.enums.SpotType;

public class TwoWheelerSpot extends Spot{
    public TwoWheelerSpot(Integer spotNo) {
        super(spotNo, SpotType.TWO_WHELLER, false, null);
    }
}
