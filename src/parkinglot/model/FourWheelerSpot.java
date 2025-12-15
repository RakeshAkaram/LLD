package parkinglot.model;

import parkinglot.enums.SpotType;

public class FourWheelerSpot extends Spot{
    public FourWheelerSpot(Integer spotNo) {
        super(spotNo, SpotType.FOUR_WHEELER, false, null);
    }
}
