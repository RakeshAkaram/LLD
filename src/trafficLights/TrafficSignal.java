package trafficLights;

import lombok.Data;

@Data
public class TrafficSignal {
    private TrafficSignalState trafficSignalState;

    public TrafficSignal() {
        this.trafficSignalState = new RedSignal();
    }

    public void changeState(){
        trafficSignalState.changeState(this);
    }
}
