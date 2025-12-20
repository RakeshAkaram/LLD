package trafficLights;

public class YellowSignal implements TrafficSignalState{
    @Override
    public void changeState(TrafficSignal trafficSignal) {
        System.out.println("***********YELLOW************");
        try {
            int i=2;
            while(i>=0){
                System.out.println("Remaining Time: "+i+" Seconds");
                Thread.sleep(1000);
                i--;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        trafficSignal.setTrafficSignalState(new RedSignal());
    }
}
