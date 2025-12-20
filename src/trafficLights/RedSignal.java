package trafficLights;

public class RedSignal implements TrafficSignalState{
    @Override
    public void changeState(TrafficSignal trafficSignal) {
        System.out.println("*************RED*************");
        try {
            int i=10;
            while(i>=0){
                System.out.println("Remaining Time: "+i+" Seconds");
                Thread.sleep(1000);
                i--;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        trafficSignal.setTrafficSignalState(new GreenSignal());
    }
}
