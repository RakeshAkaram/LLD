package trafficLights;

public class MainTrafficLight {
    public static void main(String[] args) {
        TrafficSignal trafficSignal = new TrafficSignal();
        int i = 0;
        while(i++<2){
            System.out.println("*****************************");
            System.out.println("Iteration: "+i);
            trafficSignal.changeState(); //RED stays for 10 sec
            trafficSignal.changeState(); //Green stays for 5 sec
            trafficSignal.changeState(); //Yellow stays for 2 sec

        }

    }
}
